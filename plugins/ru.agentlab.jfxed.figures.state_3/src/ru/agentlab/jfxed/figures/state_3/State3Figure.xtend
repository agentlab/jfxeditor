package ru.agentlab.jfxed.figures.state_3

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle

public class State3Figure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "State3"
		
		node = new Group  => [
			stylesheets += State3Figure.getResource("State3Figure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "state3-Rect"
				width = 350
				height = 300
				arcWidth = 50
				arcHeight = 50
			]
			
			children += new Group => [
				children += new Rectangle => [
					styleClass += "state3-RectS"
					width = 350
					height = 90
					arcWidth = 50
					arcHeight = 50
				]
				
				children += nameTextBox => [
					styleClass += "state3-Text"
					text = name
					translateX = 120
					translateY = 55
				]
				
				children += new Group => [
					children += new Rectangle => [
						styleClass += "state3-Rect"
						width = 40
						height = 40
						arcWidth = 10
						arcHeight = 10
					]
					
					children += new Rectangle => [
						styleClass += "state3-Rect"
						width = 40
						height = 15
						arcWidth = 10
						arcHeight = 10
					]
					
					children += new Rectangle => [
						styleClass += "state3-RectB"
						width = 30
						height = 3
						translateX = 5
						translateY = 5
					]
					
					translateX = 65
					translateY = 25
				]
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