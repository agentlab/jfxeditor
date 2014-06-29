package ru.agentlab.jfxed.figures.device

import de.fxdiagram.core.XNode
import javafx.scene.Group
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class Coub extends XNode implements IFigure {
	
	var GridPane root
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new (){
		super("Class");
		
		name = "Class";	
		
		root = new GridPane
		node = root

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
		
			80.0, 24.0,
			84.0, 20.0,
			87.0, 20.0,
			91.0, 24.0, 
			80.0, 24.0
			
		])
		var line2 = new Polyline(#[
		
			80.0, 18.0,
			80.0, 16.0,
			81,15,
			90,15,
			91.0, 16.0,
			91.0, 18.0,
			90,19,
			81,19, 
			80.0, 18.0
			
		])
		
		
		
		var group = new Group(pligon ,line,line1, line2)
		val s = Coub.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		root.children += group
		
		root.children += new HBox => [
			styleClass += "ClassFigure1"
			root.children += nameTextBox => [
				text = name
				styleClass += "ClassFigure-Text"

				]
				
		]
		

		}
		override setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		this
	}
	
	}
