package JenaPruebas;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class AirlineSecurity
 {
	static final String SCHEMA = "http://www.agentlab.ru/jfxed/onto/strategicrationale";
	static final String NS = SCHEMA + "#";
	
	public static void main (String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		
		OntClass concept = m.createClass(NS + "Concept");
		OntClass relation = m.createClass(NS + "Relation");
		
		OntClass taskClass = m.createClass(NS + "Task");
		taskClass.addSuperClass(concept);
		OntClass goalClass = m.createClass(NS + "Goal");
		goalClass.addSuperClass(concept);
		OntClass softGoalClass = m.createClass(NS + "softGoal");
		softGoalClass.addSuperClass(concept);
		OntClass resourceClass = m.createClass(NS + "resource");
		resourceClass.addSuperClass(concept);
		
		
		OntClass elementClass = m.createClass(NS + "element");
		elementClass.addSuperClass(relation);
		OntClass contributesPClass = m.createClass(NS + "contributesP");
		contributesPClass.addSuperClass(relation);
		OntClass contributesMClass = m.createClass(NS + "contributesM");
		contributesMClass.addSuperClass(relation);
		OntClass meansEndClass = m.createClass(NS + "meansEnd");
		meansEndClass.addSuperClass(relation);
		OntClass globalClass = m.createClass(NS + "global");
		globalClass.addSuperClass(relation);
		
		
		
		ObjectProperty propMeansEnd = m.createObjectProperty(NS + "MeansEnd");
		propMeansEnd.addDomain(goalClass);
		propMeansEnd.addRange(taskClass);
		ObjectProperty propMeansEndTo = m.createObjectProperty(NS + "MeansEndTo");
		propMeansEndTo.addDomain(goalClass);
		propMeansEndTo.addRange(taskClass);
		
		ObjectProperty propMeansEnd1 = m.createObjectProperty(NS + "MeansEnd1");
		propMeansEnd1.addDomain(resourceClass);
		propMeansEnd1.addRange(taskClass);
		ObjectProperty propMeansEnd1To = m.createObjectProperty(NS + "MeansEnd1To");
		propMeansEnd1To.addDomain(resourceClass);
		propMeansEnd1To.addRange(taskClass);
		ObjectProperty propMeansEnd21To = m.createObjectProperty(NS + "MeansEnd21To");
		propMeansEnd21To.addDomain(softGoalClass);
		propMeansEnd21To.addRange(taskClass);
		
		ObjectProperty propMeansEnd2 = m.createObjectProperty(NS + "MeansEnd2");
		propMeansEnd2.addDomain(softGoalClass);
		propMeansEnd2.addRange(taskClass);
		//ObjectProperty name = m.createObjectProperty(NS + "name");
		//propContributesP.addDomain(Classfrom);
		//propContributesP.addRange(Classto);
		
		
		ObjectProperty propContributesP = m.createObjectProperty(NS + "propContributesP");
		propContributesP.addDomain(softGoalClass);
		propContributesP.addRange(taskClass);
		ObjectProperty propContributesPTo = m.createObjectProperty(NS + "propContributesPTo");
		propContributesPTo.addDomain(softGoalClass);
		propContributesPTo.addRange(taskClass);
		
		ObjectProperty propContributesP1 = m.createObjectProperty(NS + "propContributesP1");
		propContributesP1.addDomain(softGoalClass);
		propContributesP1.addRange(softGoalClass);
		ObjectProperty propContributesP1To = m.createObjectProperty(NS + "propContributesP1To");
		propContributesP1To.addDomain(softGoalClass);
		propContributesP1To.addRange(softGoalClass);
		
		ObjectProperty propContributesP2 = m.createObjectProperty(NS + "propContributesP2");
		propContributesP2.addDomain(resourceClass);
		propContributesP2.addRange(softGoalClass);
		ObjectProperty propContributesP2To = m.createObjectProperty(NS + "propContributesP2To");
		propContributesP2To.addDomain(taskClass);
		propContributesP2To.addRange(softGoalClass);
		ObjectProperty propContributesP21To = m.createObjectProperty(NS + "propContributesP21To");
		propContributesP21To.addDomain(softGoalClass);
		propContributesP21To.addRange(softGoalClass);
		ObjectProperty propContributesP22To = m.createObjectProperty(NS + "propContributesP22To");
		propContributesP22To.addDomain(resourceClass);
		propContributesP22To.addRange(softGoalClass);
		
		ObjectProperty propContributesP3 = m.createObjectProperty(NS + "propContributesP3");
		propContributesP3.addDomain(taskClass);
		propContributesP3.addRange(softGoalClass);
		ObjectProperty propContributesP3To = m.createObjectProperty(NS + "propContributesP3To");
		propContributesP3To.addDomain(taskClass);
		propContributesP3To.addRange(softGoalClass);
		
		ObjectProperty propContributesP4 = m.createObjectProperty(NS + "propContributesP4");
		propContributesP4.addDomain(goalClass);
		propContributesP4.addRange(softGoalClass);
		ObjectProperty propContributesP4To = m.createObjectProperty(NS + "propContributesP4To");
		propContributesP4To.addDomain(goalClass);
		propContributesP4To.addRange(softGoalClass);
		ObjectProperty propContributesP43To = m.createObjectProperty(NS + "propContributesP43To");
		propContributesP43To.addDomain(goalClass);
		propContributesP43To.addRange(softGoalClass);
		
		
		ObjectProperty propContributesM = m.createObjectProperty(NS + "propContributesM");
		propContributesM.addDomain(softGoalClass);
		propContributesM.addRange(softGoalClass);
		ObjectProperty propContributesMTo = m.createObjectProperty(NS + "propContributesMTo");
		propContributesMTo.addDomain(softGoalClass);
		propContributesMTo.addRange(softGoalClass);
		ObjectProperty propContributesM11To = m.createObjectProperty(NS + "propContributesM11To");
		propContributesM11To.addDomain(softGoalClass);
		propContributesM11To.addRange(softGoalClass);
		ObjectProperty propContributesM2To = m.createObjectProperty(NS + "propContributesM2To");
		propContributesM2To.addDomain(softGoalClass);
		propContributesM2To.addRange(softGoalClass);
		
		ObjectProperty propElement = m.createObjectProperty(NS + "propElement");
		propElement.addDomain(taskClass);
		propElement.addRange(goalClass);
		ObjectProperty propElementTo = m.createObjectProperty(NS + "propElementTo");
		propElementTo.addDomain(taskClass);
		propElementTo.addRange(goalClass);
		
		ObjectProperty propGlobal = m.createObjectProperty(NS + "propGlobal");
		propGlobal.addDomain(taskClass);
		propGlobal.addRange(taskClass);
		
		ObjectProperty propGlobalTo = m.createObjectProperty(NS + "propGlobalTo");
		propGlobalTo.addDomain(taskClass);
		propGlobalTo.addRange(taskClass);
		
		ObjectProperty propGlobal1 = m.createObjectProperty(NS + "propGlobal1");
		propGlobal1.addDomain(softGoalClass);
		propGlobal1.addRange(goalClass);
		
		ObjectProperty propGlobal1To = m.createObjectProperty(NS + "propGlobal1To");
		propGlobal1To.addDomain(softGoalClass);
		propGlobal1To.addRange(goalClass);
		
		
		Individual passThroughSecurely = m.createIndividual(NS + "passThroughSecurely", softGoalClass);
		Individual passThroughEasily = m.createIndividual(NS + "passThroughEasily", softGoalClass);
		Individual checkSec = m.createIndividual(NS + "checkSecurely", softGoalClass);
		Individual checkReliab = m.createIndividual(NS + "checkReliab", softGoalClass);
		Individual checkRobust = m.createIndividual(NS + "checkReliab", softGoalClass);
		Individual passThrough = m.createIndividual(NS + "passThrough", softGoalClass);
		Individual passCheck = m.createIndividual(NS + "passCheck", goalClass);
		Individual qualityEquip = m.createIndividual(NS+"qualityEquip", resourceClass);
		Individual enoughStaff = m.createIndividual(NS+"enoughStaff", resourceClass);
		Individual maintainWeek = m.createIndividual(NS+"maintainWeek", taskClass);
		Individual staffTrain = m.createIndividual(NS + "staffTrain", softGoalClass);
		Individual repair20 = m.createIndividual(NS + "repair20", goalClass);
		Individual searchPerson = m.createIndividual(NS+"searchPerson", taskClass);
		Individual useDetector = m.createIndividual(NS+"useDetector", taskClass);
		Individual safetyStandard = m.createIndividual(NS+"safetyStandard", goalClass);
		Individual metalDetected = m.createIndividual(NS+"metalDetected", goalClass);
		Individual powerSupply = m.createIndividual(NS+"powerSupply", resourceClass);
		Individual checkEachPass = m.createIndividual(NS+"checkEachPass", taskClass);
		Individual beSafe = m.createIndividual(NS+"beSafe", softGoalClass);
		Individual passSec = m.createIndividual(NS+"passSec", taskClass);
		
		Individual linkContributesP = m.createIndividual(NS + "passThroughEasily", contributesPClass);
		linkContributesP.addProperty(propContributesP, passThroughSecurely);
		linkContributesP.addProperty(propContributesP, passThroughEasily);
		linkContributesP.addProperty(propContributesPTo, passSec);
		
		
		Individual linkContributesP1 = m.createIndividual(NS + "checkReliab", contributesPClass);
		linkContributesP1.addProperty(propContributesP1, checkReliab);
		linkContributesP1.addProperty(propContributesP1, checkRobust);
		linkContributesP1.addProperty(propContributesP1To, checkSec);
		
		Individual linkContributesP4 = m.createIndividual(NS + "passcheck", contributesPClass);
		linkContributesP4.addProperty(propContributesP4, passCheck);
		linkContributesP4.addProperty(propContributesP4To, checkSec);
		
		Individual linkContributesP43 = m.createIndividual(NS + "checkRobust", contributesPClass);
		linkContributesP43.addProperty(propContributesP4, repair20);
		linkContributesP43.addProperty(propContributesP43To, checkRobust);
		
		Individual linkContributesP21 = m.createIndividual(NS + "checkRaliab", contributesPClass);
		linkContributesP21.addProperty(propContributesP2, staffTrain);
		linkContributesP21.addProperty(propContributesP21To, checkReliab);
		
		Individual linkContributesP41 = m.createIndividual(NS + "checkreliab", contributesPClass);
		linkContributesP41.addProperty(propContributesP2, qualityEquip);
		linkContributesP41.addProperty(propContributesP2To, checkReliab);
		
		Individual linkContributesP44 = m.createIndividual(NS + "passthrough", contributesPClass);
		linkContributesP44.addProperty(propContributesP2, enoughStaff);
		linkContributesP44.addProperty(propContributesP22To, passThrough);
		
		Individual linkContributesP42 = m.createIndividual(NS + "checkreliab", contributesPClass);
		linkContributesP42.addProperty(propContributesP3, maintainWeek);
		linkContributesP42.addProperty(propContributesP3To, checkReliab);
		
		Individual linkContributesM = m.createIndividual(NS + "easily", contributesMClass);
		linkContributesM.addProperty(propContributesM, passThroughSecurely);
		linkContributesM.addProperty(propContributesM11To, passThroughEasily);
		
		Individual linkContributesM2 = m.createIndividual(NS + "securely", contributesMClass);
		linkContributesM2.addProperty(propContributesM, passThroughEasily);
		linkContributesM2.addProperty(propContributesM2To, passThroughSecurely);
		
		Individual linkContributesM1 = m.createIndividual(NS + "checksec", contributesMClass);
		linkContributesM1.addProperty(propContributesM, passThrough);
		linkContributesM1.addProperty(propContributesMTo, checkSec);
		
		Individual linkPropElement = m.createIndividual(NS + "checkSec", elementClass);
		linkPropElement.addProperty(propElement, searchPerson);
		linkPropElement.addProperty(propElement, useDetector);
		linkPropElement.addProperty(propElementTo, checkSec);
		
		Individual linkMeansEnd = m.createIndividual(NS + "usedetect", meansEndClass);
		linkMeansEnd.addProperty(propMeansEnd, safetyStandard);
		linkMeansEnd.addProperty(propMeansEnd, metalDetected);
		linkMeansEnd.addProperty(propMeansEndTo, useDetector);
		
		Individual linkMeansEnd11 = m.createIndividual(NS + "usedetector", meansEndClass);
		linkMeansEnd11.addProperty(propMeansEnd1, powerSupply);
		linkMeansEnd11.addProperty(propMeansEnd1To, useDetector);
		
		Individual linkMeansEnd12 = m.createIndividual(NS + "checkeach", meansEndClass);
		linkMeansEnd12.addProperty(propMeansEnd2, checkSec);
		linkMeansEnd12.addProperty(propMeansEnd21To, checkEachPass);
		
		Individual linkGlobal = m.createIndividual(NS + "linkGlobal", globalClass);
		linkGlobal.addProperty(propGlobal, passSec );
		linkGlobal.addProperty(propGlobalTo, checkEachPass );
		
		Individual linkGlobal1 = m.createIndividual(NS + "linkGlobal1", globalClass);
		linkGlobal1.addProperty(propGlobal1, beSafe);
		linkGlobal1.addProperty(propGlobal1To, safetyStandard);
		
		for(StmtIterator it = linkGlobal.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		for(StmtIterator it = checkSec.listProperties(); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		
		//вывод всего и всех где есть класс passCheck (goal) для  всей модели
		OntClass c = passCheck.getOntClass();
		SimpleSelector s = new SimpleSelector(null, null, c);
		for(StmtIterator it = m.listStatements(s); it.hasNext();)
		{
			System.out.println(it.nextStatement());
		}
		
		//UMLUseCase.run();
		
		/*try {
			m.write(new FileWriter("mmmm.owl"), "RDF/XML");
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}

}
