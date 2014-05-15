package ru.agentlab.jfxed.editors

import java.util.HashMap
import javafx.scene.control.Button
import javafx.scene.control.SplitPane
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.IFigure
import org.eclipse.core.runtime.IConfigurationElement

class DiagramEditorPane extends ru.agentlab.jfxed.editors.BasePane {
	
	public VBox paletteViewer = new VBox
	public DiagramPane diagramPane = new DiagramPane
	
	new(HashMap<String, IConfigurationElement> figuresTable) {
		root = new SplitPane => [
			items += diagramPane.root
			items += paletteViewer
			dividerPositions = 0.8
			
 			for(String figureText : figuresTable.keySet) {
				paletteViewer.children += new Button => [
					text = figureText
					
					onMouseClicked = [ MouseEvent event |
						var o = figuresTable.get(figureText).createExecutableExtension("class")
						(diagramPane.root as AnchorPane).children += (o as IFigure).root
					]
				]
			}
		]
	}
}
