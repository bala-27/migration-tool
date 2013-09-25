/*
 * ReplacementItemStrategy.java
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
package org.tubame.knowhow.plugin.ui.view.replace;

import org.tubame.knowhow.plugin.model.view.PortabilityKnowhowListViewOperation;

/**
 * Interface of the selected item process of moving the know-how entry view.<br/>
 */
public interface ReplacementItemStrategy {

    /**
     * Logic method of moving process.<br/>
     * 
     * @param selectedEntry
     *            Selected Item
     * @param rowIndex
     *            Move number
     */
    public void replacementSelectItem(
            PortabilityKnowhowListViewOperation selectedEntry, int rowIndex);
}