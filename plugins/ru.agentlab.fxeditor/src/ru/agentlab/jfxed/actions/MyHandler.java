package ru.agentlab.jfxed.actions;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ru.agentlab.jfxed.editors.DiagramEditorInput;
import ru.agentlab.jfxed.editors.MyEditorPart;



public class MyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
    	IEditorInput editorInput = new DiagramEditorInput();
    	
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
            page.openEditor(editorInput, MyEditorPart.ID);
        }
        catch(PartInitException ex) {
//            Logger.logError("Could not open Editor " + editorID); //$NON-NLS-1$
            ex.printStackTrace();
//            return null;
        }
    	System.out.println("Editor Opened");
		return null;
	}

}
