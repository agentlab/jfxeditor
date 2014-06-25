package ru.agentlab.jfxed.figures.decision

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline


class ClassPass extends BaseFigure {
	String name = "";
	
new (){
		root = new VBox
		
		initHandlers()
		
		val s = ClassFigure.getResource("ClassPass.css").toExternalForm()
		root.stylesheets += s
				root.styleClass += "ClassPass";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
		
			children += new Text => [
				text = name
				styleClass += "Text"
				
			]
		]
		}
		}
		
				