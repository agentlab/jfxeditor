package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.*
import javafx.scene.shape.Arc

class ClassFigure extends BaseFigure {
	
	String name = "Event";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			
			
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				
				
			root.children += new HBox => [
				
				
				
				children += new HBox => [
			
						styleClass += "Figure"
				
						]
						children += new HBox => [
			
						styleClass += "Figure2"
							children += new HBox => [
						styleClass += "Circle2"
					    translateX = 5;
						]
						
						]
						
				children += new HBox => [
						styleClass += "Circle1"
						
						
						
						
						
						children += new Text => [
						text = "                                                                         "
						styleClass += "ClassCircle-Text"
						]
						
					
						
						]
				/*children += new HBox => [
						styleClass += "Circle1"
						children += new HBox => [
						
						children += new HBox => [
						styleClass += "Circle1"
						
						]	
						] 
						]*/
						
						
				styleClass += "Circle"
			]	
			
							
	]
				
]
	}
}
