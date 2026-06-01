package org.neildev.graphy.projection;

import org.neildev.graphy.config.Screen;
import org.neildev.graphy.model.Point;
import org.neildev.graphy.model.Point3D;

/**
 * Handles 3D → 2D projection and 2D → Screen transformation.
 * This class need to be reformated
 */
public class Project {

    /**
     * Converts a 3D point into normalized 2D space using perspective projection.
     */
    public static Point render(Point3D point3D){
        double x= (point3D.getX()* Screen.getFOV())/( point3D.getZ());
        double y= (point3D.getY()*Screen.getFOV())/( point3D.getZ());
        double size = (point3D.getSize()*Screen.getFOV())/ point3D.getZ();
        return new Point(x,y,size);
    }

    /**
     * Converts normalized coordinates (-1 to +1) into actual screen pixels.
     */
    public static Point screen(Point point){
        // 1...1 -> 0...2 -> 0...1 -> 0...h/w
        double width = 730;
        double height = 730;

        double screenX = ((point.getX() + 1) / 2) * width;
        double screenY = (1 - ((point.getY() + 1) / 2)) * height;


        return new Point(screenX,screenY,point.getSize());
    }

}
