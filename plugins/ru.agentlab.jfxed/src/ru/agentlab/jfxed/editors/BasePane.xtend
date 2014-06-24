package ru.agentlab.jfxed.editors

import javafx.scene.Parent
import java.util.HashMap
import org.eclipse.core.runtime.IConfigurationElement
import de.fxdiagram.core.XDiagram

abstract class BasePane {
	protected Parent root
	
	def public Parent getRoot() {
		return root
	}
	
	def public XDiagram initDiagram(HashMap<String, IConfigurationElement> figuresTable, HashMap<String, IConfigurationElement> diagramsTable);
}