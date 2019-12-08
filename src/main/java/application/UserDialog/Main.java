package application.UserDialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainWindow main = new MainWindow(primaryStage);
        main.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MainWindow {
    Stage mainStage;

    public MainWindow(Stage primaryStage) {
        StackPane root = new StackPane();
        Button button = new Button("xxx");
        root.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                MyDialog dlg = new MyDialog(primaryStage);
                String res;

                if (!(res = dlg.showDialog()).equals("")){
                    System.out.println("helloworld");
                    button.setText(res);
                }

            }
        });

        Scene scene = new Scene(root, 200, 200);

        primaryStage.setScene(scene);
        mainStage = primaryStage;
    }

    public void show() {
        mainStage.show();
    }
}

class MyDialog extends Stage {
    private String findString = "";
    MyDialog me;

    public MyDialog(Stage primaryStage) {
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(primaryStage);
        this.setTitle("찾기");

        FlowPane pane = new FlowPane();
        Label lbl = new Label("Find");
        TextField txt = new TextField();
        Button btn = new Button("OK");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                findString = txt.getText();
                me.hide();
            }

        });
        pane.getChildren().addAll(lbl, txt, btn);
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.setResizable(false);
        me = this;
    }

    public String showDialog() {
        this.showAndWait();
        while(this.isFocused()){
            System.out.println("helloworld");
        }
        return findString;
    }
}
