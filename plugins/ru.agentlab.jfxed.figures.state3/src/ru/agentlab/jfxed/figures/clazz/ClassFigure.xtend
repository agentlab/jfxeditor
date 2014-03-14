package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class ClassFigure extends BaseFigure {
	new (){
		root = new VBox
		
		// Задаем параметры размера объекта
		root.setPrefHeight(initHeight)
		root.setPrefWidth(initWidth)
		root.setMaxSize(maxWidth, maxHeight)
		root.setMinSize(minWidth, minHeight)
		
		// Инициализируем обработчик мышки
		initHandlers()
		
		// Центрируем объект
		var double centerX = 0
		var double centerY = 0
		centerX = (760 / 2) - (initWidth / 2)
		centerY = (550 / 2) - (initHeight / 2)
		root.setLayoutX(centerX);
    	root.setLayoutY(centerY);
		
		// Подключаем стили
		val css = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.getStylesheets().addAll(css)
		
		root.styleClass += "ClassFigure";
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = "State 3"
				styleClass += "ClassFigure-Text"
			]
		]
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
//			children += new Text => [
//				text = ""
//			]
		]
	}
}