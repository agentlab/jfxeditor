package ru.agentlab.jfxed.diagramms.productviewpoint

import com.hp.hpl.jena.ontology.OntModel
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.QuerySolution
import com.hp.hpl.jena.rdf.model.Resource
import de.fxdiagram.core.XDiagram
import ru.agentlab.jfxed.IDiagram
import ru.agentlab.jfxed.figures.stakeholder.Stakeholder
import de.fxdiagram.core.XConnection
import de.fxdiagram.core.XConnectionKind
import de.fxdiagram.core.XConnectionLabel

public class StrategicDiagram implements IDiagram {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/strategicdependency"
	static String NS = SOURCE + "#"
	
	override createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri a <«SOURCE»#Someone> 
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
	     
	    println(x)
	     
		jfxDiagram => [
			val target = new Stakeholder() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]
			nodes += target
			
			/*val source = new Stakeholder() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]
			nodes += source
			
			val conn = new XConnection(source, target) => [
				kind = XConnectionKind.QUAD_CURVE
				new XConnectionLabel(it) => [
					text.text = 'quadratic'
				]
			]
			connections += conn*/
		]
	  }
		
		qe.close()
	}
}
