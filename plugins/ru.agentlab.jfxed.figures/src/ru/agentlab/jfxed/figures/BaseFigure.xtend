package ru.agentlab.jfxed.figures

import javafx.scene.Node
import javafx.scene.layout.Pane
import ru.agentlab.jfxed.IFigure
import javafx.scene.input.MouseEvent

class BaseFigure implements IFigure {
	protected Pane root
	
	var double sceneStartX = 0
	var double sceneStartY = 0
	var double figureStartTranslateX = 0
	var double figureStartTranslateY = 0
	
	var Node node = null;
	
	override public Pane getRoot() {
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