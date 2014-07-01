package ru.agentlab.jfxed.figures.event

import de.fxdiagram.core.XNode
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
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
		
		name = "Event";	
		
		root = new GridPane
		node = root
		
		val s = ClassFigure.getResource("ClassFigure.css").toExternalForm()
		root.stylesheets += s
		
		root.styleClass += "ClassFigure";
		
		root.children += new HBox => [
			styleClass += "ClassFigure-Name-Section"
			
			
			
			
			children += nameTextBox => [
				text = name
				styleClass += "ClassFigure-Text"
				
				
			root.children += new HBox => [
				
				
				
				children += new HBox => [
			
						styleClass += "Figure"
				
						]
						children += new HBox => [
			
						styleClass += "Figure2"
							children += new HBox => [
						styleClass += "Circle2"
					    translateX = 5;
						]
						
						]
						
				children += new HBox => [
						styleClass += "Circle1"
						
						
						
						
						
						children += new Text => [
						text = "                                                                         "
						styleClass += "ClassCircle-Text"
						]
						
					
						
						]
				/*children += new HBox => [
						styleClass += "Circle1"
						children += new HBox => [
						
						children += new HBox => [
						styleClass += "Circle1"
						
						]	
						] 
						]*/
						
						
				styleClass += "Circle"
			]	
			
							
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
