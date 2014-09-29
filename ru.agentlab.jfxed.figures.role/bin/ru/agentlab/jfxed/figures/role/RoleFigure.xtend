package ru.agentlab.jfxed.figures.role

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle
import javafx.scene.shape.Circle


public class RoleFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Role"
		
		node = new Group  => [
			stylesheets += RoleFigure.getResource("RoleFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "role-Rect"
				width = 340
				height = 170

			]
			
			children += nameTextBox => [
				styleClass += "role-Text"
				text = name
				translateX = 80
				translateY = 100
			]
			
			children += new Group => [
							
				children += new Rectangle => [
					styleClass += "role-Rect"
					height = 22
					width = 40
					arcHeight = 20
					arcWidth = 20
					
					
				]
				
				children += new Circle => [
					styleClass += "role-Circle"
					radius = 11
					translateX = 32
			    	translateY =11
				]
			
				translateX = 285
			    translateY = 20
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