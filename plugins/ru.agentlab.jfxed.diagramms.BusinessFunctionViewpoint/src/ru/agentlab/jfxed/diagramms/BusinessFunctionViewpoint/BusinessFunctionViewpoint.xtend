package ru.agentlab.jfxed.diagramms.BusinessFunctionViewpoint

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.ontology.OntModel
import java.io.FileInputStream


class BusinessFunctionViewpoint {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/BusinessFunctionViewpoint"
	static String NS = SOURCE + "#"
	
	protected var OntModel model
	
	static def void main(String[] args) {
		val ap = new BusinessFunctionViewpoint()
		
		ap.loadModel()
		
		println("The First Query")
		ap.makeQuery("Concept")
		
		println("The Second Query")
		ap.makeQuery("BusinessRole")
		
		println("The Third Query")
		ap.makeQuery("Flow")
	}
	
	def loadModel() {
		model = ModelFactory.createOntologyModel() => [
			val in = new FileInputStream("BusinessFunctionViewpoint.owl")
			read(in, NS, "RDF/XML")
			//write(System.out, "RDF/XML")
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