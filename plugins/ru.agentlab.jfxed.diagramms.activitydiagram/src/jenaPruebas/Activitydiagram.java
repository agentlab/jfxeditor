package jenaPruebas;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Activitydiagram
{
  static final String SCHEMA = "http://www.w3.org/2002/07/owl";
  static final String NS = "http://www.w3.org/2002/07/owl#";
  
  public static void main(String[] args)
  {
    OntModel m = ModelFactory.createOntologyModel();
    
    OntClass conceptClass = m.createClass("http://www.w3.org/2002/07/owl#Concept");
    OntClass relationClass = m.createClass("http://www.w3.org/2002/07/owl#Relation");
    
    OntClass action = m.createClass("http://www.w3.org/2002/07/owl#Action");
    action.addSuperClass(conceptClass);
    OntClass mergeNode = m.createClass("http://www.w3.org/2002/07/owl#MergeNode");
    mergeNode.addSuperClass(conceptClass);
    OntClass object = m.createClass("http://www.w3.org/2002/07/owl#Object");
    object.addSuperClass(conceptClass);
    OntClass orderRejected = m.createClass("http://www.w3.org/2002/07/owl#OrderRejected");
    orderRejected.addSuperClass(conceptClass);
    OntClass forkAndJoin = m.createClass("http://www.w3.org/2002/07/owl#forkAndJoin");
    forkAndJoin.addSuperClass(conceptClass);
    OntClass requestedOrder = m.createClass("http://www.w3.org/2002/07/owl#requestedOrder");
    requestedOrder.addSuperClass(conceptClass);
    OntClass link = m.createClass("http://www.w3.org/2002/07/owl#Link");
    link.addSuperClass(relationClass);
    
    ObjectProperty prop1 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop1");
    prop1.addDomain(action);
    prop1.addRange(action);
    
    ObjectProperty prop2 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop2");
    prop2.addDomain(action);
    prop2.addRange(mergeNode);
    
    ObjectProperty prop3 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop3");
    prop3.addDomain(mergeNode);
    prop3.addRange(action);
    
    ObjectProperty prop4 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop4");
    prop4.addDomain(forkAndJoin);
    prop4.addRange(action);
    
    ObjectProperty prop5 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop5");
    prop5.addDomain(action);
    prop5.addRange(forkAndJoin);
    
    ObjectProperty prop6 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop6");
    prop6.addDomain(forkAndJoin);
    prop6.addRange(mergeNode);
    
    ObjectProperty prop7 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop7");
    prop7.addDomain(object);
    prop7.addRange(action);
    
    ObjectProperty prop8 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop8");
    prop8.addDomain(action);
    prop8.addRange(object);
    
    ObjectProperty prop9 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop9");
    prop9.addDomain(orderRejected);
    prop9.addRange(mergeNode);
    
    ObjectProperty prop10 = m.createObjectProperty("http://www.w3.org/2002/07/owl#prop10");
    prop10.addDomain(requestedOrder);
    prop10.addRange(action);
    
    Individual receiveOrder = m.createIndividual("http://www.w3.org/2002/07/owl#receiveOrder", action);
    Individual fillOrder = m.createIndividual("http://www.w3.org/2002/07/owl#fillOrder", action);
    Individual shipOrder = m.createIndividual("http://www.w3.org/2002/07/owl#shipOrder", action);
    Individual closeOrder = m.createIndividual("http://www.w3.org/2002/07/owl#closeOrder", action);
    Individual sendInvoice = m.createIndividual("http://www.w3.org/2002/07/owl#sendInvoice", action);
    Individual makePayment = m.createIndividual("http://www.w3.org/2002/07/owl#makePayment", action);
    Individual acceptPayment = m.createIndividual("http://www.w3.org/2002/07/owl#acceptPayment", action);
    Individual invoice = m.createIndividual("http://www.w3.org/2002/07/owl#invoice", object);
    Individual forkAndJoin1 = m.createIndividual("http://www.w3.org/2002/07/owl#forkAndJoin1", forkAndJoin);
    Individual forkAndJoin2 = m.createIndividual("http://www.w3.org/2002/07/owl#forkAndJoin2", forkAndJoin);
    Individual mergeNode1 = m.createIndividual("http://www.w3.org/2002/07/owl#mergeNode1", mergeNode);
    Individual mergeNode2 = m.createIndividual("http://www.w3.org/2002/07/owl#mergeNode2", mergeNode);
    Individual request = m.createIndividual("http://www.w3.org/2002/07/owl#request", mergeNode);
    Individual a1 = m.createIndividual("http://www.w3.org/2002/07/owl#a1", orderRejected);
    Individual a2 = m.createIndividual("http://www.w3.org/2002/07/owl#a2", orderRejected);
    
    Individual link1 = m.createIndividual("http://www.w3.org/2002/07/owl#link1", link);
    link1.addProperty(prop2, receiveOrder);
    link1.addProperty(prop2, mergeNode1);
    
    Individual link2 = m.createIndividual("http://www.w3.org/2002/07/owl#link2", link);
    link2.addProperty(prop3, mergeNode1);
    link2.addProperty(prop3, fillOrder);
    
    Individual link3 = m.createIndividual("http://www.w3.org/2002/07/owl#link3", link);
    link3.addProperty(prop5, fillOrder);
    link3.addProperty(prop5, forkAndJoin1);
    
    Individual link4 = m.createIndividual("http://www.w3.org/2002/07/owl#link4", link);
    link4.addProperty(prop4, forkAndJoin1);
    link4.addProperty(prop4, shipOrder);
    
    Individual link5 = m.createIndividual("http://www.w3.org/2002/07/owl#link5", link);
    link5.addProperty(prop5, shipOrder);
    link5.addProperty(prop5, forkAndJoin2);
    
    Individual link6 = m.createIndividual("http://www.w3.org/2002/07/owl#link6", link);
    link6.addProperty(prop6, forkAndJoin2);
    link6.addProperty(prop6, mergeNode2);
    
    Individual link7 = m.createIndividual("http://www.w3.org/2002/07/owl#link7", link);
    link7.addProperty(prop3, mergeNode2);
    link7.addProperty(prop3, closeOrder);
    
    Individual link8 = m.createIndividual("http://www.w3.org/2002/07/owl#link8", link);
    link8.addProperty(prop3, mergeNode1);
    link8.addProperty(prop3, sendInvoice);
    
    Individual link9 = m.createIndividual("http://www.w3.org/2002/07/owl#link9", link);
    link9.addProperty(prop8, sendInvoice);
    link9.addProperty(prop8, invoice);
    
    Individual link10 = m.createIndividual("http://www.w3.org/2002/07/owl#link10", link);
    link10.addProperty(prop7, invoice);
    link10.addProperty(prop7, makePayment);
    
    Individual link11 = m.createIndividual("http://www.w3.org/2002/07/owl#link11", link);
    link11.addProperty(prop1, makePayment);
    link11.addProperty(prop1, acceptPayment);
    
    Individual link12 = m.createIndividual("http://www.w3.org/2002/07/owl#link12", link);
    link12.addProperty(prop6, acceptPayment);
    link12.addProperty(prop6, mergeNode2);
    
    Individual link13 = m.createIndividual("http://www.w3.org/2002/07/owl#link13", link);
    link13.addProperty(prop10, request);
    link13.addProperty(prop10, receiveOrder);
    
    Individual link14 = m.createIndividual("http://www.w3.org/2002/07/owl#link14", link);
    link14.addProperty(prop9, a1);
    link14.addProperty(prop9, mergeNode1);
    
    Individual link15 = m.createIndividual("http://www.w3.org/2002/07/owl#link15", link);
    link15.addProperty(prop9, a2);
    link15.addProperty(prop9, mergeNode2);
    for (StmtIterator it = link1.listProperties(); it.hasNext();) {
      System.out.println(it.nextStatement());
    }
    for (StmtIterator it = receiveOrder.listProperties(); it.hasNext();) {
      System.out.println(it.nextStatement());
    }
    OntClass c = mergeNode1.getOntClass();
    SimpleSelector s = new SimpleSelector(null, null, c);
    for (StmtIterator it = m.listStatements(s); it.hasNext();) {
      System.out.println(it.nextStatement());
    }
    try
    {
      m.write(new FileWriter("mmmm.owl"), "RDF/XML");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
