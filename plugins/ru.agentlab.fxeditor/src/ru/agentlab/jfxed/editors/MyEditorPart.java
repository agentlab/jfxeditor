package ru.agentlab.jfxed.editors;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import ru.agentlab.jfxed.editors.BasePane;
import ru.agentlab.jfxed.editors.DiagramEditorPane;
import ru.agentlab.jfxed.Activator;
import ru.agentlab.jfxed.IFigure;
import ru.agentlab.jfxed.workbench3.FXEditorPart;

public class MyEditorPart extends FXEditorPart {
	public static String ID = "ru.agentlab.jfxed.editors.MyEditorPartId"; //$NON-NLS-1$
	
	public static HashMap<String, IConfigurationElement> figuresTable = new HashMap<>();
	
	protected void searchFigures(IExtensionRegistry registry) throws CoreException {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(Activator.FIGURE_ID);
		for (IConfigurationElement e : config) {
			System.out.println("Evaluating extension");
			//final Object o = e.createExecutableExtension("class");
			try {
				//Class c = Class.forName( e.getAttribute("class"));
				figuresTable.put(e.getAttribute("name"), e);
			} catch (InvalidRegistryObjectException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	protected Scene createFxScene() {
		
		try {
			searchFigures(Platform.getExtensionRegistry());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BasePane editorPane = new DiagramEditorPane(figuresTable);//DiagramEditorPane();
		Pane p = null;
		//Button button = new Button("Hello!!!");
		//pane.setCenter(button);
		
		//ClassFigure classFigure = new ClassFigure();
		//pane.getChildren().add(classFigure.getRoot());
		

		
/*	    TableColumn<String, String> tc = (TableColumn<String, String>) t.getColumns().get(0);
		tc.setCellValueFactory(new Recall());
		((TableColumn)t.getColumns().get(1)).setCellValueFactory(new Recall());
				
		//ObservableList<String> l = FXCollections.observableArrayList();
		final ObservableList<String> data = FXCollections.observableArrayList("234", "456");
		t.setItems(data);*/
		
		Scene scene = new Scene(editorPane.getRoot());
		return scene;
	}

	@Override
	protected void setFxFocus() {
		
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// TODO Auto-generated method stub
		super.setSite(site);
		super.setInput(input);
		setPartName(input.getName());
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}
}