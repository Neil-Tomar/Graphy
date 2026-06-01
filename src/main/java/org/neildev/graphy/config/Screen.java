package org.neildev.graphy.config;

/**
 * Screen Configuration.
 * Stores global display and projection settings used by the render engine.
 * Provides centralized access to screen dimensions and camera field of view.
 * Acts as the display and projection configuration layer of the engine.
 */
public class Screen {
    /**
     * Screen width,height in pixels.
     * Defines horizontal,vertical  render boundary.
     */
    private static int width = 1280;
    private static int height = 730;

    /**
     * Field of View (FOV).
     * Controls projection scale and perceived depth.
     * Higher values create wider perspective distortion.
     */
    private static double FOV = 2;

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Screen.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Screen.height = height;
    }

    public static double getFOV() {
        return FOV;
    }

    public static void setFOV(double FOV) {
        Screen.FOV = FOV;
    }

}
