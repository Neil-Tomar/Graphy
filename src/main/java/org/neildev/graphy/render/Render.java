package org.neildev.graphy.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.neildev.graphy.projection.Animation;

import java.util.ArrayList;

/*
Experimental (I used these in earlier version now they have been refactored)

import javafx.scene.shape.ArcType;
import org.neildev.graphy.model.Point;
import org.neildev.graphy.model.Point3D;
import org.neildev.graphy.object.Cube;
import org.neildev.graphy.projection.Project;
*/

/**
 * Render Engine.
 * Manages the render pipeline and handles drawing of all renderable objects.
 * Responsible for clearing the screen, rendering objects, and updating animation state.
 * Acts as the core rendering layer between objects and the graphics surface.
 */
public class Render {
    private Canvas canvas;
    private GraphicsContext g;

    /**
     * List of all objects registered for rendering.
     * Each object must implement the Renderable interface.
     */
    private ArrayList<Renderable> objects = new ArrayList<>();

    /**
     * Constructs the Render engine.
     * Links the rendering surface and graphics context.
     *
     * @param canvas The canvas used for rendering output.
     * @param g The graphics context used for drawing operations.
     */
    public Render(Canvas canvas ,GraphicsContext g){
       this.canvas =canvas;
       this.g = g;
    }

    /**
     * Registers a renderable object to the render pipeline.
     * The object will be updated and rendered every frame.
     *
     * @param obj The object to add to the render pipeline.
     */
    public void addObject(Renderable obj){
        objects.add(obj);
    }

    /**
     * Called once per frame by the render loop.
     * Clears the screen, renders all objects, and updates animation state.
     */
    public void onUpdate(){
        /// Clears the entire canvas.
        /// Prepares the frame for fresh rendering.
        clear();


        /// Renders all registered objects.
        /// Each object handles its own transformation and drawing logic.
        for(var i : objects){
            i.render(g);
        }

        /// Updates animation and transformation values.
        updateValues();
    }


    private void clear(){
        g.setFill(Color.BLACK);
        g.fillRect(0,0, canvas.getWidth(),canvas.getHeight());

    }

    /**
     * Updates global animation parameters.
     * Controls rotation, translation, and other transformation effects.
     */
    private void updateValues(){
        /*
        Going away -> increase
        Animation.angle += 95.03321;
        Animation.angle += 1.5707;
        Animation.angle += 272.795;
        */
        Animation .angle += 0.01;
//        Animation.pdz += 0.0001;
    }
}
