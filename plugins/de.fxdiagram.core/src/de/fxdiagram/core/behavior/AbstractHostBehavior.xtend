package de.fxdiagram.core.behavior

import de.fxdiagram.annotations.properties.FxProperty
import de.fxdiagram.annotations.properties.ReadOnly
import javafx.scene.Node

abstract class AbstractHostBehavior <T extends Node> implements Behavior {
	
	T host 
	
	@FxProperty@ReadOnly boolean isActive
	
	new(T host) {
		this.host = host	
	}
	
	def getHost() {
		host
	}
	
	override activate() {
		if(!isActive)
			doActivate
		isActiveProperty.set(true)
	}
	
	def protected void doActivate()
}