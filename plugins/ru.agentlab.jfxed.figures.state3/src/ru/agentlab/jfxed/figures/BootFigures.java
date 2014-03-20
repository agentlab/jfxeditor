package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.ClassFigure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BootFigures extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public double initSizeX = 760;
	public double initSizeY = 550;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("[Lab 2]");

			AnchorPane root = new AnchorPane();
			final ClassFigure source = new ClassFigure();
			root.getChildren().add(source.getRoot());
			root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, initSizeX, initSizeY);
		primaryStage.setScene(scene);
		
//		primaryStage.setMinWidth(200);
//		primaryStage.setMinHeight(160);
//		primaryStage.setMaxWidth(760);
//		primaryStage.setMaxHeight(550);
		
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
