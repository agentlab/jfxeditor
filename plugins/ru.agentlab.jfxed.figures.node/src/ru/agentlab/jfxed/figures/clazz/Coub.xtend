package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.Group;
import ru.agentlab.jfxed.figures.BaseFigure

class Coub extends BaseFigure {
	new (){
		root = new VBox

		var pligon = new Polygon()
		pligon.getPoints().addAll(#[10.0, 0.0, 80.0, 00.0, 80.0, 50.0, 70.0, 60.0, 0.0, 60.0, 0.0, 10.0])
		pligon.setFill(Color.CYAN)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(0.8)
		
		var line = new Polyline(#[0.0, 10.0, 70.0, 10.0, 80.0, 0.0, 70.0, 10.0, 70.0, 60.0])
		var group = new Group(pligon,line)
		root.children += group
		
		root.translateX = 160
		root.translateY = 5
		
		}
	}
