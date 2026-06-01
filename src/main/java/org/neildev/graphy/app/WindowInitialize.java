package org.neildev.graphy.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.neildev.graphy.window.MainWindow;


/* Experimental (I used these in earlier version now they have been refactored)
  import javafx.animation.AnimationTimer;
  import javafx.scene.Parent;
  import javafx.scene.canvas.Canvas;
  import javafx.scene.canvas.GraphicsContext;
  import javafx.scene.layout.Pane;
  import javafx.scene.shape.ArcType;
  import org.neildev.graphy.object.Cube;
  import org.neildev.graphy.model.Point;
  import org.neildev.graphy.projection.Project;
  import org.neildev.graphy.config.Screen;
*/

/**
 * Window Initializer.
 * Creates the primary JavaFX window (Stage) and attaches the MainWindow scene to it.
 * Acts as the bridge between the JavaFX runtime and the application window system.
 */

public class WindowInitialize extends Application {

/*
 Experimental
    private Canvas canvas;
    private GraphicsContext g;
*/


    /**
     * JavaFX entry point.
     * Called automatically by the JavaFX runtime after Application.launch().
     * Responsible for creating and configuring the main application window.
     *
     * @param stage The primary stage provided by the JavaFX runtime.
     */

    @Override
    public void start(Stage stage) throws Exception {
        /*
          Creates the main scene using MainWindow as the root container.
          MainWindow defines the layout and rendering structure.
         */
        Scene scene = new Scene(new MainWindow().start());

        /// Sets the background color of the scene.
        /// Attaches the scene to the primary window.
        ///  Launches the window in maximized mode.
        ///  Sets the window title.
        ///  Displays the window and starts the JavaFX rendering lifecycle.
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("3D Graph");
//        stage.setOpacity(0.7);
        stage.show();
    }


    // Experimental

//    private Parent createContent() {
//        canvas = new Canvas(Screen.getWidth(), Screen.getHeight());
//        g = canvas.getGraphicsContext2D();
//
//        var root = new Pane();
//        root.setPrefSize(Screen.getWidth(), Screen.getHeight());
//
//        var leftPane = new Pane();
//        leftPane.setPrefSize(Screen.getHeight(), Screen.getHeight());
//
//        leftPane.getChildren().add(canvas);
//
//        var rightPane = new Pane();
//        leftPane.setPrefSize(560, Screen.getHeight());
//
//        root.getChildren().add(leftPane);
//        root.getChildren().add(rightPane);
//
//        var timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                onUpdate();
//            }
//        };
//
//        timer.start();
//
//        return root;
//    }
//
//    private void onUpdate(){
//        g.setFill(Color.BLACK);
//        g.fillRect(0,0,Screen.getHeight(),Screen.getHeight());
//        g.setFill(Color.gray(0.1));
//        g.fillRect(Screen.getHeight(),0,2048,Screen.getHeight());
//        g.setFill(Color.LAWNGREEN);
//
//
//
//        Cube c = new Cube();
//
//        for(var i : c.cube){
//            Point p = Project.screen(Project.render(Project.translateZ(i,Project.dz)));
//            g.fillArc(p.getRenderX(), p.getRenderY(),p.getSize(),p.getSize(),0,360, ArcType.ROUND);
//        }
//
//        for (int i = 0; i < c.cube.size(); i++) {
//            var a = c.cube.get(i%c.cube.size());
//            var b = c.cube.get(i%c.cube.size());
//
//            g.strokeLine(a.getX(),a.getY(),b.getX(),b.getY());
//
//        }
//
//        Project.dz += 0.01;
//           g.fillArc(p.getRenderX(), p.getRenderY(),p.getSize(),p.getSize(),0,360, ArcType.ROUND);
//    }
}
