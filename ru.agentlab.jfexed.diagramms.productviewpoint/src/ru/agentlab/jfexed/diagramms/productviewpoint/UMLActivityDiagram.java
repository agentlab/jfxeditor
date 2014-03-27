//Protege 2,3 необходимо для визуализации
package ru.agentlab.jfexed.diagramms.productviewpoint;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class UMLActivityDiagram {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	public static void main(String[] args) {
		OntModel model = ModelFactory.createOntologyModel();
		OntClass receiveOrder = model.createClass(NS + "ReceiveOrder");
		OntClass fillOrder = model.createClass(NS + "FillOrder");
		OntClass shipOrder = model.createClass(NS + "ShipOrder");
		OntClass closeOrder = model.createClass(NS + "CloseOrder");
		OntClass sendInvoice = model.createClass(NS + "SendInvoice");
		OntClass makePayment = model.createClass(NS + "MakePayment");
		OntClass acceptPayment = model.createClass(NS + "AcceptPayment");
		OntClass invoice = model.createClass(NS + "Invoice");
		OntClass requestOrder = model.createClass(NS + "RequestOrder");
		OntClass orderRejected1 = model.createClass(NS + "OrderRejected1");
		OntClass orderRejected2 = model.createClass(NS + "OrderRejected2");
		OntClass initialNode = model.createClass(NS + "InitialNode");
		OntClass finalNode = model.createClass(NS + "FinalNode");
		OntClass orderAccepted1 = model.createClass(NS + "OrderAccepted1");
		OntClass orderAccepted2 = model.createClass(NS + "OrderAccepted2");
		OntClass fork = model.createClass(NS + "Fork");
		OntClass join = model.createClass(NS + "Join");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");
		aggregationClass.addSuperClass(associationClass);

		ObjectProperty propTo = m.createObjectProperty(NS + "To");
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");

		propTo.addDomain(aggregationClass);
		propFrom.addDomain(aggregationClass);

		propTo.addRange(contractClass);
		propFrom.addRange(productClass);

		 
		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);
		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);

		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		aggregationIndividual.addProperty(propTo, contractIndividual);
		aggregationIndividual.addProperty(propFrom, productIndividual);
		m.write(System.out);	
	}
}
