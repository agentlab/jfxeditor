package ru.agentlab.jfxed.figures.driver

import de.fxdiagram.core.XNode
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import javafx.scene.shape.Line
import javafx.scene.shape.Polyline
import javafx.scene.text.Text
import javafx.scene.Group
import javafx.scene.text.TextAlignment
import ru.agentlab.jfxed.IFigure

class Driver extends XNode implements IFigure {
	
	val nameTextBox = new Text
	var String name

	new(String name) {
		super(name)
		this.name = name
	}
	new (){
		
		super("Class");
		
		name = "Driver";	
		// Основной прямоугольник
		node = new Group => [
			stylesheets += Driver.getResource("Driver.css").toExternalForm()
			styleClass += "ClassFigure";
			// Задаём размеры
			prefHeight(80.0)
			prefWidth(120.0)
			// Массив вершин фигуры
			val Double[] p = #[0.0,10.0,10.0,0.0,170.0,0.0,180.0,10.0,180.0,70.0,170.0,80.0,10.0,80.0,0.0,70.0,0.0,10.0]
			// Отрисовываем линии и заливаем
			children += new Polyline => [
				points.addAll(p)
				fill = Paint.valueOf("#ffccff")
			]
			// Рисуем надпись
			children += nameTextBox => [
				styleClass += "ClassFigure-Text"
				text = name
				x = 70
				y = 40
				textAlignment = TextAlignment.CENTER
			]
			// Дальше рисуем иконку
			// Наружная часть круга
			children += new Circle => [
				centerX = 160
				centerY = 20
				radius = 9
			]
			// Внутренняя часть круга
			children += new Circle => [
				centerX = 160
				centerY = 20
				radius = 7
				fill = Paint.valueOf("#ffccff")
			]
			// Четыре пересекающиеся линии значка
			children += new Line => [
				startX = 150
				startY = 20
				endX = 170
				endY = 20
			]
			children += new Line => [
				startX = 160
				startY = 10
				endX = 160
				endY = 30
			]
			children += new Line => [
				startX = 153
				startY = 13
				endX = 167
				endY = 27
			]
			children += new Line => [
				startX = 153
				startY = 27
				endX = 167
				endY = 13
			]
			]
		
	}
	
	override setName(String name) {
		nameTextBox.text = name
	}

	def getName() {
		nameTextBox.text
	}
	override getRoot() {
		return this
	}	
}
