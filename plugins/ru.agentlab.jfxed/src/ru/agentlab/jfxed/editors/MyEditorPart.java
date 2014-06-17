package ru.agentlab.jfxed.editors;

import java.io.InputStream;
import java.util.HashMap;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import de.fxdiagram.core.XDiagram;
import ru.agentlab.jfxed.IDiagram;
import ru.agentlab.jfxed.impl.Activator;
import ru.agentlab.jfxed.workbench3.FXEditorPart;

public class MyEditorPart extends FXEditorPart {
	public static String ID = "ru.agentlab.jfxed.editors.MyEditorPartId"; //$NON-NLS-1$
	
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/jfxed";
	static String NS = SOURCE + "#";
	
	public static HashMap<String, IConfigurationElement> figuresTable = new HashMap<>();
	public static HashMap<String, IConfigurationElement> diagramsTable = new HashMap<>();
	
	OntModel jenaModel;
	String ontoUri;
	XDiagram jfxDiagram;
	
	protected void searchFigures(IExtensionRegistry registry) throws CoreException {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(Activator.FIGURE_ID);
		for (IConfigurationElement e : config) {
			System.out.println("Evaluating extension");
			try {
				figuresTable.put(e.getAttribute("name"), e);
			} catch (InvalidRegistryObjectException e1) {
				e1.printStackTrace();
			}
		}
		
		config = registry.getConfigurationElementsFor(Activator.DIAGRAM_ID);
		for (IConfigurationElement e : config) {
			System.out.println("Evaluating extension");
			try {
				diagramsTable.put(e.getAttribute("ontoUri"), e);
			} catch (InvalidRegistryObjectException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	protected Scene createFxScene() {
		
		try {
			searchFigures(Platform.getExtensionRegistry());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		BasePane editorPane = new DiagramEditorPane();
		Scene scene = new Scene(editorPane.getRoot());
		//scene.setCamera(new PerspectiveCamera());
		
		jfxDiagram = editorPane.initDiagram(figuresTable, diagramsTable);
		
		IDiagram diagram = findDiagram(ontoUri);
		if(diagram != null)
			diagram.createJfx(jenaModel, jfxDiagram);
		else
			System.out.println("Diagram not found for ontoUri=" + ontoUri);
		
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
		super.setSite(site);
		super.setInput(input);
		
		jenaModel = ModelFactory.createOntologyModel();
		
		if(input == null)
			return;
		
		setPartName(input.getName());
			
		IFile f = ((FileEditorInput)input).getFile();
		try {
			InputStream inputStream = f.getContents();
			jenaModel.read(inputStream, NS, "RDF/XML");
			jenaModel.write(System.out, "RDF/XML");//и в консоль
				
			ontoUri = jenaModel.getNsPrefixURI("").replace("#", "");
			System.out.println(ontoUri);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private IDiagram findDiagram(String ontoUri) {
		try {
			IConfigurationElement icfe = diagramsTable.get(ontoUri);
			if(icfe == null) {
				System.out.println("Cannot find plug-in with diagram with URI=" + ontoUri);
				return null;
			}
			
			Object o = icfe.createExecutableExtension("class");
			if(o instanceof IDiagram)
				return (IDiagram)o;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		System.out.println("Cannot create diagram with URI=" + ontoUri);
		return null;
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