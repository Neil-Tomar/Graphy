package org.neildev.graphy.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import org.neildev.graphy.model.Point;
import org.neildev.graphy.model.Point3D;
import org.neildev.graphy.projection.Animation;
import org.neildev.graphy.projection.Project;
import org.neildev.graphy.render.Renderable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Cube Object.
 * This class need to Reformated will do it in the Future.
 * Represents a 3D cube composed of vertices and edges.
 * Implements the Renderable interface to allow rendering through the Render engine.
 * Responsible for defining cube geometry and handling its own rendering logic.
 */
public class Cube implements Renderable {
    /// Cube center X,Y position (reserved for future transformations).
    private int cX;
    private int cY;

    /**
     * List of cube vertices defined in 3D space.
     * Each Point3D represents a corner of the cube.
     */
    public ArrayList<Point3D> cube = new ArrayList<>(Arrays.asList(
            new Point3D(0.7,0.7,0.7 ,25),              //0
            new Point3D(0.7,-0.7,0.7 ,25),             //1
            new Point3D(-0.7,-0.7,0.7 ,25),            //2
            new Point3D(-0.7,0.7,0.7 ,25),             //3

            new Point3D(0.7,0.7,-0.7 ,25),             //4
            new Point3D(0.7,-0.7,-0.7 ,25),            //5
            new Point3D(-0.7,-0.7,-0.7 ,25),           //6
            new Point3D(-0.7,0.7,-0.7 ,25)             //7
            ));


    /**
     * Defines cube edges using vertex indices.
     * Each pair represents a line connecting two vertices.
     */
    private final int[][] edges = {
            // Front face
            {0,1},{1,2},{2,3},{3,0},
            // Back face
            {4,5},{5,6},{6,7},{7,4},
            // Connecting edges
            {0,4},{1,5},{2,6},{3,7}
    };


    /**
     * Returns the list of cube vertices.
     *
     * @return List of cube points in 3D space.
     */
    public List<Point3D> renderCubePoints (){
        return cube;
    }

    /**
     * Generates cube line data (experimental / debugging method).
     *
     * @return List of cube edge lines.
     */
    public List<ArrayList<Point3D>> renderCubeLines (){
        var line = new ArrayList<ArrayList<Point3D>>();
        var lines = getCubeLines();
        for(var i : lines){
            System.out.println(i);
        }
        return line;
    }

    /**
     * Constructs cube edges using vertex references.
     * Converts edge index pairs into actual Point3D line segments.
     *
     * @return List of line segments representing cube edges.
     */
    public List<ArrayList<Point3D>> getCubeLines(){
        ArrayList<Point3D> coordinates = new ArrayList<>();
        coordinates.addAll(cube);
        ArrayList<ArrayList<Point3D>> lines = new ArrayList<>();

        for( var i : edges){
            lines.add(new ArrayList<>(Arrays.asList(cube.get(i[0]), cube.get(i[1]))));
        }

        return lines;
    }

    /**
     * Render method called every frame by the Render engine.
     * Applies transformations, projection, and draws the cube.
     * Rendering pipeline:
     * 3D Model → Rotation → Translation → Projection → Screen → Render
     *
     * @param g GraphicsContext used for drawing operations.
     */
    @Override
    public void render(GraphicsContext g) {
        Cube c = new Cube();

        var lines = c.getCubeLines();

        g.setStroke(Color.LAWNGREEN);
        g.setFill(Color.LAWNGREEN);

        for(var i : cube){
            Point p = Project.screen(Project.render(Animation.translateZ(Animation.rotateX(i,Animation.angle),Animation.dz)));
            g.fillArc(p.getRenderX(), p.getRenderY(),p.getSize(),p.getSize(),0,360, ArcType.ROUND);
        }

        for(var line : lines){
            var l1 =line.get(0);
            var l2 = line.get(1);
            Point p1 = Project.screen(Project.render(Animation.translateZ(Animation.rotateX(l1,Animation.angle),Animation.dz)));
            Point p2 = Project.screen(Project.render(Animation.translateZ(Animation.rotateX(l2,Animation.angle),Animation.dz)));
            g.strokeLine(p1.getX() , p1.getY(), p2.getX(), p2.getY());
        }

    }
}
