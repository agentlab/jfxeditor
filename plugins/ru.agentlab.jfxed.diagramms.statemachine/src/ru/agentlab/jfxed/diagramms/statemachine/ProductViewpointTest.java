package ru.agentlab.jfxed.diagramms.statemachine;
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
		
		/*
		 * Здесь объявляем объекты квадратики схемы
		 * */
		OntModel m = ModelFactory.createOntologyModel();//создается пустая база знаний
		
		ObjectProperty propTo = m.createObjectProperty(NS + "To");//объекты - свойства
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		/**
		 * Вершины графа
		 */
		OntClass concept = m.createClass(NS + "Concept");
		
		OntClass productClass = m.createClass(NS + "Product");//создаем отдельные triple
		productClass.addSuperClass(concept);
		
		OntClass contractClass = m.createClass(NS + "Contract");
		contractClass.addSuperClass(concept);
		
		OntClass businessServiceClass = m.createClass(NS + "Business Service");
		businessServiceClass.addSuperClass(concept);
		
		OntClass valueClass = m.createClass(NS + "Value");
		valueClass.addSuperClass(concept);
		
		OntClass businessInterfaceClass = m.createClass(NS + "Business interface");
		businessInterfaceClass.addSuperClass(concept);
		
		OntClass businessEventClass = m.createClass(NS + "BusinessEvent");
		businessEventClass.addSuperClass(concept);
		
		OntClass businessProcessClass = m.createClass(NS + "Business process");
		businessProcessClass.addSuperClass(concept);
		
		OntClass businessRoleClass = m.createClass(NS + "Business role");
		businessRoleClass.addSuperClass(concept);
		
		OntClass businessActorClass = m.createClass(NS + "Business actor");
		businessActorClass.addSuperClass(concept);
		
		OntClass applicationServiceClass = m.createClass(NS + "Application service");
		applicationServiceClass.addSuperClass(concept);
		
		OntClass applicationInterfaceClass = m.createClass(NS + "Application interface");
		applicationInterfaceClass.addSuperClass(concept);
		
		OntClass applicationComponentClass = m.createClass(NS + "Application component");
		applicationComponentClass.addSuperClass(concept);
		
		/*
		 * end
		 * */
		
		/*
		 * Объявление связей
		 * */
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
		OntClass realizationClass = m.createClass(NS + "Realization");
		
		//сюда повсему мы говорим что наши стрелочки это association
		aggregationClass.addSuperClass(associationClass);//родительская связь
		assigmentClass.addSuperClass(associationClass);//родительская связь
		usedByClass.addSuperClass(associationClass);//родительская связь
		compositionClass.addSuperClass(associationClass);//родительская связь
		triggeringClass.addSuperClass(associationClass);//родительская связь
		accessClass.addSuperClass(associationClass);//родительская связь
		
		/*
		 * end
		 * */
	    
		//propTo.addDomain(aggregationClass);//свойства у aggregation
		//propFrom.addDomain(aggregationClass);
		
		propTo.addDomain(associationClass);
		propTo.addRange(valueClass);
		
		propFrom.addDomain(valueClass);
		propFrom.addRange(associationClass);
		
		/*
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
		*/

		
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
		
		/*
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
		
		*/
		
		m.write(System.out, "RDF/XML");//и в консоль
		//m.containsAny((StmtIterator) businessEventIndividual);
		
		//m.read(SOURCE, "RDF/XML" );
		/*
  <rdf:Description rdf:about="http://www.eswc2006.org/technologies/ontology#assigmentBusinessRole_BusinessActor">
    <j.1:From rdf:resource="http://www.eswc2006.org/technologies/ontology#businessActor"/>
    <j.1:From rdf:resource="http://www.eswc2006.org/technologies/ontology#businessRole"/>
    <j.1:To rdf:resource="http://www.eswc2006.org/technologies/ontology#businessActor"/>
    <j.1:To rdf:resource="http://www.eswc2006.org/technologies/ontology#businessRole"/>
    <rdf:type rdf:resource="http://www.eswc2006.org/technologies/ontology#Assigment"/>
  </rdf:Description>
		 * */
/*
		String queryString =        
			        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
			        + "select ?uri "+
			        "where { "+
			         "?uri rdf:type <http://www.eswc2006.org/technologies/ontology#Assigment>  "+
			        "} \n ";
			    Query query = QueryFactory.create(queryString);
		
			    // Execute the query and obtain results
			    QueryExecution qe = QueryExecutionFactory.create(query, m);
			    com.hp.hpl.jena.query.ResultSet results =  qe.execSelect();

			    // Output query results    
			    ResultSetFormatter.out(System.out, results, query);
			    
			    qe.close();
			    */
		/*
<rdf:Description rdf:about="http://www.eswc2006.org/technologies/ontology#businessEvent">
    <rdf:type rdf:resource="http://www.eswc2006.org/technologies/ontology#BusinessEvent"/>
  </rdf:Description>*/
				String queryString2 =        
				        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
				        + "select ?uri "+
				        "where { "+
				         "?uri rdf:type <http://www.eswc2006.org/technologies/ontology#Product>  "+
				        "} \n ";
				    Query query2 = QueryFactory.create(queryString2);
			
				    // Execute the query and obtain results
				    QueryExecution qe2 = QueryExecutionFactory.create(query2, m);
				    com.hp.hpl.jena.query.ResultSet results2 =  qe2.execSelect();

				    // Output query results    
				    ResultSetFormatter.out(System.out, results2, query2);
				    qe2.close();
			    
		}
	}
