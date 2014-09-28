package ru.agentlab.jfxed.figures.CommunicationPath

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle
import javafx.scene.shape.Polyline
import javafx.scene.shape.Line

public class CommunicationPathFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name
	
	val name2TextBox = new Text
	val String name2

	new(String name) {
		super(name)
		this.name = name
		this.name2 = ""
	}
	
	new() {
		super("Class")
		
		name = "Communication"
		name2 = "path"
		
		node = new Group  => [
			stylesheets += CommunicationPathFigure.getResource("CommunicationPathFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "communicationPath-Rect"
				width = 350
				height = 150
			]
			
			children += nameTextBox => [
				styleClass += "communicationPath-Text"
				text = name
				translateX = 55
				translateY = 80
			]
			
			children += name2TextBox => [
				styleClass += "communicationPath-Text"
				text = name2
				translateX = 120
				translateY = 110
			]
			
			children += new Group => [
				children += new Polyline(
					10, -10,
					0, 0,
					10, 10
				)
				
				children += new Polyline(
					40, -10,
					50, 0,
					40, 10
				)
				
				children += new Line(5, 0, 15, 0)
				children += new Line(20, 0, 30, 0)
				children += new Line(35, 0, 45, 0)
				
				translateX = 290
				translateY = 25
			]
			
		]
		
		node.setScaleX(0.6)
		node.setScaleY(0.6)
	}
	
	def override setName(String name) {
		nameTextBox.text = name
		name2TextBox.text = ""
	}
	
	def getName() {
		nameTextBox.text
	}
	
	override getRoot() {
		return this
	}
}