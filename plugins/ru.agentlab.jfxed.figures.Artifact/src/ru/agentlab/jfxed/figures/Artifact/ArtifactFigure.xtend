package ru.agentlab.jfxed.figures.Artifact

import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.shape.Rectangle
import javafx.scene.shape.Polyline

public class ArtifactFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Artifact"
		
		node = new Group  => [
			stylesheets += ArtifactFigure.getResource("ArtifactFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "artifact-Rect"
				width = 340
				height = 170
			]
			
			children += nameTextBox => [
				styleClass += "artifact-Text"
				text = name
				translateX = 60
				translateY = 105
			]
			
			
			children += new Group => [
				children += new Polyline(
					0, 0,
					35, 0,
					55, 20,
					55, 60,
					0, 60,
					0, 0
				)
				
				children += new Polyline(
					35, 0,
					35, 20,
					55, 20
				)
				
				translateX = 265
				translateY = 15
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