package ru.agentlab.jfxed.figures.specifications

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class Specifications extends XNode implements IFigure {
	
	String name = "Specifications";
	
	var gap = 10;
	
	new(String name) {
		super(name)
	}
	
	new (){
		super("lalala")
		node = new VBox => [
			setTranslateX(20)
			setTranslateY(20)
		
		
			val s = Specifications.getResource("Specifications.css").toExternalForm()
			stylesheets += s
			
	//		root.styleClass += "ClassFigure";
			
			children += new HBox => [
				styleClass += "Specifications"
				
				children += new Text => [
					text = name
					styleClass += "Specifications-Text"
				]
				
				setMaxWidth(80)
			]
			
			children += new HBox => [
				styleClass += "Specifications-Rect"
				
				setMinWidth(150)
				setMinHeight(70)
			]
			
			children += new HBox => [
				styleClass += "Specifications-Foot"
							
				for (i: 1 ..<5) {							
					children += new HBox => [
						styleClass += "Specifications-Arc"
						
						setMinWidth(15)
						setMinHeight(7)
						setTranslateX(gap * i)
					]
				}
			]
		
		]
	}
	
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	override getRoot() {
		return this
	}
}