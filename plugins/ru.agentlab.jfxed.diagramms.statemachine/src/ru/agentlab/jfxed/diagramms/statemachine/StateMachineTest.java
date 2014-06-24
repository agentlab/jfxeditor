package ru.agentlab.jfxed.diagramms.statemachine;

import java.io.FileWriter;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class StateMachineTest {

	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/statemachime";
	static String NS = 
			SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		OntModel m = ModelFactory.createOntologyModel();
	
		OntClass conceptClass = m.createClass (NS + "Concept");
		
		OntClass connectionClass = m.createClass(NS + "Connection");
		
		OntClass associationClass = m.createClass(NS + "Association");
		OntClass aggregationClass = m.createClass(NS + "Aggregation");
		associationClass.addSuperClass(connectionClass);
		aggregationClass.addSuperClass(connectionClass);
		
		OntClass startPointClass = m.createClass(NS + "StartPoint");
		OntClass endPointClass = m.createClass(NS + "EndPoint");
		OntClass stateClass = m.createClass(NS + "State");
		OntClass containerClass = m.createClass(NS + "Container");
		
		
		startPointClass.addSuperClass(conceptClass);
		endPointClass.addSuperClass(conceptClass);
		stateClass.addSuperClass(conceptClass);
		containerClass.addSuperClass(conceptClass);
				
		ObjectProperty propTo = m.createObjectProperty(NS + "To");
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		ObjectProperty conName = m.createObjectProperty(NS + "Con_Name");
		
		propTo.addDomain(associationClass);//свойства у connection
		propFrom.addDomain(associationClass);
		conName.addDomain(associationClass);
		propFrom.addRange(conceptClass);
		propTo.addRange(conceptClass);
		
		ObjectProperty holdIn = m.createObjectProperty(NS + "holdIn"); // содержится в - то есть контейнер
		ObjectProperty holds = m.createObjectProperty(NS + "holds"); // содержит - кого
		
		holdIn.addRange(conceptClass);
		holds.addRange(conceptClass);

		
				
		//наполнение базы 
		
		Individual proposed = m.createIndividual(NS + "Proposed", stateClass);
		Individual scheduled = m.createIndividual(NS + "Scheduled", stateClass);
		Individual full = m.createIndividual(NS + "full", stateClass);
		Individual openForEnrollment = m.createIndividual(NS + "Open_For_Enrollment", stateClass);
		Individual closedToEnrollment = m.createIndividual(NS + "closed_to_enrollment", stateClass);
		Individual beingTaught = m.createIndividual(NS + "being_taught", stateClass);
		Individual finalExams = m.createIndividual(NS + "final_exams", stateClass);
		
		Individual endPoint = m.createIndividual(NS + "end_point", endPointClass);
		Individual startPoint = m.createIndividual(NS + "start_point", startPointClass);
		
		
		
		Individual toBeProposed = m.createIndividual(NS + "toBeProposed", associationClass);
		toBeProposed.addProperty(propTo, proposed);
		toBeProposed.addProperty(propFrom, startPoint);

		Individual toBeScheduled = m.createIndividual(NS + "toBeScheduled", associationClass);
		toBeScheduled.addProperty(propTo, scheduled);
		toBeScheduled.addProperty(propFrom, proposed);

		Individual toEnrollment1 = m.createIndividual(NS + "toEnrollment1", associationClass);
		toEnrollment1.addProperty(propTo, openForEnrollment);
		toEnrollment1.addProperty(propFrom, scheduled);
		
		Individual toEnrollment2 = m.createIndividual(NS + "toEnrollment2", associationClass);
		toEnrollment2.addProperty(propTo, openForEnrollment);
		toEnrollment2.addProperty(propFrom, full);
		
		Individual toEnrollment3 = m.createIndividual(NS + "toEnrollment3", associationClass);
		toEnrollment3.addProperty(propTo, openForEnrollment);
		toEnrollment3.addProperty(propFrom,openForEnrollment);
		
		Individual toEnrollment4 = m.createIndividual(NS + "toEnrollment4", associationClass);
		toEnrollment4.addProperty(propTo, openForEnrollment);
		toEnrollment4.addProperty(propFrom, full);
		
		Individual toFull1 = m.createIndividual(NS + "toFull1", associationClass);
		toFull1.addProperty(propTo, full);
		toFull1.addProperty(propFrom, openForEnrollment);
		
		Individual toFull2 = m.createIndividual(NS + "toFull2", associationClass);
		toFull2.addProperty(propTo, full);
		toFull2.addProperty(propFrom, full);
		
		Individual toCloseEnrollment1 = m.createIndividual(NS + "toCloseEnrollment1", associationClass);
		toCloseEnrollment1.addProperty(propTo, closedToEnrollment);
		toCloseEnrollment1.addProperty(propFrom, full);
		
		Individual toCloseEnrollment2 = m.createIndividual(NS + "toCloseEnrollment2", associationClass);
		toCloseEnrollment2.addProperty(propTo, closedToEnrollment);
		toCloseEnrollment2.addProperty(propFrom, openForEnrollment);

		Individual termStarted = m.createIndividual(NS + "termStarted", associationClass);
		termStarted.addProperty(propTo, beingTaught);
		termStarted.addProperty(propFrom, closedToEnrollment);
		termStarted.addProperty(conName, "termStarted");
		
		Individual studentDropped = m.createIndividual(NS + "studentDropped", associationClass);
		studentDropped.addProperty(propTo, beingTaught);
		studentDropped.addProperty(propFrom, beingTaught);
		studentDropped.addProperty(conName, "studentDropped(seminar_size>0)");
		
		Individual studentDroppedFin = m.createIndividual(NS + "studentDroppedFin", associationClass);
		studentDroppedFin.addProperty(propTo, beingTaught);
		studentDroppedFin.addProperty(propFrom, beingTaught);
		studentDroppedFin.addProperty(conName, "studentDropped(seminar_size=0)");
		
		Individual closed = m.createIndividual(NS + "closed", associationClass);
		closed.addProperty(propTo, endPoint);
		closed.addProperty(propFrom, finalExams);
		closed.addProperty(conName, "closed");
		
		Individual enrollment = m.createIndividual(NS + "Enrollment", containerClass);
		
		Individual cancelled = m.createIndividual(NS + "cancelled", associationClass);
		cancelled.addProperty(propTo, endPoint);
		cancelled.addProperty(propFrom, enrollment);
		cancelled.addProperty(conName, "cancelled");
		
		Individual holdProposed = m.createIndividual(NS + "holdProposed", aggregationClass);
		Individual holdScheduled = m.createIndividual(NS + "holdScheduled", aggregationClass);
		Individual holdFull = m.createIndividual(NS + "holdFull", aggregationClass);
		Individual holdOpenEnrollment = m.createIndividual(NS + "holdOpenEnrollment", aggregationClass);
		Individual holdCloseEnrollment = m.createIndividual(NS + "holdCloseEnrollment", aggregationClass);
		holdProposed.addProperty(holdIn, enrollment);
		holdScheduled.addProperty(holdIn, enrollment);
		holdFull.addProperty(holdIn, enrollment);
		holdOpenEnrollment.addProperty(holdIn, enrollment);
		holdCloseEnrollment.addProperty(holdIn, enrollment);
		
		 holdProposed.addProperty(holds, proposed);
		 holdScheduled.addProperty(holds, scheduled);
		 holdFull.addProperty(holds, full);
		 holdOpenEnrollment.addProperty(holds, openForEnrollment);
		 holdCloseEnrollment.addProperty(holds, closedToEnrollment);
	
		
		try {
			m.write(new FileWriter("D:/ololo.owl"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
