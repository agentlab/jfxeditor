package ru.agentlab.jfxed.figures.process

import de.fxdiagram.core.XNode
import javafx.scene.layout.HBox
import javafx.scene.text.Text
import javafx.scene.shape.Polyline
import ru.agentlab.jfxed.IFigureimport javafx.scene.layout.GridPane
import javafx.scene.layout.VBox

class ClassFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name
	
	new(String name) {
		super(name)
		this.name = name
	}
	
	new (){
		
		super("Class");
		
		name = "Process"

		node = new VBox => [
			
			stylesheets += ClassFigure.getResource("ClassFigure.css").toExternalForm()
			styleClass += "ClassFigure";
			
			children += new HBox => [
				
				styleClass += "ClassFigure-Arrow"
				
				children += new Polyline => [	
					points += #[
						  0.0, 5.0,
				        10.0, 5.0,
				        10.0, 0.0,
				        20.0, 7.5,
				        10.0, 15.0,
				        10.0, 10.0,
				        0.0, 10.0,
				        0.0, 5.0	
					]
				]	
			]
			
			children += new HBox => [
				styleClass += "ClassFigure-Name-Section"
				
				children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]	
			]
		]
	}
	
	override getRoot() {
		return this
	}
	
	override setName(String name) {
		nameTextBox.text = name
	}
	
	def getName() {
		return nameTextBox.text
	}
	
}