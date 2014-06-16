package ru.agentlab.jfxed.diagramms.epc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class EpcDiagramm {

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
		
		OutputStream out;
        try {
            out = new FileOutputStream("model.xml");
            m.write(out, "RDF/XML");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		/*
		
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
		
		
		 * end
		 * 
		
		
		
		 * Объявление связей
		 * 
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
		OntClass realizationClass = m.createClass(NS + "CRealization");
		
		//сюда повсему мы говорим что наши стрелочки это association
		aggregationClass.addSuperClass(associationClass);//родительская связь
		assigmentClass.addSuperClass(assigmentClass);//родительская связь
		usedByClass.addSuperClass(associationClass);//родительская связь
		compositionClass.addSuperClass(associationClass);//родительская связь
		triggeringClass.addSuperClass(associationClass);//родительская связь
		accessClass.addSuperClass(associationClass);//родительская связь
		
		
		 * end
		 * 
		
		propTo.addDomain(aggregationClass);//свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		//связи в
		propFrom.addRange(productClass);//продукт содержит конракт т.е. связь между ними инвертировать связи
		propFrom.addRange(valueClass);
		propFrom.addRange(businessServiceClass);
		propFrom.addRange(businessInterfaceClass);
		propFrom.addRange(businessEventClass);
		propFrom.addRange(businessProcessClass);
		propFrom.addRange(businessRoleClass);
		propFrom.addRange(businessActorClass);
		propFrom.addRange(applicationServiceClass);
		propFrom.addRange(applicationInterfaceClass);
		propFrom.addRange(applicationComponentClass);
		
		//связи от
		propTo.addRange(contractClass);//т.е. продукт содержит контракт
		propTo.addRange(businessServiceClass);//и бизнесСервис
		propTo.addRange(valueClass);
		propTo.addRange(businessEventClass);
		propTo.addRange(businessProcessClass);
		propTo.addRange(businessInterfaceClass);
		propTo.addRange(businessRoleClass);
		propTo.addRange(businessActorClass);
		propTo.addRange(applicationServiceClass);
		propTo.addRange(applicationInterfaceClass);
		propTo.addRange(applicationComponentClass);
		
		
		//наполнение базы создание экзампляров
		Individual productIndividual = m.createIndividual(NS + "product", productClass);
		Individual contractIndividual = m.createIndividual(NS + "contract", contractClass);
		Individual businessServiceIndividual = m.createIndividual(NS+ "businessService", businessServiceClass);
		Individual valueIndividual = m.createIndividual(NS+ "value", valueClass);
		Individual businessInterfaceIndividual = m.createIndividual(NS+ "businessInterface", businessInterfaceClass);
		Individual businessEventIndividual = m.createIndividual(NS+ "businessEvent", businessEventClass);
		Individual businessProcessIndividual = m.createIndividual(NS+ "businessProcess", businessProcessClass);
		Individual businessRoleIndividual = m.createIndividual(NS+ "businessRole", businessRoleClass);
		Individual businessActorIndividual = m.createIndividual(NS+ "businessActor", businessActorClass);
		Individual applicationServiceIndividual = m.createIndividual(NS+ "applicationService", applicationServiceClass);
		Individual applicationInterfaceIndividual = m.createIndividual(NS+ "applicationInterface", applicationInterfaceClass);
		Individual applicationComponentIndividual = m.createIndividual(NS+ "applicationComponent", applicationComponentClass);
		
		//связи
		Individual aggToPFromCo_BS_ASIndividual = m.createIndividual(NS + "aggToProd_FromCo_BS_AS", aggregationClass);
		aggToPFromCo_BS_ASIndividual.addProperty(propFrom, productIndividual);
		aggToPFromCo_BS_ASIndividual.addProperty(propTo, contractIndividual);//от продукта к контракту
		aggToPFromCo_BS_ASIndividual.addProperty(propTo, businessServiceIndividual);//делаем связку
		aggToPFromCo_BS_ASIndividual.addProperty(propTo, applicationServiceIndividual);
		
		Individual assocValueProduct = m.createIndividual(NS + "assocValueProduct", associationClass);
		assocValueProduct.addProperty(propFrom, valueIndividual);
		assocValueProduct.addProperty(propTo, valueIndividual);
		assocValueProduct.addProperty(propFrom, productIndividual);
		assocValueProduct.addProperty(propTo, productIndividual);
		
		Individual assigmBusActorBusRole = m.createIndividual(NS + "assigmentBusinessRole_BusinessActor", assigmentClass);
		assigmBusActorBusRole.addProperty(propTo, businessRoleIndividual);
		assigmBusActorBusRole.addProperty(propTo, businessActorIndividual);
		assigmBusActorBusRole.addProperty(propFrom, businessRoleIndividual);
		assigmBusActorBusRole.addProperty(propFrom, businessActorIndividual);
		
		Individual assigmBusRoleBusProc = m.createIndividual(NS + "assigmBusRoleBusProc", assigmentClass);
		assigmBusRoleBusProc.addProperty(propTo, businessRoleIndividual);
		assigmBusRoleBusProc.addProperty(propTo, businessProcessIndividual);
		assigmBusRoleBusProc.addProperty(propFrom, businessRoleIndividual);
		assigmBusRoleBusProc.addProperty(propFrom, businessProcessIndividual);
		
		Individual assigBusServBusInt = m.createIndividual(NS + "assigBusServBusInt", assigmentClass);
		assigBusServBusInt.addProperty(propTo, businessServiceIndividual);
		assigBusServBusInt.addProperty(propTo, businessInterfaceIndividual);
		assigBusServBusInt.addProperty(propFrom, businessServiceIndividual);
		assigBusServBusInt.addProperty(propFrom, businessInterfaceIndividual);
		
		Individual assigBusServAppInt = m.createIndividual(NS + "assigBusServAppInt", assigmentClass);
		assigBusServAppInt.addProperty(propTo, businessServiceIndividual);
		assigBusServAppInt.addProperty(propTo, applicationInterfaceIndividual);
		assigBusServAppInt.addProperty(propFrom, businessServiceIndividual);
		assigBusServAppInt.addProperty(propFrom, applicationInterfaceIndividual);
		
		Individual realizBusServBusProc = m.createIndividual(NS + "realizBusServAppInt", realizationClass);
		realizBusServBusProc.addProperty(propFrom, businessServiceIndividual);
		realizBusServBusProc.addProperty(propTo, businessProcessIndividual);
		
		Individual usedbyBusProcBusServ = m.createIndividual(NS + "usedbyBusProcBusServt", usedByClass);
		usedbyBusProcBusServ.addProperty(propTo, businessServiceIndividual);
		usedbyBusProcBusServ.addProperty(propFrom, businessProcessIndividual);
		
		Individual realizBusRoleBusInt = m.createIndividual(NS + "realizBusRoleBusInt", realizationClass);
		realizBusRoleBusInt.addProperty(propFrom, businessRoleIndividual);
		realizBusRoleBusInt.addProperty(propTo, businessInterfaceIndividual);
		
		Individual composBusRoleBusInt = m.createIndividual(NS + "composBusRoleBusInt", compositionClass);
		composBusRoleBusInt.addProperty(propFrom, businessRoleIndividual);
		composBusRoleBusInt.addProperty(propTo, businessInterfaceIndividual);
		
		Individual realizAppCompAppInt = m.createIndividual(NS + "realizAppCompAppInt", realizationClass);
		realizAppCompAppInt.addProperty(propFrom, applicationComponentIndividual);
		realizAppCompAppInt.addProperty(propTo, applicationInterfaceIndividual);
		
		Individual composAppCompAppInt = m.createIndividual(NS + "composAppCompAppInt", compositionClass);
		composAppCompAppInt.addProperty(propFrom, applicationComponentIndividual);
		composAppCompAppInt.addProperty(propTo, applicationInterfaceIndividual);
		
		Individual assigAppServAppInt = m.createIndividual(NS + "assigAppServAppInt", assigmentClass);
		assigAppServAppInt.addProperty(propFrom, applicationServiceIndividual);
		assigAppServAppInt.addProperty(propTo, applicationInterfaceIndividual);
		assigAppServAppInt.addProperty(propFrom, applicationInterfaceIndividual);
		assigAppServAppInt.addProperty(propTo, applicationServiceIndividual);
		
		Individual assigAppCompBusProc = m.createIndividual(NS + "assigAppCompBusProc", assigmentClass);
		assigAppCompBusProc.addProperty(propFrom, businessProcessIndividual);
		assigAppCompBusProc.addProperty(propTo, applicationComponentIndividual);
		assigAppCompBusProc.addProperty(propTo, businessProcessIndividual);
		assigAppCompBusProc.addProperty(propFrom, applicationComponentIndividual);
		
		Individual usedbyAppIntBusRole = m.createIndividual(NS + "usedbyAppIntBusRole", usedByClass);
		usedbyAppIntBusRole.addProperty(propFrom, businessRoleIndividual);
		usedbyAppIntBusRole.addProperty(propTo, applicationInterfaceIndividual);
		
		Individual usedbyAppServBusProc = m.createIndividual(NS + "usedbyAppIntBusRole", usedByClass);
		usedbyAppServBusProc.addProperty(propFrom, businessProcessIndividual);
		usedbyAppServBusProc.addProperty(propTo, applicationServiceIndividual);
		
		Individual trigBusProc = m.createIndividual(NS + "trigBusProc", triggeringClass);
		trigBusProc.addProperty(propFrom, businessProcessIndividual);
		trigBusProc.addProperty(propTo, businessProcessIndividual);
		
		Individual accessBusProc = m.createIndividual(NS + "accessBusProc", accessClass);
		accessBusProc.addProperty(propFrom, businessProcessIndividual);
		accessBusProc.addProperty(propTo, businessProcessIndividual);
		
		Individual trigBusProcBusEvent = m.createIndividual(NS + "trigBusProcBusEvent", triggeringClass);
		trigBusProcBusEvent.addProperty(propFrom, businessEventIndividual);
		trigBusProcBusEvent.addProperty(propTo, businessProcessIndividual);
		
		Individual trigBusEventBusProc = m.createIndividual(NS + "trigBusEventBusProc", triggeringClass);
		trigBusProcBusEvent.addProperty(propTo, businessEventIndividual);
		trigBusProcBusEvent.addProperty(propFrom, businessProcessIndividual);
		
		m.write(System.out);//и в консоль
*/		}
	}
