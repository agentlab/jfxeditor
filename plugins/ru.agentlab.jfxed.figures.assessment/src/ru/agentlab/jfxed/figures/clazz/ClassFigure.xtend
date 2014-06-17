package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline
import javafx.scene.Group
import javafx.scene.shape.Circle

class ClassFigure extends BaseFigure {
	
	String name = "Assessment";
	
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
	            
	            styleClass += "Prem"

        
			] 
			
				children += new Polyline => [
				points +=  185d 
				points +=  80d 
				points +=  200d
				points +=  60d
        
			] 
			
			
						
		children += new Circle => [
				 centerX = 200 
				 centerY = 60
				 radius = 8
				 
				 styleClass += "Krug"
			]
			

	//	root.styleClass += "ClassFigure";
		
			
			
			children += new Text => [
				text = name
				layoutX = 75
				layoutY = 95
				styleClass += "ClassFigure-Text"
				
			]
		
		]
		
	}
}