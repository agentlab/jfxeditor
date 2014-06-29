package ru.agentlab.jfxed.figures.clazz

import javafx.scene.shape.Path
import javafx.scene.shape.QuadCurveTo
import javafx.scene.paint.Color
import javafx.scene.shape.MoveTo
import javafx.scene.shape.VLineTo
import javafx.scene.shape.HLineTo


import de.fxdiagram.core.XNode;
import javafx.scene.text.Text
import javafx.scene.layout.GridPane;
import ru.agentlab.jfxed.IFigure;


class Rectangle extends XNode implements IFigure  {
	
	var GridPane gp 
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	new() {
		
		super("Class");
		
		name = "                 Class";	
		
		gp = new GridPane
		
		node = gp
		val s = Rectangle.getResource("ClassFigure.css").toExternalForm()
		gp.stylesheets += s
		
		var path = new Path()
		path.getElements().addAll(
			new MoveTo(0, 80),
			new QuadCurveTo(40, 20, 80, 80),
			new QuadCurveTo(120, 120, 160, 80),
			new VLineTo(0),
			new HLineTo(0),
			new VLineTo(80)
		)

		path.setStroke(Color.BLACK);
		path.setFill(Color.CYAN)

		path.setStrokeWidth(2);
		gp.children += path

		

		
		
			
		gp.children += nameTextBox => [
				text = name
				styleClass += "ClassFigure-Text"
						translateX = 20
						translateY = -20
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