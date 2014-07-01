package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.process.ProcessFigure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BootFigures extends Application {
	
	ProcessFigure sourceToMove;
	
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
		
		final ProcessFigure source = new ProcessFigure();
				
		root.getChildren().add(source.getRoot());
		
		Scene scene = new Scene(root, 1000, 600);
		
		primaryStage.setScene(scene);
		primaryStage.show();				
	}
}
