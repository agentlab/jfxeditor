package ru.agentlab.jfxed.figures.testgoal

import javafx.scene.layout.VBox
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IFigure
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors

class TestGoal extends XNode implements IFigure {
	
	String name = "Test\n(Sample)";
	var Text textBox
	
	new (){
		super("Class")
		node = new VBox
		
		//initHandlers()
		
		val s = TestGoal.getResource("TestGoal.css").toExternalForm()
		stylesheets += s
		
		styleClass += "ClassFigure";
		
		children += new VBox => [
			
			children += new Polyline => [
				styleClass += "ClassFigure-Line"
				
				points += 10d
				points += 110d
				points += 12d
				points += 110d
				points += 18d
				points += 140d
				points += 42d
				points += 140d
				points += 48d
				points += 110d
				points += 50d
				points += 110d
				points += 48d
				points += 110d
				points += 42d
				points += 80d
				points += 18d
				points += 80d
				points += 12d
				points += 110d
				
			]
		
			textBox =  new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				setTranslateX(175);
				setTranslateY(-80);
			]
			children += textBox
		]
		
	}
	
	override getRoot() {
		this
	}
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	def setName(String name) {
		
		textBox.text = name
	}
	
}