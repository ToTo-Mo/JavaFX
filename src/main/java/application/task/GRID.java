package application.task;

import application.HBOX;
import application.VBOX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GRID extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        VBox table = new VBox();
        AnchorPane.setTopAnchor(table,0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);

        // 상
        HBox top = new HBox();
        Button[] top_button = new Button[3];
        for(int i=0; i<3; i++){
            top_button[i] = new Button(Integer.toString(i+1));
        }   
        // 하
        HBox buttom = new HBox();
        // 하 좌
        GridPane buttom_left = new GridPane();
        Button[] buttom_left_button = new Button[12];
        for(int i=0; i<12; i++){
            buttom_left_button[i] = new Button(Integer.toString(i+4));
        }        
        // 하 우
        VBox buttom_right = new VBox();
        Button[] buttom_right_button = new Button[5];
        for(int i=0; i<5; i++){
            buttom_right_button[i] = new Button(Integer.toString(i+16));
            
        }

        // 요소 설정
        top.getChildren().addAll(top_button);

        for(int i =0; i<4; i++)
            for(int j=0; j<3; j++)
                buttom_left.add(buttom_left_button[i*3+j],j,i);

        buttom_right.getChildren().addAll(buttom_right_button);
        buttom.getChildren().addAll(buttom_left,buttom_right);
        table.getChildren().addAll(top,buttom);
        root.getChildren().addAll(table);


        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();
    }

}