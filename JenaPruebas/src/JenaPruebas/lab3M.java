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
	

public class lab3M {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//create superclasses
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//create objects
		OntClass bigYellowRectClass = m.createClass(NS + "bigYellowRect");
		bigYellowRectClass.addSuperClass(concept);
		OntClass yellowOvalClass = m.createClass(NS + "yellowOval");
		yellowOvalClass.addSuperClass(concept);
		OntClass yellowRectClass = m.createClass(NS + "yellowRect");
		yellowRectClass.addSuperClass(concept);
		OntClass blueOvalClass = m.createClass(NS + "blueOval");
		blueOvalClass.addSuperClass(concept);
		
		//create arrows
		OntClass oneWayArrowClass = m.createClass(NS + "oneWayArrow");
		oneWayArrowClass.addSuperClass(relation);
		OntClass oneWayWhiteArrowClass = m.createClass(NS + "oneWayWhiteArrow");
		oneWayWhiteArrowClass.addSuperClass(relation);
		OntClass oneWayBlackArrowClass = m.createClass(NS + "oneWayBlackArrow");
		oneWayBlackArrowClass.addSuperClass(relation);
		OntClass backgroundConnectClass = m.createClass(NS + "backgroundConnect");
		backgroundConnectClass.addSuperClass(relation);
		
		//create properties
		//for onewayarrow
		 ObjectProperty propOneWayArrow = m.createObjectProperty(NS + "OneWayArrow");
		 propOneWayArrow.addDomain(yellowOvalClass);
		 propOneWayArrow.addRange(yellowRectClass);
		 ObjectProperty propOneWayArrow1 = m.createObjectProperty(NS + "OneWayArrow1");
		 propOneWayArrow1.addDomain(blueOvalClass);
		 propOneWayArrow1.addRange(yellowRectClass);
		
		//for onewaywhitearrow
		 ObjectProperty propOneWayWhiteArrow = m.createObjectProperty(NS + "OneWayWhiteArrow");
		 propOneWayWhiteArrow.addDomain(yellowRectClass);
		 propOneWayWhiteArrow.addRange(yellowOvalClass);
		 ObjectProperty propOneWayWhiteArrow1 = m.createObjectProperty(NS + "OneWayWhiteArrow1");
		 propOneWayWhiteArrow1.addDomain(bigYellowRectClass);
		 propOneWayWhiteArrow1.addRange(yellowOvalClass);

		//for onewayblackarrow 
		 ObjectProperty propOneWayBlackArrow = m.createObjectProperty(NS + "OneWayBlackArrow");
		 propOneWayBlackArrow.addDomain(yellowRectClass);
		 propOneWayBlackArrow.addRange(yellowRectClass);
		 
		//for backgroundConnect
		 ObjectProperty propBackgroundConnect = m.createObjectProperty(NS + "backgroundConnect");
		 propBackgroundConnect.addDomain(yellowRectClass);
		 propBackgroundConnect.addRange(bigYellowRectClass);
		 
		 //create individuals
		 Individual cust = m.createIndividual(NS + "Customer", yellowRectClass);
		 Individual claimReg = m.createIndividual(NS + "ClaimRegistration", yellowOvalClass);
		 Individual custInf = m.createIndividual(NS + "customerInformation", yellowOvalClass);
		 Individual claimPay = m.createIndividual(NS + "cliampayment", yellowOvalClass);
		 Individual insuranceApl = m.createIndividual(NS + "insuranceApplication", yellowOvalClass);
		 Individual reg = m.createIndividual(NS + "register", yellowRectClass);
		 Individual accept = m.createIndividual(NS + "accept", yellowRectClass);
		 Individual valuate = m.createIndividual(NS + "valuate", yellowRectClass);
		 Individual pay = m.createIndividual(NS + "pay", yellowRectClass);
		 Individual hanCl = m.createIndividual(NS + "handleClaim", bigYellowRectClass);
		 Individual closeCon = m.createIndividual(NS + "closeContract", bigYellowRectClass);
		 Individual formReq = m.createIndividual(NS + "FormalizeRequest", yellowRectClass);
		 Individual createCon = m.createIndividual(NS + "createContract", yellowRectClass);
		 Individual checkSignCon = m.createIndividual(NS + "checkAndSignContract", yellowRectClass);
		 Individual claimsInfServ = m.createIndividual(NS + "claimsInformationService", blueOvalClass);
		 Individual contrServ = m.createIndividual(NS + "ContractingService", blueOvalClass);
		 Individual policyCreServ = m.createIndividual(NS + "policyCreationService", blueOvalClass);
		 		 
		 
		 //****
		 //create ind links
		 //****
		 
		 //create all 1waydots links
		 //create 1 links
		 Individual link11 = m.createIndividual(NS + "insuranceApplication", oneWayArrowClass);
		 link11.addProperty(propOneWayArrow, cust);
		 
		 Individual link12 = m.createIndividual(NS + "insuranceApplication", oneWayArrowClass);
		 link12.addProperty(propOneWayArrow, reg);
		 
		 Individual link13 = m.createIndividual(NS + "ClaimRegistration", oneWayArrowClass);
		 link13.addProperty(propOneWayArrow, cust);
		 
		 Individual link14 = m.createIndividual(NS + "customerInformation", oneWayArrowClass);
		 link14.addProperty(propOneWayArrow, cust);
		 
		 Individual link15 = m.createIndividual(NS + "cliampayment", oneWayArrowClass);
		 link15.addProperty(propOneWayArrow, cust);
		 
		 Individual link16 = m.createIndividual(NS + "claimsInformationService", oneWayArrowClass);
		 link16.addProperty(propOneWayArrow1, formReq);	 
		 
		 Individual link17 = m.createIndividual(NS + "ContractingService", oneWayArrowClass);
		 link17.addProperty(propOneWayArrow1, createCon);
		 
		 Individual link18 = m.createIndividual(NS + "policyCreationService", oneWayArrowClass);
		 link18.addProperty(propOneWayArrow1, checkSignCon);
		 
		 //create all 1wayblackarrow links
		 //create 2 links
		 Individual link21 = m.createIndividual(NS + "register", oneWayBlackArrowClass);
		 link21.addProperty(propOneWayBlackArrow, accept);
		 
		 Individual link22 = m.createIndividual(NS + "accept", oneWayBlackArrowClass);
		 link22.addProperty(propOneWayBlackArrow, valuate);
		 
		 Individual link23 = m.createIndividual(NS + "valuate", oneWayBlackArrowClass);
		 link23.addProperty(propOneWayBlackArrow, pay);
		 
		 Individual link24 = m.createIndividual(NS + "FormalizeRequest", oneWayBlackArrowClass);
		 link24.addProperty(propOneWayBlackArrow, createCon);
		 
		 Individual link25 = m.createIndividual(NS + "createContract", oneWayBlackArrowClass);
		 link25.addProperty(propOneWayBlackArrow, checkSignCon);
		 
		 //create all background links
		//create 3 links
		 Individual link31 = m.createIndividual(NS + "register", backgroundConnectClass);
		 link31.addProperty(propBackgroundConnect, hanCl);
		 
		 Individual link32 = m.createIndividual(NS + "accept", backgroundConnectClass);
		 link32.addProperty(propBackgroundConnect, hanCl);
		 
		 Individual link33 = m.createIndividual(NS + "valuate", backgroundConnectClass);
		 link33.addProperty(propBackgroundConnect, hanCl);
		 
		 Individual link34 = m.createIndividual(NS + "pay", backgroundConnectClass);
		 link34.addProperty(propBackgroundConnect, hanCl);
		 
		 Individual link35 = m.createIndividual(NS + "FormalizeRequest", backgroundConnectClass);
		 link35.addProperty(propBackgroundConnect, closeCon);
		 
		 Individual link36 = m.createIndividual(NS + "createContract", backgroundConnectClass);
		 link36.addProperty(propBackgroundConnect, closeCon);
		 
		 Individual link37 = m.createIndividual(NS + "checkAndSignContract", backgroundConnectClass);
		 link37.addProperty(propBackgroundConnect, closeCon);

		 
		 //create all background links
		 //create 4 links
		 Individual link41 = m.createIndividual(NS + "register", oneWayWhiteArrowClass);
		 link41.addProperty(propOneWayWhiteArrow, claimReg);

		 Individual link42 = m.createIndividual(NS + "accept", oneWayWhiteArrowClass);
		 link42.addProperty(propOneWayWhiteArrow, custInf);
		 
		 Individual link43 = m.createIndividual(NS + "pay", oneWayWhiteArrowClass);
		 link43.addProperty(propOneWayWhiteArrow, claimPay);
		 
		 Individual link44 = m.createIndividual(NS + "closeContract", oneWayWhiteArrowClass);
		 link44.addProperty(propOneWayWhiteArrow1, insuranceApl);
		 
		 System.out.println("Request1\n");
			for(StmtIterator it = link11.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request2\n");
			for(StmtIterator it = reg.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request3\n");
			//вывод всего, что связано с contrServ для всей модели 
			OntClass c = contrServ.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			
		 
		 try {
				m.write(new FileWriter("Mike.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}	

}
