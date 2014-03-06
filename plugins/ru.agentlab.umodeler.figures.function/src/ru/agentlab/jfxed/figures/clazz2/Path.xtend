package ru.agentlab.jfxed.figures.clazz2

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class Path extends BaseFigure {
	
	String name = "ClassName";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = Path.getResource("Path.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "Path";
		
		root.children += new HBox => [
			styleClass += "Path-Name-Section"
			
			children += new Text => [
				//text = name
				styleClass += "Path-Text"
			]
		]
		
		root.children += new VBox => [
			styleClass += "Path-Methods-List"
			
			children += new Text => [
			//	text = "method 1 lalalala"
			]
			
			children += new Text => [
				//text = "Function"
			]
			
			children += new Text => [
				//text = "method 3 lalalala"
			]
		]
	}
	////
	
}
	
	