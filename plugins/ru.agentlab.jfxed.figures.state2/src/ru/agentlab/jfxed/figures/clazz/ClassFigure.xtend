package ru.agentlab.jfxed.figures.clazz

import de.fxdiagram.core.XNode
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class ClassFigure extends XNode implements IFigure {
	
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
		
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
		    
		    children += new HBox => [
				styleClass += "ClassFigure-Inc"
			]		
			children += nameTextBox => [
				text = name
				styleClass += "ClassFigure-Text"
			]			
		]

		
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