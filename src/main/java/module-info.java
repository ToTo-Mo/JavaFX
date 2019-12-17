module application {
    requires javafx.controls;
    requires javafx.base;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires com.jfoenix;
    requires mysql.connector.java;
    requires java.sql;

    opens application.task.TextInput;
    opens application.task.TextArea;
    opens application.task.Login;
    opens application.task.CheckBox;
    opens application.task.RadioButton;
    opens application.task.ComboBox;
    opens application.task.ListView;
    opens application.task.TabPane;
    opens application.task.MouseEvent;
    opens application.Dialog.ChoiceDialog;
    opens application.Container.ListView;
    opens application.Graphics.Shape;
    opens application.task.Graphics.MouseEvent;
    opens application.Graphics.Image;
    opens application.Pixel.Processing.Lightter;
    opens application.Pixel.Processing.toColorOrGray;
}