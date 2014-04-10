package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline

class ClassPass extends BaseFigure {
	String name = "";
	
new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassPass.css").toExternalForm()
		root.stylesheets += s
				root.styleClass += "ClassPass";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
		
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				
		
			]
		]
		}
		}
		
				