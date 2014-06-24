package ru.agentlab.jfxed.figures.clazz

import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.text.Text
import javafx.scene.layout.VBox

class text extends BaseFigure {
	new() {
		root = new VBox
		initHandlers()
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
			root.children += new Text => [
				text = "Device"
				styleClass += "ClassFigure-Text"
			]
		root.translateX = 78
		root.translateY = 78
	}
}