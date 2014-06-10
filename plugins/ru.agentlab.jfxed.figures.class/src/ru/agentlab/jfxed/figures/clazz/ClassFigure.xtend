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
	var String name
	
	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Class"
		
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
			]
		]
	}
	
	def setName(String name) {
		nameTextBox.text = name
	}
	
	def getName() {
		nameTextBox.text
	}
	
	def addMethod(String name) {
		methodsCompartment => [
			children += new Text => [
				text = name
			]
		]
	}
	
	def removeMethod(String name) {
		for (int i : 0 ..< methodsCompartment.children.size) {
			var t = methodsCompartment.children.get(i) as Text
			if(t.text.equals(name)) {
				methodsCompartment.children.remove(i)
				return
			}
		}
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	override getRoot() {
		return this
	}
	
}