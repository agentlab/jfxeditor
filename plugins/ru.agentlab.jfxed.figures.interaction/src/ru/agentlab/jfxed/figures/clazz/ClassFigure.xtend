package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.*
import javafx.scene.shape.Arc

class ClassFigure extends BaseFigure {
	
	String name = "Interaction";
	
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
				styleClass += "ClassFigure2SemiCircle"
				
				
				children += new Arc() => [
					centerX = 50.0f
					centerY = 50.0f
					radiusX=25.0f
					radiusY=25.0f
					startAngle = 45.0f
					length = 100.0f
					//atype= ArcType.ROUND
					
					
				]
				
			]	
				
	]
				
]
			
		

		
		//root.children += new VBox => [
			//styleClass += "ClassFigure-Methods-List"
			
			
			//children += new Text => [
				//text = "Interaction"
			//]
			
		//]
	}
}