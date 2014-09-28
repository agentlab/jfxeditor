package ru.agentlab.jfxed.diagramms.ActorCooperationViewpoint

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.ontology.OntModel
import java.io.FileInputStream


class ActorCooperationViewpoint {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/ActorCooperationViewpoint"
	static String NS = SOURCE + "#"
	
	protected var OntModel model
	
	static def void main(String[] args) {
		val ap = new ActorCooperationViewpoint()
		
		ap.loadModel()
		
		println("The First query")
		ap.makeQuery("Concept")
		
		println("The Second query")
		ap.makeQuery("BusinessActor")
		
		println("The Third query")
		ap.makeQuery("Flow")
	}
	
	def loadModel() {
		model = ModelFactory.createOntologyModel() => [
			val in = new FileInputStream("ActorCooperationViewpoint.owl")
			read(in, NS, "RDF/XML")
		]
	}
	
	def makeQuery(String param) {
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#«param»> 
		} 
		'''
		println(queryString)
		
	    val query = QueryFactory.create(queryString)
	    val qe = QueryExecutionFactory.create(query, model)
		val results = qe.execSelect()	
		  
		ResultSetFormatter.out(System.out, results, query)
		
		qe.close()
	}
}