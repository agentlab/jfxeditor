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
		 	95.0, 60.0
		 	])
		var line1 = new Polyline(#[
		
			70.0, 30.0,
			74.0, 26.0,
			77.0, 26.0,
			81.0, 30.0, 
			70.0, 30.0
			
		])
		var line2 = new Polyline(#[
		
			70.0, 24.0,
			70.0, 22.0,
			71,21,
			80,21,
			81.0, 22.0,
			81.0, 24.0,
			80,25,
			71,25, 
			70.0, 24.0
			
		])
		var poligon = new Polygon()
		poligon.getPoints().addAll(#[
			200.0, 62.0,
			215.0, 51.5,
			270.0, 51.5,
			285.0, 62.0 
		])
		poligon.setFill(Color.CYAN)
		poligon.setStroke(Color.BLACK)
		poligon.setStrokeWidth(0.8)
		var group = new Group(pligon ,line,line1, line2, poligon)
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s

		root.children += new Text => [
				text = "Device"
				styleClass += "ClassFigure-Text"

				]
				
		root.children += group
		

		}
	}
