package ru.agentlab.jfxed.figures.clazz

import de.fxdiagram.core.XNode
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import javafx.scene.shape.Rectangle
import javafx.scene.Group;

public class ClassFigure extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	
	new() {
		super("Class")
		
		name = "Component"
		
		node = new Group  => [
			stylesheets += ClassFigure.getResource("ClassFigure.css").toExternalForm()
			
			children += new Rectangle => [
				styleClass += "ClassFigure-Rect";
				width = 320;
				height = 160;
			]
			
			children += nameTextBox => [
				styleClass += "ClassFigure-Text"
				text = name			
				translateX = 70;
				translateY = 90;			
			]
			
			children += new Group => [
				translateX = 250;
				translateY = 10;
				
				children += new Rectangle => [
					styleClass += "ClassFigure-Rect"
					width = 50;
					height = 60;				
				]
				children += new Rectangle => [
					styleClass += "ClassFigure-Rect"
					width = 30;
					height = 15;
					translateX = -15;
					translateY = 10;
				]
				children += new Rectangle => [
					styleClass += "ClassFigure-Rect"
					width = 30;
					height = 15;
					translateX = -15;
					translateY = 35;
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