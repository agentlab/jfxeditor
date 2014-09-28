package ru.agentlab.jfxed.diagramms.ApplicationCooperationViewpoint

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.ontology.OntModel
import java.io.FileInputStream


class ApplicationCooperationViewpoint {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/ApplicationCooperationViewpoint"
	static String NS = SOURCE + "#"
	
	protected var OntModel model
	
	static def void main(String[] args) {
		val ap = new ApplicationCooperationViewpoint()
		
		ap.loadModel()
		
		println("The First Query")
		ap.makeQuery("Concept")
		
		println("The Second Query")
		ap.makeQuery("ApplicationComponent")
		
		println("The Third Query")
		ap.makeQuery("UsedBy")
	}
	
	def loadModel() {
		model = ModelFactory.createOntologyModel() => [
			val in = new FileInputStream("ApplicationCooperationViewpoint.owl")
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