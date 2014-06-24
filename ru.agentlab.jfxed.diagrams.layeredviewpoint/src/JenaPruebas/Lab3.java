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
	

public class Lab3 {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//create superclasses
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//create objects
		OntClass pinkRectClass = m.createClass(NS + "pinkRect");
		pinkRectClass.addSuperClass(concept);
		OntClass yellowOvalClass = m.createClass(NS + "yellowOval");
		yellowOvalClass.addSuperClass(concept);
		OntClass yellowRectClass = m.createClass(NS + "yellowRect");
		yellowRectClass.addSuperClass(concept);
		OntClass blueOvalClass = m.createClass(NS + "blueOval");
		blueOvalClass.addSuperClass(concept);
		OntClass greenOvalClass = m.createClass(NS + "greenOval");
		greenOvalClass.addSuperClass(concept);
		OntClass blueRectClass = m.createClass(NS + "blueRect");
		blueRectClass.addSuperClass(concept);
		OntClass greenRectClass = m.createClass(NS + "greenRect");
		greenRectClass.addSuperClass(concept);
		OntClass greenPcClass = m.createClass(NS + "greenPc");
		greenPcClass.addSuperClass(concept);
		
		//create arrows
		OntClass oneWayArrowClass = m.createClass(NS + "oneWayArrow");
		oneWayArrowClass.addSuperClass(relation);
		OntClass twoWayDotsArrowClass = m.createClass(NS + "twoWayDotsArrow");
		twoWayDotsArrowClass.addSuperClass(relation);
		OntClass oneWayWhiteArrowClass = m.createClass(NS + "oneWayWhiteArrow");
		oneWayWhiteArrowClass.addSuperClass(relation);
		OntClass oneWayBlackArrowClass = m.createClass(NS + "oneWayBlackArrow");
		oneWayBlackArrowClass.addSuperClass(relation);
		
		//create properties
		//for onewayarrow
		 ObjectProperty propOneWayArrow = m.createObjectProperty(NS + "OneWayArrow");
		 propOneWayArrow.addDomain(yellowOvalClass);
		 propOneWayArrow.addRange(pinkRectClass);
		 ObjectProperty propOneWayArrow1 = m.createObjectProperty(NS + "OneWayArrow1");
		 propOneWayArrow1.addDomain(greenOvalClass);
		 propOneWayArrow1.addRange(blueRectClass);
		 ObjectProperty propOneWayArrow2 = m.createObjectProperty(NS + "OneWayArrow2");
		 propOneWayArrow2.addDomain(blueOvalClass);
		 propOneWayArrow2.addRange(yellowRectClass);
		 ObjectProperty propOneWayArrow3 = m.createObjectProperty(NS + "OneWayArrow3");
		 propOneWayArrow3.addDomain(blueOvalClass);
		 propOneWayArrow3.addRange(blueRectClass);
		 
		//for twowaydots
		 ObjectProperty propTwoWayDotsArrow = m.createObjectProperty(NS + "twoWayDotsArrow");
		 propTwoWayDotsArrow.addDomain(pinkRectClass);
		 propTwoWayDotsArrow.addRange(pinkRectClass); 
		 ObjectProperty propTwoWayDotsArrow1 = m.createObjectProperty(NS + "twoWayDotsArrow1");
		 propTwoWayDotsArrow1.addDomain(yellowRectClass);
		 propTwoWayDotsArrow1.addRange(pinkRectClass);
		 ObjectProperty propTwoWayDotsArrow2 = m.createObjectProperty(NS + "twoWayDotsArrow2");
		 propTwoWayDotsArrow2.addDomain(pinkRectClass);
		 propTwoWayDotsArrow2.addRange(yellowRectClass);
		
		//for onewaywhitearrow
		 ObjectProperty propOneWayWhiteArrow = m.createObjectProperty(NS + "OneWayWhiteArrow");
		 propOneWayWhiteArrow.addDomain(blueRectClass);
		 propOneWayWhiteArrow.addRange(blueOvalClass);
		 ObjectProperty propOneWayWhiteArrow1 = m.createObjectProperty(NS + "OneWayWhiteArrow1");
		 propOneWayWhiteArrow1.addDomain(yellowRectClass);
		 propOneWayWhiteArrow1.addRange(yellowOvalClass);
		 ObjectProperty propOneWayWhiteArrow2 = m.createObjectProperty(NS + "OneWayWhiteArrow2");
		 propOneWayWhiteArrow2.addDomain(greenRectClass);
		 propOneWayWhiteArrow2.addRange(greenOvalClass);
		 
		//for onewayblackarrow 
		 ObjectProperty propOneWayBlackArrow = m.createObjectProperty(NS + "OneWayBlackArrow");
		 propOneWayBlackArrow.addDomain(yellowRectClass);
		 propOneWayBlackArrow.addRange(yellowRectClass);		
		 
		 //create individuals
		 Individual insurant = m.createIndividual(NS + "insurant", pinkRectClass);
		 Individual client = m.createIndividual(NS + "client", pinkRectClass);
		 Individual cliamReg = m.createIndividual(NS + "cliamregistration", yellowOvalClass);
		 Individual custInf = m.createIndividual(NS + "custominformation", yellowOvalClass);
		 Individual cliamPay = m.createIndividual(NS + "cliampayment", yellowOvalClass);
		 Individual reg = m.createIndividual(NS + "register", yellowRectClass);
		 Individual accept = m.createIndividual(NS + "accept", yellowRectClass);
		 Individual valuate = m.createIndividual(NS + "valuate", yellowRectClass);
		 Individual pay = m.createIndividual(NS + "pay", yellowRectClass);
		 Individual insurer = m.createIndividual(NS + "insurer", pinkRectClass);
		 Individual archiSur = m.createIndividual(NS + "archiSurance", pinkRectClass);
		 Individual insuranceApl = m.createIndividual(NS + "insuranceApplication", blueOvalClass);
		 Individual custDataMod = m.createIndividual(NS + "customerDataModfication", blueOvalClass);
		 Individual premiumPay = m.createIndividual(NS + "premiumPayment", blueOvalClass);
		 Individual cis = m.createIndividual(NS + "CIS", blueOvalClass);
		 Individual claimsInfServ = m.createIndividual(NS + "ClaimsInfoServ", blueOvalClass);
		 Individual crmSystem = m.createIndividual(NS + "crmSystem", blueRectClass);
		 Individual policyDataManagment = m.createIndividual(NS + "policyDataManagment", blueRectClass);
		 Individual finApl = m.createIndividual(NS + "FinantialApplication", blueRectClass);
		 Individual claimFilSer = m.createIndividual(NS + "CliamFilesService", greenOvalClass);
		 Individual custFilServ = m.createIndividual(NS + "CustomerFileService", greenOvalClass);
		 Individual mainFrame = m.createIndividual(NS + "Mainframe", greenRectClass);
		 Individual nasFile = m.createIndividual(NS + "NASfileserver", greenPcClass);
		 
		 //****
		 //create ind links
		 //****
		 
		 //create all 1waydots links
		 //create 1 links
		 Individual link11 = m.createIndividual(NS + "cliamregistration", oneWayArrowClass);
		 link11.addProperty(propOneWayArrow, insurant);
		 
		 Individual link12 = m.createIndividual(NS + "custominformation", oneWayArrowClass);
		 link12.addProperty(propOneWayArrow, insurant);
		 
		 Individual link13 = m.createIndividual(NS + "cliampayment", oneWayArrowClass);
		 link13.addProperty(propOneWayArrow, insurant);
		 
		 Individual link14 = m.createIndividual(NS + "insuranceApplication", oneWayArrowClass);
		 link14.addProperty(propOneWayArrow2, reg);
		 
		 Individual link15 = m.createIndividual(NS + "customerDataModfication", oneWayArrowClass);
		 link15.addProperty(propOneWayArrow2, reg);	 
		 
		 Individual link16 = m.createIndividual(NS + "premiumPayment", oneWayArrowClass);
		 link16.addProperty(propOneWayArrow2, pay);
		 
		 Individual link17 = m.createIndividual(NS + "CIS", oneWayArrowClass);
		 link17.addProperty(propOneWayArrow3, policyDataManagment);
		 
		 Individual link18 = m.createIndividual(NS + "ClaimsInfoServ", oneWayArrowClass);
		 link18.addProperty(propOneWayArrow3, finApl);
		 
		 Individual link19 = m.createIndividual(NS + "CliamFilesService", oneWayArrowClass);
		 link19.addProperty(propOneWayArrow1, crmSystem);
		 link19.addProperty(propOneWayArrow1, policyDataManagment);
		 
		 Individual link110 = m.createIndividual(NS + "CustomerFileService", oneWayArrowClass);
		 link110.addProperty(propOneWayArrow1, policyDataManagment);
		 link110.addProperty(propOneWayArrow1, finApl);
		 
		 //create all 2waydots links
		 //create 2 links
		 Individual link21 = m.createIndividual(NS + "client", twoWayDotsArrowClass);
		 link21.addProperty(propTwoWayDotsArrow, insurant);
		 
		 Individual link22 = m.createIndividual(NS + "insurant", twoWayDotsArrowClass);
		 link22.addProperty(propTwoWayDotsArrow, client);
		 
		 Individual link23 = m.createIndividual(NS + "insurer", twoWayDotsArrowClass);
		 link23.addProperty(propTwoWayDotsArrow2, reg);
		 link23.addProperty(propTwoWayDotsArrow2, accept);
		 link23.addProperty(propTwoWayDotsArrow2, valuate);
		 link23.addProperty(propTwoWayDotsArrow2, pay);
		 link23.addProperty(propTwoWayDotsArrow, archiSur);		 
		 
		 Individual link24 = m.createIndividual(NS + "register", twoWayDotsArrowClass);
		 link24.addProperty(propTwoWayDotsArrow1, insurer);
		 
		 Individual link25 = m.createIndividual(NS + "accept", twoWayDotsArrowClass);
		 link25.addProperty(propTwoWayDotsArrow1, insurer);
		 
		 Individual link26 = m.createIndividual(NS + "valuate", twoWayDotsArrowClass);
		 link26.addProperty(propTwoWayDotsArrow1, insurer);
		 
		 Individual link27 = m.createIndividual(NS + "pay", twoWayDotsArrowClass);
		 link27.addProperty(propTwoWayDotsArrow1, insurer);
		 
		 Individual link28 = m.createIndividual(NS + "archiSurance", twoWayDotsArrowClass);
		 link28.addProperty(propTwoWayDotsArrow, insurer);
		 
		 //create all 1wayblackarrow links
		 //create 3 links
		 Individual link31 = m.createIndividual(NS + "register", oneWayBlackArrowClass);
		 link31.addProperty(propOneWayBlackArrow, accept);
		 
		 Individual link32 = m.createIndividual(NS + "accept", oneWayBlackArrowClass);
		 link32.addProperty(propOneWayBlackArrow, valuate);
		 
		 Individual link33 = m.createIndividual(NS + "valuate", oneWayBlackArrowClass);
		 link33.addProperty(propOneWayBlackArrow, pay);
		 
		 //create all 1waywhite links
		 Individual link41 = m.createIndividual(NS + "register", oneWayWhiteArrowClass);
		 link41.addProperty(propOneWayWhiteArrow1, cliamReg);
		 
		 Individual link42 = m.createIndividual(NS + "accept", oneWayWhiteArrowClass);
		 link42.addProperty(propOneWayWhiteArrow1, custInf);
		 
		 Individual link43 = m.createIndividual(NS + "pay", oneWayWhiteArrowClass);
		 link43.addProperty(propOneWayWhiteArrow1, cliamPay);
		 
		 Individual link44 = m.createIndividual(NS + "FinantialApplication", oneWayWhiteArrowClass);
		 link44.addProperty(propOneWayWhiteArrow1, premiumPay);
		 
		 Individual link45 = m.createIndividual(NS + "crmSystem", oneWayWhiteArrowClass);
		 link45.addProperty(propOneWayWhiteArrow, insuranceApl);
		 link45.addProperty(propOneWayWhiteArrow, cis);
		 
		 Individual link46 = m.createIndividual(NS + "policyDataManagment", oneWayWhiteArrowClass);
		 link46.addProperty(propOneWayWhiteArrow, custDataMod);
		 link46.addProperty(propOneWayWhiteArrow, claimsInfServ);
		 
		 Individual link47 = m.createIndividual(NS + "mainframe", oneWayWhiteArrowClass);
		 link47.addProperty(propOneWayWhiteArrow2, claimFilSer);
		 
		 Individual link48 = m.createIndividual(NS + "NASfileserver", oneWayWhiteArrowClass);
		 link48.addProperty(propOneWayWhiteArrow2, custFilServ);
		 
		
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
			//вывод всего, что связано с insurer для всей модели 
			OntClass c = insurer.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
		 
		 try {
				m.write(new FileWriter("Ilya.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}	

}
