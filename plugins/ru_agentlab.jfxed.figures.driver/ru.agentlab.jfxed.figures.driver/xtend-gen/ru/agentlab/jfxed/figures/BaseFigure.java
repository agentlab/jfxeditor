package ru.agentlab.jfxed.figures;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class BaseFigure {
  protected Pane root;
  
  private double sceneStartX = 0;
  
  private double sceneStartY = 0;
  
  private double figureStartTranslateX = 0;
  
  private double figureStartTranslateY = 0;
  
  private Node node = null;
  
  public Pane getRoot() {
    return this.root;
  }
  
  public void initHandlers() {
    final EventHandler<MouseEvent> _function = new EventHandler<MouseEvent>() {
      public void handle(final MouseEvent event) {
        InputOutput.<String>println("setOnMousePressed");
        double _sceneX = event.getSceneX();
        BaseFigure.this.sceneStartX = _sceneX;
        double _sceneY = event.getSceneY();
        BaseFigure.this.sceneStartY = _sceneY;
        Object _source = event.getSource();
        BaseFigure.this.node = ((Node) _source);
        double _translateX = BaseFigure.this.node.getTranslateX();
        BaseFigure.this.figureStartTranslateX = _translateX;
        double _translateY = BaseFigure.this.node.getTranslateY();
        BaseFigure.this.figureStartTranslateY = _translateY;
      }
    };
    this.root.setOnMousePressed(_function);
    final EventHandler<MouseEvent> _function_1 = new EventHandler<MouseEvent>() {
      public void handle(final MouseEvent event) {
        InputOutput.<String>println("setOnMouseDragged");
        double _sceneX = event.getSceneX();
        String _plus = (Double.valueOf(_sceneX) + " ");
        double _sceneY = event.getSceneY();
        String _plus_1 = (_plus + Double.valueOf(_sceneY));
        InputOutput.<String>println(_plus_1);
        double _sceneX_1 = event.getSceneX();
        double _plus_2 = (BaseFigure.this.figureStartTranslateX + _sceneX_1);
        double _minus = (_plus_2 - BaseFigure.this.sceneStartX);
        BaseFigure.this.root.setTranslateX(_minus);
        double _sceneY_1 = event.getSceneY();
        double _plus_3 = (BaseFigure.this.figureStartTranslateY + _sceneY_1);
        double _minus_1 = (_plus_3 - BaseFigure.this.sceneStartY);
        BaseFigure.this.root.setTranslateY(_minus_1);
      }
    };
    this.root.setOnMouseDragged(_function_1);
  }
}
