package ru.agentlab.jfxed.diagramms.IntroductoryViewpoint_lab3;

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
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/alborovDiagram";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		//Create superclass
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		//**
		//create objects
		//***
		
		OntClass businessActorRoleObj = m.createClass(NS + "businessActorRole");
		businessActorRoleObj.addSuperClass(concept);
		OntClass applicationServiceObj = m.createClass(NS + "applicationService");
		applicationServiceObj.addSuperClass(concept);
		OntClass businessProcFuncObj = m.createClass(NS + "businessProcessFunction");
		businessProcFuncObj.addSuperClass(concept);
		OntClass applicationComponentObj = m.createClass(NS + "applicationComponent");
		applicationComponentObj.addSuperClass(concept);
		OntClass networkObj = m.createClass(NS + "Network");
		networkObj.addSuperClass(concept);
		OntClass deviceObj = m.createClass(NS + "Device");
		deviceObj.addSuperClass(concept);
		OntClass businessServiceObj = m.createClass(NS + "businessService");
		businessServiceObj.addSuperClass(concept);
		
		
		OntClass linkClass = m.createClass(NS + "linkClass");
		linkClass.addSuperClass(relation);
		
		
		//***
		//Create arrow types
		//***
		/*
		//Association Arrow
		OntClass associationArrow = m.createClass(NS + "assotiation");
		associationArrow.addSuperClass(relation);
		//Triggering Arrow
		OntClass triggeringArrow = m.createClass(NS + "triggering");
		triggeringArrow.addSuperClass(relation);
		*/
		
		//***
		//Create properties
		//***
		
		//Triggering Arrow Property
		ObjectProperty proptriggering1 = m.createObjectProperty(NS + "triggering");
		proptriggering1.addDomain(businessProcFuncObj);
		proptriggering1.addRange(businessServiceObj);
		
		ObjectProperty proptriggering2 = m.createObjectProperty(NS + "triggering");
		proptriggering2.addDomain(applicationComponentObj);
		proptriggering2.addRange(applicationServiceObj);
		
		ObjectProperty proptriggering3 = m.createObjectProperty(NS + "triggering");
		proptriggering3.addDomain(businessProcFuncObj);
		proptriggering3.addRange(businessProcFuncObj);
		
		ObjectProperty propassociation1 = m.createObjectProperty(NS + "association");
		propassociation1.addDomain(businessActorRoleObj);
		propassociation1.addRange(businessServiceObj);
		
		ObjectProperty propassociation2 = m.createObjectProperty(NS + "association");
		propassociation2.addDomain(applicationServiceObj);
		propassociation2.addRange(businessProcFuncObj);
		
		ObjectProperty propassociation3 = m.createObjectProperty(NS + "association");
		propassociation3.addDomain(deviceObj);
		propassociation3.addRange(applicationComponentObj);
		
		ObjectProperty propassociation4 = m.createObjectProperty(NS + "association");
		propassociation4.addDomain(networkObj);
		propassociation4.addRange(deviceObj);	
		
		ObjectProperty propassociation5 = m.createObjectProperty(NS + "association");
		propassociation4.addDomain(businessProcFuncObj);
		propassociation4.addRange(applicationComponentObj);
		
		ObjectProperty propassociation6 = m.createObjectProperty(NS + "association");
		propassociation4.addDomain(applicationComponentObj);
		propassociation4.addRange(applicationComponentObj);
		
		
		 		
		//***
				//Create individuals
				//***
				
				Individual client = m.createIndividual(NS + "Client", businessActorRoleObj);
				Individual archiSurance = m.createIndividual(NS + "ArchiSurance", businessActorRoleObj);
				
				Individual claimReg = m.createIndividual(NS + "CLaimRegistration", businessServiceObj);
				Individual customerInf = m.createIndividual(NS + "customerInformation", businessServiceObj);
				Individual claimPay = m.createIndividual(NS + "ClaimPayment", businessServiceObj);
				
				Individual damage = m.createIndividual(NS + "DamageClaimingProcess", applicationServiceObj);
				
				Individual register = m.createIndividual(NS + "Register", businessProcFuncObj);
				Individual accept = m.createIndividual(NS + "Accept", businessProcFuncObj);
				Individual valuate = m.createIndividual(NS + "Valuate", businessProcFuncObj);
				Individual pay = m.createIndividual(NS + "Pay", businessProcFuncObj);
				
				Individual crm = m.createIndividual(NS + "CRMapplication", applicationComponentObj);
				Individual policy = m.createIndividual(NS + "PolicyAdministration", applicationComponentObj);
				Individual financial = m.createIndividual(NS + "FinancialApplication", applicationComponentObj);
				
				Individual unix = m.createIndividual(NS + "UNIXServers", deviceObj);
				Individual mainframe = m.createIndividual(NS + "Mainframe", deviceObj);
				
				Individual network = m.createIndividual(NS + "Network", networkObj);
				 
		        //***
				//Create links
				//***
				
				Individual link1 = m.createIndividual(NS + "Client", linkClass);
				link1.addProperty(propassociation1, claimReg);
				link1.addProperty(propassociation1, customerInf);
				link1.addProperty(propassociation1, claimPay);
				
				Individual link2 = m.createIndividual(NS + "ArchiSurance", linkClass);
				link2.addProperty(propassociation1, damage);
				
				Individual link3 = m.createIndividual(NS + "Register", linkClass);
				link3.addProperty(proptriggering1, accept);
				link3.addProperty(proptriggering3, claimReg);
				link3.addProperty(propassociation5, crm);
				
				Individual link4 = m.createIndividual(NS + "Accept", linkClass);
				link4.addProperty(proptriggering1, valuate);
				link4.addProperty(proptriggering3, customerInf);
				link4.addProperty(propassociation5, policy);
				
				Individual link5 = m.createIndividual(NS + "Valuate", linkClass);
				link5.addProperty(proptriggering1, pay);
				
				Individual link6 = m.createIndividual(NS + "Pay", linkClass);
				link6.addProperty(proptriggering3, claimPay);
				link6.addProperty(propassociation5, financial);
				
				Individual link7 = m.createIndividual(NS + "DamageClaimingProcess", linkClass);
				link7.addProperty(propassociation2, register);
				link7.addProperty(propassociation2, accept);
				link7.addProperty(propassociation2, valuate);
				link7.addProperty(propassociation2, pay);
				
				Individual link8 = m.createIndividual(NS + "CRMapplication", linkClass);
				link8.addProperty(propassociation6, policy);
				
				Individual link9 = m.createIndividual(NS + "PolicyAdministration", linkClass);
				link9.addProperty(propassociation6, financial);
				
				Individual link10 = m.createIndividual(NS + "UNIXservers", linkClass);
				link10.addProperty(propassociation3, crm);
				
				Individual link11 = m.createIndividual(NS + "Mainframe", linkClass);
				link11.addProperty(propassociation3, policy);
				link11.addProperty(propassociation3, financial);
				
				Individual link12 = m.createIndividual(NS + "Network", linkClass);
				link12.addProperty(propassociation4, unix);
				link12.addProperty(propassociation4, mainframe);
				
				
				
				

				
						
				 System.out.println("Request1\n");
					for(StmtIterator it = link1.listProperties(); it.hasNext();)
					{
						System.out.println(it.nextStatement());
					}
					System.out.println("Request2\n");
					for(StmtIterator it = register.listProperties(); it.hasNext();)
					{
						System.out.println(it.nextStatement());
					}
					System.out.println("Request3\n");
					
					OntClass c = policy.getOntClass();
					SimpleSelector s = new SimpleSelector(null, null, c);
					for(StmtIterator it = m.listStatements(s); it.hasNext();)
					{
						System.out.println(it.nextStatement());
					}
				 
				try {
						m.write(new FileWriter("alborovDiagram.owl"), "OWL/XML");
					} catch (IOException e) {
						e.printStackTrace();
					}		
			}	
		}
