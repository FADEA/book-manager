package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;

public class Main extends Application {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/sample.fxml"));
        primaryStage.setTitle("图书管理系统");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void login(){
        String username=usernameField.getText().trim();
        String password=passwordField.getText().trim();
        System.out.println(username);
        System.out.println(password);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
