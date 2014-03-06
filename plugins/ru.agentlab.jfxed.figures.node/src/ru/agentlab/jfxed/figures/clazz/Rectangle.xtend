package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.Node
import javafx.scene.shape.Polyline

class Rectangle extends BaseFigure {
	
	Polyline line
	//String name = "ClassName";
	var double sceneStartX = 0
	var double sceneStartY = 0
	var double figureStartTranslateX = 0
	var double figureStartTranslateY = 0
	var Node node = null;
	var double [] points
	
	new (){
		root = new VBox
		
		initHandlers()
		
		val s = Rectangle.getResource("Style.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure-Rect";
		
		/*root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
	
		]*/
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "Node"
			]
		]
		
		line = new Polyline()
		points = #[100,100, 20.0, 10.0 ,10.0,20.0]
		line.getPoints().addAll(points)
		
		root.children += line
		
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
