package org.neildev.graphy.window;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import org.neildev.graphy.model.Point3D;
import org.neildev.graphy.object.Cube;
import org.neildev.graphy.render.Render;

/**
 * Render View.
 * Provides the rendering surface for drawing graphics using a Canvas.
 * Manages the render loop and delegates rendering operations to the Render engine.
 * Acts as the visual output layer of the application.
 */
public class RenderView extends Pane {
    private final Canvas canvas;
    private final GraphicsContext g;
    private Render render;

    Point3D p = new Point3D(0,0,-1,5);

    /**
     * Constructs the RenderView.
     * Initializes the Canvas, binds its size to the container, and sets the background.
     */
    public RenderView (){
        canvas = new Canvas();
        g = canvas.getGraphicsContext2D();

        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        setStyle("-fx-background-color: black");
    }

    /**
     * Starts the rendering system.
     * Initializes the Render engine, adds objects, and starts the render loop.
     */
    public void start(){
        /// Adds canvas to the scene graph.
        this.getChildren().add(canvas);

        /// Initialize render engine with canvas and graphics context.
        render = new Render(canvas ,g);

        //Add Cube to render
        render.addObject(new Cube());
        render.addObject(p);


        /*
          AnimationTimer acts as the main render loop.
          Executes once per frame and updates the render engine.
         */
        var timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        /// Starts the render loop.
        timer.start();

    }

    /**
     * Called every frame by the render loop.
     * Delegates update and render operations to the Render engine.
     */
    private void onUpdate(){

//        System.out.println(p.getZ());
//        if(p.getZ() >2){
//            p.setZ(-0.6);
//            Animation.pdz =0;
//        }
        render.onUpdate();
    }


}
