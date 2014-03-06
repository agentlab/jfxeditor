package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.shape.Circle
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure2 extends BaseFigure {
	
	String name = "ClassName";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure2.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Circle(10) => [
			]
		]
	}
}