package application;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

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
                new ArcTo(1, 1, 0, 140, 70, true, true)
                );
        
        Path path2 = new Path();
        path1.getElements().addAll(
        		new MoveTo(185, 5),
        		new LineTo(205, 22)
                );
        
        Path path3 = new Path();
        path1.getElements().addAll(
        		new MoveTo(270, 90),
        		new LineTo(300, 120)
                );
        
        Path path4 = new Path();
        path1.getElements().addAll(
        		new MoveTo(205, 22),
        		new LineTo(203, 8)
                );
        
        Path path5 = new Path();
        path1.getElements().addAll(
        		new MoveTo(205, 22),
        		new LineTo(187, 14)
                );

        Text text = new Text(185, 70, "    Send \n Shippeng list");
        path1.setFill(null);
        path1.setStroke(Color.DODGERBLUE);
        path1.setStrokeWidth(2);

        // show the path shapes;
        root.getChildren().add(new Group(path1, path2, path3, path4, path5));
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