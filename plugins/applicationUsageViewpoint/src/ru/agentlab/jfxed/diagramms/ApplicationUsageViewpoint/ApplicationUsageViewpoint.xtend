package ru.agentlab.jfxed.diagramms.ApplicationUsageViewpoint

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import java.io.FileInputStream
import com.hp.hpl.jena.ontology.OntModel

class ApplicationUsageViewpoint {
	static String SOURCE = "http://www.goodlink.ru"
	static String NS = SOURCE + "#"
	
	protected var OntModel model
	
	static def void main(String[] args) {
		val app = new ApplicationUsageViewpoint()
		
		app.loadModel()
		
		println("First Query")
		app.makeQuery("Concept")
		
		println("Second Query")
		app.makeQuery("UsedBy")
		
		println("Third Query")
		app.makeQuery("ApplicationService")
	}
	
	def loadModel() {
		model = ModelFactory.createOntologyModel() => [
			val in = new FileInputStream("ApplicationUsageViewpoint.owl")
			read(in, NS, "RDF/XML");
			write(System.out, "RDF/XML");
		]
	}
	
	def makeQuery(String option) {
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#«option»> 
		} 
		'''
		println(queryString);
		
	    val query = QueryFactory.create(queryString);
		val result =  QueryExecutionFactory.create(query, model).execSelect();
		  
		ResultSetFormatter.out(System.out, result, query);
	}
}
