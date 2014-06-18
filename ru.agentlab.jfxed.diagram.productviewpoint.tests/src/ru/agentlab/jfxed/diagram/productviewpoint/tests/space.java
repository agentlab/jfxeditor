package ru.agentlab.jfxed.diagram.productviewpoint.tests;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
//import com.hp.hpl.jena.ontology.OntModelSpec;
//import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
//import com.hp.hpl.jena.rdf.model.Resource;
//import com.hp.hpl.jena.rdf.model.SimpleSelector;
//import com.hp.hpl.jena.rdf.model.StmtIterator;
//import com.hp.hpl.jena.vocabulary.VCARD;

 public class space
{
	static final String SCHEMA = "http://www.w3.org/2002/07/owl";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		
		//OntClass relationClass = m.createClass(NS + "Relation");
		//OntClass conceptClass = m.createClass(NS + "Concept");
		
		OntClass businessActorClass = m.createClass(NS + "BusinessActor");
		
		/*
		 * Объявление связей
		 * */
		OntClass associationClass = m.createClass(NS + "Association");//родительский суперкласс
		//для того чтобы отличать фигурки от связей
		
		OntClass compositionClass = m.createClass(NS + "Composition");//composition
		compositionClass.addSuperClass(associationClass);//родительская связь
		
		ObjectProperty propTo = m.createObjectProperty(NS + "propTo");//объекты - свойства
		propTo.addDomain(businessActorClass);
		propTo.addRange(businessActorClass);
		
		ObjectProperty propFrom = m.createObjectProperty(NS + "propFrom");//объекты - свойства
		propFrom.addDomain(businessActorClass);
		propFrom.addRange(businessActorClass);
		
		propTo.addDomain(compositionClass);//свойства у composition
		propFrom.addDomain(compositionClass);
		
		
		
		//индивидуалы
		Individual archiusranceIndividual = m.createIndividual(NS + "Archiusrance", businessActorClass);
		Individual  frontOfficeIndividual = m.createIndividual(NS + "FrontOffice", businessActorClass);
		Individual customerRelationsIndividual = m.createIndividual(NS + "CustomerRelations", businessActorClass);
		Individual intermediaryRelationsIndividual = m.createIndividual(NS + "IntermediaryRelations", businessActorClass);
		Individual backOfficeIndividual = m.createIndividual(NS + "BackOffice", businessActorClass);
		Individual homeAwayIndividual = m.createIndividual(NS + "HomeAway", businessActorClass);
		Individual carIndividual = m.createIndividual(NS + "Car", businessActorClass);
		Individual legalAidIndividual = m.createIndividual(NS + "LegalAid", businessActorClass);
		Individual financeIndividual = m.createIndividual(NS + "Finance", businessActorClass);
		Individual productDevelopmentIndividual = m.createIndividual(NS + "ProductDevelopment", businessActorClass);
		Individual hrmIndividual = m.createIndividual(NS + "HRM", businessActorClass);
		Individual documentProcessingSscIndividual = m.createIndividual(NS + "DocumentProcessingSsc", businessActorClass);
		
		
	
		//связи между индивидуалами
		Individual compositionIndividual = m.createIndividual(NS+ "compositionIndividual", compositionClass);

		compositionIndividual.addProperty(propFrom, frontOfficeIndividual);
		compositionIndividual.addProperty(propFrom, backOfficeIndividual);
		compositionIndividual.addProperty(propTo, archiusranceIndividual);
		
		compositionIndividual.addProperty(propFrom, financeIndividual);
		compositionIndividual.addProperty(propFrom, productDevelopmentIndividual);
		compositionIndividual.addProperty(propFrom, hrmIndividual);
		compositionIndividual.addProperty(propFrom, documentProcessingSscIndividual);
		compositionIndividual.addProperty(propTo, archiusranceIndividual);		
		
		compositionIndividual.addProperty(propFrom, customerRelationsIndividual);
		compositionIndividual.addProperty(propFrom, intermediaryRelationsIndividual);
		compositionIndividual.addProperty(propTo, frontOfficeIndividual);
		
		compositionIndividual.addProperty(propFrom, frontOfficeIndividual);
		compositionIndividual.addProperty(propTo, customerRelationsIndividual);
		compositionIndividual.addProperty(propTo,intermediaryRelationsIndividual);
		
		compositionIndividual.addProperty(propFrom, homeAwayIndividual);
		compositionIndividual.addProperty(propFrom, carIndividual);
		compositionIndividual.addProperty(propFrom, legalAidIndividual);
		compositionIndividual.addProperty(propTo, backOfficeIndividual);
		
		compositionIndividual.addProperty(propFrom, backOfficeIndividual);
		compositionIndividual.addProperty(propTo, homeAwayIndividual);
		compositionIndividual.addProperty(propTo,carIndividual);
		compositionIndividual.addProperty(propTo,legalAidIndividual);

		/*
		for(StmtIterator it = hrmClass.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		for(StmtIterator it = checkSec.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		
	
		OntClass c = hrmClass.getOntClass();
		SimpleSelector s = new SimpleSelector(null, null, c);
		for(StmtIterator it = m.listStatements(s); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}*/
		
		//UMLUseCase.run();
		
		try {
			 		//	m.write(new FileWriter("mmmm.xml"));
			 			m.write(new FileWriter("mmmm.owl"), "RDF/XML");
			  		} catch (IOException e)
			  		{
			  			e.printStackTrace();}
	}}
			

	

