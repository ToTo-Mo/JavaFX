package application.task.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private TextArea textArea1;

    @FXML
    private Button copy1;

    @FXML
    private Button copy2;

    @FXML
    private TextArea textArea2;

    String str;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea1.setText("앞에서 얘기한 것처럼 이벤트 핸들러 객체는 하나의 메소드, \n"
                          + "즉 actionPerformed 메소드만 구현이 되어 있다. \n"
                          + "그리고 그 메소드 안에서 인자로 넘어온 객체를 통해 이벤트를 발생시킨\n"
                          + "소스 객체의 레퍼런스를 파악하여 작업을 달리하고 있다.");

        copy1.setOnAction(event -> {
            str = textArea2.getText();
            textArea2.setText(str + textArea1.getSelectedText());
        });

        copy2.setOnAction(event -> {
            str = textArea1.getText();
            textArea1.setText(str + textArea2.getSelectedText());
        });
    }

}
