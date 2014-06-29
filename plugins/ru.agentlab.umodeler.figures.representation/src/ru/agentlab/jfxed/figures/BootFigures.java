package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BootFigures extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Representation!");
 
		AnchorPane root = new AnchorPane();
		final Rectangle rect = new Rectangle();
		root.getChildren().add(rect.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 50, 150);
		primaryStage.setScene(scene);
		primaryStage.show();


	}
}
