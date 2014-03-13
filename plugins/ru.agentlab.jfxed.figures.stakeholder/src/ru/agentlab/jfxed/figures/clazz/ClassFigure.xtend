package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline
import javafx.scene.Group
import javafx.scene.shape.Circle

class ClassFigure extends BaseFigure {
	
	String name = "Stakeholder";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.children += new Group => [
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
}