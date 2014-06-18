package ru.agentlab.jfxed.figures.clazz;

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline
import javafx.scene.shape.Line

class ClassFigure extends BaseFigure {
	
	String name = "Plateau";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [


	children += new Polyline => [
		styleClass += "ClassFigure-Name-Section"
		
				points += 0d;
				points += 20d;
				
				points += 20d;
				points += 0d;
				
				points += 80d;
				points += 0d;
				
				points += 60d;
				points += 20d;
				
				points += 0d;
				points += 20d;
				
				points += 0d;
				points += 60d;
				
				points += 60d;
				points += 60d;
				
				points += 60d;
				points += 20d;
				
		
				points += 80d;
				points += 0d;
				
				
				points += 80d;
				points += 40d;
				
				points += 60d;
				points += 60d;
			
			    points += 60d;
				points += 20d;
				
			
			]
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				setTranslateX (-70)
				setTranslateY (30)

			]
			
			children += new Line => [
				
				setTranslateX (-75)
				setTranslateY (25)
				
				setStartX(-10)
				

			]
			
			children += new Line => [
				
				setTranslateX (-90)
				setTranslateY (28)
				
				setStartX(-10)
			

			]
			children += new Line => [
				
				setTranslateX (-105)
				setTranslateY (31)
				
				setStartX(-10)
				
			]
		
		]
		
	}


}