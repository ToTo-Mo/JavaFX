module application {
    requires javafx.controls;
    requires javafx.base;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires com.jfoenix;
    requires mysql.connector.java;
    requires java.sql;

    exports TestServer;

    exports application;
    exports application.Container.ListView;
    exports application.task;
    exports application.task.TextInput;
    exports application.task.TextArea;
    exports application.task.Login;
    exports application.task.CheckBox;
    exports application.task.ComboBox;
    exports application.task.RadioButton;
    exports application.task.ListView;
    exports application.task.TabPane;
    exports application.ResizingOfChildNodes;
    exports application.AligningOfChildNodes;
    exports application.UsingCSS;
    exports application.EventDrivenGUI;
    exports application.Mouse;

    opens application.task.TextInput to javafx.fxml;
    opens application.task.TextArea to javafx.fxml;
    opens application.task.Login to javafx.fxml;
    opens application.task.CheckBox to javafx.fxml;
    opens application.task.RadioButton to javafx.fxml;
    opens application.task.ComboBox to javafx.fxml;
    opens application.task.ListView to javafx.fxml;
    opens application.task.TabPane to javafx.fxml;

    opens application.Container.ListView to javafx.fxml;
}