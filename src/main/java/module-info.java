module application {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.jfoenix;

    exports application;
    exports application.task;
    exports application.ResizingOfChildNodes;
    exports application.AligningOfChildNodes;
    exports application.UsingCSS;
    exports application.EventDrivenGUI;
}