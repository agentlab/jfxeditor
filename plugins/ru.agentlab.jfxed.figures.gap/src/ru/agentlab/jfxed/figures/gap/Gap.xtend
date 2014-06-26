package ru.agentlab.jfxed.figures.gap

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure
import javafx.scene.shape.Circle
import javafx.scene.shape.Line
import javafx.scene.shape.Arc


class Gap extends XNode implements IFigure {
	
	String name = "Gap";
	
	var h = 100;
	var Text nameTextBox
	
	new(String name) {
		super(name)
	}
	
	new (){
		super("lalala")
		node = new VBox => [
			setTranslateX(20)
			setTranslateY(20)
		
		
			val s = Gap.getResource("Gap.css").toExternalForm()
			stylesheets += s
			
	//		root.styleClass += "Gap";
			
			children += new HBox => [
				setMinWidth(400)
			    setMinHeight(h)
				styleClass += "Gap"
				
				nameTextBox = new Text => [
					text = name
					styleClass += "Gap-Text"
					setTranslateX(40)
				    setTranslateY(33)
				]
				
				children += nameTextBox
				
				setMaxWidth(80)
			//]
			
			children += new Circle => [
				styleClass += "Gap-Circle"
				radius = 10
				setTranslateX(193)
				setTranslateY(7)
			]
			
			children += new VBox => [
				setTranslateX(162.5)
				setTranslateY(13)
				
				children += new Line => [
					styleClass += "Gap-Line"
	//				setStartX(250)
					setEndX(35)
				]
				
				children += new Line => [
					styleClass += "Gap-Line"
//					setStartX(250)
//					setStartY(40)
//					setEndY(20)
					setTranslateY(6)
					setEndX(35)
				]
			]
		]
		
		children += new HBox => [
			children += new HBox => [
				styleClass += "Gap-Arc"
			
				setMinWidth(200)
				setMinHeight(h / 2.3)
				
				setTranslateY(-1)
			]
			
			children += new HBox => [
				styleClass += "Gap-Arc2"
				setMinHeight(h / 2.3)
				setMinWidth(200)
				
				setTranslateY(-43)
			]
			
			setMinWidth(400)
		]
		]
				
			
		
		
	}
	
	
	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	override getRoot() {
		return this
	}
	
	override setName(String name) {
		nameTextBox.text = name
	}
}