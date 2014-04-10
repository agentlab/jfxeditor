package ru.agentlab.jfxed.figures.clazz;

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline

class ClassFigure extends BaseFigure {
	
	String name = "Plateau";
	
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
				setTranslateX (60)
				setTranslateY (7)

			]
	children += new Polyline => [
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
				
				points += 80d;
				points += 40d;
				
				points += 80d;
				points += 0d;
				
				points += 60d;
				points += 20d;
				
				points += 60d;
				points += 60d;
			
			]
		]
		
	}


}