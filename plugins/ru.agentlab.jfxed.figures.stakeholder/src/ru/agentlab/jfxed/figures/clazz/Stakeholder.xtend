package ru.agentlab.jfxed.figures.clazz

import de.fxdiagram.core.XNode
import javafx.scene.Group
import javafx.scene.layout.VBox
import javafx.scene.shape.Circle
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class Stakeholder extends XNode implements IFigure {
	
	new (String name){
		super(name)
		node = new VBox
		
		
		
		val s = Stakeholder.getResource("ClassFigure.css").toExternalForm()
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
			

	//	root.styleClass += "ClassFigure";
		
			
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				layoutX = 85
				layoutY = 95
			]
		
		]
		
//		root.children += new HBox => [
//			styleClass += "Kolbasa"
//			children += new Text => [
//				text = "ololo"
//				styleClass += "ClassFigure-Text"
//			]
//		
//		]
		
	/*	root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "method 1 lalalala"
			]
			
			children += new Text => [
				text = "method 2 lalalala"
			]
			
			children += new Text => [
				text = "method 3 lalalala"
			]
		]*/
	}

override getRoot() {
		
		return this
	}

}