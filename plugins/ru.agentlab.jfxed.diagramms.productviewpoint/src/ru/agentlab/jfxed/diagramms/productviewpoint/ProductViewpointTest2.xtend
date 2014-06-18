package ru.agentlab.jfxed.diagramms.productviewpoint

import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.ModelFactory
import java.io.FileInputStream
import com.hp.hpl.jena.ontology.OntModel

class ProductViewpointTest2 {
	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/productviewpoint"
	static String NS = SOURCE + "#"
	
	protected var OntModel m
	
	static def void main(String[] args){
		val me = new ProductViewpointTest2()
		
		me.loadModel()
		
		me.testQuery1()
		me.testQuery2()
		me.testQuery3()
		me.testQuery4()
		me.testQuery5()
	}
	
	def loadModel() {
		//создается пустая база знаний
		m = ModelFactory.createOntologyModel() => [
			// внутри блока можно обращаться к методам объкта m без m.
			
			val inputStream = new FileInputStream("productviewpoint.owl")
			read(inputStream, NS, "RDF/XML");
			write(System.out, "RDF/XML");//и в консоль
		]
	}
	
	

	
	def testQuery1(){
		//шаблон из статических строк и значений переменных с автоматической подстановкой
		//в духе php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#Agregation> 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		println( " Zapros 1" );
		println( queryString );
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
	def testQuery2(){
		//шаблон из статических строк и значений переменных с автоматической подстановкой
		//в духе php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#Concept> 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		println( " Zapros 2" );
		println( queryString );
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
	def testQuery3(){
		//шаблон из статических строк и значений переменных с автоматической подстановкой
		//в духе php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#Product> 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		println( " Zapros 3" );
		println( queryString );
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
		def testQuery4(){
		//шаблон из статических строк и значений переменных с автоматической подстановкой
		//в духе php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#UsedBy> 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		println( " Zapros 4" );
		println( queryString );
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
		def testQuery5(){
		//шаблон из статических строк и значений переменных с автоматической подстановкой
		//в духе php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <«SOURCE»#BusinessActor> 
		} 
		'''
	    val query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		val qe = QueryExecutionFactory.create(query, m);
		val results =  qe.execSelect();
		
		println( " Zapros 5" );
		println( queryString );
		
		// Output query results    
		ResultSetFormatter.out(System.out, results, query);
		qe.close();
	}
	
	
	
}