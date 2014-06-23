package ru.agentlab.jfxed.diagramms.strategicdependency

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
import ru.agentlab.jfxed.figures.clazz.ClassFigure
import com.hp.hpl.jena.query.Query
import com.hp.hpl.jena.query.QueryExecution
import com.hp.hpl.jena.query.ResultSet
import ru.agentlab.jfxed.figures.testgoal.TestGoal
import de.fxdiagram.core.XNode
import ru.agentlab.jfxed.figures.plateau.Plateau

public class StrategicDiagram implements IDiagram {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/strategicdependency"
	static String NS = SOURCE + "#"
	
	Query query
	
	QueryExecution qe
	
	ResultSet results
	
	String queryString
	
	QuerySolution soln
	
	Resource x
	
	XNode target
	
	override createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		
//		makeQuery(jenaModel, jfxDiagram, "Someone")
		makeQuery(jenaModel, jfxDiagram, "Blue")
//		makeQuery(jenaModel, jfxDiagram, "Green")
		makeQuery(jenaModel, jfxDiagram, "Red")
//		makeQuery(jenaModel, jfxDiagram, "Orange")
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
			if (className.equals("Someone")) {
			 target = new TestGoal() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]
			}
			
			if (className.equals("Red")) {
			target = new Stakeholder() => [
				color = "Red"
				layoutX = 280
				layoutY = 280
				name = x.localName
				
			]
			
			}
			
			if (className.equals("Orange")) {
			target = new Stakeholder() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
				color = "Orange"
			]
			
			}
			
			if (className.equals("Green")) {
			target = new Plateau() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]
			
			}
			
			if (className.equals("Blue")) {
			target = new ClassFigure() => [
				layoutX = 280
				layoutY = 280
				name = x.localName
			]
			}
			
			
			nodes += target
			
			val source = new Stakeholder() => [
				layoutX = 280
				layoutY = 280
				name = "Stakeholder"
			]
			nodes += source
			
			val conn = new XConnection(source, target) => [
				kind = XConnectionKind.QUAD_CURVE
				new XConnectionLabel(it) => [
					text.text = 'quadratic'
				]
			]
		//	connections += conn
		]
		
		}
		
		qe.close()
		
	}
}
