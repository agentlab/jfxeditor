package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.shape.Circle
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure extends BaseFigure {
	
	String name = "ClassName";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		/*root.children += new HBox => [
			//styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
		]*/
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "Interface"
			]
		]
		
		/*root.children += new Circle(100) => [
			
			styleClass += "ClassFigure-Circle"
			
		]*/
		/*root.children += new Circle(50) => [
			styleClass += ".ClassFigure-Circle"
		]*/
	}
}