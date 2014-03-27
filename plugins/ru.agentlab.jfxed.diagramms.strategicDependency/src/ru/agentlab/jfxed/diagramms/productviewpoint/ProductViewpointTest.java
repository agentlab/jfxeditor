package ru.agentlab.jfxed.diagramms.productviewpoint;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ProductViewpointTest {

	static String SOURCE = "http://test/";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();//��������� ������ ���� ������
		OntClass someoneClass = m.createClass(NS + "Someone");//��������
		OntClass greenClass = m.createClass(NS + "Green");//������ ��������
		OntClass blueClass = m.createClass(NS + "Blue");//���������
		OntClass redClass = m.createClass(NS + "Red");//�����������
		OntClass orangeClass = m.createClass(NS + "Orange");
		
		OntClass associationClass = m.createClass(NS + "Association");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//�����
		aggregationClass.addSuperClass(associationClass);//������������ �����
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//������� - ��������
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass);//�������� � aggregation
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
		
				
		//���������� ���� 
		//������� ����� ������
		Individual counterStaff = m.createIndividual(NS + "Counter Staff", someoneClass);
		Individual qMatic = m.createIndividual(NS + "Q-Matic", someoneClass);
		Individual customer = m.createIndividual(NS + "Customer", someoneClass);
		Individual poManagement = m.createIndividual(NS + "Post Office Managemenet", someoneClass);
		Individual anotherCustomer = m.createIndividual(NS + "Another Customer", someoneClass);
		//������ ������
		Individual reachCounter = m.createIndividual(NS + "Reach counter", greenClass);
		Individual stateTheRequest = m.createIndividual(NS + "State the request", greenClass);
		Individual pushButton = m.createIndividual(NS + "Push \"next Customer\" button", greenClass);
		Individual checkTicket = m.createIndividual(NS + "Check ticket validity", greenClass);
		Individual getTicket = m.createIndividual(NS + "Get ticket", greenClass);
		Individual reachTheCounter = m.createIndividual(NS + "Reach the counter", greenClass);
		//������������ �������
		Individual ticket = m.createIndividual(NS + "ticket", blueClass);
		
		//�����������
		Individual askQuestions = m.createIndividual(NS + "To ask queue-specific questions", redClass);
		Individual giveGoodService = m.createIndividual(NS + "Give customer a good service", redClass);
		Individual respectSystem = m.createIndividual(NS + "respect queuing system", redClass);
		
		//���������
		Individual getService = m.createIndividual(NS + "Get the right service", orangeClass);
		Individual workCorrectly = m.createIndividual(NS + "Work correctly", orangeClass);
		Individual fuckOff = m.createIndividual(NS + "To f**k off when done", orangeClass);
		Individual neededService = m.createIndividual(NS + "Needed service decided", orangeClass);
		
		
		
		//�� ���� ����� �����������
		
		Individual toGiveService = m.createIndividual(NS + "toGiveService", aggregationClass);
		toGiveService.addProperty(propTo, giveGoodService);
		toGiveService.addProperty(propFrom, poManagement);
		
		Individual toServiceDecide = m.createIndividual(NS + "needed Service", aggregationClass);
		toServiceDecide.addProperty(propTo, neededService);
		toServiceDecide.addProperty(propFrom, poManagement);
		
		//�� counter staffa
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
		
		//�� customera
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
		
		//� customer�
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
		
		//� another customer�
//		Individual fromStateRequest = m.createIndividual(NS + "fromStateRequest", aggregationClass);
//		fromStateRequest.addProperty(propTo, anotherCustomer);
//		fromStateRequest.addProperty(propFrom, stateTheRequest);
		
		Individual fromFuckOff = m.createIndividual(NS + "fromStateRequest", aggregationClass);
		fromStateRequest.addProperty(propTo, anotherCustomer);
		fromStateRequest.addProperty(propFrom, fuckOff);
		
		
		
		
	
		
		m.write(System.out);//� � �������
	}
}
