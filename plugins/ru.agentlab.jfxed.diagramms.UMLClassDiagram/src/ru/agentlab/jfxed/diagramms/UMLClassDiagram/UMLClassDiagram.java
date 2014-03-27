package ru.agentlab.jfxed.diagramms.UMLClassDiagram;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class UMLClassDiagram {
	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";

	//test from sourcetree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();//ñîçäàåòñÿ ïóñòàÿ áàçà çíàíèé
		OntClass productClass = m.createClass(NS + "Product");//ñîçäàåì îòäåëüíûå triple
		OntClass contractClass = m.createClass(NS + "Contract");
		OntClass associationClass = m.createClass(NS + "Association");

		OntClass aggregationClass = m.createClass(NS + "Agregation");//ñâÿçü
		aggregationClass.addSuperClass(associationClass);//ðîäèòåëüñêàÿ ñâÿçü

		ObjectProperty propTo = m.createObjectProperty(NS + "To");//îáúåêòû - ñâîéñòâà
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");

		propTo.addDomain(aggregationClass);//ñâîéñòâà ó aggregation
		propFrom.addDomain(aggregationClass);

		propTo.addRange(contractClass);//òî ÷òî ìîãóò ïðèíèìàòü
		propFrom.addRange(productClass);

		//íàïîëíåíèå áàçû 
		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);
		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);

		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		aggregationIndividual.addProperty(propTo, contractIndividual);//îò ïðîäóêòà ê êîíòðàêòó
		aggregationIndividual.addProperty(propFrom, productIndividual);
		m.write(System.out);//è â êîíñîëü
	}
}
