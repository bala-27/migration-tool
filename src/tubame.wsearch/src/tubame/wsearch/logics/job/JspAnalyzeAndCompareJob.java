/*
 * JspAnalyzeAndCompareJob.java
 * Created on 2013/06/28
 *
 * Copyright (C) 2011-2013 Nippon Telegraph and Telephone Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tubame.wsearch.logics.job;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import tubame.wsearch.Activator;
import tubame.wsearch.biz.WSPhaseService.TYPE;
import tubame.wsearch.biz.ex.WSearchBizException;
import tubame.wsearch.biz.model.AnalyzeAndCompareInput;
import tubame.wsearch.biz.model.PhaseCountDownLatch;
import tubame.wsearch.biz.model.PhaseInbound;
import tubame.wsearch.biz.process.WSearchAnalyzeAndCompareProcessor;
import tubame.wsearch.biz.process.WSearchAnalyzeAndCompareProcessor.PARSER;
import tubame.wsearch.logics.obsvr.WSearchJspAnalyzeProcessObserver;
import tubame.wsearch.logics.obsvr.WSearchProcessObserver;

/**
 * Jobs EclipsePlatform to compare processing and Jsp analyze.<br/>
 */
public class JspAnalyzeAndCompareJob extends Job {

    /**
     * List of extensions analyze target
     */
    private List<String> extensions;

    /**
     * Map of analyze target
     */
    private Map<String, List<String>> targetsMap;

    /**
     * Map of the filter
     */
    private Map<String, List<Pattern>> filtersMap;

    /**
     * Destination directory
     */
    private String outputDir;

    /**
     * Constructor.<br/>
     * 
     * @param name
     *            Job name
     * @param extensions
     *            List of extensions
     * @param targetsMap
     *            Map of analyze target
     * @param filtersMap
     *            Map of the filter
     * @param outputDir
     *            Destination directory
     */
    public JspAnalyzeAndCompareJob(String name, List<String> extensions,
            Map<String, List<String>> targetsMap,
            Map<String, List<Pattern>> filtersMap, String outputDir) {
        super(name);
        this.extensions = extensions;
        this.targetsMap = targetsMap;
        this.filtersMap = filtersMap;
        this.outputDir = outputDir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IStatus run(IProgressMonitor monitor) {

        int targetCount = 0;
        for (String extension : this.extensions) {
            targetCount += this.targetsMap.get(extension).size();
        }

        final PhaseCountDownLatch phaseCountDownLatch = new PhaseCountDownLatch(
                targetCount);

        CountDownLatch starter = new CountDownLatch(1);
        WSearchAnalyzeAndCompareProcessor analyzeAndCompareProcessor = new WSearchAnalyzeAndCompareProcessor(
                1, starter, phaseCountDownLatch, PARSER.JSP);
        WSearchProcessObserver observer = new WSearchJspAnalyzeProcessObserver(
                starter, phaseCountDownLatch, analyzeAndCompareProcessor,
                monitor);
        analyzeAndCompareProcessor.setObserver(observer);

        AnalyzeAndCompareInput analyzeAndCompareInput = new AnalyzeAndCompareInput(
                this.outputDir);
        analyzeAndCompareInput.setExtensions(extensions);
        analyzeAndCompareInput.setTargetsMap(targetsMap);
        analyzeAndCompareInput.setFiltersMap(filtersMap);
        PhaseInbound<AnalyzeAndCompareInput> phaseInbound = new PhaseInbound<AnalyzeAndCompareInput>(
                analyzeAndCompareInput);

        analyzeAndCompareProcessor.process(phaseInbound);

        monitor.beginTask("Doing something timeconsuming here", targetCount);

        try {
            phaseCountDownLatch.await();
        } catch (InterruptedException e) {
            String message = Activator
                    .getResourceString(JspAnalyzeAndCompareJob.class.getName()
                            + ".err.msg.InterruptedErr");
            Activator.log(e, message);
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
        }

        monitor.done();
        if (observer.exceptionOccurred()) {
            String message = Activator
                    .getResourceString(JspAnalyzeAndCompareJob.class.getName()
                            + ".err.msg.ExceptionOccurred");
            MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID,
                    IStatus.ERROR, null, new WSearchBizException(
                            TYPE.SRC_PARSER_AND_COMPARE, message));
            if (observer.getExceptionList() != null) {
                for (Throwable e : observer.getExceptionList()) {
                    MultiStatus status = new MultiStatus(Activator.PLUGIN_ID,
                            IStatus.ERROR, null, e);
                    for (StackTraceElement element : e.getStackTrace()) {
                        status.add(new Status(IStatus.ERROR,
                                Activator.PLUGIN_ID, element.toString()));
                    }
                    multiStatus.add(status);
                }
            }

            return multiStatus;
        }
        if (monitor.isCanceled()) {
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }
}
