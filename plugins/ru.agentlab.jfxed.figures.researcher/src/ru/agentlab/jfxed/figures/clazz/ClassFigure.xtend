package ru.agentlab.jfxed.figures.clazz

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.figures.BaseFigure
import javafx.scene.shape.Polyline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.GridPane;

class ClassFigure extends BaseFigure {
	
	String name = "Researcher";
	
	new (){
		root = new GridPane;
		
		
		initHandlers()
		
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		//root.styleClass += "ClassFigure"; //figure
		
		root.children += new HBox => [
			styleClass += "Polygon"//ClassFigure-Name-Section			
		]
		
		/*val p = new Polyline => [
			points += 50d;
			 points += 0d;
			 points += 50d;
			 points += 104d;
			styleClass += "Line"//ClassFigure-Name-Section			
			
			]	*/		
			
		root.children += new Text => [
				text = name
				styleClass += "ClassFigure-Text"
			]
		
	
	/*	root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += new Text => [
				text = "method 1 lalalala"
			]
			
			children += new Text => [
				text = "method 2 lalalala"
			]
			
			children += new Text => [
				text = "method 3 lalalala"
			]
		]*/
	}
}