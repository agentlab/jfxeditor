package ru.agentlab.jfxed.diagramms.productviewpoint;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ProductViewpointTest {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
//		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
//		OntClass productClass = m.createClass(NS + "Product");//создаем отдельные triple
//		OntClass contractClass = m.createClass(NS + "Contract");
//		OntClass associationClass = m.createClass(NS + "Association");
//		
//		OntClass aggregationClass = m.createClass(NS + "Agregation");//связь
//		aggregationClass.addSuperClass(associationClass);//родительская связь
//		
//		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
//		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
//		
//		propTo.addDomain(aggregationClass);//свойства у aggregation
//		propFrom.addDomain(aggregationClass);
//		
//		propTo.addRange(contractClass);//то что могут принимать
//		propFrom.addRange(productClass);
//		
//		//наполнение базы 
//		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);
//		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);
//		
//		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
//		aggregationIndividual.addProperty(propTo, contractIndividual);//от продукта к контракту
//		aggregationIndividual.addProperty(propFrom, productIndividual);
		
		OntModel m = ModelFactory.createOntologyModel();
		OntClass ProposedClass = m.createClass(NS + "Proposed");
		OntClass ScheduledClass = m.createClass(NS + "Scheduled");
		OntClass OpenForEnrollmentClass = m.createClass(NS + "Open For Enrollment");
		OntClass FullClass = m.createClass(NS + "Full");
		OntClass ClosedToEnrollmentClass = m.createClass(NS + "Closed To Enrollment");
		OntClass BeingTaughtClass = m.createClass(NS + "Being Taught");
		OntClass FinalexamsClass = m.createClass(NS + "Final exams");
		OntClass StartClass = m.createClass(NS + "Start");
		OntClass FinalClass = m.createClass(NS + "Final");
		
		
		
		
		m.write(System.out);//и в консоль
	}
}
