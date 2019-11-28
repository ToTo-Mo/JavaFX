module application {
    requires javafx.controls;
    requires javafx.base;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires com.jfoenix;

    exports application;
    exports application.task;
    exports application.task.TextInput;
    exports application.task.TextArea;
    exports application.task.Login;
    exports application.task.CheckBox;
    exports application.task.RadioButton;
    exports application.ResizingOfChildNodes;
    exports application.AligningOfChildNodes;
    exports application.UsingCSS;
    exports application.EventDrivenGUI;

    opens application.task.TextInput to javafx.fxml;
    opens application.task.TextArea to javafx.fxml;
    opens application.task.Login to javafx.fxml;
    opens application.task.CheckBox to javafx.fxml;
    opens application.task.RadioButton to javafx.fxml;
    
}