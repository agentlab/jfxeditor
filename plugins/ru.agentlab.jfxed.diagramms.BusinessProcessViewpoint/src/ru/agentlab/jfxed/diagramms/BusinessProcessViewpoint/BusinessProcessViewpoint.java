package ru.agentlab.jfxed.diagramms.BusinessProcessViewpoint;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class BusinessProcessViewpoint {
	
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main(String[] args) {
		
		OntModel m = ModelFactory.createOntologyModel();
		
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Realation");
		
		// creating objects
		OntClass buisnessProcessClass = m.createClass(NS + "buisnessProcess");
		buisnessProcessClass.addSuperClass(concept);
		
		OntClass buisnessObjectClass = m.createClass(NS + "buisnessObject");
		buisnessObjectClass.addSuperClass(concept);
		
		OntClass buisnessEventClass = m.createClass(NS + "buisnessEvent");
		buisnessEventClass.addSuperClass(concept);
		
		OntClass representationClass = m.createClass(NS + "representation");
		representationClass.addSuperClass(concept);
		
		//creating relations
		OntClass accessClass = m.createClass(NS + "access");
		accessClass.addSuperClass(relation);
		
		OntClass triggeringClass = m.createClass(NS + "triggering");
		triggeringClass.addSuperClass(relation);
		
		OntClass realizationClass = m.createClass(NS + "realiztion");
		realizationClass.addSuperClass(relation);
		
		OntClass compositionClass = m.createClass(NS + "composition");
		compositionClass.addSuperClass(relation);
		
		//creating properties
		ObjectProperty propertyAccessToObj = m.createObjectProperty(NS + "access");
		propertyAccessToObj.addDomain(buisnessProcessClass);
		propertyAccessToObj.addRange(buisnessObjectClass);
		
		ObjectProperty propertyAccessToProc = m.createObjectProperty(NS + "access");
		propertyAccessToProc.addDomain(buisnessObjectClass);
		propertyAccessToProc.addRange(buisnessProcessClass);

		ObjectProperty propertyRealization = m.createObjectProperty(NS + "realization");
		propertyRealization.addDomain(representationClass);
		propertyRealization.addRange(buisnessObjectClass);

		ObjectProperty propertyTriggeringFromEvent = m.createObjectProperty(NS + "triggering");
		propertyTriggeringFromEvent.addDomain(buisnessEventClass);
		propertyTriggeringFromEvent.addRange(buisnessProcessClass);
		
		ObjectProperty propertyTriggeringProc = m.createObjectProperty(NS + "triggering");
		propertyTriggeringProc.addDomain(buisnessProcessClass);
		propertyTriggeringProc.addRange(buisnessProcessClass);
		
		ObjectProperty propertyComposition = m.createObjectProperty(NS + "composition");
		propertyComposition.addDomain(buisnessProcessClass);
		propertyComposition.addRange(buisnessProcessClass);
		
		//create individuals
		Individual damageOccured = m.createIndividual(NS + "damageOccured", buisnessEventClass);
		Individual claimForm = m.createIndividual(NS + "claimForm", representationClass);
		Individual insurancePolicy = m.createIndividual(NS + "insuransePolicy", buisnessObjectClass);
		Individual damageClaim = m.createIndividual(NS + "damageClaim", buisnessObjectClass);
		Individual customerFile = m.createIndividual(NS + "customerFile", buisnessObjectClass);
		Individual handleClaim = m.createIndividual(NS + "handleClaim", buisnessProcessClass);
		Individual register = m.createIndividual(NS + "register", buisnessProcessClass);
		Individual accept = m.createIndividual(NS + "accept", buisnessProcessClass);
		Individual valuate = m.createIndividual(NS + "valuate", buisnessProcessClass);
		Individual pay = m.createIndividual(NS + "pay", buisnessProcessClass);
		
		//create individual links
		Individual linkCompReg = m.createIndividual(NS + "register", compositionClass);
		linkCompReg.addProperty(propertyComposition, handleClaim);
		Individual linkCompAcc = m.createIndividual(NS + "accept", compositionClass);
		linkCompAcc.addProperty(propertyComposition, handleClaim);
		Individual linkCompVal = m.createIndividual(NS + "valuate", compositionClass);
		linkCompVal.addProperty(propertyComposition, handleClaim);
		Individual linkCompPay = m.createIndividual(NS + "pay", compositionClass);
		linkCompPay.addProperty(propertyComposition, handleClaim);
		
		Individual linkDamOccToReg = m.createIndividual(NS + "damageOccured", triggeringClass);
		linkDamOccToReg.addProperty(propertyTriggeringFromEvent, register);
		
		Individual linkRegToAcc = m.createIndividual(NS + "register", triggeringClass);
		linkRegToAcc.addProperty(propertyTriggeringProc, accept);
		Individual linkRegToDamClaim = m.createIndividual(NS + "register", accessClass);
		linkRegToDamClaim.addProperty(propertyAccessToObj, damageClaim);
		Individual linkRegToCustFile = m.createIndividual(NS + "register", accessClass);
		linkRegToCustFile.addProperty(propertyAccessToObj, customerFile);
		
		Individual linkAccToVal = m.createIndividual(NS + "accept", triggeringClass);
		linkAccToVal.addProperty(propertyTriggeringProc, valuate);
		
		Individual linkValToPay = m.createIndividual(NS + "valuate", triggeringClass);
		linkValToPay.addProperty(propertyTriggeringProc, pay);
		Individual linkValToDamClaim = m.createIndividual(NS + "valuate", accessClass);
		linkValToDamClaim.addProperty(propertyAccessToObj, damageClaim);
		
		Individual linkPayToCustFile = m.createIndividual(NS + "pay", accessClass);
		linkPayToCustFile.addProperty(propertyAccessToObj, customerFile);
		
		Individual linkInsPolToReg = m.createIndividual(NS + "insurancePolicy", accessClass);
		linkInsPolToReg.addProperty(propertyAccessToProc, register);
		Individual linkInsPolToAcc = m.createIndividual(NS + "insurancePolicy", accessClass);
		linkInsPolToAcc.addProperty(propertyAccessToProc, accept);
		
		Individual linkDamClaimToAcc = m.createIndividual(NS + "damageClaim", accessClass);
		linkDamClaimToAcc.addProperty(propertyAccessToProc, accept);
		
		Individual linkClaimFormToDamClaim = m.createIndividual(NS + "claimForm", realizationClass);
		linkClaimFormToDamClaim.addProperty(propertyRealization, damageClaim);
		
		Individual linkCustFileToAcc = m.createIndividual(NS + "customerFile", accessClass);
		linkCustFileToAcc.addProperty(propertyAccessToProc, accept);
				
		try {
			System.out.println("print");
			m.write(new FileWriter("BuisnessProcessViewpoint.owl"), "RDF/XML");
		} catch (IOException e) {
			System.out.println("errr");
			e.printStackTrace();
		}
		
		System.out.println("\nRequest1\n");
		for(StmtIterator si = linkRegToAcc.listProperties(); si.hasNext();)
		{
			System.out.println(si.nextStatement());
		}
		
		System.out.println("\nRequest2\n");
		for(StmtIterator si = handleClaim.listProperties(); si.hasNext();)
		{
			System.out.println(si.nextStatement());
		}
		
		System.out.println("\nRequest3\n");
		OntClass c = damageClaim.getOntClass();
		SimpleSelector s = new SimpleSelector(null, null, c);
		for(StmtIterator si = m.listStatements(s); si.hasNext();)
		{
			System.out.println(si.nextStatement());
		}
	}
}
