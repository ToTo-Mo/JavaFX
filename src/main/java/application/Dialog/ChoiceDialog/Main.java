package application.Dialog.ChoiceDialog;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        Book java = new Book(1L, "J01", "Java ");
        Book csharp = new Book(2L, "C01", "CSharp ");
        Book python = new Book(3L, "P01", "Python");
         
        Book defaultBook = csharp;
         
        ChoiceDialog<Book> dialog = new ChoiceDialog<Book>(defaultBook, java, csharp, python);
         
        dialog.setTitle("o7planning");
        dialog.setHeaderText("Select a Book:");
        dialog.setContentText("Book:");
         
        dialog.showAndWait().ifPresent(book ->{
            System.out.println(book.toString());
        });    
        
        /*
            동일한 코드
            Optional<Book> result = dialog.showAndWait();
            if(result.isPresent()){
                Book seletedBook = result.get();
                System.out.println(seletedBook.toString());
            }
        */

     
    }

    public static void main(String[] args){
        launch();
    }

}