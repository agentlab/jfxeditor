package ru.agentlab.jfxed.figures.decision

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure

class ClassFigure extends XNode implements IFigure {
	
	String name = "Ѕыть или не быть?";
	
		val tekst = new Text
		val vbox = new VBox
		
		new(String name) {
		super(name)
		this.name = name
	}

	new() {
		super("Class")

		name = "Class"
		node = vbox
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
	node = new Group => [
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
		
		
		
			children += tekst => [
				text = name
				styleClass += "Text"
				layoutX = 70
 				layoutY = 65
			]
		]
		
	
	}
	override setName(String name) {
		tekst.text = name
	}
	
	def getName() {
		tekst.text
	}
	override getRoot() {
		return this
	}
}