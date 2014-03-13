package ru.agentlab.jfxed.figures.clazz2

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure2 extends BaseFigure {
	
	String name = "";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure2.getResource("ClassFigure2.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure2";
		
		root.children += new HBox => [
			styleClass += "ClassFigure2-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure2-Text"
			]
		]
		
		/*root.children += new VBox => [
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