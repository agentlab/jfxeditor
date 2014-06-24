package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.layout.HBox

class LineFig extends BaseFigure {
	

	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure1";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section1"
			]
		root.translateX = 126
		root.translateY = 65	
				
		
	}
}
