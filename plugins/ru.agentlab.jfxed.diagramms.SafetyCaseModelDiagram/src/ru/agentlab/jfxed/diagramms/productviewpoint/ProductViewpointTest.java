package ru.agentlab.jfxed.diagramms.productviewpoint;
import java.io.FileWriter;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.StmtIterator;


public class ProductViewpointTest {

	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
		
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		OntClass goalClass = m.createClass(NS + "Goal");
		OntClass strategyClass = m.createClass(NS + "Strategy");
		OntClass jClass = m.createClass(NS + "J");
		OntClass solutionClass = m.createClass(NS + "Solution");
	
		OntClass connectionClass = m.createClass(NS + "Connection");
		
		OntClass associationClass = m.createClass(NS + "Association");
		
		OntClass aggregationClass = m.createClass(NS + "Agregation");//связь
		
		aggregationClass.addSuperClass(connectionClass);//родительская связь
		associationClass.addSuperClass(connectionClass);//родительская связь
		
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		propTo.addDomain(aggregationClass);//свойства у aggregation
		propFrom.addDomain(aggregationClass);
		
		propTo.addRange(goalClass);
		propFrom.addRange(goalClass);
		propTo.addRange(strategyClass);
		propFrom.addRange(strategyClass);
		propTo.addRange(jClass);
		propFrom.addRange(jClass);
		propTo.addRange(solutionClass);
		propFrom.addRange(solutionClass);
		
				
		//наполнение базы 
		
		//сначала goalClass
		Individual railwiseSafe = m.createIndividual(NS + "RailwiseSafe", goalClass);
		Individual noExtraHazard = m.createIndividual(NS + "NoExtraHazard", goalClass);
		Individual predictFailure = m.createIndividual(NS + "PredictFailurer", goalClass);
		Individual improveTrackside = m.createIndividual(NS + "ImproveTrackside", goalClass);
		Individual falseAlarms = m.createIndividual(NS + "FalseAlarms", goalClass);
		Individual distributeArchitecture = m.createIndividual(NS + "DistributeArchitecture", goalClass);
		Individual dataCollectionAndAnalysis = m.createIndividual(NS + "DataCollectionAndAnalysis", goalClass);
		
		//теперь strategyClass
		Individual safetyMeasures = m.createIndividual(NS + "SafetyMeasures", strategyClass);
		Individual dataAnalysis = m.createIndividual(NS + "DataAnalysis", strategyClass);
		
		//jClass
		Individual latestData = m.createIndividual(NS + "LatestData", jClass);
		
		// solutionClass
		Individual theSolution = m.createIndividual(NS + "TheSolution", solutionClass);
		Individual tracksideWork= m.createIndividual(NS + "TracksideWork", solutionClass);
		Individual theSolution1 = m.createIndividual(NS + "TheSolution1", solutionClass);
		
		
		//связи
		
		Individual toSafetyMeasures = m.createIndividual(NS + "toSafetyMeasures", aggregationClass);
		toSafetyMeasures.addProperty(propTo, safetyMeasures);
		toSafetyMeasures.addProperty(propFrom, railwiseSafe);
		
		//////////////////////
		Individual toNoExtraHazard = m.createIndividual(NS + "toNoExtraHazard", aggregationClass);
		toNoExtraHazard.addProperty(propTo, noExtraHazard);
		toNoExtraHazard.addProperty(propFrom, safetyMeasures);
		
		Individual toPredictFailurer = m.createIndividual(NS + "toPredictFailurer", aggregationClass);
		toPredictFailurer.addProperty(propTo, predictFailure);
		toPredictFailurer.addProperty(propFrom, safetyMeasures);
		
		Individual toImproveTrackside = m.createIndividual(NS + "toImproveTrackside", aggregationClass);
		toImproveTrackside.addProperty(propTo, improveTrackside);
		toImproveTrackside.addProperty(propFrom, safetyMeasures);
		
		Individual toFalseAlarms = m.createIndividual(NS + "toFalseAlarms", aggregationClass);
		toFalseAlarms.addProperty(propTo, falseAlarms);
		toFalseAlarms.addProperty(propFrom, safetyMeasures);
		
		////////////////////////////
		Individual toTheSolution = m.createIndividual(NS + "toTheSolution", aggregationClass);
		toTheSolution.addProperty(propTo, theSolution);
		toTheSolution.addProperty(propFrom, noExtraHazard);
		
		Individual toDataAnalysis = m.createIndividual(NS + "toDataAnalysis", aggregationClass);
		toDataAnalysis.addProperty(propTo, dataAnalysis);
		toDataAnalysis.addProperty(propFrom, predictFailure);
		
		Individual toTracksideWork = m.createIndividual(NS + "toTracksideWork", aggregationClass);
		toTracksideWork.addProperty(propTo, tracksideWork);
		toTracksideWork.addProperty(propFrom, improveTrackside);
		
		Individual toTheSolution1 = m.createIndividual(NS + "toTheSolution1", aggregationClass);
		toTheSolution1.addProperty(propTo, theSolution1);
		toTheSolution1.addProperty(propFrom, falseAlarms);
		
		//////////////////////////////////////
		Individual toDistributeArchitecture = m.createIndividual(NS + "toDistributeArchitecture", aggregationClass);
		toDistributeArchitecture.addProperty(propTo, distributeArchitecture);
		toDistributeArchitecture.addProperty(propFrom, dataAnalysis);
		
		Individual toDataCollectionAndAnalysis = m.createIndividual(NS + "toDataCollectionAndAnalysis", aggregationClass);
		toDataCollectionAndAnalysis.addProperty(propTo, dataCollectionAndAnalysis);
		toDataCollectionAndAnalysis.addProperty(propFrom, dataAnalysis);
		
		////////////////////////////// связь1
		Individual toLatestData = m.createIndividual(NS + "toLatestData", associationClass);
		toLatestData.addProperty(propTo, latestData);
		toLatestData.addProperty(propFrom, predictFailure);
		
	
		try {
			m.write(new FileWriter("D:/eclipse-standard/qwe.owl"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
			    
		}
	}
