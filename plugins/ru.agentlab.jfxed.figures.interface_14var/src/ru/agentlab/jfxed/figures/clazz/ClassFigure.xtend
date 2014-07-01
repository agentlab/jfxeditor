package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure extends BaseFigure {
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Image-Section"
						translateX = 10;
						translateY = -8;
		children += new HBox => [
			styleClass += "ClassFigure-Line-Section"
			children += new HBox => [
						styleClass += "Line"
						translateX = 11;
						translateY = 10;	
						]
	    ]
		children += new HBox => [
			styleClass += "ClassFigure-Circle-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = "Interface"
			]
		]
	}
	
	
	
}