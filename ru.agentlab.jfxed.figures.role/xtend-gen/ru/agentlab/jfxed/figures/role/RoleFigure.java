package ru.agentlab.jfxed.figures.role;

import de.fxdiagram.core.XNode;
import java.net.URL;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import ru.agentlab.jfxed.IFigure;

@SuppressWarnings("all")
public class RoleFigure extends XNode implements IFigure {
  private final Text nameTextBox = new Text();
  
  private String name;
  
  public RoleFigure(final String name) {
    super(name);
    this.name = name;
  }
  
  public RoleFigure() {
    super("Class");
    this.name = "Role";
    Group _group = new Group();
    final Procedure1<Group> _function = new Procedure1<Group>() {
      public void apply(final Group it) {
        ObservableList<String> _stylesheets = it.getStylesheets();
        URL _resource = RoleFigure.class.getResource("RoleFigure.css");
        String _externalForm = _resource.toExternalForm();
        _stylesheets.add(_externalForm);
        ObservableList<Node> _children = it.getChildren();
        Rectangle _rectangle = new Rectangle();
        final Procedure1<Rectangle> _function = new Procedure1<Rectangle>() {
          public void apply(final Rectangle it) {
            ObservableList<String> _styleClass = it.getStyleClass();
            _styleClass.add("role-Rect");
            it.setWidth(340);
            it.setHeight(170);
          }
        };
        Rectangle _doubleArrow = ObjectExtensions.<Rectangle>operator_doubleArrow(_rectangle, _function);
        _children.add(_doubleArrow);
        ObservableList<Node> _children_1 = it.getChildren();
        final Procedure1<Text> _function_1 = new Procedure1<Text>() {
          public void apply(final Text it) {
            ObservableList<String> _styleClass = it.getStyleClass();
            _styleClass.add("role-Text");
            it.setText(RoleFigure.this.name);
            it.setTranslateX(80);
            it.setTranslateY(100);
          }
        };
        Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(RoleFigure.this.nameTextBox, _function_1);
        _children_1.add(_doubleArrow_1);
        ObservableList<Node> _children_2 = it.getChildren();
        Group _group = new Group();
        final Procedure1<Group> _function_2 = new Procedure1<Group>() {
          public void apply(final Group it) {
            ObservableList<Node> _children = it.getChildren();
            Rectangle _rectangle = new Rectangle();
            final Procedure1<Rectangle> _function = new Procedure1<Rectangle>() {
              public void apply(final Rectangle it) {
                ObservableList<String> _styleClass = it.getStyleClass();
                _styleClass.add("role-Rect");
                it.setHeight(22);
                it.setWidth(40);
                it.setArcHeight(20);
                it.setArcWidth(20);
              }
            };
            Rectangle _doubleArrow = ObjectExtensions.<Rectangle>operator_doubleArrow(_rectangle, _function);
            _children.add(_doubleArrow);
            ObservableList<Node> _children_1 = it.getChildren();
            Circle _circle = new Circle();
            final Procedure1<Circle> _function_1 = new Procedure1<Circle>() {
              public void apply(final Circle it) {
                ObservableList<String> _styleClass = it.getStyleClass();
                _styleClass.add("role-Circle");
                it.setRadius(11);
                it.setTranslateX(32);
                it.setTranslateY(11);
              }
            };
            Circle _doubleArrow_1 = ObjectExtensions.<Circle>operator_doubleArrow(_circle, _function_1);
            _children_1.add(_doubleArrow_1);
            it.setTranslateX(285);
            it.setTranslateY(20);
          }
        };
        Group _doubleArrow_2 = ObjectExtensions.<Group>operator_doubleArrow(_group, _function_2);
        _children_2.add(_doubleArrow_2);
      }
    };
    Group _doubleArrow = ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
    this.setNode(_doubleArrow);
    Node _node = this.getNode();
    _node.setScaleX(0.5);
    Node _node_1 = this.getNode();
    _node_1.setScaleY(0.5);
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
