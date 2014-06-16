package ru.agentlab.jfxed.diagramms.epcdiagram;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class EPCdiagram {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		
		/*
		 * Здесь объявляем объекты квадратики схемы
		 * */
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		
		
		/**
		 * Вершины графа
		 */
		
		OntClass unitClass = m.createClass(NS + "Organization Unit");
		OntClass resourceClass = m.createClass(NS + "Information Resource");
		OntClass functionClass = m.createClass(NS + "Function");
		OntClass eventClass = m.createClass(NS + "Event");
		
		OntClass controlClass = m.createClass(NS + "Control");//связь Control
		OntClass orgClass = m.createClass(NS + "Organization");
		OntClass infClass = m.createClass(NS + "Information");
		
		// связи
		
		ObjectProperty unitFuncTo = m.createObjectProperty(NS + "OrganizationTo");
		unitFuncTo.addDomain(orgClass);
		unitFuncTo.addRange(unitClass);
		ObjectProperty unitFuncFrom = m.createObjectProperty(NS + "OrganizationFrom");
		unitFuncFrom.addDomain(orgClass);
		unitFuncFrom.addRange(functionClass);
		
		ObjectProperty resFuncTo = m.createObjectProperty(NS + "InformationTo");
		resFuncTo.addDomain(infClass);
		resFuncTo.addRange(functionClass);
		resFuncTo.addRange(resourceClass);
		ObjectProperty resFuncFrom = m.createObjectProperty(NS + "InformationFrom");
		resFuncFrom.addDomain(infClass);
		resFuncFrom.addRange(functionClass);
		resFuncFrom.addRange(resourceClass);
		
		ObjectProperty eventFuncTo = m.createObjectProperty(NS + "ControlTo");
		eventFuncTo.addDomain(controlClass);
		eventFuncTo.addRange(eventClass);
		eventFuncTo.addRange(functionClass);
		ObjectProperty eventFuncFrom = m.createObjectProperty(NS + "ControlFrom");
		eventFuncFrom.addDomain(controlClass);
		eventFuncFrom.addRange(eventClass);
		eventFuncFrom.addRange(functionClass);
		
		// наполнение базы
		Individual customer = m.createIndividual(orgClass);
		Individual genClerk = m.createIndividual(orgClass);
		Individual cash = m.createIndividual(resourceClass);
		Individual billInf = m.createIndividual(resourceClass);
		Individual receipt = m.createIndividual(resourceClass);
		Individual billSetted = m.createIndividual(eventClass);
		Individual billRec = m.createIndividual(eventClass);
		Individual procBill = m.createIndividual(functionClass);
		Individual reqBill = m.createIndividual(functionClass);
		
		Individual orgIndividual = m.createIndividual(orgClass);
		orgIndividual.addProperty(unitFuncFrom, customer);
		orgIndividual.addProperty(unitFuncTo, reqBill);
		orgIndividual.addProperty(unitFuncFrom, genClerk);
		orgIndividual.addProperty(unitFuncTo, procBill);
		
		Individual infIndividual = m.createIndividual(infClass);
		infIndividual.addProperty(resFuncFrom, cash);
		infIndividual.addProperty(resFuncTo, procBill);
		infIndividual.addProperty(resFuncFrom, billInf);
		infIndividual.addProperty(resFuncTo, procBill);
		infIndividual.addProperty(resFuncFrom, procBill);
		infIndividual.addProperty(resFuncTo, receipt);
		
		Individual controlIndividual = m.createIndividual(controlClass);
		controlIndividual.addProperty(eventFuncFrom, reqBill);
		controlIndividual.addProperty(eventFuncTo, billRec);
		controlIndividual.addProperty(eventFuncFrom, billRec);
		controlIndividual.addProperty(eventFuncTo, procBill);
		controlIndividual.addProperty(eventFuncFrom, procBill);
		controlIndividual.addProperty(eventFuncTo, billSetted);
		
		m.write(System.out);
		
			}
	}
