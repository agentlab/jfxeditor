package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure extends BaseFigure {
	
	String name = "Process";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Image-Section"
		children += new HBox => [
			styleClass += "ClassFigure-Image1-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		children += new HBox => [
			styleClass += "ClassFigure-Image2-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Name-Selection"
			
			children += new Text => [
				text = "Collaboration"
			]
			
			
		]
		
		
	}
	
	
	
}