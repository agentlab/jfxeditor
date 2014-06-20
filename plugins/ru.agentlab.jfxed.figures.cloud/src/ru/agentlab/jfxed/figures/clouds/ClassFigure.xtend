package ru.agentlab.jfxed.figures.clouds

import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import javafx.scene.shape.ArcTo
import javafx.scene.shape.Path
import javafx.scene.shape.MoveTo
import de.fxdiagram.core.XNode
import javafx.scene.shape.LineTo
import javafx.scene.Group
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class ClassFigure extends XNode implements IFigure {
	
	private Path path	
	val nameTextBox = new Text
	var String name
	
	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("                Send \n            Shipping list")
		name = "                Send \n            Shipping list"
		
		path = new Path => [
			styleClass += "ClassFigure"
			elements += new MoveTo(-30, 0)

            // Create cloud.
        	elements += new ArcTo(1, 1, 0, 0, -15, true, true)
            elements += new ArcTo(1, 1, 0, 50, -45, true, true)
            elements += new ArcTo(1, 1, 0, 110, -50, true, true)
            elements += new ArcTo(1, 1, 0, 150, -40, true, true)
            elements += new ArcTo(1, 1, 0, 180, -20, true, true)
            elements += new ArcTo(1, 1, 0, 210, 5, true, true)
            elements += new ArcTo(1, 1, 0, 160, 25, true, true)
            elements += new ArcTo(1, 1, 0, 110, 45, true, true)
            elements += new ArcTo(1, 1, 0, 60, 50, true, true)
            elements += new ArcTo(1, 1, 0, 20, 30, true, true)
            elements += new ArcTo(1, 1, 0, -30, 0, true, true)
            // Create top arrow.
            elements += new MoveTo(49, -107)
        	elements += new LineTo(65, -75)
        	elements += new MoveTo(65, -90)
        	elements += new LineTo(65, -75)
        	elements += new MoveTo(55, -84)
        	elements += new LineTo(65, -75)
        	// Create bottom line.
        	elements += new MoveTo(134, 63)
        	elements += new LineTo(145, 85)		
            
		]
		
		node = new VBox  => [		
			children += new Group => [
				children += path
				children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]
			]			
		]			
	}
	
	def setName(String name) {
		nameTextBox.text = name
	}
	
	def getName() {
		nameTextBox.text
	}
	
	override getRoot() {
		return this
	}

}

	
	
	
	

