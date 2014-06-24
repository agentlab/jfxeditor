package ru.agentlab.jfxed.figures.clazz.tests;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.agentlab.jfxed.figures.clazz.ClassFigure;

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
		
		final ClassFigure source = new ClassFigure("sdfsf");
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 800, 600);
		//scene.getStylesheets().addAll(ClassFigure.class.getResource("ClassFigure.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
