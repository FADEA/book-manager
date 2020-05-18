package controller;

import dao.impl.StudentDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Register {
    @FXML GridPane registerPane;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML PasswordField confirmPasswordField;
    @FXML ChoiceBox registerType;
    @FXML TextField nameField;
    @FXML TextField phoneField;
    @FXML TextField idField;

    public void register(){
        String username=usernameField.getText().trim();
        String name=nameField.getText().trim();
        String password=passwordField.getText().trim();
        String confirmPassword=confirmPasswordField.getText().trim();
        String phone=phoneField.getText().trim();
        String id=idField.getText().trim();
        String type=registerType.getValue().toString();

        if(!password.equals(confirmPassword)){
            remind("密码与确认密码不一致");
        }else{
            if(type.equals("学生")){
                StudentDaoImpl sdi = new StudentDaoImpl();
                sdi.insert(Long.valueOf(username),name,password,phone,id,5);
            }else if(type.equals("管理员")){

            }
        }
    }

    public void back() throws IOException {
        Stage mainStage = (Stage) registerPane.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        Stage stage = new Stage();
        stage.setTitle("图书管理系统");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void remind(String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set("信息");
        alert.headerTextProperty().set(info);
        alert.showAndWait();
    }
}
