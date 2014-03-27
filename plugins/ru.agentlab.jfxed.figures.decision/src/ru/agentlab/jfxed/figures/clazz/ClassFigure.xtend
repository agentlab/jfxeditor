package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline

class ClassFigure extends BaseFigure {
	
	String name = "Ѕыть или не быть?";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
	
	root.children += new Group => [
 		children += new Polyline => [
 				points +=  30d 
 				points +=  60d 
 				points +=  150d
 				points +=  0d
 	            points += 270d
 	            points += 60d                      
 	            points += 150d
 	            points += 120d	            	            
 	            points += 30d
 	            points += 60d	            
 	            
 	            
 	            styleClass += "Polyline"
 
         ]
 			 
		
		//root.styleClass += "ClassFigure"; //figure
		
		
		
			children += new Text => [
				text = name
				styleClass += "Text"
				layoutX = 70
 				layoutY = 65
			]
		]
		
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