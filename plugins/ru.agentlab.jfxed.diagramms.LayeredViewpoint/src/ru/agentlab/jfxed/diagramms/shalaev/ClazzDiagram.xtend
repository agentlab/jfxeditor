package ru.agentlab.jfxed.diagramms.shalaev

import com.hp.hpl.jena.ontology.OntModel
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.QuerySolution
import com.hp.hpl.jena.rdf.model.Resource
import ru.agentlab.jfxed.figures.shalaev.Coub
import de.fxdiagram.core.XDiagram
import ru.agentlab.jfxed.IDiagram


public class ClazzDiagram implements IDiagram {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/shalaev"
	static String NS = SOURCE + "#"
	
	override createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <�SOURCE�#Concept> 
		} 
		'''
	    val query = QueryFactory.create(queryString)
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, jenaModel)
		val results =  qe.execSelect()		
		
		for ( ; results.hasNext() ; )
	    {
	      val QuerySolution soln = results.nextSolution() 
	      val Resource x = soln.getResource("uri")       // Get a result variable by name.
	     
	     val target = new Coub() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
		]
		
		jfxDiagram => [
			nodes += target
		]
	  }
		
		qe.close()
	}
}
