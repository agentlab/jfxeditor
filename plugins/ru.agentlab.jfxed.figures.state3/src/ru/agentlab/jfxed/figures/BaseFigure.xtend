package ru.agentlab.jfxed.figures

import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane

class BaseFigure {
	protected Pane root
	
	var double sceneStartX = 0       
	var double sceneStartY = 0
	var double figureStartTranslateX = 0
	var double figureStartTranslateY = 0
	// Начальные размеры объекта
	var public double initWidth = 320
	var public double initHeight = 150
	// Максимальные размеры объекта
	var public double maxWidth = 350
	var public double maxHeight = 300
	// Минимальные размеры объекта
	var public double minWidth = 200
	var public double minHeight = 100
	
	var public double sizeStartX = 0
	var public double sizeStartY = 0
	var public double rootWidth = 0
	var public double rootHeight = 0
	
	var Node node = null;

	var public boolean resizing = false
	var public boolean dragged = false
	
	def public Pane getRoot() {
		return root
	}
	
	def void initHandlers() {
		root.onMouseClicked = [ MouseEvent event |
			if (!dragged) {
				resizing = !resizing;
			}
			if (resizing) {
				root.setStyle("	-fx-border-width: 1;
								-fx-border-color: red	"); 
			} else {
            	root.setStyle("	-fx-border-style: null;	");
			}
            dragged = false
		]
		
		//root.onMouseReleased = [ MouseEvent event |
		//	println("Mouse released")
	    //]

		root.onMousePressed = [ MouseEvent event |
			println("Mouse pressed")

			sceneStartX = event.getSceneX()
			sceneStartY = event.getSceneY()

			sizeStartX = event.getSceneX()
			sizeStartY = event.getSceneY()

			rootWidth = root.width
			rootHeight = root.height 
			
			node = event.source as Node
			figureStartTranslateX = node.translateX
			figureStartTranslateY = node.translateY	
	    ]

		root.onMouseDragged = [ MouseEvent event |
			dragged = true
			if (!resizing) {
				println("Moving: [x:" + event.sceneX + "] [y:" + event.sceneY + "]");
				root.translateX = figureStartTranslateX + event.sceneX - sceneStartX;
				root.translateY = figureStartTranslateY + event.sceneY - sceneStartY;
			} else {
				println("Resizing [x:" + event.sceneX + "] [y:" + event.sceneY + "]");
	        	root.setPrefWidth = rootWidth + event.sceneX - sizeStartX;
	        	root.setPrefHeight = rootHeight + event.sceneY - sizeStartY;
			}
		]
	}
}
