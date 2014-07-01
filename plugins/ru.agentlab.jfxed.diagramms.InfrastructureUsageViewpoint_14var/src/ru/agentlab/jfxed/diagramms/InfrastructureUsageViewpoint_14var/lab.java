package ru.agentlab.jfxed.diagramms.InfrastructureUsageViewpoint_14var;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
	

public class lab {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//Create superclass
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//**
		//create objects
		//***
		
		//Application component
		OntClass appComponentObj = m.createClass(NS + "applicationComponent");
		appComponentObj.addSuperClass(concept);
		//Infrastructure service
		OntClass infServiceObj = m.createClass(NS + "infrastructureService");
		infServiceObj.addSuperClass(concept);
		//System software
		OntClass sysSoftwareObj = m.createClass(NS + "systemSoftware");
		sysSoftwareObj.addSuperClass(concept);
		//Node
		OntClass nodeObj = m.createClass(NS + "node");
		nodeObj.addSuperClass(concept);
		
		//
		OntClass linkClass = m.createClass(NS + "linkClass");
		linkClass.addSuperClass(relation);
		
		//***
		//Create arrow types
		//***
		
		/*//Usedby Arrow
		OntClass usedbyArrow = m.createClass(NS + "usedby");
		usedbyArrow.addSuperClass(relation);
		//Realization Arrow
		OntClass realArrow = m.createClass(NS + "realization");
		realArrow.addSuperClass(relation);
		//Specialization Arrow
		OntClass specArrow = m.createClass(NS + "specialization");
		specArrow.addSuperClass(relation);*/
		
		//***
		//Create properties
		//***
		
		//usedby Arrow Property
		ObjectProperty propusedby = m.createObjectProperty(NS + "usedby");
		propusedby.addDomain(infServiceObj);
		propusedby.addRange(appComponentObj);
		//Realization Arrow Property
		ObjectProperty proprealization = m.createObjectProperty(NS + "realization");
		proprealization.addDomain(sysSoftwareObj);
		proprealization.addRange(infServiceObj);
		//Composition Arrow Property
		ObjectProperty propspecialization = m.createObjectProperty(NS + "specialization");
		propspecialization.addDomain(sysSoftwareObj);
		propspecialization.addRange(nodeObj);
		
		 		
		//***
		//Create individuals
		//***
		
		//Application components on diagram
		Individual appComponent1 = m.createIndividual(NS + "Home&AwayPolicyAdministration", appComponentObj);
		Individual appComponent2 = m.createIndividual(NS + "Home&AwayFinancialApplication", appComponentObj);
		Individual appComponent3 = m.createIndividual(NS + "CarInsuranceApplication", appComponentObj);
		Individual appComponent4 = m.createIndividual(NS + "LegalAidBack-officeSystem", appComponentObj);
		//Infrastructure services on diagram
		Individual infService1 = m.createIndividual(NS + "messagingService", infServiceObj);
		Individual infService2 = m.createIndividual(NS + "dataAccessService", infServiceObj);
		//System software on diagram
		Individual sysSoftware1 = m.createIndividual(NS + "messageQueuing", sysSoftwareObj);
		Individual sysSoftware2 = m.createIndividual(NS + "DBMS", sysSoftwareObj);
		//Node on diagram
		Individual node1 = m.createIndividual(NS + "Mainframe", nodeObj);
		 
		 
        //***
		//Create links
		//***
		
		Individual link1 = m.createIndividual(NS + "messagingService", linkClass);
		link1.addProperty(propusedby, appComponent1);
		link1.addProperty(propusedby, appComponent2);
		link1.addProperty(propusedby, appComponent3);
		
		Individual link2 = m.createIndividual(NS + "dataAccessService", linkClass);
		link2.addProperty(propusedby, appComponent1);
		link2.addProperty(propusedby, appComponent2);
		link2.addProperty(propusedby, appComponent3);
		link2.addProperty(propusedby, appComponent4);
		
		Individual link3 = m.createIndividual(NS + "messageQueuing", linkClass);
		link3.addProperty(proprealization, infService1);
		
		Individual link4 = m.createIndividual(NS + "DBMS", linkClass);
		link4.addProperty(proprealization, infService2);
		
		Individual link5 = m.createIndividual(NS + "Mainframe", linkClass);
		link5.addProperty(propspecialization, sysSoftware1);
		link5.addProperty(propspecialization, sysSoftware2);
		
		
		/*
		Individual link1 = m.createIndividual(NS + "Home&AwayPolicyAdministration", linkClass);
		link1.addProperty(propusedby, infService1);
		link1.addProperty(propusedby, infService2);
		
		Individual link2 = m.createIndividual(NS + "Home&AwayFinancialApplication", linkClass);
		link2.addProperty(propusedby, infService1);
		link2.addProperty(propusedby, infService2);
		
		Individual link3 = m.createIndividual(NS + "CarInsuranceApplication", linkClass);
		link3.addProperty(propusedby, infService1);
		link3.addProperty(propusedby, infService2);
		
		Individual link4 = m.createIndividual(NS + "LegalAidBack-officeSystem", linkClass);
		link4.addProperty(propusedby, infService2);
		
		Individual link5 = m.createIndividual(NS + "messagingService", linkClass);
		link5.addProperty(proprealization, sysSoftware1);
		
		Individual link6 = m.createIndividual(NS + "dataAccessService", linkClass);
		link6.addProperty(proprealization, sysSoftware2);
		
		Individual link7 = m.createIndividual(NS + "Mainframe", linkClass);
		link7.addProperty(propspecialization, sysSoftware1);
		link7.addProperty(propspecialization, sysSoftware2);
		*/
		

		
		//Links from Message Service
		/*Individual link1_1 = m.createIndividual(NS + "messagingService", usedbyArrow);
		link1_1.addProperty(propusedby, appComponent1);
		Individual link1_2 = m.createIndividual(NS + "messagingService", usedbyArrow);
		link1_2.addProperty(propusedby, appComponent2);
		Individual link1_3 = m.createIndividual(NS + "messagingService", usedbyArrow);
		link1_3.addProperty(propusedby, appComponent3);
		
		//Links from Data Access Service
		Individual link2_1 = m.createIndividual(NS + "dataAccessService", usedbyArrow);
		link2_1.addProperty(propusedby, appComponent1);
		Individual link2_2 = m.createIndividual(NS + "dataAccessService", usedbyArrow);
		link2_2.addProperty(propusedby, appComponent2);
		Individual link2_3 = m.createIndividual(NS + "dataAccessService", usedbyArrow);
		link2_3.addProperty(propusedby, appComponent3);
		Individual link2_4 = m.createIndividual(NS + "dataAccessService", usedbyArrow);
		link2_4.addProperty(propusedby, appComponent4);
		
		//Link from Message Queuing
		Individual link3_1 = m.createIndividual(NS + "messageQueuing", realArrow);
		link3_1.addProperty(proprealization, infService1);
		//Link from DBMS
		Individual link4_1 = m.createIndividual(NS + "DBMS", realArrow);
		link4_1.addProperty(proprealization, infService2);
		//Link in Node
		Individual link5_1 = m.createIndividual(NS + "messageQueuing", specArrow);
		link5_1.addProperty(propcomposition, node1);
		Individual link5_2 = m.createIndividual(NS + "DBMS", specArrow);
		link5_2.addProperty(propcomposition, node1);*/
		
				 
		
		 System.out.println("Request1\n");
			for(StmtIterator it = link1.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request2\n");
			for(StmtIterator it = appComponent1.listProperties(); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
			System.out.println("Request3\n");
			
			OntClass c = infService1.getOntClass();
			SimpleSelector s = new SimpleSelector(null, null, c);
			for(StmtIterator it = m.listStatements(s); it.hasNext();)
			{
				System.out.println(it.nextStatement());
			}
		 
		try {
				m.write(new FileWriter("myDiagramm.owl"), "RDF/XML");
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}	
}
