package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import de.fxdiagram.core.XNode;
import ru.agentlab.jfxed.IFigure;
import javafx.scene.layout.GridPane;

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
			styleClass += "ClassFigure-Image-Section"
		children += new HBox => [
			styleClass += "ClassFigure-Image1-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		children += new HBox => [
			styleClass += "ClassFigure-Image2-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Name-Selection"
			
			children += nameTextBox => [
				text = "Collaboration"
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