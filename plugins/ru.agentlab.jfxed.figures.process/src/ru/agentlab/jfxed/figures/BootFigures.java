package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.ClassArrow;
import ru.agentlab.jfxed.figures.clazz.ClassFigure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BootFigures extends Application {
	
	ClassFigure sourceToMove;
	
	double sceneStartX;
	double sceneStartY;
	double figureStartTranslateX;
	double figureStartTranslateY;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");

		AnchorPane root = new AnchorPane();
		
		final ClassFigure source = new ClassFigure();
		final ClassArrow arrow = new ClassArrow();
				
		root.getChildren().add(source.getRoot());
		root.getChildren().add(arrow.getRoot());
		
		Scene scene = new Scene(root, 1000, 600);
		
		primaryStage.setScene(scene);
		primaryStage.show();				
	}
}
