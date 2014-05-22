package de.fxdiagram.examples.ecore

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import de.fxdiagram.lib.nodes.RectangleBorderPane
import java.util.List
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import org.eclipse.emf.ecore.EClass

class EClassNode extends XNode {
	
	EClass eClass
	
	val name = new Text
	val attributeCompartment = new VBox
	val operationCompartment = new VBox
	
	new(EClass eClass) {
		super(eClass.name)
		this.eClass = eClass
		name.text = eClass.name
		node = new RectangleBorderPane => [
			children += new VBox => [
				children += name => [
					textOrigin = VPos.TOP
					font = Font.font(getFont.family, FontWeight.BOLD, getFont.size * 1.1)
					VBox.setMargin(it, new Insets(12, 12, 12, 12))
				]
				children += new Separator 
				children += attributeCompartment => [
					VBox.setMargin(it, new Insets(5, 10, 5, 10))
				]
				children += new Separator
				children += operationCompartment => [
					VBox.setMargin(it, new Insets(5, 10, 5, 10))
				]
				alignment = Pos.CENTER
			]
		]
	}

	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}
	
	def populateCompartments() {
		eClass.EAttributes.limit.forEach [
			attribute |
			attributeCompartment.children += new Text => [
				text = '''«attribute.name»: «attribute.EType.name»''' 
			]
		]
		eClass.EOperations.limit.forEach [
			operation |
			operationCompartment.children += new Text => [
				text = '''«operation.name»(«operation.EParameters.map[EType.name].join(', ')»): «operation.EType.name»''' 
			]
		]
	}
	
	protected def <T> limit(List<T> list) {
		if(list.empty)
			list
		else if(getIsActive)
			list
		else 
			list.subList(0, Math.min(list.size, 4))
	}
	
	def getEClass() {
		eClass
	}
	
	override doActivate() {
		super.doActivate()
		populateCompartments
		addBehavior(new AddESuperTypeRapidButtonBehavior(this))
		addBehavior(new AddEReferenceRapidButtonBehavior(this))
	}
}



