package org.neildev.graphy.app;

import javafx.application.Application;

/**
 * Entry point for the JavaFX application.
 * This class exists to launch the JavaFX runtime from a standard
 * Java main() method. This is especially useful when using build tools
 * like Maven/Gradle or when separating launcher logic from UI logic.
 * JavaFX requires Application.launch(...) to bootstrap:
 *  - JavaFX runtime initialization
 *  - JavaFX Application Thread creation
 *  - Invocation of the start(Stage) method in the specified class
 */

public class Launcher {

    /**
     * Main method — standard JVM entry point.
     * Delegates control to the JavaFX runtime by launching
     * the specified Application subclass.
     * NOTE:
     * WindowInitialize Class must extend javafx.application.Application.
     * args are forwarded to the JavaFX runtime and can be accessed via:
     * getParameters() inside the Application subclass.
     */
    public static void main(String[] args) {


        // Alternative launcher (disabled):
//         Application.launch(HelloApplication.class, args);


        // Launches the JavaFX application.
        // This call blocks until the application exits.
        Application.launch(WindowInitialize.class,args);
    }
}
