package ru.agentlab.jfxed.figures.shalaev

import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class Rectangle extends BaseFigure {
	
	LineFig line1 = new LineFig()
	
	new (){
		root = new VBox
		
		val s = Rectangle.getResource("Style.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure-Rect";
		root.styleClass += "ClassFigure-Text";
		
		root.translateX = 5
		root.translateY = 5
		root.getChildren().add(line1.getRoot());
		
		root.children += new Text => [
				text = " System\nsoftware\n"
			]
		
		initHandlers()
		}
	}
