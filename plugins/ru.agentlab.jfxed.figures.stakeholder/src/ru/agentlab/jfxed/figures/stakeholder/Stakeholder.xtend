package ru.agentlab.jfxed.figures.stakeholder

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.IFigure
import javafx.scene.Group
import javafx.scene.shape.Polyline
import javafx.scene.shape.Circle
import javafx.scene.text.Text

class Stakeholder extends XNode implements IFigure {
	var String name
	
	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		name = "Class"
		
		node = new VBox  => [
			val s = Stakeholder.getResource("Stakeholder.css").toExternalForm()
			stylesheets += s
			
			children += new Group => [
			children += new Polyline => [
					points +=  60d 
					points +=  40d 
					points +=  40d
					points +=  60d
		            points += 40d
		            points += 120d                      
		            points += 60d
		            points += 140d	            	            
		            points += 200d
		            points += 140d	            
		            points += 220d
		            points += 120d	            
		            points += 220d
		            points += 60d	            
		            points += 200d
		            points += 40d             
		            points += 60d 
		            points += 40d
		            
		            styleClass.clear
		            styleClass += "Vasya"
				] 
							
				children += new Circle => [
					 centerX = 160 
					 centerY = 70
					 radius = 10
				]
	
				children += new Text => [
					text = name
					styleClass += "ClassFigure-Text"
					layoutX = 85
					layoutY = 95
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
