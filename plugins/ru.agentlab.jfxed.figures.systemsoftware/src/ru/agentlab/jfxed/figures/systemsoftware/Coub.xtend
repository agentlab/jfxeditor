package ru.agentlab.jfxed.figures.systemsoftware

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.Group;
import javafx.scene.shape.Path
import javafx.scene.shape.ArcTo
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.text.Text
import de.fxdiagram.core.XNode;
import javafx.scene.layout.GridPane;
import ru.agentlab.jfxed.IFigure;


public class Coub extends XNode implements IFigure {
		var GridPane root 
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	Path path
	ArcTo arcto
	ArcTo arcto1
	ArcTo arcto2
	LineTo line1
	LineTo line2
	MoveTo move1
	MoveTo move2

	new (){
		
	    super("Class");
		
		name = "Class";	
		
		root = new GridPane
		
		node = root
		//root = new VBox
		
		path = new Path()
		arcto = new ArcTo()
		arcto1 = new ArcTo()
		arcto2 = new ArcTo()
		line1 = new LineTo()
		line2 = new LineTo()
		move1 = new MoveTo()
		move2 = new MoveTo()

		var pligon = new Polygon()
		pligon.getPoints().addAll(#[20.0, 0.0, 240.0, 00.0, 240.0, 100.0, 220.0, 120.0, 00.0, 120.0, 0.0, 20.0])
		pligon.setFill(Color.CYAN)
		pligon.setStroke(Color.BLACK)
		pligon.setStrokeWidth(1)
		
		var line = new Polyline(#[0.0, 20.0, 220.0, 20.0, 240.0, 0.0, 220.0, 20.0, 220.0, 120.0])
		
		move1.setX(190)
		move1.setY(35)
		
		arcto.setX(200)
		arcto.setY(45)
		arcto.setRadiusX(7)
		arcto.setRadiusY(7)
		
		arcto1.setX(190)
		arcto1.setY(35)
		arcto1.setRadiusX(7)
		arcto1.setRadiusY(7)
		
		move2.setX(200)
		move2.setY(45)
		
		line1.setX(205)
		line1.setY(40)
		
		arcto2.setX(195)
		arcto2.setY(30)
		arcto2.setRadiusX(7)
		arcto2.setRadiusY(7)
		
		line2.setX(190)
		line2.setY(35)
		
		path.getElements().add(move1)
		path.getElements().add(arcto)
		path.getElements().add(arcto1)
		path.getElements().add(move2)
		path.getElements().add(line1)
		path.getElements().add(arcto2)
		path.getElements().add(line2)

		var group = new Group(pligon,line,path)
		root.children += group
		
		root.translateX = 260
		root.translateY = 5
		
		root.children += nameTextBox => [
			text = name
		]
		
	//	initHandlers()
		}
		
		override setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		return this
	}
}
