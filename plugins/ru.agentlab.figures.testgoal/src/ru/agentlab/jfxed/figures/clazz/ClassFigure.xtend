package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline

class ClassFigure extends BaseFigure {
	
	String name = "Test\n(Sample)";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new VBox => [
			
			children += new Polyline => [
				styleClass += "ClassFigure-Line"
				
				points += 100d
				points += 220d
				points += 120d
				points += 220d
				points += 180d
				points += 280d
				points += 420d
				points += 280d
				points += 480d
				points += 220d
				points += 500d
				points += 220d
				points += 480d
				points += 220d
				points += 420d
				points += 160d
				points += 180d
				points += 160d
				points += 120d
				points += 220d
				
			]
		
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				setTranslateX(175);
				setTranslateY(-80);
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