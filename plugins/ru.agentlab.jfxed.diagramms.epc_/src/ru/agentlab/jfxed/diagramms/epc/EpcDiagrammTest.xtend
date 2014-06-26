package ru.agentlab.jfxed.diagramms.epc

import com.hp.hpl.jena.ontology.OntModel
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.QuerySolution
import com.hp.hpl.jena.rdf.model.Resource
//import ru.agentlab.jfxed.figures.specifications.Specifications
import ru.agentlab.jfxed.figures.gap.Gap
import ru.agentlab.jfxed.IDiagram
import de.fxdiagram.core.XDiagram


public class EpcDiagrammTest implements IDiagram {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/epc"
	static String NS = SOURCE + "#"
	
	
	override createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#Function>
		} 
		'''
		/*val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#Control>
		} 
		'''*/
	    val query = QueryFactory.create(queryString)
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, jenaModel)
		val results =  qe.execSelect()		
		
		for ( ; results.hasNext() ; )
	    {
	      val QuerySolution soln = results.nextSolution() 
	      val Resource x = soln.getResource("uri")       // Get a result variable by name.
	     
	     val target = new Gap() => [
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
