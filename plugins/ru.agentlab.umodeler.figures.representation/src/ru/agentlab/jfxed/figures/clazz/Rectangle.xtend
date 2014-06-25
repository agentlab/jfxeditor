package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.VBox
import javafx.scene.shape.Path
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.QuadCurveTo
import javafx.scene.paint.Color
import javafx.scene.shape.MoveTo
import javafx.scene.shape.VLineTo
import javafx.scene.shape.HLineTo

class Rectangle extends BaseFigure {

	new() {
		root = new VBox
		var path = new Path()
		path.getElements().addAll(
			new MoveTo(0, 80),
			new QuadCurveTo(40, 20, 80, 80),
			new QuadCurveTo(120, 120, 160, 80),
			new VLineTo(0),
			new HLineTo(0),
			new VLineTo(80)
		)

		path.setStroke(Color.BLACK);
		path.setFill(Color.CYAN)

		path.setStrokeWidth(2);
		root.children += path
		root.translateX = 10
		root.translateY = 10
	}
}

