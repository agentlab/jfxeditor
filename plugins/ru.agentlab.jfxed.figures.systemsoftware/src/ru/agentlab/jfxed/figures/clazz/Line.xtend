package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Path
import javafx.scene.shape.ArcTo
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo

class LineFig extends BaseFigure {
	
	Path path
	ArcTo arcto
	ArcTo arcto1
	ArcTo arcto2
	LineTo line1
	LineTo line2
	MoveTo move1
	MoveTo move2

	
	new (){
		root = new VBox
		
		path = new Path()
		arcto = new ArcTo()
		arcto1 = new ArcTo()
		arcto2 = new ArcTo()
		line1 = new LineTo()
		line2 = new LineTo()
		move1 = new MoveTo()
		move2 = new MoveTo()
		
		move1.setX(0)
		move1.setY(15)
		
		arcto.setX(10)
		arcto.setY(25)
		arcto.setRadiusX(7)
		arcto.setRadiusY(7)
		
		arcto1.setX(0)
		arcto1.setY(15)
		arcto1.setRadiusX(7)
		arcto1.setRadiusY(7)
		
		move2.setX(10)
		move2.setY(25)
		
		line1.setX(15)
		line1.setY(20)
		
		arcto2.setX(5)
		arcto2.setY(10)
		arcto2.setRadiusX(7)
		arcto2.setRadiusY(7)
		
		line2.setX(0)
		line2.setY(15)
		
		path.getElements().add(move1)
		path.getElements().add(arcto)
		path.getElements().add(arcto1)
		path.getElements().add(move2)
		path.getElements().add(line1)
		path.getElements().add(arcto2)
		path.getElements().add(line2)
		
		root.translateX = 125
		root.translateY = -10
		root.children += path
		
		}
	}
