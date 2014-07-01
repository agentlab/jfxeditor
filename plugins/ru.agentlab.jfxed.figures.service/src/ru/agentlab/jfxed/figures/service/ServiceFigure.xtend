package ru.agentlab.jfxed.figures.service

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group;
import javafx.scene.shape.Rectangle


public class ServiceFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Service"
		
		node = new Group  => [
			stylesheets += ServiceFigure.getResource("ServiceFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "service-Rect"
				width = 320
				height = 160
				arcWidth = 50
				arcHeight = 50
			]
			
			children += nameTextBox => [
				styleClass += "service-Text"
				text = name			
				translateX = 60
				translateY = 95		
			]
			
			children += new Rectangle => [
				styleClass += "service-Rect"
				width = 60
				height = 25
				arcWidth = 23
			    arcHeight = 23
			    translateX = 245
			    translateY = 10
			]
		]
		
		node.setScaleX(0.4)
		node.setScaleY(0.4)
	}
	
	def override setName(String name) {
		nameTextBox.text = name
	} 
	
	def getName() {
		nameTextBox.text
	}
	
	override getRoot() {
		return this
	}
}