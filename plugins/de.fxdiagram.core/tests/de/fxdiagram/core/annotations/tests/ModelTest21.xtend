package de.fxdiagram.core.annotations.tests

import de.fxdiagram.annotations.logging.Logging
import de.fxdiagram.annotations.properties.FxProperty
import de.fxdiagram.core.XConnection
import de.fxdiagram.core.XShape
import de.fxdiagram.core.anchors.Anchors
import de.fxdiagram.core.behavior.MoveBehavior
import javafx.collections.ObservableList
import javafx.scene.effect.Effect

import static javafx.collections.FXCollections.*

@Logging
class ModelTest21 extends XShape {
	
	@FxProperty double width
	@FxProperty double height
	@FxProperty ObservableList<XConnection> incomingConnections = observableArrayList
	@FxProperty ObservableList<XConnection> outgoingConnections = observableArrayList
	
	Effect mouseOverEffect
	Effect selectionEffect
	Effect originalEffect
 
	Anchors anchors
	
	protected def createNode() {
		null
	}

	override doActivate() {
		addBehavior(new MoveBehavior(this))

	}
	
}
