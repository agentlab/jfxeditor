package ru.agentlab.jfxed.diagramms.UMLUseCase;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class UMLUseCase {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
static String NS = SOURCE + "#";

//test from sourcetree
public static void main (String[] args){
OntModel m = ModelFactory.createOntologyModel();//ñîçäàåòñÿ ïóñòàÿ áàçà çíàíèé
OntClass UseCaseClass = m.createClass(NS + "Use Case");// блок Use Case triple
OntClass actorClass = m.createClass(NS + "Actor");// actor
OntClass associationClass = m.createClass(NS + "Association");// связь Association
OntClass includeClass = m.createClass(NS + "Include");// связь Include
OntClass extendClass = m.createClass(NS + "Extend");// связь Extend


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
