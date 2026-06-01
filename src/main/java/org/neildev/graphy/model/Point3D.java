package org.neildev.graphy.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import org.neildev.graphy.projection.Animation;
import org.neildev.graphy.projection.Project;
import org.neildev.graphy.render.Renderable;

/**
 * Point3D.
 * Represents a point in 3D space with position and visual size.
 * Acts as the fundamental unit for all 3D geometry in the engine.
 * Used in model space before transformation and projection.
 */
public class Point3D implements Pointable, Renderable {
    private double x;
    private double y;
    private double z;
    private double size;

    /**
     * Constructs a 3D point with position and size.
     *
     * @param x X coordinate in 3D space.
     * @param y Y coordinate in 3D space.
     * @param z Z coordinate in 3D space.
     * @param size Visual size of the point.
     */
    public Point3D(double x, double y, double z, double size) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public void setSize(double size) {
        this.size =size;
    }

    /**
     * Translates the point by offset values.
     *
     * @param x X offset.
     * @param y Y offset.
     * @param z Z offset.
     */
    public void add(double x, double y,double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void subtract(double x, double y,double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    /**
     * Returns string representation of the point.
     *
     * @return Formatted 3D coordinates.
     */
    @Override
    public String toString(){
        return "Point3D [x = " + getX() + ", y = " + getY() + ", z = " + getZ() + "]";
    }

    @Override
    public void render(GraphicsContext g) {
        Point3D point = this;
        Point p = Project.screen(Project.render(Animation.translateZ(point,Animation.pdz)));
        g.fillArc(p.getRenderX(), p.getRenderY(),p.getSize(),p.getSize(),0,360, ArcType.ROUND);
    }
}
