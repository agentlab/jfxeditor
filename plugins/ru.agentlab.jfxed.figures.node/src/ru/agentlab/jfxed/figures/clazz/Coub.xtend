package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.Node


class Coub extends BaseFigure {
	
	//String name = "ClassName";

	var double sceneStartX = 0
	var double sceneStartY = 0
	var double figureStartTranslateX = 0
	var double figureStartTranslateY = 0
	var Node node = null;

	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = Coub.getResource("Style.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure-Coub";
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
		]
		
		
		
		}
		@Override
		override void initHandlers(){
			
			root.onMousePressed = [ MouseEvent event |
			println("setOnMousePressed_adada")
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
