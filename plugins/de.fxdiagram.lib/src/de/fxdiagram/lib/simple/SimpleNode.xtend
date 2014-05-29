package de.fxdiagram.lib.simple

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.nodes.RectangleBorderPane
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.effect.InnerShadow
import javafx.scene.layout.StackPane
import javafx.scene.text.Text
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors

class SimpleNode extends XNode {

	String name

	new(String name) {
		super(name)
		this.name = name
		node = new RectangleBorderPane => [
			val label = new Text
			children += label => [
				text = name
				textOrigin = VPos.TOP
			]
			StackPane.setMargin(label, new Insets(10, 20, 10, 20))
		]
		getNode.effect = new InnerShadow => [
			radius = 7
		]
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}

	override doActivate() {
		super.doActivate
	}

	override toString() {
		name
	}
}
