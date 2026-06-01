package org.neildev.graphy.window;

import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

/**
 * Main Window.
 * Defines the primary layout structure of the application.
 * Contains the RenderView for graphics rendering and the ControlPanel for user interaction.
 * Acts as the root container for the main application scene.
 */
public class MainWindow extends BorderPane {

    /**
     * RenderView.
     * Responsible for rendering graphics and running the render loop.
     */
    private final RenderView renderView;

    /**
     * ControlPanel.
     * Provides UI controls and interaction components for the application.
     */
    private final ControlPanel controlPanel;

    public MainWindow() {


        // Initialize rendering surface & ControlPane;
        renderView = new RenderView();
        controlPanel = new ControlPanel();
        // Sets the preferred window size.
        setPrefSize(800,500);

        /*
          SplitPane separates the render area and control panel.
          Allows dynamic resizing between rendering and UI sections.
          Loads application stylesheet for UI styling.
          Adds RenderView (left) and ControlPanel (right) to the layout.
          Sets the initial divider position.
          75% render area, 25% control panel.
         */
        SplitPane splitPane = new SplitPane();
        splitPane.getStylesheets().add(getClass().getResource("/org/neildev/graphy/application.css").toExternalForm());
        splitPane.getItems().addAll(renderView, controlPanel);
        splitPane.setDividerPositions(0.75);

        /// Places the SplitPane at the center of the BorderPane layout.
        setCenter(splitPane);
    }

    /**
     * Starts the MainWindow.
     * Initializes the RenderView and returns this as the root node.
     *
     * @return The root Parent node for the application scene.
     */
    public Parent start() {
        renderView.start();
        return this;
    }
}