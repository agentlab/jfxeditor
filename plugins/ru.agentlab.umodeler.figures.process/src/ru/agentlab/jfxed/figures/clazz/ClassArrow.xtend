package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline;

class ClassArrow extends BaseFigure {
	
	String name = "Process";
	
	new (){
		root = new VBox
		
		initHandlers()
			
		val s = ClassFigure.getResource("ClassArrow.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
			
		]
		
	}
	
	
	
}