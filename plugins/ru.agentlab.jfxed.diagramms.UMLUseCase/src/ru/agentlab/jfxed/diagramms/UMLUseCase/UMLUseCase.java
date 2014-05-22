package ru.agentlab.jfxed.diagramms.UMLUseCase;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class UMLUseCase {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";

	// test from sourcetree
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();// пустая база знаний
		OntClass actorClass = m.createClass(NS + "Actor");// actor
		OntClass usecaseClass = m.createClass(NS + "Use Case");// блок Use Case
		OntClass atmClass = m.createClass(NS + "ATM");// ATM
		OntClass associationClass = m.createClass(NS + "Association");// связь Association
		OntClass inclusionClass = m.createClass(NS + "Include");// связь Include
		OntClass extensionClass = m.createClass(NS + "Extend");// связь Extend

		OntClass aggregationClass = m.createClass(NS + "Agregation");// связь
		aggregationClass.addSuperClass(associationClass);// родительская связь

		ObjectProperty aggrPropTo = m.createObjectProperty(NS + "AggregationTo");// объекты - свойства
		aggrPropTo.addDomain(aggregationClass);// свойства у aggregation
		aggrPropTo.addRange(usecaseClass);
		ObjectProperty aggrPropFrom = m.createObjectProperty(NS + "AggregationFrom");
		aggrPropFrom.addDomain(aggregationClass);
		aggrPropFrom.addRange(aggregationClass);

		// связь actor - use case
		ObjectProperty assocPropTo = m.createObjectProperty(NS + "AssociationTo");
		assocPropTo.addRange(actorClass);
		assocPropTo.addDomain(associationClass);
		ObjectProperty assocPropFrom = m.createObjectProperty(NS + "AssociationFrom");
		assocPropFrom.addDomain(associationClass);
		assocPropFrom.addRange(usecaseClass);
		
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
		
		// наполнение базы
		Individual user = m.createIndividual(NS + "User", actorClass);
		Individual withdrawCash = m.createIndividual(NS + "Withdraw cash", usecaseClass);
		Individual checkBalance = m.createIndividual(NS + "Check balance", usecaseClass);
		Individual donate = m.createIndividual(NS + "Donate money to charity", usecaseClass);
		Individual transferMoney = m.createIndividual(NS + "Transfer money", usecaseClass);
		Individual payBills = m.createIndividual(NS + "Pay bills", usecaseClass);
		Individual login = m.createIndividual(NS + "Extension poits. Invalid password entered. Abort triggered", usecaseClass);
		Individual handleInvalidPassword = m.createIndividual(NS + "Handle invalid password", usecaseClass);
		Individual handleAbort = m.createIndividual(NS + "Handle abort", usecaseClass);
		Individual atm = m.createIndividual(NS + "ATM", atmClass);
		
		
		Individual aggregationIndividual = m.createIndividual(NS + "agg1", aggregationClass);
		//создание связей atm с use case
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, withdrawCash);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, checkBalance);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, donate);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, transferMoney);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, payBills);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, login);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, handleInvalidPassword);
		aggregationIndividual.addProperty(aggrPropFrom, atm);
		aggregationIndividual.addProperty(aggrPropTo, handleAbort);
		
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
	}
}
