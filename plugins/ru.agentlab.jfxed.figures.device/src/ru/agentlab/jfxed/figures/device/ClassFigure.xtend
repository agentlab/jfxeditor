package ru.agentlab.jfxed.figures.device

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.Group;
import javafx.scene.shape.Polygon
import javafx.scene.paint.Color;

class ClassFigure extends BaseFigure {
	
	
	new (){
		root = new VBox
			
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
		
		var group = new Group(poligon)
		
		
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		//root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure"
			]
		root.children += group	
		root.translateX = 200
		root.translateY = 10
			
				
		
	}
}