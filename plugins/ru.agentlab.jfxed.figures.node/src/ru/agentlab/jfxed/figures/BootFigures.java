package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.node.Rectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BootFigures extends Application {
		
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");

		AnchorPane root = new AnchorPane();
		
		final Rectangle rect = new Rectangle();
		root.getChildren().add(rect.getRoot());
		
		Scene scene = new Scene(root, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
}
