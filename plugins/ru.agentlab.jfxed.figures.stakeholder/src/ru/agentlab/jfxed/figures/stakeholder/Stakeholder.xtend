package ru.agentlab.jfxed.figures.stakeholder

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import javafx.scene.layout.VBox
import ru.agentlab.jfxed.IFigure
import javafx.scene.Group
import javafx.scene.shape.Polyline
import javafx.scene.shape.Circle
import javafx.scene.text.Text
import javafx.scene.shape.Path
import javafx.scene.shape.Arc

class Stakeholder extends XNode implements IFigure {
	var String name
	var Text boxy

	var Polyline polyline
	var Circle wurst
	var Arc wurstArc
	

	
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
		            styleClass += "Stakeholder"

		            
		            
		        
				] 
				
				children += polyline
				
				wurst = new Circle => [
					 centerX = 100 
					 centerY = 30
					 radius = 3
					 styleClass += "Wurst"
				]
							
				children += wurst
				
				children += new Polyline => [
					points += 100d
					points += 27d
					points += 90d
					points += 27d
				]
				
				children += new Polyline => [										
					points += 90d
					points += 33d
					points += 100d
					points += 33d									
				]
				
				wurstArc = new Arc() => [
					centerX = 90.0f
					centerY = 30.0f
					radiusX = 3.0f
					radiusY = 3.0f
					startAngle = 90.0f
					length = 180.0f
				//	type = ArcType.ROUND
					styleClass += "Wurst"
				]
				
				children += wurstArc
				
				
				
								
				
				boxy = new Text => [
					text = name
					styleClass += "Text"
					layoutX = 35
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
			wurst.setStyle(" -fx-fill: #ff8000")
			wurstArc.setStyle(" -fx-fill: #ff8000")
		}
		
		if (className.equals("Red")) {
			polyline.setStyle(" -fx-fill: #EE2C2C")
			wurst.setStyle(" -fx-fill: #EE2C2C")
			wurstArc.setStyle(" -fx-fill: #EE2C2C")
		}
		
		
		
		
	}

	
}
