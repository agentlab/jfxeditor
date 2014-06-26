package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline

class ClassFigure extends BaseFigure {
	
	String name = "Process";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Arrow"
			
			children += new Polyline => [
				
				points += #[
					  0.0, 5.0,
			        10.0, 5.0,
			        10.0, 0.0,
			        20.0, 7.5,
			        10.0, 15.0,
			        10.0, 10.0,
			        0.0, 10.0,
			        0.0, 5.0	
	
				]
			]	
		]
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]	
		]
	}	
}