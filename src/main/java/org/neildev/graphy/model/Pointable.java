package org.neildev.graphy.model;

/**
 * Pointable Interface.
 * Defines the contract for objects that represent a point with position and size.
 * Provides abstraction for accessing and modifying spatial properties.
 * Acts as the base interface for all point-based model objects.
 */
public interface Pointable {
    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    double getSize();

    void setSize(double size);

}
