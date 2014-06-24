package org.xtext.example.mydsl;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;

/**
 * A sample that demonstrates two path shapes.
 *
 * @see javafx.scene.shape.Path
 * @see javafx.scene.shape.ArcTo
 * @see javafx.scene.shape.ClosePath
 * @see javafx.scene.shape.CubicCurveTo
 * @see javafx.scene.shape.HLineTo
 * @see javafx.scene.shape.LineTo
 * @see javafx.scene.shape.MoveTo
 * @see javafx.scene.shape.QuadCurveTo
 * @see javafx.scene.shape.VLineTo
 * @see javafx.scene.shape.Shape
 * @see javafx.scene.paint.Color
 */
public class Main extends Application {
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500,300));
        // Create path shape - curves
        Path path1 = new Path();
        path1.getElements().addAll(
        	    new MoveTo(140, 70),
                // Create cloud.
        	    new ArcTo(1, 1, 0, 140, 70, true, true),
                new ArcTo(1, 1, 0, 180, 50, true, true),
                new ArcTo(1, 1, 0, 225, 40, true, true),
                new ArcTo(1, 1, 0, 260, 40, true, true),
                new ArcTo(1, 1, 0, 275, 65, true, true),
                new ArcTo(1, 1, 0, 280, 80, true, true),
                new ArcTo(1, 1, 0, 270, 90, true, true),
                new ArcTo(1, 1, 0, 240, 100, true, true),
                new ArcTo(1, 1, 0, 200, 90, true, true),
                new ArcTo(1, 1, 0, 150, 80, true, true),
                new ArcTo(1, 1, 0, 140, 70, true, true),
                // Create top arrow.
                new MoveTo(180, 5),
        		new LineTo(190, 25),
        		new MoveTo(190, 10),
        		new LineTo(190, 25),
        		new MoveTo(178, 15),
        		new LineTo(190, 25),
        		// Create bottom line.
        		new MoveTo(225, 115),
        		new LineTo(230, 125)	
    );
        Text text = new Text(172, 65, "    Send \n Shippeng list");
        path1.setFill(null);
        path1.setStroke(Color.DODGERBLUE);
        path1.setStrokeWidth(2);

        // show the path shapes;
        root.getChildren().add(new Group(path1));
        root.getChildren().add(text);
     }

    public double getSampleWidth() { return 180; }
    public double getSampleHeight() { return 90; }
 
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
