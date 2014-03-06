package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassKok extends BaseFigure {
	
	String name = "              ";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassKok.getResource("ClassKok.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
/*	root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
		] 
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "   Event    "
                      
			]
			
		
		]*/
	}
}
