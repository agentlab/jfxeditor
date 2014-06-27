package ru.agentlab.jfxed.figures.node

import de.fxdiagram.core.XNode
import javafx.scene.layout.VBox
import javafx.scene.layout.HBox
import javafx.scene.text.Text
import javafx.scene.shape.Polyline
import ru.agentlab.jfxed.IFigure
import javafx.scene.layout.GridPane

class Rectangle extends XNode implements IFigure {
	
	var GridPane gp 
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	new (){
		
		super("Class");
		
		name = "Class";	
		
		gp = new GridPane
		
		node = gp
		
		node = new VBox => [
			stylesheets += Rectangle.getResource("Style.css").toExternalForm()
			styleClass += "ClassFigure";
			
			children += new HBox => [
				styleClass += "icon"
				children += new Polyline(#[7,3,10,0,20,0,20,10,17,13,17,3,7,3,7,13,17,13,17,3,20,0]) 
			]
	
			children += new HBox => [
				styleClass += "ClassFigure-Name-Section"
				children += nameTextBox => [
					styleClass += "ClassFigure-Text"	
					text = "Node"
				]
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
		return this
	}	
}
