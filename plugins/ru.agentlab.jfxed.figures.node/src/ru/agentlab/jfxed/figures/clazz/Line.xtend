package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline

class LineFig extends BaseFigure {
	
	Polyline line

	var double [] points
	
	new (){
		root = new VBox
				
		line = new Polyline()
		points = #[7,3,10,0,20,0,20,10,17,13,17,3,7,3,7,13,17,13,17,3,20,0]
		line.getPoints().addAll(points)
		
		root.translateX = 100
		root.translateY = 10
		root.children += line
		
		}
	}
