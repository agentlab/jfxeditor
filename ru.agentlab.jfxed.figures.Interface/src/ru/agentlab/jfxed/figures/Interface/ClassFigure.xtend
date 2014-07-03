package ru.agentlab.jfxed.figures.Interface

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.layout.GridPane

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
						translateX = 10;
						translateY = -8;
		children += new HBox => [
			styleClass += "ClassFigure-Line-Section"
			children += new HBox => [
						styleClass += "Line"
						translateX = 11;
						translateY = 10;	
						]
	    ]
		children += new HBox => [
			styleClass += "ClassFigure-Circle-Section"
			children += new HBox => [
						styleClass += "Circle"
						]
	    ]
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = "Interface"
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