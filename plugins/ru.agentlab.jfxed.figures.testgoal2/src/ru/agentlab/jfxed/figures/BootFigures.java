package ru.agentlab.jfxed.figures;


import ru.agentlab.jfxed.figures.testgoal.TestGoal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BootFigures extends Application {
	
	TestGoal sourceToMove;
	
	double sceneStartX;
	double sceneStartY;
	
	double figureStartTranslateX;
	double figureStartTranslateY;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Test (Sample)");

		AnchorPane root = new AnchorPane();
		
		final TestGoal source = new TestGoal();
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 550, 300);
		//scene.getStylesheets().addAll(ClassFigure.class.getResource("ClassFigure.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		/*source.getRoot().setOnMousePressed(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	            System.out.println("setOnMousePressed");
	            sceneStartX = event.getSceneX();
	            sceneStartY = event.getSceneY();
	            figureStartTranslateX = ((Node) event.getSource()).getTranslateX();
	            figureStartTranslateY = ((Node) event.getSource()).getTranslateY();
	        }
	    });
		
		
		source.getRoot().setOnMouseDragged(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	System.out.println("setOnMouseDragged");
	        	System.out.println(event.getSceneX() + " " + event.getSceneY());
	        	source.getRoot().setTranslateX(figureStartTranslateX + event.getSceneX() - sceneStartX);
	        	source.getRoot().setTranslateY(figureStartTranslateY + event.getSceneY() - sceneStartY);
	        }
	    });*/

	}
}
