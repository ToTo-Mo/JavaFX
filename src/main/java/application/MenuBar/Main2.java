package application.MenuBar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main2 extends Application implements EventHandler, ChangeListener {
    private MenuBar menuBar;
    private MenuItem aboutItem, exitItem;
    private Color colValue[] = { Color.RED, Color.GREEN, Color.BLUE, Color.BLACK };
    private RadioMenuItem colorItems[], fontItems[];
    private CheckMenuItem styleItems[];
    private Label testMsg;
    private ToggleGroup fontGroup, colorGroup;
    private int style;
    private FlowPane root;

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("test");
        testMsg = new Label("String for Test");
        testMsg.setTextFill(colValue[0]);
        testMsg.setFont(Font.font("Corbel", FontPosture.REGULAR, 72));

        root = new FlowPane();
        Scene scene = new Scene(root, 600, 300, Color.WHITE);
        menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        constructMenu();

        root.getChildren().add(testMsg);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void constructMenu() {
        Menu fileMenu = new Menu("_File");
        fileMenu.setMnemonicParsing(true);
        aboutItem = new MenuItem("_About");
        aboutItem.setMnemonicParsing(true);
        aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
        aboutItem.setOnAction(this);
        exitItem = new MenuItem("E_xit");
        exitItem.setMnemonicParsing(true);
        exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
        exitItem.setOnAction(this);

        fileMenu.getItems().addAll(aboutItem, exitItem);
        Menu formatMenu = new Menu("For_mat");
        formatMenu.setMnemonicParsing(true);
        String colors[] = { "빨강", "녹색", "파랑", "검정" };
        Menu colorMenu = new Menu("_Color");
        colorMenu.setMnemonicParsing(true);
        colorMenu.setAccelerator(KeyCombination.keyCombination("SHORTCUT+C"));
        colorItems = new RadioMenuItem[colors.length];
        colorGroup = new ToggleGroup();
        for (int i = 0; i < colors.length; i++) {
            colorItems[i] = new RadioMenuItem(colors[i]);
            colorMenu.getItems().add(colorItems[i]);
            colorItems[i].setToggleGroup(colorGroup);
            colorItems[i].setOnAction(this);
        }
        colorItems[0].setSelected(true);
        formatMenu.getItems().add(colorMenu);

        String fontNames[] = { "Arial", "Cambria", "Corbel" };

        Menu fontMenu = new Menu("Fo_nt");
        fontMenu.setMnemonicParsing(true);
        fontItems = new RadioMenuItem[fontNames.length];
        fontGroup = new ToggleGroup();
        for (int i = 0; i < fontNames.length; i++) {
            fontItems[i] = new RadioMenuItem(fontNames[i]);
            fontMenu.getItems().add(fontItems[i]);
            fontItems[i].setToggleGroup(fontGroup);
            fontItems[i].setOnAction(this);
        }
        fontItems[0].setSelected(true);
        formatMenu.getItems().add(fontMenu);
        fontMenu.getItems().add(new SeparatorMenuItem());
        String styleNames[] = { "Bold", "Italic" };
        styleItems = new CheckMenuItem[styleNames.length];
        for (int i = 0; i < styleNames.length; i++) {
            styleItems[i] = new CheckMenuItem(styleNames[i]);
            fontMenu.getItems().add(styleItems[i]);
            styleItems[i].selectedProperty().addListener(this);
        }

        menuBar.getMenus().addAll(fileMenu, formatMenu);
        root.getChildren().add(menuBar);
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if (styleItems[0].isSelected() == true) {
            if (styleItems[1].isSelected() == true) {
                testMsg.setFont(Font.font(testMsg.getFont().getFamily(), FontWeight.BOLD, FontPosture.ITALIC, 72));
            } else {
                testMsg.setFont(Font.font(testMsg.getFont().getFamily(), FontWeight.BOLD, FontPosture.REGULAR, 72));
            }
        } else {
            if (styleItems[1].isSelected() == true) {
                testMsg.setFont(Font.font(testMsg.getFont().getFamily(), FontWeight.NORMAL, FontPosture.ITALIC, 72));
            } else {
                testMsg.setFont(Font.font(testMsg.getFont().getFamily(), FontWeight.NORMAL, FontPosture.REGULAR, 72));
            }
        }
    }

    @Override
    public void handle(Event e) {
        if (e.getSource() == aboutItem) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("메뉴 예제 프로그램입니다.");
            alert.showAndWait();
        } else if (e.getSource() == exitItem)
            System.exit(0);
        else {
            for (int i = 0; i < colorItems.length; i++)
                if (colorItems[i].isSelected()) {
                    testMsg.setTextFill(colValue[i]);
                    break;
                }
        }
        for (int i = 0; i < fontItems.length; i++)
            if (e.getSource() == fontItems[i]) {
                testMsg.setFont(Font.font(fontItems[i].getText(), 72));
                break;
            }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}