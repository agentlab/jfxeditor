package ru.agentlab.jfxed.figures.specifications

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure extends BaseFigure {
	
	String name = "Specifications";
	
	var gap = 10;
	
	new (){
		root = new VBox => [
			setTranslateX(20)
			setTranslateY(20)
		]
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
//		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
			
			setMaxWidth(80)
		]
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Rect"
			
			setMinWidth(150)
			setMinHeight(70)
		]
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Foot"
						
			for (i: 1 ..<5) {							
				children += new HBox => [
					styleClass += "ClassFigure-Arc"
					
					setMinWidth(15)
					setMinHeight(7)
					setTranslateX(gap * i)
				]
			}
		]
	}
}