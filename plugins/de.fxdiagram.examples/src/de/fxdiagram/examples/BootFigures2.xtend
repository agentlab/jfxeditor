package de.fxdiagram.examples

import javafx.application.Application
import javafx.stage.Stage
import de.fxdiagram.core.XRoot
import javafx.scene.Scene
import javafx.scene.PerspectiveCamera
import de.fxdiagram.core.XDiagram
import de.fxdiagram.core.XConnection
import de.fxdiagram.lib.simple.SimpleNode
import de.fxdiagram.core.XConnectionKind
import de.fxdiagram.core.XConnectionLabel

class BootFigures2 extends Application {
	
	def static main(String... args) {
		launch(args)
	}
	
	override start(Stage it) {
		title = 'FX Diagram Demo'
		scene = createScene
		show
	}
	
	def createScene() {
		val root = new XRoot
		val scene = new Scene(root, 1024, 768)
		scene.setCamera(new PerspectiveCamera)
		root.activate
		val diagram = new XDiagram
		root.diagram = diagram
		
		diagram => [
			val source = new SimpleNode('Simple Node') => [
				layoutX = 280
				layoutY = 280
				width = 80
				height = 30
			]
			getNodes += source

			val target = new SimpleNode('Simple Node') => [
				layoutX = 280
				layoutY = 280
				width = 80
				height = 30
			]
			getNodes += target

			getConnections += new XConnection(source, target) => [
				kind = XConnectionKind.QUAD_CURVE
				new XConnectionLabel(it) => [
					getText.text = 'quadratic'
				]
			]
		]
		
		root.centerDiagram
		scene
	}
	
}