package ru.agentlab.jfxed.diagramms.processmap;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ProcessMapDiagrammTest {

	static String SOURCE = "http://www.agentlab.ru/jfxed/onto/processmap";
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
		
		OntClass processClass = m.createClass(NS + "Process");
		OntClass receiveClass = m.createClass(NS + "Receive");
		OntClass sendClass = m.createClass(NS + "Send");
		
		OntClass procLinkClass = m.createClass(NS + "ProcessLink");
		
		// связи
		
		ObjectProperty procTo = m.createObjectProperty(NS + "ProcessTo");
		procTo.addDomain(procLinkClass);
		procTo.addRange(processClass);
		procTo.addRange(sendClass);
		ObjectProperty procFrom = m.createObjectProperty(NS + "ProcessFrom");
		procFrom.addDomain(procLinkClass);
		procFrom.addRange(processClass);
		procFrom.addRange(receiveClass);
		
		// наполнение базы
		Individual order = m.createIndividual(NS + "order",sendClass);
		Individual procOther = m.createIndividual(NS + "procOther",processClass);
		Individual shipOther = m.createIndividual(NS + "shipOther",processClass);
		Individual goods = m.createIndividual(NS + "goods",receiveClass);
		
		Individual procLinkIndividual = m.createIndividual(procLinkClass);
		procLinkIndividual.addProperty(procFrom, order);
		procLinkIndividual.addProperty(procTo, procOther);
		procLinkIndividual.addProperty(procFrom, procOther);
		procLinkIndividual.addProperty(procTo, shipOther);
		procLinkIndividual.addProperty(procFrom, shipOther);
		procLinkIndividual.addProperty(procFrom, goods);
		
		FileOutputStream out;
        try {
            out = new FileOutputStream("model.owl");
            m.write(out, "RDF/XML");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		}
	}
