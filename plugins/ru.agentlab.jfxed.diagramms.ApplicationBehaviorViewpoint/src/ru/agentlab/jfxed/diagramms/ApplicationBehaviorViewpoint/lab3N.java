package ru.agentlab.jfxed.diagramms.ApplicationBehaviorViewpoint;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
	

public class lab3N {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//create superclasses
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//create objects
		OntClass applicationserviceClass = m.createClass(NS + "applicationserviceClass");
		applicationserviceClass.addSuperClass(concept);
		OntClass applicationfunctionClass = m.createClass(NS + "applicationfunctionClass");
		applicationfunctionClass.addSuperClass(concept);
		//OntClassapplicationfunctionClass = m.createClass(NS + "applicationfunctionClass");
		//applicationfunctionClass.addSuperClass(concept);
		OntClass applicationcomponentClass = m.createClass(NS + "applicationcomponentClass");
		applicationcomponentClass.addSuperClass(concept);
		OntClass dataobjectClass = m.createClass(NS + "dataobjectClass");
		dataobjectClass.addSuperClass(concept);

		
		//create arrows
		OntClass accessClass = m.createClass(NS + "access");
		accessClass.addSuperClass(relation);
		OntClass realizationClass = m.createClass(NS + "realization");
		realizationClass.addSuperClass(relation);
		OntClass triggeringClass = m.createClass(NS + "triggering");
		triggeringClass.addSuperClass(relation);
		
		OntClass compositionClass = m.createClass(NS + "composition");
		compositionClass.addSuperClass(relation);
		
		
		//create properties
		//for onewaywhitearrow
		ObjectProperty proprealizationealization = m.createObjectProperty(NS + "realizationealization");
		proprealizationealization.addDomain(applicationcomponentClass);
		proprealizationealization.addRange(applicationserviceClass);
		
		//!for onewayblackarrow
		ObjectProperty proptriggering = m.createObjectProperty(NS + "triggering");
		proptriggering.addDomain(applicationfunctionClass);
		proptriggering.addRange(applicationfunctionClass);	
		
		//!for onewaydotsarrow
		ObjectProperty propaccess = m.createObjectProperty(NS + "access");
		propaccess.addDomain(applicationfunctionClass);
		propaccess.addRange(dataobjectClass); 

		//!for backgroundConnect
		ObjectProperty propcomposition = m.createObjectProperty(NS + "composition");
		propcomposition.addDomain(applicationfunctionClass);
		propcomposition.addRange(applicationfunctionClass);
		 //ObjectPropertypropcomposition = m.createObjectProperty(NS + "composition");
		 //propcomposition.addDomain(applicationfunctionClass);
		// propcomposition.addRange(applicationcomponentClass);		

		
	
		//create individuals
		 Individual polCreServ = m.createIndividual(NS + "PolicyCreationService", applicationserviceClass);
		 Individual homeAPolAdmin = m.createIndividual(NS + "HomeAndAwayPolicyAdministration", applicationcomponentClass);
		 Individual policCreat = m.createIndividual(NS + "PolicyCreation",applicationfunctionClass);
		 Individual calcRisk = m.createIndividual(NS + "CalculateRisk", applicationfunctionClass);
		 Individual calcPrem = m.createIndividual(NS + "CalculatePremium", applicationfunctionClass);
		 Individual creatPol = m.createIndividual(NS + "CreatePolicy", applicationfunctionClass);
		 Individual storePol= m.createIndividual(NS + "StorePolicy", applicationfunctionClass);
		 Individual insurReqD = m.createIndividual(NS + "InsuranceRequestData",dataobjectClass);
		 Individual insPolData = m.createIndividual(NS + "InsurancePolicyData", dataobjectClass);
		 Individual custFileData = m.createIndividual(NS + "CustomerFileData",dataobjectClass);
		
		 //****
		 //create ind links
		 //****
		
		 //create all onewaywhitearrow links
		 //create 1 links
		 Individual link11 = m.createIndividual(NS + "HomeAndAwayPolicyAdministration", realizationClass);
		link11.addProperty(proprealizationealization, polCreServ);
		
		
		 //create all backgroundconnection links
		 //create 2 links
		 Individual link21 = m.createIndividual(NS + "PolicyCreation", compositionClass);
		link21.addProperty(propcomposition, homeAPolAdmin);
		
		 Individual link22 = m.createIndividual(NS + "CalculateRisk", compositionClass);
		link22.addProperty(propcomposition, policCreat);
		
		 Individual link23 = m.createIndividual(NS + "CalculatePremium", compositionClass);
		link23.addProperty(propcomposition, policCreat);
		
		 Individual link24 = m.createIndividual(NS + "CreatePolicy", compositionClass);
		link24.addProperty(propcomposition, policCreat);
		
		 Individual link25 = m.createIndividual(NS + "StorePolicy", compositionClass);
		link25.addProperty(propcomposition, policCreat);
		
		 //create all 1wayblackarrow links
		 //create 3 links
		 Individual link31 = m.createIndividual(NS + "CalculateRisk", triggeringClass);
		link31.addProperty(proptriggering, calcPrem);
		
		 Individual link32 = m.createIndividual(NS + "CalculatePremium", triggeringClass);
		link32.addProperty(proptriggering, creatPol);
		
		 Individual link33 = m.createIndividual(NS + "CreatePolicy", triggeringClass);
		link33.addProperty(proptriggering, storePol);
		
		 //create all 1waywdotsarrow links
		 Individual link41 = m.createIndividual(NS + "CalculateRisk", accessClass);
		link41.addProperty(propaccess, insurReqD);
		
		 Individual link42 = m.createIndividual(NS + "CreatePolicy", accessClass);
		link42.addProperty(propaccess, insPolData);
		
		 Individual link43 = m.createIndividual(NS + "StorePolicy", accessClass);
		link43.addProperty(propaccess, custFileData);
		
		
		
		System.out.println("Request1\n");
			for(StmtIterator it = link11.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request2\n");
			for(StmtIterator it = polCreServ.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request3\n");
			//вывод всего, что связано с InturancePolicyData для всей модели 
			OntClass c = insPolData.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
		
		try {
				m.write(new FileWriter("Nastya.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}	

}
