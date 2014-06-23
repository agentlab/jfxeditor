package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.Group;
import ru.agentlab.jfxed.figures.BaseFigure

class trap extends BaseFigure {
	new (){
		root = new VBox


		var pligon = new Polygon()
		pligon.getPoints().addAll(#[
			0.0, 10.0,
			10.0, 0.0,
			75.0, 0.0,
			85.0, 10.0 
			
		])
		pligon.setFill(Color.CYAN)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(0.8)
		var group = new Group(pligon)
		root.children += group
		root.translateX = 199
		root.translateY = 92.5
	}

}		