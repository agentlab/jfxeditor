package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.device.ClassFigure;
import ru.agentlab.jfxed.figures.device.Coub;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BootFigures extends Application {
	
	//ClassFigure sourceToMove;
	
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
		final Coub coub = new Coub();
	
		root.getChildren().add(source.getRoot());
		root.getChildren().add(coub.getRoot());
		root.getChildren().add(new VBox());
		Scene scene = new Scene(root, 800, 600);
			
		primaryStage.setScene(scene);
		primaryStage.show();
	

	}
}
