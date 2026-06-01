package org.neildev.graphy.window;

import javafx.scene.layout.Pane;

/**
 * Control Panel.
 * Provides a dedicated area for user interface controls and interaction components.
 * Intended for managing application settings, parameters, and debugging tools.
 * Acts as the input and control layer of the application.
 */
public class ControlPanel extends Pane {
    public ControlPanel() {

        setStyle("-fx-background-color: #111;");
        setMinWidth(200);
        setPrefWidth(300);
    }
}
