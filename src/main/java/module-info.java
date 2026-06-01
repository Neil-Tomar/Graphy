module org.neildev.graphy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.neildev.graphy to javafx.fxml;
    exports org.neildev.graphy;
    exports org.neildev.graphy.app;
}