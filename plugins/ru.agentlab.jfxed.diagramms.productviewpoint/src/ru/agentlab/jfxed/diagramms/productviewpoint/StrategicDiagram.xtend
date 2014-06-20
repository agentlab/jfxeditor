package ru.agentlab.jfxed.diagramms.productviewpoint

import com.hp.hpl.jena.ontology.OntModel
import com.hp.hpl.jena.query.Query
import com.hp.hpl.jena.query.QueryExecution
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.QuerySolution
import com.hp.hpl.jena.query.ResultSet
import com.hp.hpl.jena.rdf.model.Resource
import de.fxdiagram.core.XDiagram
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.IDiagram
import ru.agentlab.jfxed.figures.clazz.ClassFigure

public class StrategicDiagram implements IDiagram {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/productviewpoint"
	
	Query query
	
	QueryExecution qe
	
	ResultSet results
	
	String queryString
	
	QuerySolution soln
	
	Resource x
	
	XNode target
	
	override createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		
		makeQuery(jenaModel, jfxDiagram, "BusinessActor")
		//makeQuery(jenaModel, jfxDiagram, "Blue")

		}
		
	
	def makeQuery(OntModel jenaModel, XDiagram jfxDiagram, String className) {
		target = null
		
		queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#«className»>  
		} 
		'''
	    query = QueryFactory.create(queryString)
		// Execute the query and obtain results
		qe = QueryExecutionFactory.create(query, jenaModel)
		results =  qe.execSelect()		
		
		for ( ; results.hasNext() ; )
	    {
	      soln = results.nextSolution() 
	      x = soln.getResource("uri")       // Get a result variable by name.
	     
	    println(x)
	     
		jfxDiagram => [
			
			className.equals("BusinessActor")
			target = new ClassFigure() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]

			
			target = new ClassFigure() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
				
			]
			
			
			
			nodes += target
			
		]
		
		
		}
		
		qe.close()
		
	}
}
