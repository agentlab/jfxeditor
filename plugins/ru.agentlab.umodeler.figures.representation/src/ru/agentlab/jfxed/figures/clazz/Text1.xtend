package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

class Text1 extends BaseFigure {

	new() {
		root = new VBox
		
        root.children += new Text => [
				text = "Representation"
			]
        root.translateX = 50
        root.translateY = 25
	}
}
