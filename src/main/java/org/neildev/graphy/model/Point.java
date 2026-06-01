package org.neildev.graphy.model;

/**
 * Point (2D).
 * Represents a projected point in screen space.
 * Stores position and visual size used for rendering.
 * Acts as the final representation of a 3D point after projection.
 */
public class Point implements Pointable {
    /// X coordinate in screen space.
    private double x;
    private double y;
    /**
     * Visual size of the point.
     * Used during rendering to determine draw scale.
     */
    private double size;

    /**
     * Constructs a 2D point with position and size.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param size Visual size of the point.
     */
    public Point(double x, double y,double size) {
        this.x = x;
        this.y = y;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    /**
     * Returns adjusted X,Y coordinate for rendering.
     * Centers the point visually based on its size.
     *
     * @return Render-adjusted X position.
     */
    public double getRenderX() {
        return getX() - (size / 2);
    }

    public double getRenderY() {
        return getY() - (size / 2);
    }

    /**
     * Translates the point by offset values.
     *
     * @param x X offset.
     * @param y Y offset.
     */
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    /**
     * Returns string representation of the point.
     *
     * @return Formatted point coordinates.
     */
    @Override
    public String toString(){
        return "Point2D [x = " + getX() + ", y = " + getY() + "]";
    }
}