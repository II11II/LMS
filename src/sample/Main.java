package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.*;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        Person model=new Student("u1810037","19991111","Islam","Akhrarov");
        model.register();
        System.out.println( model.login("u1810037","19991111"));
        Book book=new Book();
        System.out.println( book.getSortedByTitle());
        System.out.println(book.getSortedByAuthor());
        System.out.println(book.getSortedByISBN());
        System.out.println(book.getSortedByPublishDate());
        System.out.println(book.getSortedBySubject());
        System.out.println(book.getSortedByQuantity());



//        launch(args);
    }
}
