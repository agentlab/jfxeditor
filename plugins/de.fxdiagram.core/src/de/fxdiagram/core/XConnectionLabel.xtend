package de.fxdiagram.core

import de.fxdiagram.annotations.properties.FxProperty
import de.fxdiagram.core.behavior.MoveBehavior
import java.util.List
import javafx.geometry.VPos
import javafx.scene.effect.DropShadow
import javafx.scene.effect.Effect
import javafx.scene.text.Text
import javafx.scene.transform.Affine

import static extension de.fxdiagram.core.extensions.TransformExtensions.*
import static extension java.lang.Math.*
import javafx.scene.text.Font

class XConnectionLabel extends XShape {

	@FxProperty XConnection connection
	@FxProperty Text text
	@FxProperty double position = 0.5

	Effect selectionEffect

	new(XConnection connection) {
		this.connection = connection
		connection.labels += this
		text = new Text => [
			textOrigin = VPos.TOP
			font = Font.font(font.family, font.size * 0.9)
			fillProperty.bind(connection.strokeProperty)
		]
		node = text
		selectionEffect = new DropShadow
	}

	override doActivate() {
		addBehavior(new MoveBehavior(this))
	}
	
	override selectionFeedback(boolean isSelected) {
		if (isSelected) {
			effect = selectionEffect
			scaleX = 1.05
			scaleY = 1.05
			connection.selected = true
		} else {
			effect = null
			scaleX = 1.0
			scaleY = 1.0
		}
	}

	def void place(List<XControlPoint> list) {
		val center = connection.at(position)
		val derivative = connection.derivativeAt(position)
		var angle = atan2(derivative.y, derivative.x)
		val labelDx = -boundsInLocal.width / 2
		var labelDy = 1
		if (abs(angle) > PI / 2) {
			if (angle < 0)
				angle = angle + PI
			else if (angle > 0)
				angle = angle - PI
		}
		val transform = new Affine
		transform.translate(labelDx, labelDy)
		transform.rotate(angle.toDegrees)
		layoutX = transform.tx + center.x
		layoutY = transform.ty + center.y
		transform.tx = 0
		transform.ty = 0
		transforms.setAll(transform)
	}
}
