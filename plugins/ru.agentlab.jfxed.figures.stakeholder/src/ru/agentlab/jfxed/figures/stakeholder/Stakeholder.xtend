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
	var Text boxy

	var Polyline polyline

	
	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		name = "Class111"
 
		
		node = new VBox  => [
			val s = Stakeholder.getResource("Stakeholder.css").toExternalForm()
			stylesheets += s
			
			children += new Group => [
			
			polyline = new Polyline => [
					points +=  30d 
					points +=  20d 
					points +=  20d
					points +=  30d
		            points += 20d
		            points += 60d                      
		            points += 30d
		            points += 70d	            	            
		            points += 100d
		            points += 70d	            
		            points += 110d
		            points += 60d	            
		            points += 110d
		            points += 30d	            
		            points += 100d
		            points += 20d             
		            points += 30d 
		            points += 20d
		            
		    //        styleClass.clear
		            styleClass += "Vasya"

		            
		            
		        
				] 
				
				children += polyline
							
				children += new Circle => [
					 centerX = 80 
					 centerY = 35
					 radius = 5
				]
				
				boxy = new Text => [
					text = name
					styleClass += "ClassFigure-Text"
					layoutX = 43
					layoutY = 48
				]
	
				children += boxy
			]
		]
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}

	override getRoot() {
		return this
	}
	
	def setName(String name) {
		this.name = name
		boxy.text = name		
	}
	
	def setColor(String className) {	
		
		if (className.equals("Orange")){
			polyline.setStyle(" -fx-fill: #ff8000")
		}
		
		if (className.equals("Red")) {
			polyline.setStyle(" -fx-fill: #EE2C2C")
		}
		
		
		
		
	}

	
}
