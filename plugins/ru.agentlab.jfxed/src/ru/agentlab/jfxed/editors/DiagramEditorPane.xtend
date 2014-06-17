package ru.agentlab.jfxed.editors

import de.fxdiagram.core.XDiagram
import de.fxdiagram.core.XNode
import de.fxdiagram.core.XRoot
import java.util.HashMap
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import org.eclipse.core.runtime.IConfigurationElement
import ru.agentlab.jfxed.IDiagram
import ru.agentlab.jfxed.IFigure
import javafx.scene.paint.Color
import javafx.scene.layout.Background

class DiagramEditorPane extends BasePane {
	
	public VBox paletteViewer	
	public Pane diagramPane
	
	new() {
		root = new BorderPane => [
			paletteViewer = new VBox => [
				setMinWidth = 100
				setMaxWidth = 100
			]
			right = paletteViewer
			
			diagramPane = new Pane() => [
//				prefWidthProperty.bind(root.scene.widthProperty)
//				prefHeightProperty.bind(root.scene.heightProperty)
			]
			center = diagramPane
		]
	}
	
	override initDiagram(HashMap<String, IConfigurationElement> figuresTable, HashMap<String, IConfigurationElement> diagramsTable) {
		val root2 = new XRoot() => [
//			diagramCanvas.prefWidthProperty.bind(root.cen scene.widthProperty)
		]
		diagramPane.children += root2
		root2.activate
		
		val diagram = new XDiagram
		root2.diagram = diagram
		
		for (String figureText : figuresTable.keySet) {
			paletteViewer.children += new Button => [
				text = figureText
				wrapText = true
				setPrefWidth = 100
				onMouseClicked = [ MouseEvent event |
					var o = figuresTable.get(text).createExecutableExtension("class")
					val XNode n = (o as IFigure).getRoot()
					diagram.nodes += n
				]
			]
		}

		for (String diagramText : diagramsTable.keySet) {
			paletteViewer.children += new Button => [
				text = diagramText
				wrapText = true
				setPrefWidth = 100
				disable = true
				//onMouseClicked = [ MouseEvent event |
				//	var o = figuresTable.get(text).createExecutableExtension("class")
				//	(o as IDiagram).createElements(diagram)
				//]
			]
		}
		
		diagram
	}
}
