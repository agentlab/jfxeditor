package ru.agentlab.jfxed.figures.driver;

import de.fxdiagram.core.XNode;
import java.net.URL;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import ru.agentlab.jfxed.IFigure;

@SuppressWarnings("all")
public class Driver extends XNode implements IFigure {
  private final Text nameTextBox = new Text();
  
  private String name;
  
  public Driver(final String name) {
    super(name);
    this.name = name;
  }
  
  public Driver() {
    super("Class");
    this.name = "Driver";
    Group _group = new Group();
    final Procedure1<Group> _function = new Procedure1<Group>() {
      public void apply(final Group it) {
        ObservableList<String> _stylesheets = it.getStylesheets();
        URL _resource = Driver.class.getResource("Driver.css");
        String _externalForm = _resource.toExternalForm();
        _stylesheets.add(_externalForm);
        ObservableList<String> _styleClass = it.getStyleClass();
        _styleClass.add("ClassFigure");
        it.prefHeight(80.0);
        it.prefWidth(120.0);
        final Double[] p = { Double.valueOf(0.0), Double.valueOf(10.0), Double.valueOf(10.0), Double.valueOf(0.0), Double.valueOf(170.0), Double.valueOf(0.0), Double.valueOf(180.0), Double.valueOf(10.0), Double.valueOf(180.0), Double.valueOf(70.0), Double.valueOf(170.0), Double.valueOf(80.0), Double.valueOf(10.0), Double.valueOf(80.0), Double.valueOf(0.0), Double.valueOf(70.0), Double.valueOf(0.0), Double.valueOf(10.0) };
        ObservableList<Node> _children = it.getChildren();
        Polyline _polyline = new Polyline();
        final Procedure1<Polyline> _function = new Procedure1<Polyline>() {
          public void apply(final Polyline it) {
            ObservableList<Double> _points = it.getPoints();
            _points.addAll(p);
            Paint _valueOf = Paint.valueOf("#ffccff");
            it.setFill(_valueOf);
          }
        };
        Polyline _doubleArrow = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function);
        _children.add(_doubleArrow);
        ObservableList<Node> _children_1 = it.getChildren();
        final Procedure1<Text> _function_1 = new Procedure1<Text>() {
          public void apply(final Text it) {
            ObservableList<String> _styleClass = it.getStyleClass();
            _styleClass.add("ClassFigure-Text");
            it.setText(Driver.this.name);
            it.setX(70);
            it.setY(40);
            it.setTextAlignment(TextAlignment.CENTER);
          }
        };
        Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(Driver.this.nameTextBox, _function_1);
        _children_1.add(_doubleArrow_1);
        ObservableList<Node> _children_2 = it.getChildren();
        Circle _circle = new Circle();
        final Procedure1<Circle> _function_2 = new Procedure1<Circle>() {
          public void apply(final Circle it) {
            it.setCenterX(160);
            it.setCenterY(20);
            it.setRadius(9);
          }
        };
        Circle _doubleArrow_2 = ObjectExtensions.<Circle>operator_doubleArrow(_circle, _function_2);
        _children_2.add(_doubleArrow_2);
        ObservableList<Node> _children_3 = it.getChildren();
        Circle _circle_1 = new Circle();
        final Procedure1<Circle> _function_3 = new Procedure1<Circle>() {
          public void apply(final Circle it) {
            it.setCenterX(160);
            it.setCenterY(20);
            it.setRadius(7);
            Paint _valueOf = Paint.valueOf("#ffccff");
            it.setFill(_valueOf);
          }
        };
        Circle _doubleArrow_3 = ObjectExtensions.<Circle>operator_doubleArrow(_circle_1, _function_3);
        _children_3.add(_doubleArrow_3);
        ObservableList<Node> _children_4 = it.getChildren();
        Line _line = new Line();
        final Procedure1<Line> _function_4 = new Procedure1<Line>() {
          public void apply(final Line it) {
            it.setStartX(150);
            it.setStartY(20);
            it.setEndX(170);
            it.setEndY(20);
          }
        };
        Line _doubleArrow_4 = ObjectExtensions.<Line>operator_doubleArrow(_line, _function_4);
        _children_4.add(_doubleArrow_4);
        ObservableList<Node> _children_5 = it.getChildren();
        Line _line_1 = new Line();
        final Procedure1<Line> _function_5 = new Procedure1<Line>() {
          public void apply(final Line it) {
            it.setStartX(160);
            it.setStartY(10);
            it.setEndX(160);
            it.setEndY(30);
          }
        };
        Line _doubleArrow_5 = ObjectExtensions.<Line>operator_doubleArrow(_line_1, _function_5);
        _children_5.add(_doubleArrow_5);
        ObservableList<Node> _children_6 = it.getChildren();
        Line _line_2 = new Line();
        final Procedure1<Line> _function_6 = new Procedure1<Line>() {
          public void apply(final Line it) {
            it.setStartX(153);
            it.setStartY(13);
            it.setEndX(167);
            it.setEndY(27);
          }
        };
        Line _doubleArrow_6 = ObjectExtensions.<Line>operator_doubleArrow(_line_2, _function_6);
        _children_6.add(_doubleArrow_6);
        ObservableList<Node> _children_7 = it.getChildren();
        Line _line_3 = new Line();
        final Procedure1<Line> _function_7 = new Procedure1<Line>() {
          public void apply(final Line it) {
            it.setStartX(153);
            it.setStartY(27);
            it.setEndX(167);
            it.setEndY(13);
          }
        };
        Line _doubleArrow_7 = ObjectExtensions.<Line>operator_doubleArrow(_line_3, _function_7);
        _children_7.add(_doubleArrow_7);
      }
    };
    Group _doubleArrow = ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
    this.setNode(_doubleArrow);
  }
  
  public void setName(final String name) {
    this.nameTextBox.setText(name);
  }
  
  public String getName() {
    return this.nameTextBox.getText();
  }
  
  public XNode getRoot() {
    return this;
  }
}
