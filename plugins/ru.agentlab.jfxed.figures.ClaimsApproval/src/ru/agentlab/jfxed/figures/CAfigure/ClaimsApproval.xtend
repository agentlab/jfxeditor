package ru.agentlab.jfxed.figures.CAfigure

import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import javafx.scene.shape.ArcTo
import javafx.scene.shape.Path
import javafx.scene.shape.MoveTo
import de.fxdiagram.core.XNode
import javafx.scene.shape.LineTo
import javafx.scene.Group
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.shape.HLineTo
import javafx.scene.shape.CubicCurveTo

class ClaimsApproval extends XNode implements IFigure {

	private Path path	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}

	new() {
		super("Fast[Claims \n Approval]")
		name = "Fast[Claims \n Approval]"

		path = new Path => [
			styleClass += "ClaimsApproval"
			
        	elements += new MoveTo(-35, -3)
			elements += new HLineTo(-15)
			elements += new CubicCurveTo(-15, -65, 82, -3, 150, -32)
			elements += new ArcTo(3, 10, 0, 150, 29, false, true)
			
			elements += new MoveTo(158, -3)
			elements += new LineTo(170, -3)
			elements += new MoveTo(-15, -8)
			elements += new CubicCurveTo(-7, 77, -45, -13, 150, 29) 
		]

		node = new VBox  => [		
			children += new Group => [
				children += path
				children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]
			]			
		]			
	}

	def setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}

	override getRoot() {
		return this
	}

}



/* 
import de.fxdiagram.core.XNode
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import javafx.scene.shape.Path
import javafx.scene.shape.MoveTo
import javafx.scene.shape.LineTo
import javafx.scene.shape.ArcTo
import javafx.scene.shape.CubicCurveTo
import javafx.scene.shape.HLineTo
import javafx.scene.Group

class ClassFigure extends XNode implements IFigure {
	
	public String name = "Fast[Claims \n Approval]";
	public Text textStr;
	
	private Path path
	private Text text = new Text(143, 50, name)
	
	public def setlabel(String str1) {
		textStr.text = str1
	}
	
	new(String id) {
		super(id)
	}

	new() {
		super("Text")
		path = new Path => [
			elements += new MoveTo(115, 55)
			elements += new HLineTo(130)
			elements += new CubicCurveTo(130, 0, 180, 50, 210, 30)
			elements += new ArcTo(3, 10, 0, 210, 84, false, true)
			elements += new MoveTo(218, 55)
			elements += new LineTo(230, 55)
			elements += new MoveTo(130, 50)
			elements += new CubicCurveTo(138, 135, 105, 45, 210, 85)
		]
		
		node = new Group =>[
			children += path
			children += text
		] 
	}

	override getRoot() {
		return this
	}
	
}*/