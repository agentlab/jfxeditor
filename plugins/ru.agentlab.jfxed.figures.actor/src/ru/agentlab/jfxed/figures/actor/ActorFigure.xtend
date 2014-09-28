package ru.agentlab.jfxed.figures.actor

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle
import javafx.scene.shape.Circle
import javafx.scene.shape.Line

public class ActorFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Actor"
		
		node = new Group  => [
			stylesheets += ActorFigure.getResource("ActorFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "actor-Rect"
				width = 340
				height = 220
			]
			
			children += nameTextBox => [
				styleClass += "actor-Text"
				text = name
				translateX = 55
				translateY = 125
			]
			
			children += new Group => [
				children += new Circle => [
					styleClass += "actor-Circle"
					radius = 15
				]
				
				children += new Line(0, 15, 0, 35)
				children += new Line(-18, 20, 18, 20)
				children += new Line(0, 35, -18, 55)
				children += new Line(0, 35, 18, 55)
				
				translateX = 310
				translateY = 25
			]
			
		]
		
		node.setScaleX(0.5)
		node.setScaleY(0.5)
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