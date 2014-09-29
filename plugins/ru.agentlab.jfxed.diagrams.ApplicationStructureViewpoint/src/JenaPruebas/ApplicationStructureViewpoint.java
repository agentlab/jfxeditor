package JenaPruebas;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
	

public class ApplicationStructureViewpoint {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//create superclasses
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//create objects
		
		OntClass ApplicationComponentClass = m.createClass(NS + "ApplicationComponent");
		ApplicationComponentClass.addSuperClass(concept);
		OntClass DataObjectClass = m.createClass(NS + "DataObject");
		DataObjectClass.addSuperClass(concept);
		
		
		//create arrows
		OntClass AccessClass = m.createClass(NS + "Access");
		AccessClass.addSuperClass(relation);
		OntClass CompositionClass = m.createClass(NS + "Composition");
		CompositionClass.addSuperClass(relation);
		
		//create properties
		//Access
		 ObjectProperty propAccess = m.createObjectProperty(NS + "Aggregation");
		 propAccess.addDomain(ApplicationComponentClass);
		 propAccess.addRange(DataObjectClass);
		 
		//Composition
		 ObjectProperty propComposition = m.createObjectProperty(NS + "Realization");
		 propComposition.addDomain(ApplicationComponentClass);
		 propComposition.addRange(ApplicationComponentClass);
		 
		 //create individuals
		 Individual customerDataAccess = m.createIndividual(NS + "customerDataAccess", ApplicationComponentClass);
		 Individual claimDataManagement = m.createIndividual(NS + "claimDataManagement", ApplicationComponentClass);
		 Individual policyDataManagement = m.createIndividual(NS + "policyDataManagement", ApplicationComponentClass);
		 Individual riskAssessment = m.createIndividual(NS + "riskAssessment", ApplicationComponentClass);
		 Individual homeAndAwayPolicyAdministration = m.createIndividual(NS + "homeAndAwayPolicyAdministaration", ApplicationComponentClass);
		 Individual customerFileData = m.createIndividual(NS + "custFileData", DataObjectClass);
		 Individual damageClaimData = m.createIndividual(NS + "damageClaimData", DataObjectClass);
		 Individual insurancePolicyData = m.createIndividual(NS + "insurancePolicyData", DataObjectClass);
		 
		 
		 //create ind links

		 Individual link11 = m.createIndividual(NS + "customerDataAccess", AccessClass);
		 link11.addProperty(propAccess, customerFileData);
		 
		 Individual link12 = m.createIndividual(NS + "claimDataManagement", AccessClass);
		 link12.addProperty(propAccess, damageClaimData);
		 
		 Individual link13 = m.createIndividual(NS + "policyDataManagement", AccessClass);
		 link13.addProperty(propAccess, insurancePolicyData);
		 
		 Individual link21 = m.createIndividual(NS + "homeAndAwayPolicyAdministration", CompositionClass);
		 link21.addProperty(propComposition, customerDataAccess);
		 
		 Individual link22 = m.createIndividual(NS + "homeAndAwayPolicyAdministration", CompositionClass);
		 link22.addProperty(propComposition, claimDataManagement);	 
		 
		 Individual link23 = m.createIndividual(NS + "homeAndAwayPolicyAdministration", CompositionClass);
		 link23.addProperty(propComposition, policyDataManagement);
		 
		 Individual link24 = m.createIndividual(NS + "homeAndAwayPolicyAdministration", CompositionClass);
		 link24.addProperty(propComposition, riskAssessment);
		 
		 System.out.println("Request1\n");
			for(StmtIterator it = link11.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request2\n");
			for(StmtIterator it = damageClaimData.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request3\n");

			OntClass c = homeAndAwayPolicyAdministration.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
		
		 try {
				m.write(new FileWriter("Konstantin.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}	

}
