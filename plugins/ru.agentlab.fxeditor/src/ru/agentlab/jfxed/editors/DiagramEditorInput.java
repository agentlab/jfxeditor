/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package ru.agentlab.jfxed.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;


/**
 * Editor Input for a Diagram Editor
 * 
 * @author Phillip Beauvoir
 */
public class DiagramEditorInput 
implements IEditorInput, IPersistableElement {
    
    /**
     * Model
     */
//    protected IDiagramModel fModel;
    
    public DiagramEditorInput(/*IDiagramModel model*/) {
//        fModel = model;
    }
    
//    public IDiagramModel getDiagramModel() {
//       return fModel;
 //   }
    
    @Override
    public boolean exists() {
        return true;//fModel.getArchimateModel() != null;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;//IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_DIAGRAM_16);
    }

    @Override
    public String getName() { 
    	return "sdfsdfdfg"; //fModel.getArchimateModel() == null ? Messages.DiagramEditorInput_0 : fModel.getArchimateModel().getName() + ": " + fModel.getName(); //$NON-NLS-1$\
    }

    @Override
    public String getToolTipText() {
        return getName();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class adapter) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof DiagramEditorInput)) {
            return false;
        }
        
      /*  if(fModel != null && ((DiagramEditorInput)obj).fModel != null) {
            return fModel.equals(((DiagramEditorInput)obj).fModel);
        }*/
        
        return false;
    }

    public IPersistableElement getPersistable() {
        // This can happen somehow (but can't remember how - so, a sanity check)
/*        if(fModel.getArchimateModel() == null) {
            return null;
        }
        
        // Not saved, or a new file based on a template
        if(fModel.getArchimateModel().getFile() == null) {
            return null;
        }
        
        
        // If the user creates a new diagram (in a saved model) and that diagram is open when the user
        // closes the application without saving the model again, then Eclipse tries to restore it again next time.
        // So we don't persist the state of the diagram if the diagram view is not marked as saved.
         
        if(fModel.getAdapter(IEditorModelManager.ADAPTER_PROPERTY_MODEL_SAVED) == null) {
            return null;
        }
        */
        // OK, we'll handle it
        return this;
    }

    @Override
    public String getFactoryId() {
        return DiagramEditorInputFactory.ID_FACTORY;
    }

    @Override
    public void saveState(IMemento memento) {
        DiagramEditorInputFactory.saveState(memento, this);
    }
}
