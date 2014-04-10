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
		OntModel m = ModelFactory.createOntologyModel();  //создается пустая база знаний
		
		//создаем отдельные triple
		
		OntClass GoalClass = m.createClass(NS + "Goal");
		OntClass StrategyClass = m.createClass(NS + "Strategy");
		OntClass SolutionClass = m.createClass(NS + "Solution");
		OntClass JClass = m.createClass(NS + "J");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//связь
		OntClass aggregation1Class = m.createClass(NS + "Agregation1");
		
		aggregationClass.addSuperClass(GoalClass);  //родительская связь
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");  //объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass); //свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		propTo.addRange(GoalClass);  //   то что могут принимать
		propTo.addRange(StrategyClass);
		propTo.addRange(SolutionClass);
		propFrom.addRange(GoalClass);
		propFrom.addRange(StrategyClass);
		
		//наполнение базы 
		
		Individual RailwiseSafe = m.createIndividual(NS + "Railwise System", GoalClass);
		
		Individual NoExtraHazards = m.createIndividual(NS + "No additional", GoalClass);
		Individual PredictFailure = m.createIndividual(NS + "Railwise", GoalClass);
		Individual ImproveTrackside = m.createIndividual(NS + "The use of Railwise", GoalClass);
		Individual FalseAlarm = m.createIndividual(NS + "Alarms", GoalClass);
		
		Individual Distribute = m.createIndividual(NS + "Railwise utililises", GoalClass);
		Individual DataCollection = m.createIndividual(NS + "Railwise transmits", GoalClass);
		
		Individual SafetyMeasures = m.createIndividual(NS + "Railwise employs", StrategyClass);
		Individual DataAnalysis = m.createIndividual(NS + "With the use", StrategyClass);
		
		Individual TheSolution = m.createIndividual(NS + "Here is the solution", SolutionClass);
		Individual TracksideWork= m.createIndividual(NS + "As a result", SolutionClass);
		Individual TheSolution1 = m.createIndividual(NS + "Here is the solution", SolutionClass);
		
		Individual Latest = m.createIndividual(NS + "Latest", JClass);
		
		
		Individual FrRailToSafety = m.createIndividual(NS + "FrRailToSafety", aggregationClass);
		FrRailToSafety.addProperty(propTo, SafetyMeasures);  //от продукта к контракту
		FrRailToSafety.addProperty(propFrom, RailwiseSafe);
		
		Individual FrSafetyToNoExtract = m.createIndividual(NS + "FrSafetyToNoExtract", aggregationClass);
		FrSafetyToNoExtract.addProperty(propTo, NoExtraHazards);  
		FrSafetyToNoExtract.addProperty(propFrom, SafetyMeasures);
		
		Individual FrSafetyToPredict = m.createIndividual(NS + "FrSafetyToPredict", aggregationClass);
		FrSafetyToPredict.addProperty(propTo, PredictFailure);  
		FrSafetyToPredict.addProperty(propFrom, SafetyMeasures);
		
		Individual FrSafetyToImprove = m.createIndividual(NS + "FrSafetyToImprove", aggregationClass);
		FrSafetyToImprove.addProperty(propTo, ImproveTrackside);  
		FrSafetyToImprove.addProperty(propFrom, SafetyMeasures);
		
		Individual FrSafetyToFalse = m.createIndividual(NS + "FrSafetyToFalse", aggregationClass);
		FrSafetyToFalse.addProperty(propTo, FalseAlarm);  
		FrSafetyToFalse.addProperty(propFrom, SafetyMeasures);
		
		Individual FrNoToSolut = m.createIndividual(NS + "FrNoToSolut", aggregationClass);
		FrNoToSolut.addProperty(propTo, TheSolution );  
		FrNoToSolut.addProperty(propFrom, NoExtraHazards);
		
		Individual FrPredToData = m.createIndividual(NS + "FrPredToData", aggregationClass);
		FrPredToData.addProperty(propTo, DataAnalysis );  
		FrPredToData.addProperty(propFrom, PredictFailure);
		
		Individual FrImproveToTrack = m.createIndividual(NS + "FrImproveToTrack", aggregationClass);
		FrImproveToTrack.addProperty(propTo,TracksideWork );  
		FrImproveToTrack.addProperty(propFrom, ImproveTrackside);
		
		Individual FrfalseToSolu1 = m.createIndividual(NS + "FrfalseToSolu1", aggregationClass);
		FrfalseToSolu1.addProperty(propTo,TheSolution1 );  
		FrfalseToSolu1.addProperty(propFrom, FalseAlarm);
		
		Individual FrPredictToLatest = m.createIndividual(NS + "FrPredictToLatest", aggregation1Class);
		FrPredictToLatest.addProperty(propTo,Latest );  
		FrPredictToLatest.addProperty(propFrom, PredictFailure);
		
		Individual FrPredictToDistribute = m.createIndividual(NS + "FrPredictToDistribute", aggregationClass);
		FrPredictToDistribute.addProperty(propTo,Distribute );  
		FrPredictToDistribute.addProperty(propFrom, DataAnalysis);
		
		Individual FrPredictToDataCollection = m.createIndividual(NS + "FrPredictToDataCollection", aggregationClass);
		FrPredictToDataCollection.addProperty(propTo,DataCollection );  
		FrPredictToDataCollection.addProperty(propFrom, DataAnalysis);
		
		
		m.write(System.out); //и в консоль
		
		
		
	}
	
	public class Transform {
		
	}
}
