package ru.agentlab.jfxed.figures.clazz.tests

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
import ru.agentlab.jfxed.figures.clazz.ClassFigure

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
				layoutY = 170
				width = 80
				height = 30
			]
			nodes += source

			val target = new ClassFigure('MyClass') => [
				layoutX = 280
				layoutY = 280
				width = 80
				height = 30
				
				addMethod("method 1 lalalala")
				addMethod("method 2 lalalala")
				addMethod("method 3 lalalala")
			]
			nodes += target
			
			val target2 = new SimpleNode('Openable') => [
				layoutX = 400
				layoutY = 240
				width = 80
				height = 30
			]
			nodes += target2

			connections += new XConnection(source, target) => [
				kind = XConnectionKind.QUAD_CURVE
				new XConnectionLabel(it) => [
					text.text = 'quadratic'
				]
			]
			
			connections += new XConnection(source, target2) => [
				kind = XConnectionKind.CUBIC_CURVE
				new XConnectionLabel(it) => [
					text.text = 'cubic'
				]
			]
			
			connections += new XConnection(target, target2) => [
				new XConnectionLabel(it) => [
					text.text = 'polyline'
				]
			]
		]
		
		root.centerDiagram
		scene
	}
	
}