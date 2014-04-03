package ru.agentlab.jfxed.diagramms.productviewpoint;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ProductViewpointTest {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		
		{
		/*
		 * Здесь объявляем объекты квадратики схемы
		 * */
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		OntClass productClass = m.createClass(NS + "Product");//создаем отдельные triple
		OntClass contractClass = m.createClass(NS + "Contract");
		/****
		 * Мои добавления
		 * ****/
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
		 * Объявление связей
		 * */
		//
		OntClass associationClass = m.createClass(NS + "Association");//родительский суперкласс
		//для того чтобы отличать фигурки от связей
		//
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//связь Aggregation
		OntClass assigmentClass = m.createClass(NS + "Assigment");//связь assigment
		OntClass usedByClass = m.createClass(NS + "Used by");//usedBy
		OntClass compositionClass = m.createClass(NS + "Composition");//composition
		OntClass triggeringClass = m.createClass(NS + "Triggering");//triggering
		OntClass accessClass = m.createClass(NS + "Composition");//composition
		
		//сюдя повсему мы говорим что наши стрелочки это association
		aggregationClass.addSuperClass(associationClass);//родительская связь
		
		/*
		 * end
		 * */
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass);//свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		propTo.addRange(contractClass);//то что могут принимать
		propFrom.addRange(productClass);//продуки содержит конракт т.е. связь между ними инвертировать связи
		
		
		//propFrom.addRange(businessServiceClass);//свойство говорящее что businessServiceClass отдает данные
		
		//наполнение базы создание экзампляров
		Individual productIndividual = m.createIndividual(NS + "jkljklj2", productClass);//тоже спросить
		Individual contractIndividual = m.createIndividual(NS + "jkljklj3", contractClass);
		
		Individual businessServiceIndividual = m.createIndividual(NS+ "4", businessServiceClass);
		
		Individual aggregationIndividual = m.createIndividual(NS + "jkljklj1", aggregationClass);
		
		aggregationIndividual.addProperty(propTo, contractIndividual);//от продукта к контракту
		aggregationIndividual.addProperty(propFrom, productIndividual);
		aggregationIndividual.addProperty(propFrom, businessServiceIndividual);//делаем связку
		
		
		m.write(System.out);//и в консоль
			}
		}
	}
