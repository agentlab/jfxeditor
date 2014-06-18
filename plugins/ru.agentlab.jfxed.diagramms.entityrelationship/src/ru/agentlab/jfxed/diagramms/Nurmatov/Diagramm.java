package ru.agentlab.jfxed.diagramms.Nurmatov;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Diagramm {
	static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	static String NS = SOURCE + "#";
	
	//test from sourcetree
	public static void main (String[] args){
	
		OntModel m = ModelFactory.createOntologyModel();
		
		OntClass relationClass = m.createClass(NS + "Relation");
		OntClass conceptClass = m.createClass(NS + "Concept");
		
		OntClass relationshipClass = m.createClass(NS + "Relationship");
		relationshipClass.addSuperClass(relationClass);
		
		OntClass attrRelationshipClass = m.createClass(NS + "Attribute-Relationship");
		attrRelationshipClass.addSuperClass(relationClass);
		 
		
		OntClass attributeConceptClass = m.createClass(NS + "Attribute-Concept");
		attributeConceptClass.addSuperClass(conceptClass);
		OntClass entityConceptClass = m.createClass(NS + "Entity-Concept");
		entityConceptClass.addSuperClass(conceptClass);
		
		 
		ObjectProperty propTo = m.createObjectProperty(NS + "To");
		ObjectProperty propFrom = m.createObjectProperty(NS + "From");
		
		ObjectProperty propAttrTo = m.createObjectProperty(NS + "Attribution-To");
		ObjectProperty propAttrFrom = m.createObjectProperty(NS + "Attribution-From");
		
		propTo.addDomain(relationshipClass);
		propFrom.addDomain(entityConceptClass);
		
		propAttrTo.addDomain(attrRelationshipClass);
		propAttrFrom.addDomain(relationshipClass);
		propAttrFrom.addDomain(entityConceptClass);
	
		propFrom.addRange(relationshipClass);
		
		propTo.addRange(entityConceptClass);
		

		propAttrFrom.addRange(attrRelationshipClass);
		

		propAttrTo.addRange(attributeConceptClass); 
		
		

		Individual accountIndividual = m.createIndividual(NS + "account", entityConceptClass);
		Individual characterIndividual = m.createIndividual(NS + "character", entityConceptClass);
		Individual regionIndividual = m.createIndividual(NS + "region", entityConceptClass);
		Individual itemInstantiationIndividual = m.createIndividual(NS + "item-instantiation", entityConceptClass);
		Individual itemIndividual = m.createIndividual(NS + "item", entityConceptClass);
		Individual creepInstantiationIndividual = m.createIndividual(NS + "creep-instantiation", entityConceptClass);
		Individual creepIndividual = m.createIndividual(NS + "creep", entityConceptClass);
		

		Individual hasIndividual = m.createIndividual(NS+ "Has", relationshipClass);
		Individual containsIndividual = m.createIndividual(NS+ "Contains", relationshipClass);
		Individual carryingIndividual = m.createIndividual(NS+ "Carrying", relationshipClass);
		Individual ranIntoIndividual = m.createIndividual(NS+ "Ran-Into", relationshipClass);
		Individual isTypeIndividual = m.createIndividual(NS+ "Is-Type", relationshipClass);
		
		// ACCOUNT
		Individual acctName = m.createIndividual(NS + "Account-name", attributeConceptClass);
		acctName.addProperty(propAttrTo, accountIndividual);
		
		Individual password = m.createIndividual(NS + "Password", attributeConceptClass);
		password.addProperty(propAttrTo, accountIndividual);
		
		Individual lastSignedOn = m.createIndividual(NS + "Last-Signed-On", attributeConceptClass);
		lastSignedOn.addProperty(propAttrTo, accountIndividual);
		
		Individual sbscrbrName = m.createIndividual(NS + "Subscriber-name", attributeConceptClass);
		sbscrbrName.addProperty(propAttrTo, accountIndividual);
		
		Individual sbscrbrAddres = m.createIndividual(NS + "Subscriber-Addres", attributeConceptClass);
		sbscrbrAddres.addProperty(propAttrTo, accountIndividual);
		
		Individual sbscrbrEMail = m.createIndividual(NS + "Subscriber-EMail", attributeConceptClass);
		sbscrbrEMail.addProperty(propAttrTo, accountIndividual);
		
		Individual sbscrbrPhone = m.createIndividual(NS + "Subscribert-Phone", attributeConceptClass);
		sbscrbrPhone.addProperty(propAttrTo, accountIndividual);
		
		Individual acctCreatedOn = m.createIndividual(NS + "Account-Created-On", attributeConceptClass);
		acctCreatedOn.addProperty(propAttrTo, accountIndividual);
		
		
		
		// CHARACTER
		Individual charName = m.createIndividual(NS + "Character-name", attributeConceptClass);
		charName.addProperty(propAttrFrom, characterIndividual);
		
		Individual level = m.createIndividual(NS + "Character-Level", attributeConceptClass);
		level.addProperty(propAttrFrom, characterIndividual);
		
		Individual expPoints = m.createIndividual(NS + "Character-exp-Points", attributeConceptClass);
		expPoints.addProperty(propAttrFrom, characterIndividual);
		
		Individual type = m.createIndividual(NS + "Character-type", attributeConceptClass);
		type.addProperty(propAttrFrom, characterIndividual);
		
		Individual maxHitPoints = m.createIndividual(NS + "Character-Max-Hit-Points", attributeConceptClass);
		maxHitPoints.addProperty(propAttrFrom, characterIndividual);
		
		Individual maxMana = m.createIndividual(NS + "Character-Max-Mana", attributeConceptClass);
		maxMana.addProperty(propAttrFrom, characterIndividual);
		
		Individual currHitPoints = m.createIndividual(NS + "Character-Current-Hit-Points", attributeConceptClass);
		currHitPoints.addProperty(propAttrFrom, characterIndividual);
		
		Individual currMana = m.createIndividual(NS + "Character-Current-Mana", attributeConceptClass);
		currMana.addProperty(propAttrFrom, characterIndividual);
		
		
		// REGION
		Individual regionName = m.createIndividual(NS + "Region-name", attributeConceptClass);
		regionName.addProperty(propAttrFrom, regionIndividual);
		
		Individual climate = m.createIndividual(NS + "Region-Climate", attributeConceptClass);
		climate.addProperty(propAttrFrom, regionIndividual);
		
		Individual precipitation = m.createIndividual(NS + "Region-Precipitation", attributeConceptClass);
		precipitation.addProperty(propAttrFrom, regionIndividual);
		
		Individual foliage = m.createIndividual(NS + "Region-Foliage", attributeConceptClass);
		foliage.addProperty(propAttrFrom, regionIndividual);
		
		Individual playersln = m.createIndividual(NS + "Region-Playersln", attributeConceptClass);
		playersln.addProperty(propAttrFrom, regionIndividual);
	
		
		// ITEM INSTANTIATION
		Individual itemIdnum = m.createIndividual(NS + "Item-IDNum", attributeConceptClass);
		itemIdnum.addProperty(propAttrFrom, itemInstantiationIndividual);
		
		Individual modifier = m.createIndividual(NS + "Item-Modifier", attributeConceptClass);
		modifier.addProperty(propAttrFrom, itemInstantiationIndividual);
		
		
		// ITEM
		Individual itemName = m.createIndividual(NS + "Item-Name", attributeConceptClass);
		itemName.addProperty(propAttrFrom, itemIndividual);
		
		Individual itemType = m.createIndividual(NS + "Item-Type", attributeConceptClass);
		itemType.addProperty(propAttrFrom, itemIndividual);
		
		Individual itemDamage = m.createIndividual(NS + "Item-Damage", attributeConceptClass);
		itemDamage.addProperty(propAttrFrom, itemIndividual);
		
		
		//СЃРІСЏР·Рё CREEP INSTANTIATION
		Individual creepIdnum = m.createIndividual(NS + "Creep-IDNum", attributeConceptClass);
		creepIdnum.addProperty(propAttrFrom, creepInstantiationIndividual);
		
		
		//СЃРІСЏР·Рё CREEP
		Individual creepName = m.createIndividual(NS + "Creep-Name", attributeConceptClass);
		creepName.addProperty(propAttrFrom, creepIndividual);
		
		Individual creepHP = m.createIndividual(NS + "Creep-Hit-Points", attributeConceptClass);
		creepHP.addProperty(propAttrFrom, creepIndividual);
		
		Individual creepMana = m.createIndividual(NS + "Creep-Mana", attributeConceptClass);
		creepMana.addProperty(propAttrFrom, creepIndividual);
		
		Individual creepAttack = m.createIndividual(NS + "Creep-Attack", attributeConceptClass);
		creepAttack.addProperty(propAttrFrom, creepIndividual);
		
		
		
		

		// HAS
		Individual lastPlayed = m.createIndividual(NS + "Last-played", attributeConceptClass);
		lastPlayed.addProperty(propAttrFrom, hasIndividual);
		
		Individual createdOn = m.createIndividual(NS + "Created-On", attributeConceptClass);
		createdOn.addProperty(propAttrFrom, hasIndividual);
		
		//IS TYPE
		Individual whenCreated = m.createIndividual(NS + "When-Created", attributeConceptClass);
		whenCreated.addProperty(propAttrFrom, isTypeIndividual);
		
		
		/*
		
		//ACCOUNT - HAS
		Individual acctHas = m.createIndividual(NS + "Account-to-Has", entityConceptClass);
		acctHas.addProperty(propFrom, hasIndividual);
		Individual hasAcct = m.createIndividual(NS + "Has-to-Account", relationshipClass);
		hasAcct.addProperty(propTo, accountIndividual);
		
		//CHARACTER->HAS
		Individual charHas = m.createIndividual(NS + "Character-to-Has", entityConceptClass);
		charHas.addProperty(propFrom, hasIndividual);
		Individual hasChar = m.createIndividual(NS + "Has-to-Character", relationshipClass);
		hasChar.addProperty(propTo, characterIndividual);
		
		//CHARACTER->RanInto
		Individual charRI = m.createIndividual(NS + "Character-to-Ran-Into", entityConceptClass);
		charRI.addProperty(propFrom, ranIntoIndividual);
		Individual RIChar = m.createIndividual(NS + "Ran-Into-to-Character", relationshipClass);
		RIChar.addProperty(propTo, characterIndividual);
		
		//CHARACTER->CONTAINS
		Individual charCont = m.createIndividual(NS + "Character-to-Contains", entityConceptClass);
		charCont.addProperty(propFrom, containsIndividual);
		Individual contChar = m.createIndividual(NS + "Contains-to-Character", relationshipClass);
		contChar.addProperty(propTo, characterIndividual);
		
		//CHARACTER->CARRYING
		Individual charCarr = m.createIndividual(NS + "Character-to-Carrying", entityConceptClass);
		charCarr.addProperty(propFrom, carryingIndividual);
		Individual carrChar = m.createIndividual(NS + "Carrying-to-Character", relationshipClass);
		carrChar.addProperty(propTo, characterIndividual);
		
		//REGION->CONTAINS
		Individual regCont = m.createIndividual(NS + "Region-to-Contains", entityConceptClass);
		regCont.addProperty(propFrom, containsIndividual);
		Individual contReg = m.createIndividual(NS + "Contains-to-Region", relationshipClass);
		contReg.addProperty(propTo, regionIndividual);
		
		//ITEM INSTANTIATION->CARRYING
		Individual IICarr = m.createIndividual(NS + "Item-Instantiation-to-Carrying", entityConceptClass);
		IICarr.addProperty(propFrom, carryingIndividual);
		Individual carrII = m.createIndividual(NS + "Carrying-to-Item-Instantiation", relationshipClass);
		carrII.addProperty(propTo, itemInstantiationIndividual);

		//ITEM INSTANTIATION->IS TYPE
		Individual IIiT = m.createIndividual(NS + "Item-Instantiation-to-Is-Type", entityConceptClass);
		IIiT.addProperty(propFrom, isTypeIndividual);
		Individual ITiI = m.createIndividual(NS + "Is-Type-to-Item-Instantiation", relationshipClass);
		ITiI.addProperty(propTo, itemInstantiationIndividual);
		
		//ITEM ->IS TYPE
		Individual ItemiT = m.createIndividual(NS + "Item-to-Is-Type", entityConceptClass);
		ItemiT.addProperty(propFrom, isTypeIndividual);
		Individual ITitem = m.createIndividual(NS + "Is-Type-to-Item", relationshipClass);
		ITitem.addProperty(propTo, itemIndividual);
		
		//CREEP INSTANTIATION->CARRYING
		Individual CICarr = m.createIndividual(NS + "Creep-Instantiation-to-Carrying", entityConceptClass);
		CICarr.addProperty(propFrom, carryingIndividual);
		Individual carrCI = m.createIndividual(NS + "Carrying-to-Creep-Instantiation", relationshipClass);
		carrCI.addProperty(propTo, creepInstantiationIndividual);
		
		//CREEP INSTANTIATION->IS TYPE
		Individual CIiT = m.createIndividual(NS + "Creep-Instantiation-to-Is-Type", entityConceptClass);
		CIiT.addProperty(propFrom, isTypeIndividual);
		Individual ITcI = m.createIndividual(NS + "Is-Type-to-Creep-Instantiation", relationshipClass);
		ITcI.addProperty(propTo, creepInstantiationIndividual);
		
		//CREEP INSTANTIATION->CONTAINS
		Individual CiCont = m.createIndividual(NS + "Creep-Instantiation-to-Contains", entityConceptClass);
		CiCont.addProperty(propFrom, containsIndividual);
		Individual contCi = m.createIndividual(NS + "Contains-to-Creep-Instantiation", relationshipClass);
		contCi.addProperty(propTo, creepInstantiationIndividual);
		
		//CREEP ->IS TYPE
		Individual CreepiT = m.createIndividual(NS + "Creep-to-Is-Type", entityConceptClass);
		CreepiT.addProperty(propFrom, isTypeIndividual);
		Individual ITcreep = m.createIndividual(NS + "Is-Type-to-Creep", relationshipClass);
		ITcreep.addProperty(propTo, creepIndividual);
		
		//CREEP->RanInto
		Individual creepRI = m.createIndividual(NS + "Creep-to-Ran-Into", entityConceptClass);
		creepRI.addProperty(propFrom, ranIntoIndividual);
		Individual RICreep = m.createIndividual(NS + "Ran-Into-to-Creep", relationshipClass);
		RICreep.addProperty(propTo, creepIndividual);
		
		 */
		
		m.write(System.out, "N3");//РІС‹РІРѕРґ РІ РєРѕРЅСЃРѕР»СЊ
		
		try {
			m.write(new FileWriter("MyOwlLab3.owl"), "RDF/XML");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
}
