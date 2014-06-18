package ru.agentlab.jfxed;

import com.hp.hpl.jena.ontology.OntModel;

import de.fxdiagram.core.XDiagram;

public interface IDiagram {
	void createJfx(OntModel jenaModel, XDiagram jfxDiagram);
}
