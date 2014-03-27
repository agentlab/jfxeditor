package ru.agentlab.jfxed.diagrams.airlinesecurityexample;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class airlinesecurityexample {
	
	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";

	//test from sourcetree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();//��������� ������ ���� ������
		OntClass productClass = m.createClass(NS + "Product");//������� ��������� triple
		OntClass contractClass = m.createClass(NS + "Contract");
		OntClass associationClass = m.createClass(NS + "Association");

		OntClass aggregationClass = m.createClass(NS + "Agregation");//�����
		aggregationClass.addSuperClass(associationClass);//������������ �����

		ObjectProperty propTo = m.createObjectProperty(NS + "To");//������� - ��������
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");

		propTo.addDomain(aggregationClass);//�������� � aggregation
		propFrom.addDomain(aggregationClass);

		propTo.addRange(contractClass);//�� ��� ����� ���������
		propFrom.addRange(productClass);

		//���������� ���� 
		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);
		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);

		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		aggregationIndividual.addProperty(propTo, contractIndividual);//�� �������� � ���������
		aggregationIndividual.addProperty(propFrom, productIndividual);
		m.write(System.out);//� � �������
	}
}
