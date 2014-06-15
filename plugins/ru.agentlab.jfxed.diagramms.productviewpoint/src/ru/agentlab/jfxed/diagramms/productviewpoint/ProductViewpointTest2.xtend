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
	}
	
	def loadModel() {
		//��������� ������ ���� ������
		m = ModelFactory.createOntologyModel() => [
			// ������ ����� ����� ���������� � ������� ������ m ��� m.
			
			val inputStream = new FileInputStream("productviewpoint.owl")
			read(inputStream, NS, "RDF/XML");
			write(System.out, "RDF/XML");//� � �������
		]
	}
	
	def testQuery1(){
		//������ �� ����������� ����� � �������� ���������� � �������������� ������������
		//� ���� php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <�SOURCE�#Assigment> 
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
		//������ �� ����������� ����� � �������� ���������� � �������������� ������������
		//� ���� php
		val queryString ='''
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
		select ?uri 
		where { 
			?uri rdf:type <�SOURCE�#Product> 
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
	}
}