/*
 * ContextMenuListener.java
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
package tubame.portability.plugin.editor;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.TreeItem;

import tubame.portability.model.JbmEditorMigrationRow;
import tubame.portability.plugin.action.ConfirmItemChangeActionFactory;
import tubame.portability.plugin.action.AllItemExpandAndCollapseAction;
import tubame.portability.plugin.action.SelectionItemExpandAndContractAction;
import tubame.portability.plugin.action.ShowCodeViewerAction;
import tubame.portability.util.resource.MessageUtil;

/**
 * Right-click the mouse at the time, the control to display the context menu.<br/>
 * When visual inspection of (hearing) confirmation item, and display the
 * following menu.<br/>
 * Confirmed (migrated)<br/>
 * Confirmed (non-migrated)<br/>
 * To return to the unconfirmed state<br/>
 * 
 */
public class ContextMenuListener implements IMenuListener {
    /**
     * Access to the Editor
     */
    private final MigrationEditorOperation editor;
    
    private final AllItemExpandAndCollapseAction allExpandtAction = new AllItemExpandAndCollapseAction(MessageUtil.ALL_EXPAND,true);
    
    private final AllItemExpandAndCollapseAction allContractAction = new AllItemExpandAndCollapseAction(MessageUtil.ALL_COLLAPSE,false);
    
    private final SelectionItemExpandAndContractAction selectionItemExpandAndContractAction = new SelectionItemExpandAndContractAction(true);
    
    private final ShowCodeViewerAction tubameCodeViewShowAction = new ShowCodeViewerAction();

    /**
     * Constructor.<br/>
     * 
     * @param editor
     *            Editor
     * 
     */
    public ContextMenuListener(MigrationEditorOperation editor) {
        this.editor = editor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void menuAboutToShow(IMenuManager manager) {
        manager.removeAll();
        if (this.editor.getSelectionObject() instanceof JbmEditorMigrationRow) {
            // If it is right click on the 1 or 2 or 3 level
            Point point = this.editor.getMouseClickPoint();
            ConfirmItemChangeActionFactory.setAction(manager,
                    this.editor.getTreeViewer(), point);
            
            ViewerCell cell = this.editor.getTreeViewer().getCell(point);
            if(cell != null && cell.getColumnIndex()==0){
            	expandAndContractActionToMenu(manager, this.editor.getTreeViewer(), point);
            }else if (cell != null && cell.getColumnIndex()!=11 && cell.getColumnIndex()!=12){
            	tubameCodeViewShowActionToMenu(manager, this.editor.getTreeViewer(), point);
            }
        }
    }
    
    private void tubameCodeViewShowActionToMenu(IMenuManager manager, TreeViewer treeViewer, Point point) {
        // Get the selected row
        TreeItem[] selectedItems = treeViewer.getTree().getSelection();

        for (TreeItem selectedItem : selectedItems) {
            JbmEditorMigrationRow row = (JbmEditorMigrationRow) selectedItem
                    .getData();
        	if (row.getLevel() == JbmEditorMigrationRow.LEVEL_THIRD) {
        		manager.add(tubameCodeViewShowAction);
            }
        }
		
	}

	void expandAndContractActionToMenu(IMenuManager manager,TreeViewer viewer,
            Point mousePoint){
        // Get the selected row
        TreeItem[] selectedItems = viewer.getTree().getSelection();

        for (TreeItem selectedItem : selectedItems) {
            JbmEditorMigrationRow row = (JbmEditorMigrationRow) selectedItem
                    .getData();
        	if (row.getLevel() == JbmEditorMigrationRow.LEVEL_FIRST) {
        		selectionItemExpandAndContractAction.setLabel(selectedItem.getExpanded());
        		manager.add(selectionItemExpandAndContractAction);
        		manager.add(new Separator());
        		manager.add(allExpandtAction);
        		manager.add(allContractAction);
            }
        }
	}
}
