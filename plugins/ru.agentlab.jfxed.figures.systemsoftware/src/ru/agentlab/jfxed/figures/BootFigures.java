package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.LineFig;
import ru.agentlab.jfxed.figures.clazz.Rectangle;
import ru.agentlab.jfxed.figures.clazz.Coub;
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
		primaryStage.setTitle("System Software");

		AnchorPane root = new AnchorPane();
		
		final Rectangle rect = new Rectangle();
		final Coub coub = new Coub();
		root.getChildren().add(rect.getRoot());
		root.getChildren().add(coub.getRoot());
		
		Scene scene = new Scene(root, 400, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
}
