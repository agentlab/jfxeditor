package ru.agentlab.jfxed.diagram.productviewpoint.tests;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

import org.junit.Test;
import org.loadui.testfx.GuiTest;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import ru.agentlab.jfxed.diagramms.productviewpoint.Transform;

public class TestClass extends GuiTest {
	
	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	

	@Test
	public void myTest(){
	
		/*
		 * «десь объ€вл€ем объекты квадратики схемы
		 * */
		OntModel m = ModelFactory.createOntologyModel();//создаетс€ пуста€ база знаний
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		OntClass productClass = m.createClass(NS + "Product");//создаем отдельные triple
		OntClass contractClass = m.createClass(NS + "Contract");
		
		OntClass businessServiceClass = m.createClass(NS + "Business Service");
		OntClass valueClass = m.createClass(NS + "Value");
		
		OntClass businessInterfaceClass = m.createClass(NS + "Business interface");
		OntClass businessEventClass = m.createClass(NS + "Business event");
		OntClass businessProcessClass = m.createClass(NS + "Business process");
		OntClass businessRoleClass = m.createClass(NS + "Business role");
		OntClass businessActorClass = m.createClass(NS + "Business actor");
		
		OntClass applicationServiceClass = m.createClass(NS + "Application service");
		OntClass applicationInterfaceClass = m.createClass(NS + "Application interface");
		OntClass applicationComponentClass = m.createClass(NS + "Application component");
		
		/*
		 * end
		 * */
		
		
		/*
		 * ќбъ€вление св€зей
		 * */
		//
		OntClass associationClass = m.createClass(NS + "Association");//родительский суперкласс
		//дл€ того чтобы отличать фигурки от св€зей
		//
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//св€зь Aggregation
		OntClass assigmentClass = m.createClass(NS + "Assigment");//св€зь assigment
		OntClass usedByClass = m.createClass(NS + "Used by");//usedBy
		OntClass compositionClass = m.createClass(NS + "Composition");//composition
		OntClass triggeringClass = m.createClass(NS + "Triggering");//triggering
		OntClass accessClass = m.createClass(NS + "Composition");//composition
		
		//сюда повсему мы говорим что наши стрелочки это association
		aggregationClass.addSuperClass(associationClass);//родительска€ св€зь
		usedByClass.addSuperClass(associationClass);//родительска€ св€зь
		compositionClass.addSuperClass(associationClass);//родительска€ св€зь
		triggeringClass.addSuperClass(associationClass);//родительска€ св€зь
		accessClass.addSuperClass(associationClass);//родительска€ св€зь
		
		/*
		 * end
		 * */
		
		propTo.addDomain(aggregationClass);//свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		propFrom.addRange(productClass);//продуки содержит конракт т.е. св€зь между ними инвертировать св€зи
		
		propFrom.addRange(businessServiceClass);
		propFrom.addRange(businessInterfaceClass);
		propFrom.addRange(businessEventClass);
		propFrom.addRange(businessProcessClass);
		
		
		
		propTo.addRange(contractClass);//т.е. продукт содержит конракт
		propTo.addRange(businessServiceClass);//и бизнес—ервис
		propTo.addRange(valueClass);
		//propTo.addRange(valueClass);
		
		
		//наполнение базы создание экзампл€ров
		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);//тоже спросить
		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);
		
		Individual businessServiceIndividual = m.createIndividual(NS+ "4", businessServiceClass);
		
		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		
		aggregationIndividual.addProperty(propFrom, productIndividual);
		
		aggregationIndividual.addProperty(propTo, contractIndividual);//от продукта к контракту
		aggregationIndividual.addProperty(propTo, businessServiceIndividual);//делаем св€зку
		
		
		Transform transf1 = new Transform();
		transf1.transform(m, getRootNode());
		
	}

	@Override
	protected Parent getRootNode() {
		// TODO Auto-generated method stub
		return new Group();
	}
}
