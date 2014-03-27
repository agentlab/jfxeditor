package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.*
import javafx.scene.shape.Arc

class ClassFigure extends BaseFigure {
	
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				
			root.children += new HBox => [
				children += new HBox => [
						styleClass += "Circle1"
						]
				children += new HBox => [
						styleClass += "Circle1"
						children += new HBox => [
							
						] 
						]
				styleClass += "Circle"
			]	
			
							
	]
				
]
	}
}