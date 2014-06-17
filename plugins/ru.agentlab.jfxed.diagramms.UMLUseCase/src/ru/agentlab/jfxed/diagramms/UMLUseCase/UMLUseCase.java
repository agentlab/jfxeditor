package ru.agentlab.jfxed.diagramms.UMLUseCase;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class UMLUseCase {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	

	// test from sourcetree
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();// пустая база знаний
		
		//для Protege
		OntClass concept = m.createClass(NS + "concept");
		OntClass relation = m.createClass(NS + "relation");
		
		OntClass actorClass = m.createClass(NS + "Actor");// actor
		actorClass.addSuperClass(concept);
		
		OntClass usecaseClass = m.createClass(NS + "UseCase");// блок Use Case
		usecaseClass.addSuperClass(concept);
		
		OntClass associationClass = m.createClass(NS + "Association");// связь Association
		associationClass.addSuperClass(relation);
		
		OntClass inclusionClass = m.createClass(NS + "Include");// связь Include
		inclusionClass.addSuperClass(relation);
		
		OntClass extensionClass = m.createClass(NS + "Extend");// связь Extend
		extensionClass.addSuperClass(relation);
		
		OntClass systemClass = m.createClass(NS + "ATM");// блок System
		systemClass.addSuperClass(concept);
		
		
		// связь actor - use case
		ObjectProperty assocPropTo = m.createObjectProperty(NS + "AssociationTo");
		assocPropTo.addRange(usecaseClass);
		assocPropTo.addDomain(associationClass);
		ObjectProperty assocPropFrom = m.createObjectProperty(NS + "AssociationFrom");
		assocPropFrom.addDomain(associationClass);
		assocPropFrom.addRange(actorClass);
		
		// связи include
		ObjectProperty incPropTo = m.createObjectProperty(NS + "InclusionTo");
		incPropTo.addDomain(inclusionClass);
		incPropTo.addRange(usecaseClass);
		ObjectProperty incPropFrom = m.createObjectProperty(NS + "InclusionFrom");
		incPropFrom.addRange(usecaseClass);
		incPropFrom.addDomain(inclusionClass);
		
		// связи extend
		ObjectProperty extPropTo = m.createObjectProperty(NS + "ExtensionTo");
		extPropTo.addDomain(extensionClass);
		extPropTo.addRange(usecaseClass);
		ObjectProperty extPropFrom = m.createObjectProperty(NS + "ExtensionFrom");
		extPropFrom.addRange(usecaseClass);
		extPropFrom.addDomain(extensionClass);
		
		// связь use case - system
		ObjectProperty systemPropTo = m.createObjectProperty(NS + "SystemTo");
		assocPropTo.addRange(usecaseClass);
		assocPropTo.addDomain(associationClass);
		ObjectProperty systemPropFrom = m.createObjectProperty(NS + "SystemFrom");
		assocPropFrom.addDomain(associationClass);
		assocPropFrom.addRange(usecaseClass);
		
		// наполнение базы
		Individual user = m.createIndividual(NS + "User", actorClass);
		Individual withdrawCash = m.createIndividual(NS + "WithdrawCash", usecaseClass);
		Individual checkBalance = m.createIndividual(NS + "Checkbalance", usecaseClass);
		Individual donate = m.createIndividual(NS + "DonateMoneyToCharity", usecaseClass);
		Individual transferMoney = m.createIndividual(NS + "TransferMoney", usecaseClass);
		Individual payBills = m.createIndividual(NS + "PayBills", usecaseClass);
		Individual login = m.createIndividual(NS + "ExtensionPoits.InvalidPasswordEntered.AbortTriggered", usecaseClass);
		Individual handleInvalidPassword = m.createIndividual(NS + "HandleInvalidPassword", usecaseClass);
		Individual handleAbort = m.createIndividual(NS + "HandleAbort", usecaseClass);
		Individual atm = m.createIndividual(NS + "ATM", systemClass);
		
		
		Individual systemIndividual = m.createIndividual(NS + "agg1", associationClass);
		systemIndividual.addProperty(systemPropFrom, withdrawCash);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, checkBalance);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, donate);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, transferMoney);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, payBills);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, login);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, handleInvalidPassword);
		systemIndividual.addProperty(systemPropTo, atm);
		systemIndividual.addProperty(systemPropFrom, handleAbort);
		systemIndividual.addProperty(systemPropTo, atm);
		
		
		Individual associationIndividual = m.createIndividual(NS + "agg2", associationClass);
		associationIndividual.addProperty(assocPropFrom, user);
		associationIndividual.addProperty(assocPropTo, withdrawCash);
		associationIndividual.addProperty(assocPropFrom, user);
		associationIndividual.addProperty(assocPropTo, checkBalance);
		associationIndividual.addProperty(assocPropFrom, user);
		associationIndividual.addProperty(assocPropTo, donate);
		associationIndividual.addProperty(assocPropFrom, user);
		associationIndividual.addProperty(assocPropTo, transferMoney);
		associationIndividual.addProperty(assocPropFrom, user);
		associationIndividual.addProperty(assocPropTo, payBills);
		
		Individual inclusionIndividual = m.createIndividual(NS + "agg3", inclusionClass);
		inclusionIndividual.addProperty(incPropFrom, withdrawCash);
		inclusionIndividual.addProperty(incPropTo, login);
		inclusionIndividual.addProperty(incPropFrom, checkBalance); 
		inclusionIndividual.addProperty(incPropTo, login);
		inclusionIndividual.addProperty(incPropFrom, donate);
		inclusionIndividual.addProperty(incPropTo, login);
		inclusionIndividual.addProperty(incPropFrom, transferMoney);
		inclusionIndividual.addProperty(incPropTo, login);
		inclusionIndividual.addProperty(incPropFrom, payBills);
		inclusionIndividual.addProperty(incPropTo, login);
		
		Individual extensionIndividual = m.createIndividual(NS + "agg4", extensionClass);
		extensionIndividual.addProperty(extPropFrom, handleInvalidPassword);
		extensionIndividual.addProperty(extPropTo, login);
		extensionIndividual.addProperty(extPropFrom, handleAbort);
		extensionIndividual.addProperty(extPropTo, login);
		
		m.write(System.out);// в консоль
		System.out.println("Привет");
		
		
		//Запросы
		
		
		System.out.println("\n");
		for(StmtIterator it = inclusionClass.listProperties(); it.hasNext();)
		{
		System.out.println(it.nextStatement());
		}
		
		System.out.println("\n");
		for(StmtIterator it = checkBalance.listProperties(); it.hasNext();)
		{
		System.out.println(it.nextStatement());
		}
		System.out.println("\n");

		
		//вывод всего и всех где есть user
		OntClass c = user.getOntClass();
		SimpleSelector s = new SimpleSelector(null, null, c);
		for(StmtIterator it = m.listStatements(s); it.hasNext();)
		{
		System.out.println(it.nextStatement());
		}
		
		try {
		m.write(new FileWriter("ex1.owl"));//xml
		} catch (IOException e){
		e.printStackTrace();
		
		}
	}
}
