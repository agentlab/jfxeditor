package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline
import javafx.scene.Group
import javafx.scene.shape.Circle

class ClassFigure extends BaseFigure {
	
	String name = "Constraint";
	
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
				points +=  50d 
				
				points +=  180d 
				points +=  50d 
				
				points +=  175d
				points +=  60d
				
	            points += 180d
	            points += 60d  
	                                
	            points +=  185d 
				points +=  50d 	
	                        	            
	            points += 200d
	            points += 50d	
	                        
	            points += 195d
	            points += 60d	
	                        
				points +=  175d
				points +=  60d
				 
			]
			

	//	root.styleClass += "ClassFigure";
		
			
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				layoutX = 85
				layoutY = 95
			]
		
		]
		
	}
}