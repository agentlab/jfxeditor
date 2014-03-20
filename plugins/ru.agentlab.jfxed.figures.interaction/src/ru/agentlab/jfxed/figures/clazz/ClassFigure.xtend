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
				styleClass += "ClassFigure2SemiCircleCENTRED"
				
				children += new Arc() => [
					styleClass += "ClassFigure2SemiCircle"
					centerX = 50.0f
					centerY = 50.0f
					radiusX=15.0f
					radiusY=15.0f
					startAngle = 90.0f
					length = 180.0f
					type= ArcType.ROUND
					
					
				] 
				
					children += new Line() => [
						setStartX(0.0f);
						setStartY(0.0f);
						setEndX(5.0f);
						setEndY(0.0f);
					]
					
					children += new Arc() => [
					styleClass += "ClassFigure2SemiCircle"
					centerX = 50.0f
					centerY = 50.0f
					radiusX=15.0f
					radiusY=15.0f
					startAngle = -90.0f
					length = 180.0f
					type= ArcType.ROUND
					
					
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