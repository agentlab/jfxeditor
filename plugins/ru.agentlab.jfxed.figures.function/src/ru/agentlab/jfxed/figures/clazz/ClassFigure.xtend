package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.Group;

class ClassFigure extends BaseFigure {
	
	String name = "ClassName";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s	
		root.styleClass += "ClassFigure";
		
		//root.children += group
		
		root.children += new HBox => [
			styleClass += "ClassFigurePol"
			
			children += new Polygon => [
				points += #[
					800.0, 25.0,
				 	800.0, 20.0,
				 	805.0, 15.0, 
				 	810.0, 20.0, 
				 	810.0, 25.0,
				 	805.0, 20.0
				]
				setFill(Color.YELLOW)
				setStroke(Color.BLACK)
			]	
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "Function"
			]
		]
	}
}