package org.neildev.graphy.projection;

import org.neildev.graphy.model.Point3D;


/**
 * Animation and Transformation Engine.
 * Provides transformation operations for 3D points including translation and rotation.
 * Controls spatial movement and orientation in world space.
 * Acts as the transformation layer between model space and projection space.
 */
public class Animation {

    /// Experimental
    public static double dz = 3;
    public static double angle = 1;
    public static double pdz = 0;
    public static double pangle = 1;

    /**
     * Translates a point along the Z axis.
     * Moves the point closer or farther from the camera.
     *
     * @param p Original 3D point.
     * @param dz Translation offset.
     * @return New transformed point.
     */
    public static Point3D translateZ(Point3D p, double dz){
        p.setZ(p.getZ()+dz);
        return p;
    }

    /**
     * Rotates a point around the X axis.
     * Affects Y and Z coordinates.
     *
     * @param p Original 3D point.
     * @param angle Rotation angle in radians.
     * @return New rotated point.
     */
    public static Point3D rotateX(Point3D p, double angle){
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        return new Point3D(
                p.getX(),
                (p.getY() * cos) + (p.getZ() * sin),
                (p.getZ() * cos) - (p.getY() * sin),
                p.getSize()
        );
    }

    /**
     * Rotates a point around the Y axis.
     * Affects X and Z coordinates.
     *
     * @param p Original 3D point.
     * @param angle Rotation angle in radians.
     * @return New rotated point.
     */
    public static Point3D rotateY(Point3D p ,double angle){
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        return new Point3D(
                (p.getX() * cos) - (p.getZ() * sin),
                p.getY(),
                (p.getZ() * cos) + (p.getX() * sin),
                p.getSize()
        );
    }

    /**
     * Rotates a point around the Z axis.
     * Affects X and Y coordinates.
     *
     * @param p Original 3D point.
     * @param angle Rotation angle in radians.
     * @return New rotated point.
     */
    public static Point3D rotateZ(Point3D p ,double angle){
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        return new Point3D(
                (p.getX() * cos) - (p.getY() * sin),
                (p.getY() * cos) + (p.getX() * sin),
                p.getZ(),
                p.getSize()
        );
    }

}
