package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.Group;
import javafx.scene.layout.HBox
import ru.agentlab.jfxed.figures.BaseFigure

class miniTrap extends BaseFigure {
	new (){
		root = new VBox
		initHandlers()

		var pligon = new Polygon()
		pligon.getPoints().addAll(#[
			0.0, 5.0,
			3.0, 0.0,
			10.0, 0.0,
			13.0, 5.0 
			
		])
		pligon.setFill(Color.CYAN)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(1.5)
		var group = new Group(pligon)
		root.children += group
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section1"
			]
		root.translateX = 125
		root.translateY = 73
	}

}	