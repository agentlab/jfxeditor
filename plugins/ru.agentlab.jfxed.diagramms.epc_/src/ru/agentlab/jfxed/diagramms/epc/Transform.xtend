package ru.agentlab.jfxed.diagramms.epc

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import java.io.FileInputStream
import com.hp.hpl.jena.ontology.OntModel

class Transform {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/epc"
	static String NS = SOURCE + "#"
	
	protected var OntModel m
	
	static def void main(String[] args){
		val me = new Transform()
		
		me.loadModel()
		
		me.testQuery1()
		me.testQuery2()
		me.testQuery3()
	}
	
	def loadModel() {
	
		m = ModelFactory.createOntologyModel() => [
		
			
			val inputStream = new FileInputStream("model.xml")
			read(inputStream, NS, "RDF/XML");
			write(System.out, "RDF/XML");//� � �������
		]
	}
	
	def testQuery1(){
	
	
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
		PREFIX src: <http://www.eswc2006.org/technologies/ontology#> 
		select ?uri 
		where { 
			?uri rdf:type src:Information
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
	def testQuery2(){

		
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
		PREFIX src: <http://www.eswc2006.org/technologies/ontology#> 
		select ?uri 
		where { 
			?uri rdf:type src:Function 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
	def testQuery3(){
		
		
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
		PREFIX src: <http://www.eswc2006.org/technologies/ontology#> 
		select ?uri 
		where { 
			?uri rdf:type src:ControlTo 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
}
