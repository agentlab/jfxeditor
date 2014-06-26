package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polygon
import javafx.scene.paint.Color

class ClassArrow extends BaseFigure {
		
	new (){
		root = new VBox
		
		initHandlers()
				
		root.children += new HBox => [
			styleClass += "ClassFigure-Array"
			
			children += new Polygon => [
				
				points += #[
					 0.0, 15.0,
			        50.0, 15.0,
			        50.0, 0.0,
			        75.0, 30.0,
			        50.0, 60.0,
			        50.0, 45.0,
			        0.0, 45.0,
			        0.0, 15.0
				]
				setFill(Color.web("FFE873"))
				setStroke(Color.BLACK)
			]	
		]	
	}	
}