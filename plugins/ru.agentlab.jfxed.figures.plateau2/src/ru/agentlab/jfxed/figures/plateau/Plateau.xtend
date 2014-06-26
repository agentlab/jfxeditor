package ru.agentlab.jfxed.figures.plateau;

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.shape.Line
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors

class Plateau extends XNode implements IFigure {
	var Text textBox
	String name = "Plateau";
	new(String name) {
		super(name)
		this.name = name
	}
	
	new (){
		super("Class")
		node = new VBox
		
	//	initHandlers()
		
		val s = Plateau.getResource("Plateau.css").toExternalForm()
		stylesheets += s
		
		styleClass += "ClassFigure";
		
		children += new HBox => [


	children += new Polyline => [
		styleClass += "ClassFigure-Name-Section"
		
				points += 0d;
				points += 20d;
				
				points += 20d;
				points += 0d;
				
				points += 80d;
				points += 0d;
				
				points += 60d;
				points += 20d;
				
				points += 0d;
				points += 20d;
				
				points += 0d;
				points += 60d;
				
				points += 60d;
				points += 60d;
				
				points += 60d;
				points += 20d;
				
		
				points += 80d;
				points += 0d;
				
				
				points += 80d;
				points += 40d;
				
				points += 60d;
				points += 60d;
			
			    points += 60d;
				points += 20d;
				
			
			]
			textBox =  new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				setTranslateX (-70)
				setTranslateY (30)

			]
			children += textBox
			
			children += new Line => [
				
				setTranslateX (-75)
				setTranslateY (25)
				
				setStartX(-10)
				

			]
			
			children += new Line => [
				
				setTranslateX (-90)
				setTranslateY (28)
				
				setStartX(-10)
			

			]
			children += new Line => [
				
				setTranslateX (-105)
				setTranslateY (31)
				
				setStartX(-10)
				
			]
		
		]
		
	}
	
	override getRoot() {
		this
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}

	override setName(String name) {
		textBox.text = name
	}

}