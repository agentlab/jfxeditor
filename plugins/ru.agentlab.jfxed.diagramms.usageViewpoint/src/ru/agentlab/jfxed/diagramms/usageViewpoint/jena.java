package ru.agentlab.jfxed.diagramms.usageViewpoint;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
	
		

public class jena {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		
		
		//объекты
		OntClass redRectClass = m.createClass(NS + "redRect");
		redRectClass.addSuperClass(concept);
		OntClass greenComputer = m.createClass(NS + "greenComputer");
		greenComputer.addSuperClass(concept);
		OntClass greenRectClass = m.createClass(NS + "greenRect");
		greenRectClass.addSuperClass(concept);
		OntClass greenOvalClass = m.createClass(NS + "greenOval");
		greenOvalClass.addSuperClass(concept);
		OntClass bigGreenRectClass = m.createClass(NS + "bigGreenRect");
		bigGreenRectClass.addSuperClass(concept);
		
		//связи
		OntClass oneWayArrowClass = m.createClass(NS + "oneWayArrow");
		oneWayArrowClass.addSuperClass(relation);
		OntClass oneWayLinkClass = m.createClass(NS + "oneWayLink");
		oneWayLinkClass.addSuperClass(relation);
		
		
		
		 //свойства стрелки
		 ObjectProperty propOneWayArrow = m.createObjectProperty(NS + "OneWayArrow");
		 propOneWayArrow.addDomain(bigGreenRectClass);
		 propOneWayArrow.addRange(greenOvalClass);
		 ObjectProperty propOneWayArrow1 = m.createObjectProperty(NS + "OneWayArrow1");
		 propOneWayArrow1.addDomain(greenComputer);
		 propOneWayArrow1.addRange(greenOvalClass);
		 ObjectProperty propOneWayArrow2 = m.createObjectProperty(NS + "OneWayArrow2");
		 propOneWayArrow2.addDomain(redRectClass);
		 propOneWayArrow2.addRange(greenOvalClass);
		 
		 //свойства линии
		 ObjectProperty propOneWayLink = m.createObjectProperty(NS + "OneWayLink");
		 propOneWayLink.addDomain(bigGreenRectClass);
		 propOneWayLink.addRange(greenRectClass);
		 ObjectProperty propOneWayLink1 = m.createObjectProperty(NS + "OneWayLink");
		 propOneWayLink.addDomain(greenRectClass);
		 propOneWayLink.addRange(greenComputer);
		 ObjectProperty propOneWayLink2 = m.createObjectProperty(NS + "OneWayLink");
		 propOneWayLink.addDomain(greenRectClass);
		 propOneWayLink.addRange(redRectClass);
		
		 
		 
		 
		 Individual mainframe = m.createIndividual(NS + "mainframe", bigGreenRectClass);
		 Individual unixServer = m.createIndividual(NS + "UNIXServerfarm", bigGreenRectClass);
		 Individual lan1 = m.createIndividual(NS + "LAN", greenRectClass);
		 Individual lan2 = m.createIndividual(NS + "LAN", greenRectClass);
		 Individual internet = m.createIndividual(NS + "internet", greenRectClass);
		 Individual databaseServer = m.createIndividual(NS + "DatabaseServer", greenOvalClass);
		 Individual fileService = m.createIndividual(NS + "FileService", greenOvalClass);
		 Individual networkService = m.createIndividual(NS + "NetworkService", greenOvalClass);
		 Individual firewall1 = m.createIndividual(NS + "firewall", redRectClass);
		 Individual firewall2 = m.createIndividual(NS + "firewall", redRectClass);
		 Individual nasFileServer = m.createIndividual(NS + "NASFileServer", greenComputer);
		 Individual adminServer = m.createIndividual(NS + "AdminServer", greenComputer);
		 
		 
		 Individual link1 = m.createIndividual(NS + "mainframe", oneWayArrowClass);
		 link1.addProperty(propOneWayArrow, databaseServer);
		 
		 Individual link2 = m.createIndividual(NS + "NASFileServer", oneWayArrowClass);
		 link1.addProperty(propOneWayArrow1, fileService);
		 
		 Individual link3 = m.createIndividual(NS + "firewall1", oneWayArrowClass);
		 link1.addProperty(propOneWayArrow2, networkService);
		 
		 Individual lane1 = m.createIndividual(NS + "mainframe1", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow, lan1);
		 
		 Individual lane2 = m.createIndividual(NS + "lan1", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow1, nasFileServer);
		 
		 Individual lane3 = m.createIndividual(NS + "unixServerFarm", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow, nasFileServer);
		 
		 Individual lane4 = m.createIndividual(NS + "unixServerFarm1", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow2, firewall1);
		 
		 Individual lane5 = m.createIndividual(NS + "unixServerFarm2", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow2, internet);
		 
		 Individual lane6 = m.createIndividual(NS + "unixServerFarm3", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow2, firewall2);
		 
		 Individual lane7 = m.createIndividual(NS + "unixServerFarm4", oneWayLinkClass);
		 link1.addProperty(propOneWayArrow1, adminServer);
		 
		 System.out.println("Request1\n");
			for(StmtIterator it = link1.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request2\n");
			for(StmtIterator it = lan1.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request3\n");
			//вывод всего, что св€зано с insurer дл€ всей модели 
			OntClass c = mainframe.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
	    
		 
		 try {
				m.write(new FileWriter("Dm.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
}

