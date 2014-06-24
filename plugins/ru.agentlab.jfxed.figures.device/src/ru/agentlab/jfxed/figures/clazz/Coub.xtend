package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.Group;
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.layout.HBox
import javafx.scene.text.Text

class Coub extends BaseFigure {
	new (){
		root = new VBox
		//initHandlers()

		var pligon = new Polygon()
		pligon.getPoints().addAll(#[
			10.0, 0.0,
			105.0, 00.0,
			105.0, 50.0, 
			95.0, 60.0, 
			0.0, 60.0, 
			0.0, 10.0
		])
		pligon.setFill(Color.CYAN)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(0.8)
		
		var line = new Polyline(#[
			0.0, 10.0,
		 	95.0, 10.0,
		 	105.0, 0.0, 
		 	95.0, 10.0, 
		 	95.0, 60.0])
		var group = new Group(pligon ,line)
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "trap";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
					]
		
		root.children += group
		
		root.translateX = 0
		root.translateY = 0
		}
	}
