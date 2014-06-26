package ru.agentlab.jfxed.figures.clazz2

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.Group;
class Path extends BaseFigure {
	
	String name = "ClassName";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = Path.getResource("Path.css").toExternalForm()
		root.stylesheets += s
		var pligon = new Polygon()
		pligon.getPoints().addAll(#[
			200.0, 40.0,
			200.0, 20.0,
			220.0, 0.0, 
			240.0, 20.0, 
			240.0, 40.0, 
			220.0, 20.0
		])
		pligon.setFill(Color.YELLOW)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(1.0)
		var group = new Group(pligon)
		 	root.children +=group
		
	////
	
}
}	
	