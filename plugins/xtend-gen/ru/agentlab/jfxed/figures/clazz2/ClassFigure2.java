package ru.agentlab.jfxed.figures.clazz2;

import java.net.URL;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import ru.agentlab.jfxed.figures.BaseFigure;

@SuppressWarnings("all")
public class ClassFigure2 extends BaseFigure {
  private String name = "";
  
  public ClassFigure2() {
    VBox _vBox = new VBox();
    this.root = _vBox;
    this.initHandlers();
    URL _resource = ClassFigure2.class.getResource("ClassFigure2.css");
    final String s = _resource.toExternalForm();
    ObservableList<String> _stylesheets = this.root.getStylesheets();
    _stylesheets.add(s);
    ObservableList<String> _styleClass = this.root.getStyleClass();
    _styleClass.add("ClassFigure2");
    ObservableList<Node> _children = this.root.getChildren();
    HBox _hBox = new HBox();
    final Procedure1<HBox> _function = new Procedure1<HBox>() {
      public void apply(final HBox it) {
        ObservableList<String> _styleClass = it.getStyleClass();
        _styleClass.add("ClassFigure2-Name-Section");
        ObservableList<Node> _children = it.getChildren();
        Text _text = new Text();
        final Procedure1<Text> _function = new Procedure1<Text>() {
          public void apply(final Text it) {
            it.setText(ClassFigure2.this.name);
            ObservableList<String> _styleClass = it.getStyleClass();
            _styleClass.add("ClassFigure2-Text");
          }
        };
        Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_text, _function);
        _children.add(_doubleArrow);
      }
    };
    HBox _doubleArrow = ObjectExtensions.<HBox>operator_doubleArrow(_hBox, _function);
    _children.add(_doubleArrow);
  }
}
