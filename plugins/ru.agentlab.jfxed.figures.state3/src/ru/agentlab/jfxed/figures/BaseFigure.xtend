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
		// Событие нажатия на клавишу мышки
		root.onMouseClicked = [ MouseEvent event |
			if (!dragged) { // Если не было зарегистрировано перемещения, то и не разрешаем ресайзить объект
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
		
		// Событие отпускания клавиши мышки
		//root.onMouseReleased = [ MouseEvent event |
		//	println("Mouse released")
	    //]

		// Событие зажимания клавиши мышки
		root.onMousePressed = [ MouseEvent event |
			println("Mouse pressed")
			
			// Получаем начальные координаты для перемещения объекта
			sceneStartX = event.getSceneX()
			sceneStartY = event.getSceneY()
			
			// Получаем начальные координаты для ресайза объекта
			sizeStartX = event.getSceneX()
			sizeStartY = event.getSceneY()

			// Получаем размеры объекта
			rootWidth = root.width
			rootHeight = root.height 
			
			node = event.source as Node
			figureStartTranslateX = node.translateX
			figureStartTranslateY = node.translateY	
	    ]
		
		// Событие движения мышки
		root.onMouseDragged = [ MouseEvent event |
			dragged = true
			if (!resizing) { // Перемещение объекта
				println("Moving: [x:" + event.sceneX + "] [y:" + event.sceneY + "]");
				root.translateX = figureStartTranslateX + event.sceneX - sceneStartX;
				root.translateY = figureStartTranslateY + event.sceneY - sceneStartY;
			} else { // Ресайз объекта
				println("Resizing [x:" + event.sceneX + "] [y:" + event.sceneY + "]");
	        	root.setPrefWidth = rootWidth + event.sceneX - sizeStartX;
	        	root.setPrefHeight = rootHeight + event.sceneY - sizeStartY;
			}
		]
	}
}
