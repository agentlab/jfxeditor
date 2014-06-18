package ru.agentlab.jfxed.diagramms.requirements;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Requirements {
	
	static final String resourceURL = "http://www.eswc2006.org/technologies/ontology";
	static final String NS = resourceURL + ": ";
	
	// test from source tree
	public static void main (String[] args) {
		
		// Объявление модели.
		OntModel m = ModelFactory.createOntologyModel();
		ObjectProperty propTo = m.createObjectProperty(NS + "to");
		ObjectProperty propFrom = m.createObjectProperty(NS + "from");
		
		// Объявление классов для узлов графа.
		OntClass rectangleClass = m.createClass(NS + "RectangleClass"); // Суперкласс для двух классов прямоугольников.
		OntClass greenRectangle = m.createClass(NS + "Green Rectangle");
		greenRectangle.addSuperClass(rectangleClass);
		OntClass yellowRectangle = m.createClass(NS + "Yellow Rectangle");
		yellowRectangle.addSuperClass(rectangleClass);
		
		// Объявление связей.
		OntClass conceptClass = m.createClass(NS + "Concept"); // Родительский класс для всех связей.	
		OntClass containmentClass = m.createClass(NS + "Containment"); // Связь Containment.
		containmentClass.addSuperClass(conceptClass); // Привязываем нашу связь к классу связей.
		
		propFrom.addDomain(rectangleClass);
		propTo.addDomain(rectangleClass);
		
		propFrom.addRange(rectangleClass);
		propTo.addRange(rectangleClass);
			
		// Наполнение базы экземплярами.
		Individual storeUserDetailsIndividual = m.createIndividual(NS + "REQ025 - Store User Details", greenRectangle);
		Individual validateUserIndividual = m.createIndividual(NS + "REQ026 - Validate User", yellowRectangle);
		Individual addUsersIndividual = m.createIndividual(NS + "REQ016 - Add Users", greenRectangle);
		Individual remoteUserIndividual = m.createIndividual(NS + "REQ017 - Remote User", greenRectangle);
		Individual reportOnUserAccountIndividual = m.createIndividual(NS + "REQ018 - Report On User Account", greenRectangle);
		Individual secureAccessIndividual = m.createIndividual(NS + "REQ024 - Secure Access", yellowRectangle);
		Individual manageUserAccountIndividual = m.createIndividual(NS + "REQ011 - Manage User Accounts", greenRectangle);
		
		// Связи от storeUserDetailsIndividual.
		Individual fromStoreUserDetailsToAddUsers = m.createIndividual(NS + "fromStoreUserDetailsToAddUsers", containmentClass);
		fromStoreUserDetailsToAddUsers.addProperty(propFrom, storeUserDetailsIndividual);
		fromStoreUserDetailsToAddUsers.addProperty(propTo, addUsersIndividual);
		
		Individual fromStoreUserDetailsToRemoteUser = m.createIndividual(NS + "fromStoreUserDetailsToRemoteUser", containmentClass);
		fromStoreUserDetailsToRemoteUser.addProperty(propFrom, storeUserDetailsIndividual);
		fromStoreUserDetailsToRemoteUser.addProperty(propTo, remoteUserIndividual);
		
		Individual fromStoreUserDetailsToReportOnUserAccount = m.createIndividual(NS + "fromStoreUserDetailsToReportOnUserAccount", containmentClass);
		fromStoreUserDetailsToReportOnUserAccount.addProperty(propFrom, storeUserDetailsIndividual);
		fromStoreUserDetailsToReportOnUserAccount.addProperty(propTo, reportOnUserAccountIndividual);
					
		// Связи от validateUserIndividual.
		Individual fromValidateUserToSecureAccess = m.createIndividual(NS + "fromValidateUserToSecureAccess", containmentClass);
		fromValidateUserToSecureAccess.addProperty(propFrom, validateUserIndividual);
		fromValidateUserToSecureAccess.addProperty(propTo, secureAccessIndividual);
				
		// Связи к manageUserAccountIndividual.
		Individual fromAddUsersToManageUserAccount = m.createIndividual(NS + "fromAddUsersToManageUserAccount", containmentClass);
		fromAddUsersToManageUserAccount.addProperty(propFrom, addUsersIndividual);
		fromAddUsersToManageUserAccount.addProperty(propTo, manageUserAccountIndividual);
		
		Individual fromRemoteUserToManageUserAccount = m.createIndividual(NS + "fromRemoteUserToManageUserAccount", containmentClass);
		fromRemoteUserToManageUserAccount.addProperty(propFrom, remoteUserIndividual);
		fromRemoteUserToManageUserAccount.addProperty(propTo, manageUserAccountIndividual);
		
		Individual fromReportOnUserAccountToManageUserAccount = m.createIndividual(NS + "fromReportOnUserAccountToManageUserAccount", containmentClass);
		fromReportOnUserAccountToManageUserAccount.addProperty(propFrom, reportOnUserAccountIndividual);
		fromReportOnUserAccountToManageUserAccount.addProperty(propTo, manageUserAccountIndividual);
		
		Individual fromSecureAccessToManageUserAccount = m.createIndividual(NS + "fromSecureAccessToManageUserAccount", containmentClass);
		fromSecureAccessToManageUserAccount.addProperty(propFrom, secureAccessIndividual);
		fromSecureAccessToManageUserAccount.addProperty(propTo, manageUserAccountIndividual);
		
		m.write(System.out, "N3");
		
	}
}

