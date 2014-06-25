package ru.agentlab.jfxed.figures.clazz

import de.fxdiagram.core.XNode;
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.shape.Polyline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.GridPane;
import ru.agentlab.jfxed.IFigure;


class Researcher extends XNode implements IFigure  {
	
	var GridPane gp 
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	new() {
		
		super("Class");
		
		name = "Class";	
		
		gp = new GridPane
		
		node = gp
		
		val s = Researcher.getResource("ClassFigure.css").toExternalForm()
		gp.stylesheets += s
		
		
		gp.children += new HBox => [
			styleClass += "Polygon"//ClassFigure-Name-Section			
		]
		
		/**val p = new Polyline => [
			points += 50d;
			 points += 0d;
			 points += 50d;
			 points += 104d;
			styleClass += "Line"//ClassFigure-Name-Section			
			
			]**/		
			
		gp.children += nameTextBox => [
				text = name
				styleClass += "ClassFigure-Text"
			]
			/*
			children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]
		*/
	
	/*	root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "method 1 lalalala"
			]
			
			children += new Text => [
				text = "method 2 lalalala"
			]
			
			children += new Text => [
				text = "method 3 lalalala"
			]
		]*/
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