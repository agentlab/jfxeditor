package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.Group;
import javafx.scene.shape.Polygon
import javafx.scene.paint.Color;

class ClassFigure extends BaseFigure {
	
	
	new (){
		root = new VBox
				
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			]
		
		root.translateX = 200
		root.translateY = 10
			
				
		
	}
}