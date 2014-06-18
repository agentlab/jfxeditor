package ru.agentlab.jfxed.figures.gap2

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Circle
import javafx.scene.shape.Line

class ClassFigure extends BaseFigure {
	
	String name = "Gap";
	
	var h = 100
	
	new (){
		root = new VBox => [
			setTranslateX(20)
			setTranslateY(20)
		]
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.children += new HBox => [
			setMinWidth(400)
			setMinHeight(h)
			
			styleClass += "ClassFigure";
			
			children += new Text => [
				styleClass += "ClassFigure-Text"
			
				text = name
				
				setTranslateX(40)
				setTranslateY(33)
			]
			
			children += new Circle => [
				styleClass += "ClassFigure-Circle"
				radius = 10
				setTranslateX(193)
				setTranslateY(7)
			]
			
			children += new VBox => [
				setTranslateX(162.5)
				setTranslateY(13)
				
				children += new Line => [
					styleClass += "ClassFigure-Line"
	//				setStartX(250)
					setEndX(35)
				]
				
				children += new Line => [
					styleClass += "ClassFigure-Line"
//					setStartX(250)
//					setStartY(40)
//					setEndY(20)
					setTranslateY(6)
					setEndX(35)
				]
			]
		]
		
		root.children += new HBox => [
			children += new HBox => [
				styleClass += "ClassFigure-Arc"
			
				setMinWidth(200)
				setMinHeight(h / 2.3)
				
				setTranslateY(-1)
			]
			
			children += new HBox => [
				styleClass += "ClassFigure-Arc2"
				setMinHeight(h / 2.3)
				setMinWidth(200)
				
				setTranslateY(-43)
			]
			
			setMinWidth(400)
		]
	}
}