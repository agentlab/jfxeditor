package ru.agentlab.jfxed.figures.gap.tests

import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.input.MouseEvent

class BaseFigure {
	protected Pane root
	
	var double sceneStartX = 0
	var double sceneStartY = 0
	var double figureStartTranslateX = 0
	var double figureStartTranslateY = 0
	
	var Node node = null;
	
	def public Pane getRoot() {
		return root
	}
	
	def void initHandlers() {
		
		
		root.onMousePressed = [ MouseEvent event |
			println("setOnMousePressed")
			sceneStartX = event.getSceneX()
			sceneStartY = event.getSceneY()
			
			node = event.source as Node
			figureStartTranslateX = node.translateX
			figureStartTranslateY = node.translateY
	    ]
		
		root.onMouseDragged = [ MouseEvent event |
			println("setOnMouseDragged");
			println(event.sceneX + " " + event.sceneY);
			root.translateX = figureStartTranslateX + event.sceneX - sceneStartX
			root.translateY = figureStartTranslateY + event.sceneY - sceneStartY
		]
	}
}