package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Main extends Application {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ChoiceBox type;
    @FXML private GridPane mainPane;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        primaryStage.setTitle("图书管理系统");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void login(){
        String username=usernameField.getText().trim();
        String password=passwordField.getText().trim();
        System.out.println(type.getValue().toString());
        System.out.println(username);
        System.out.println(password);
    }

    public void register() throws IOException {
        Stage mainStage = (Stage) mainPane.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Stage stage = new Stage();
        stage.setTitle("注册界面");
        stage.setScene(new Scene(root));
        stage.setFocused(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
