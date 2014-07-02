package ru.agentlab.jfxed.figures.function

import de.fxdiagram.core.XNode
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Polygon
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class ClassFigure extends XNode implements IFigure {
	
	var GridPane root
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new (){
		super("Class");
		
		name = "Function";	
		
		root = new GridPane
		node = root
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s	
		root.styleClass += "ClassFigure";
		
		//root.children += group
		
		root.children += new HBox => [
			styleClass += "ClassFigurePol"
			
			children += new Polygon => [
				points += #[
					800.0, 25.0,
				 	800.0, 20.0,
				 	805.0, 15.0, 
				 	810.0, 20.0, 
				 	810.0, 25.0,
				 	805.0, 20.0
				]
				setFill(Color.YELLOW)
				setStroke(Color.BLACK)
			]	
		]
		
		root.children += new VBox => [
			styleClass += "ClassFigure-Methods-List"
			
			children += nameTextBox => [
				text = name
			]
		]
	}
	override setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		this
	}
}