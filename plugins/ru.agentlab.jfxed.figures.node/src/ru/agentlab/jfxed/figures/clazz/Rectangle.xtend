package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure


class Rectangle extends BaseFigure {
	
	new (){
		root = new VBox
		
		val s = Rectangle.getResource("Style.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure-Rect";
		
		root.translateX = 5
		root.translateY = 5
		
		root.children += new Text => [
				text = "Node"
			]
		
		}
	}
