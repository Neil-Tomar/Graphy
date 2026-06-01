package org.neildev.graphy.render;

import javafx.scene.canvas.GraphicsContext;

/**
 * Renderable Interface.
 * Defines the contract for all objects that can be rendered by the Render engine.
 * Any class implementing this interface can be registered and drawn in the render pipeline.
 * Acts as the base abstraction for all renderable objects in the application.
 */
public interface Renderable {
    /**
     * Called every frame by the Render engine.
     * Responsible for rendering the object using the provided GraphicsContext.
     *
     * @param g The graphics context used for drawing operations.
     */
    void render(GraphicsContext g);
}
