package ru.agentlab.jfxed.diagramms.productviewpoint;

import java.io.FileWriter;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ProductViewpointTest {

	static String SOURCE = "http://test/";
	static String NS = 
			SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		OntClass someoneClass = m.createClass(NS + "Someone");//личности
		OntClass greenClass = m.createClass(NS + "Green");//зелёная фиговина
		OntClass blueClass = m.createClass(NS + "Blue");//синенький
		OntClass redClass = m.createClass(NS + "Red");//красненький
		OntClass orangeClass = m.createClass(NS + "Orange");
		
		OntClass associationClass = m.createClass(NS + "Association");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//связь
		aggregationClass.addSuperClass(associationClass);//родительская связь
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass);//свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		propTo.addRange(greenClass);
		propFrom.addRange(greenClass);
		propTo.addRange(someoneClass);
		propFrom.addRange(someoneClass);
		propTo.addRange(redClass);
		propFrom.addRange(redClass);
		propTo.addRange(blueClass);
		propFrom.addRange(blueClass);
		propTo.addRange(orangeClass);
		propFrom.addRange(orangeClass);
		
				
		//наполнение базы 
		//сначала жёлтые чуваки
		Individual counterStaff = m.createIndividual(NS + "CounterStaff", someoneClass);
		Individual qMatic = m.createIndividual(NS + "Q-Matic", someoneClass);
		Individual customer = m.createIndividual(NS + "Customer", someoneClass);
		Individual poManagement = m.createIndividual(NS + "PostOfficeManagemenet", someoneClass);
		Individual anotherCustomer = m.createIndividual(NS + "AnotherCustomer", someoneClass);
		//теперь зелёные
		Individual reachCounter = m.createIndividual(NS + "Reachcounter", greenClass);
		Individual stateTheRequest = m.createIndividual(NS + "Statetherequest", greenClass);
		Individual pushButton = m.createIndividual(NS + "Push_nextCustomer_button", greenClass);
		Individual checkTicket = m.createIndividual(NS + "Check_ticket_validity", greenClass);
		Individual getTicket = m.createIndividual(NS + "Get_ticket", greenClass);
		Individual reachTheCounter = m.createIndividual(NS + "Reach_the_counter", greenClass);
		//единственный голубой
		Individual ticket = m.createIndividual(NS + "ticket", blueClass);
		
		//красненькие
		Individual askQuestions = m.createIndividual(NS + "To_ask_queue-specific_questions", redClass);
		Individual giveGoodService = m.createIndividual(NS + "Give_customer_a_good_service", redClass);
		Individual respectSystem = m.createIndividual(NS + "respect_queuing_system", redClass);
		
		//рыженькие
		Individual getService = m.createIndividual(NS + "Get_the_right_service", orangeClass);
		Individual workCorrectly = m.createIndividual(NS + "Work_correctly", orangeClass);
		Individual fuckOff = m.createIndividual(NS + "To_f**k_off_when_done", orangeClass);
		Individual neededService = m.createIndividual(NS + "Needed_service_decided", orangeClass);
		
		
		
		//от пост офисс менеджмента
		
		Individual toGiveService = m.createIndividual(NS + "toGiveService", aggregationClass);
		toGiveService.addProperty(propTo, giveGoodService);
		toGiveService.addProperty(propFrom, poManagement);
		
		Individual toServiceDecide = m.createIndividual(NS + "needed_Service", aggregationClass);
		toServiceDecide.addProperty(propTo, neededService);
		toServiceDecide.addProperty(propFrom, poManagement);
		
		//от counter staffa
		Individual toReachCounter = m.createIndividual(NS + "toReachCounter", aggregationClass);
		toReachCounter.addProperty(propTo, reachCounter);
		toReachCounter.addProperty(propFrom, counterStaff);
		
		Individual toAskQuestions = m.createIndividual(NS + "toAskQuestions", aggregationClass);
		toAskQuestions.addProperty(propTo, askQuestions);
		toAskQuestions.addProperty(propFrom, counterStaff);
		
		Individual toStateRequest = m.createIndividual(NS + "toStateRequest", aggregationClass);
		toStateRequest.addProperty(propTo, stateTheRequest);
		toStateRequest.addProperty(propFrom, counterStaff);
		
		Individual toWorkCorrectly = m.createIndividual(NS + "toWorkCorrectly", aggregationClass);
		toWorkCorrectly.addProperty(propTo, workCorrectly);
		toWorkCorrectly.addProperty(propFrom, counterStaff);
		
		//ot Q-Magic
		Individual toCheckValidity = m.createIndividual(NS + "toCheckValidity", aggregationClass);
		toCheckValidity.addProperty(propTo, checkTicket);
		toCheckValidity.addProperty(propFrom, qMatic);
		
		Individual toPushButton = m.createIndividual(NS + "toPushButton", aggregationClass);
		toPushButton.addProperty(propTo, pushButton);
		toPushButton.addProperty(propFrom, qMatic);
		
		//от customera
		Individual toRespect = m.createIndividual(NS + "toRespect", aggregationClass);
		toRespect.addProperty(propTo, respectSystem);
		toRespect.addProperty(propFrom, customer);
		
		Individual toFuckOff = m.createIndividual(NS + "toFuckOff", aggregationClass);
		toFuckOff.addProperty(propTo, fuckOff);
		toFuckOff.addProperty(propFrom, customer);
		
		Individual toReachTheCounter = m.createIndividual(NS + "toReachTheCounter", aggregationClass);
		toReachTheCounter.addProperty(propTo, reachTheCounter);
		toReachTheCounter.addProperty(propFrom, customer);
		
		Individual toGetTicket = m.createIndividual(NS + "toGetTicket", aggregationClass);
		toGetTicket.addProperty(propTo, getTicket);
		toGetTicket.addProperty(propFrom, customer);
		
		Individual toOwnTicket = m.createIndividual(NS + "toOwnTicket", aggregationClass);
		toOwnTicket.addProperty(propTo, ticket);
		toOwnTicket.addProperty(propFrom, customer);
		
		Individual toWorkCorrectly2 = m.createIndividual(NS + "toWorkCorrectly2", aggregationClass);
		toWorkCorrectly2.addProperty(propTo, workCorrectly);
		toWorkCorrectly2.addProperty(propFrom, customer);
		
		Individual toGetService = m.createIndividual(NS + "toGetService", aggregationClass);
		toGetService.addProperty(propTo, getService);
		toGetService.addProperty(propFrom, customer);
		
		//к customerу
		Individual fromService = m.createIndividual(NS + "fromService", aggregationClass);
		fromService.addProperty(propTo, customer);
		fromService.addProperty(propFrom, neededService);
		
		Individual fromAskQuestions = m.createIndividual(NS + "fromAskQuestions", aggregationClass);
		fromAskQuestions.addProperty(propTo, customer);
		fromAskQuestions.addProperty(propFrom, askQuestions);
		
		Individual fromReachCounter = m.createIndividual(NS + "fromReachCounter", aggregationClass);
		fromReachCounter.addProperty(propTo, customer);
		fromReachCounter.addProperty(propFrom, reachCounter);
		
		Individual fromStateRequest = m.createIndividual(NS + "fromStateRequest", aggregationClass);
		fromStateRequest.addProperty(propTo, customer);
		fromStateRequest.addProperty(propFrom, stateTheRequest);
		
		//к another customerу
		Individual fromRespectSystem = m.createIndividual(NS + "fromRespectSystem", aggregationClass);
		fromRespectSystem.addProperty(propTo, anotherCustomer);
		fromRespectSystem.addProperty(propFrom, respectSystem);
		
		Individual fromFuckOff = m.createIndividual(NS + "fromStateRequest", aggregationClass);
		fromFuckOff.addProperty(propTo, anotherCustomer);
		fromFuckOff.addProperty(propFrom, fuckOff);
		
		//к Q-Maticу
		
		Individual fromReachTheCounter = m.createIndividual(NS + "fromReachTheCounter", aggregationClass);
		fromReachTheCounter.addProperty(propTo, qMatic);
		fromReachTheCounter.addProperty(propFrom, reachTheCounter);
		
		Individual fromGetTicket = m.createIndividual(NS + "fromGetTicket", aggregationClass);
		fromGetTicket.addProperty(propTo, qMatic);
		fromGetTicket.addProperty(propFrom, getTicket);
		
		Individual fromTicket = m.createIndividual(NS + "fromTicket", aggregationClass);
		fromTicket.addProperty(propTo, qMatic);
		fromTicket.addProperty(propFrom, ticket);
		
		Individual fromWorkCorrectly = m.createIndividual(NS + "fromWorkCorrectly", aggregationClass);
		fromWorkCorrectly.addProperty(propTo, qMatic);
		fromWorkCorrectly.addProperty(propFrom, workCorrectly);
		
		//к CounterStuffy
		Individual fromGiveService = m.createIndividual(NS + "fromGiveService", aggregationClass);
		fromGiveService.addProperty(propTo, counterStaff);
		fromGiveService.addProperty(propFrom, giveGoodService);
		
		Individual fromGetService = m.createIndividual(NS + "fromGetService", aggregationClass);
		fromGetService.addProperty(propTo, counterStaff);
		fromGetService.addProperty(propFrom, getService);
		
		Individual fromPushButton = m.createIndividual(NS + "fromPushButton", aggregationClass);
		fromPushButton.addProperty(propTo, counterStaff);
		fromPushButton.addProperty(propFrom, pushButton);
		
		Individual fromCheckTicket = m.createIndividual(NS + "fromCheckTicket", aggregationClass);
		fromCheckTicket.addProperty(propTo, counterStaff);
		fromCheckTicket.addProperty(propFrom, checkTicket);
		
		
		
		
		
	
		try {
			m.write(new FileWriter("D:/bom2.owl"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
