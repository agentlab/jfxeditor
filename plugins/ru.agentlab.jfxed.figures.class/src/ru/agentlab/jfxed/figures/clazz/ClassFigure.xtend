package ru.agentlab.jfxed.figures.clazz

import de.fxdiagram.core.XNode
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors

class ClassFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	val methodsCompartment = new VBox
	
	new(String name) {
		super(name)
		
		node = new VBox  => [
			stylesheets += ClassFigure.getResource("ClassFigure.css").toExternalForm()
			styleClass += "ClassFigure"
			
			children += new HBox => [
				styleClass += "ClassFigure-Name-Section"
			
				children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]
			]
			
			children += methodsCompartment => [
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
			]
		]
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	override getRoot() {
		return this
	}
	
}