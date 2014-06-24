package ru.agentlab.jfxed.diagramms.umlclassdiagram;



import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class UMLClassDiagram {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/UMLClassDiagram";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		
		OntModel m = ModelFactory.createOntologyModel();
		
		OntClass concept = m.createClass(NS + "concept");
		OntClass relation = m.createClass(NS + "relation");
		
		OntClass objectClass = m.createClass(NS + "object");
		objectClass.addSuperClass(concept);
		
		OntClass associationClass = m.createClass(NS + "association");
		associationClass.addSuperClass(relation);
		OntClass compositionClass = m.createClass(NS + "composition");
		compositionClass.addSuperClass(relation);
		OntClass aggregationClass = m.createClass(NS + "aggregation");
		aggregationClass.addSuperClass(relation);
		OntClass generalizationClass = m.createClass(NS + "generalization");
		generalizationClass.addSuperClass(relation);
		
		
		
		ObjectProperty propAssociationFrom = m.createObjectProperty(NS + "associationFrom");
		propAssociationFrom.addDomain(objectClass);
		propAssociationFrom.addRange(objectClass);		
		ObjectProperty propAssociationTo = m.createObjectProperty(NS + "associationTo");
		propAssociationTo.addDomain(objectClass);
		propAssociationTo.addRange(objectClass);
		
		ObjectProperty propCompositionFrom = m.createObjectProperty(NS + "compositionFrom");
		propCompositionFrom.addDomain(objectClass);
		propCompositionFrom.addRange(objectClass);
		ObjectProperty propCompositionTo = m.createObjectProperty(NS + "compositionTo");
		propCompositionTo.addDomain(objectClass);
		propCompositionTo.addRange(objectClass);
		
		ObjectProperty propAggregationFrom = m.createObjectProperty(NS + "aggregationFrom");
		propAggregationFrom.addDomain(objectClass);
		propAggregationFrom.addRange(objectClass);
		ObjectProperty propAggregationTo = m.createObjectProperty(NS + "aggregationTo");
		propAggregationTo.addDomain(objectClass);
		propAggregationTo.addRange(objectClass);
		
		ObjectProperty propGeneralizationFrom = m.createObjectProperty(NS + "generalizationFrom");
		propGeneralizationFrom.addDomain(objectClass);
		propGeneralizationFrom.addRange(objectClass);
		ObjectProperty propGeneralizationTo = m.createObjectProperty(NS + "generalizationTo");
		propGeneralizationTo.addDomain(objectClass);
		propGeneralizationTo.addRange(objectClass);
		
		
		Individual tutor = m.createIndividual(NS + "tutor", objectClass);
		Individual program = m.createIndividual(NS + "program", objectClass);
		Individual transaction = m.createIndividual(NS + "transaction", objectClass);
		Individual member = m.createIndividual(NS + "member", objectClass);
		Individual vipMember = m.createIndividual(NS + "vipMember", objectClass);
		Individual stadium = m.createIndividual(NS + "stadium", objectClass);
		Individual booking = m.createIndividual(NS + "booking", objectClass);
		Individual session = m.createIndividual(NS + "session", objectClass);
		
		
		Individual linkAssociation1 = m.createIndividual(NS + "program", associationClass);
		linkAssociation1.addProperty(propAssociationFrom, tutor);
		linkAssociation1.addProperty(propAssociationTo, program);
		
		Individual linkAssociation11 = m.createIndividual(NS + "tutor", associationClass);
		linkAssociation11.addProperty(propAssociationFrom, program);
		linkAssociation11.addProperty(propAssociationTo, tutor);
		
		Individual linkAssociation2 = m.createIndividual(NS + "member", associationClass);
		linkAssociation2.addProperty(propAssociationFrom, program);
		linkAssociation2.addProperty(propAssociationTo, member);
		
		Individual linkAssociation22 = m.createIndividual(NS + "program", associationClass);
		linkAssociation22.addProperty(propAssociationFrom, member);
		linkAssociation22.addProperty(propAssociationTo, program);
		
		Individual linkAssociation3 = m.createIndividual(NS + "booking", associationClass);
		linkAssociation3.addProperty(propAssociationFrom, stadium);
		linkAssociation3.addProperty(propAssociationTo, booking);
		
		Individual linkAssociation33 = m.createIndividual(NS + "stadium", associationClass);
		linkAssociation33.addProperty(propAssociationFrom, booking);
		linkAssociation33.addProperty(propAssociationTo, stadium);
		
		Individual linkAssociation4 = m.createIndividual(NS + "session", associationClass);
		linkAssociation4.addProperty(propAssociationFrom, booking);
		linkAssociation4.addProperty(propAssociationTo, session);
		
		Individual linkAssociation44 = m.createIndividual(NS + "booking", associationClass);
		linkAssociation44.addProperty(propAssociationFrom, session);
		linkAssociation44.addProperty(propAssociationTo, booking);
		
		Individual linkComposition = m.createIndividual(NS + "member", compositionClass);
		linkComposition.addProperty(propCompositionFrom, booking);
		linkComposition.addProperty(propCompositionTo, member);
		
		Individual linkAggregation = m.createIndividual(NS + "member", aggregationClass);
		linkAggregation.addProperty(propAggregationFrom, transaction);
		linkAggregation.addProperty(propAggregationTo, member);
		
		Individual linkGeneralization = m.createIndividual(NS + "member", generalizationClass);
		linkGeneralization.addProperty(propGeneralizationFrom, vipMember);
		linkGeneralization.addProperty(propGeneralizationTo, member);
		
		System.out.println("\n");
		
		for(StmtIterator it = linkAggregation.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		System.out.println("\n");
		
		for(StmtIterator it = member.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		
		System.out.println("\n");
		//вывод всего и всех где есть класс passCheck (goal) для  всей модели
		OntClass c = tutor.getOntClass();
		SimpleSelector s = new SimpleSelector(null, null, c);
		for(StmtIterator it = m.listStatements(s); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		
		try {
			m.write(new FileWriter("mm.owl"));
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
