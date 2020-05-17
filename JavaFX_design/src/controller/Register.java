package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class Register {
    private URL url=getClass().getResource("register.fxml");

    public Register() throws IOException {
        Parent root=FXMLLoader.load(url);

    }
}
