package ru.agentlab.jfxed.figures.product

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
				children += new Polyline(#[0,10,70,10,70,0]) 
			
			]
	
			children += new HBox => [
				styleClass += "ClassFigure-Name-Section"
				children += nameTextBox => [
					styleClass += "ClassFigure-Text"	
					text = "Product"
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
