package ru.agentlab.jfxed.figures.ass

import de.fxdiagram.core.XNode
import javafx.scene.Group
import javafx.scene.layout.GridPane
import javafx.scene.shape.Circle
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class Assessment extends XNode implements IFigure {
	
	var GridPane root
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	//String name = "Assessment";
	
	new (){
		super("Class");
		
		name = "Class";	
		
		root = new GridPane
		
		node = root
		
		val s = Assessment.getResource("ClassFigure.css").toExternalForm()
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
		
			
			
			children += nameTextBox => [
				text = name
				layoutX = 75
				layoutY = 95
				styleClass += "ClassFigure-Text"
				
			]
		
		]
		
	}
	
	override setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		this
	}
}