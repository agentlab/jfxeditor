package ru.agentlab.jfxed.figures.interaction

import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.shape.Arc
import javafx.scene.shape.ArcType
import javafx.scene.shape.Line
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import de.fxdiagram.core.XNode

class ClassFigure extends XNode implements IFigure  {
	
	public String name = "Interaction1";
	public Text textStr;
	
	private Node root

	public def setlabel(String str1) {
		textStr.text = str1
	}

	
	new() {
		
		super("Class")
		
		root = new VBox => [
			stylesheets += ClassFigure.getResource("ClassFigure.css").toExternalForm()
			styleClass += "ClassFigure";
			//setMaxSize(10, 10)
			//setPrefSize(10,10)
			//setManaged(false)
			
			children += new HBox => [
				styleClass += "ClassFigure2SemiCircleCENTRED"
				children += new Arc() => [
					styleClass += "ClassFigure2SemiCircle"
					centerX = 50.0f
					centerY = 50.0f
					radiusX = 15.0f
					radiusY = 15.0f
					startAngle = 90.0f
					length = 180.0f
					type = ArcType.ROUND
				]
				children += new Line() => [
					styleClass += "ClassFigureLine";
					setStartX(0.0f);
					setStartY(0.0f);
					setEndX(5.0f);
					setEndY(0.0f);
				]
				children += new Arc() => [
					styleClass += "ClassFigure2SemiCircle"
					centerX = 50.0f
					centerY = 50.0f
					radiusX = 15.0f
					radiusY = 15.0f
					startAngle = -90.0f
					length = 180.0f
					type = ArcType.ROUND
				]
			]
			
			children += new HBox => [
				styleClass += "ClassFigure-Name-Section"
				textStr = new Text => [
					styleClass += "ClassFigure-Text"
					
				]
				children += textStr
			]
		]
		
		setlabel("Interaction")

	}
	
	override getRoot() {
		return this
	}
	
}
