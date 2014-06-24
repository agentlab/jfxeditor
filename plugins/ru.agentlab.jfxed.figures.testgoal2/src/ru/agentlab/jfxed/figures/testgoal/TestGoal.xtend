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
				
				points += 20d
				points += 110d
				points += 24d
				points += 110d
				points += 36d
				points += 140d
				points += 84d
				points += 140d
				points += 96d
				points += 110d
				points += 100d
				points += 110d
				points += 96d
				points += 110d
				points += 84d
				points += 80d
				points += 36d
				points += 80d
				points += 24d
				points += 110d
				
			]
		
			textBox =  new Text => [
				text = name
				styleClass += "ClassFigure-Text"
				setTranslateX(25);
				setTranslateY(-40);
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