package ru.agentlab.jfxed.figures.requirement
import de.fxdiagram.core.XNode
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import ru.agentlab.jfxed.IFigure

class ClassFigure extends XNode implements IFigure {

	//var String name = " REQ017- \n Remove User"
	//String name2 = "E"
	var GridPane gp
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}

	new() {
		super("Class")

		name = "Class"
		
		gp = new GridPane
		node = gp
		val smallbox = new HBox
		val pane = new GridPane

		val s = ClassFigure.getResource("ClassPass.css").toExternalForm()
		smallbox.stylesheets += s

		val p = new Polyline => [
			points += 50d;
			points += 0d;
			points += 50d;
			points += 104d;
			styleClass += "ClassPolyline"
		]

		val p2 = new Polyline => [
			points += 50d;
			points += 0d;
			points += 50d;
			points += 124d;
			styleClass += "ClassPolyline2"
		]

		val p3 = new Polyline => [
			points += 50d;
			points += 0d;
			points += 50d;
			points += 126d;
			styleClass += "ClassPolyline3"
		]
		val p4 = new Polyline => [
			points += 50d;
			points += 0d;
			points += 50d;
			points += 127d;
			styleClass += "ClassPolyline4"
		]

		val pq = new Polyline => [
			points += 0d;
			points += 300d;
			points += 5d;
			points += 300d;
			styleClass += "ClassPolyline4"
		]
		val pt = new Polyline => [
			points += 20d;
			points += 10d;
			points += 10d;
			points += 15d;
			points += 20d;
			points += 20d;
			styleClass += "ClassPolyline4"
		]

		smallbox.children += p
		smallbox.children += p2
		smallbox.children += p3
		smallbox.children += p4
		children += nameTextBox => [
					text = name
					styleClass += "ClassFigure-Text"
				]

		smallbox.children += pane

		smallbox.styleClass += "ClassPass";
		gp.add(pq, 0, 1)
		gp.add(smallbox, 1, 1)
		gp.add(pt, 2, 1)

		//pane.add(p, 0,0);
		/*val text1 = new Text => [
			text = name
			styleClass += "ClassFigure-Text2"
		]*/
		
		/* 
		val text1 = new Text => [
			text = name
			styleClass += "ClassFigure-Text"
		]
		pane.add(text1, 1, 1);*/
		//pane.add(text2, 2, 0);
	}
	def setName(String name) {
		nameTextBox.text = name
	}
	
	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		return this
	}
}
