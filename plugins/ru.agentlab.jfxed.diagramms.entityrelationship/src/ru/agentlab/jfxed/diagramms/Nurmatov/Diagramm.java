package ru.agentlab.jfxed.diagramms.Nurmatov;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Diagramm {
	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from source tree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();//��������� ������ ���� ������
		OntClass characterClass = m.createClass(NS + "Character");//������� ��������� triple
		OntClass itemInstantionClass = m.createClass(NS + "ItemInstantion");
		OntClass creepInstantionClass = m.createClass(NS + "CreepInstantion");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//�����
		aggregationClass.addSuperClass(associationClass);//������������ �����
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//������� - ��������
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass);//�������� � aggregation
		propFrom.addDomain(aggregationClass);
		
		propTo.addRange(contractClass);//�� ��� ����� ���������
		propFrom.addRange(productClass);
		
		//���������� ���� 
		Individual accountIndividual = m.createIndividual(NS + "account's individuals", characterClass);
		Individual regionIndividual = m.createIndividual(NS + "region's individuals", characterClass);
		Individual itemIndividual = m.createIndividual(NS + "item's individuals", itemInstantionClass);
		Individual creepIndividual = m.createIndividual(NS + "creep's individuals", creepInstantionClass);
		
		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		aggregationIndividual.addProperty(propTo, contractIndividual);//�� �������� � ���������
		aggregationIndividual.addProperty(propFrom, productIndividual);
		m.write(System.out);//� � �������
	}
}

Is it works?
