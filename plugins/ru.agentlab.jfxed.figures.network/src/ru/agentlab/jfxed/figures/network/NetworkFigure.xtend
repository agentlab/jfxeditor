package ru.agentlab.jfxed.figures.network

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle
import javafx.scene.shape.Circle
import javafx.scene.shape.Polyline

public class NetworkFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Network"
		
		node = new Group  => [
			stylesheets += NetworkFigure.getResource("NetworkFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "network-Rect"
				width = 340
				height = 170
			]
			
			children += nameTextBox => [
				styleClass += "network-Text"
				text = name
				translateX = 60
				translateY = 100
			]
			
			children += new Group => [
							
				children += new Polyline(
					0, 0,
					30, 0,
					20, 30,
					-10, 30,
					0, 0
				)
				
				children += new Circle => [
					styleClass += "network-Circle"
					radius = 7
				]
				
				children += new Circle => [
					styleClass += "network-Circle"
					radius = 7
					translateX = 30
				]
				
				children += new Circle => [
					styleClass += "network-Circle"
					radius = 7
					translateX = -10
					translateY = 30
				]
				
				children += new Circle => [
					styleClass += "network-Circle"
					radius = 7
					translateX = 20
					translateY = 30
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