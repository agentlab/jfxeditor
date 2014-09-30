package ru.agentlab.jfxed.diagramms.BusinessProcessModelandNotation;

import ru.agentlab.jfxed.IDiagram;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Resource;

import de.fxdiagram.core.XDiagram;

import ru.agentlab.jfxed.figures.clazz.ClassFigure;

public class BusinessProcessModelandNotationFigure implements IDiagram {
	
	String ONT_IRI = "http://www.agentlab.ru/jfxed/onto/BusinessProcessModelandNotation";

	@Override
	public void createJfx(OntModel jenaModel, XDiagram jfxDiagram) {
		
		executeQuery(jenaModel, jfxDiagram, "Task");
		executeQuery(jenaModel, jfxDiagram, "Start");
		
	}

	private void executeQuery(OntModel jenaModel, XDiagram jfxDiagram, String queryString) {
		
		/*
		PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 
			select ?uri 
			where { 
				?uri rdf:type <«SOURCE»#«className»>  
			} 
		*/
		
		String SPARQL = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n\t"
				+ "select ?uri \n\t"
				+ "where { \n\t\t"
				+ "?uri rdf:type <" + ONT_IRI + "#" + queryString + "> \n\t"
				+ "}\n";

		Query query = QueryFactory.create(SPARQL);
		QueryExecution qe = QueryExecutionFactory.create(query, jenaModel);
		ResultSet rs = qe.execSelect();
		
		while (rs.hasNext()) {
			QuerySolution qs = rs.nextSolution();
			Resource res = qs.getResource("uri");
			System.out.println("MyRes: " + res);
			
			ClassFigure fig = new ClassFigure();
			fig.setLayoutX(250.0);
			fig.setLayoutY(250.0);
			fig.setName(res.getLocalName());
			
			jfxDiagram.getNodes().add(fig);
		}
		qe.close();
	}
}
