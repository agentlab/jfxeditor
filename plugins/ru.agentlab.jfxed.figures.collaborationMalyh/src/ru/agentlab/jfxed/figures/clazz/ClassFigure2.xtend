package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure2 extends BaseFigure {
	
	String name = "Process";
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure2";
		
		root.children += new HBox => [
			styleClass += "ClassFigure2-Image-Section"
		children += new HBox => [
			styleClass += "ClassFigure2-Image1-Section"
			children += new HBox => [
						styleClass += "BigCircle1"
						children += new HBox => [
						styleClass += "BigCirclefon"
						
						]
						]
	    ]
		children += new HBox => [
			styleClass += "ClassFigure2-Image2-Section"
			children += new HBox => [
						styleClass += "BigCircle"
						]
	    ]
		]
		
		
		
		
	}
	
	
	
}