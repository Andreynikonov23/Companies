package ru.sapteh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainWindowController {
    String login;
    Stage stage = new Stage();
    @FXML
    private SplitPane splitPane;

    @FXML
    private Button buttonCreateOrder;

    @FXML
    private Button buttonDoc;

    @FXML
    private Button buttonDb;

    @FXML
    private Button buttonExit;

    @FXML
    Label nameLbl;

    @FXML
    void initialize(){
        nameLbl.setText(login);
    }

    @FXML
    void actionCreateOrder(ActionEvent event) throws IOException {
        buttonCreateOrder.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/view/buttons/createOrder.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Создание заказа");
        stage.getIcons().add(new Image("/image/logo.jpg"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void actionDb(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dataBase.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Библиотека данных");
        stage.getIcons().add(new Image("/image/logo.jpg"));
        stage.setScene(new Scene(root));
        stage.show();
        buttonDb.getScene().getWindow().hide();
    }

    @FXML
    void actionExit(ActionEvent event) throws IOException {
        buttonExit.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/view/entrance.fxml"));
        stage.setTitle("Караван");
        stage.getIcons().add(new Image("/image/logo.jpg"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void actionDoc(ActionEvent event) throws IOException {
        File dir = new File("C:\\Users\\User\\IdeaProjects\\Диплом\\Company\\src\\main\\resources\\Документы");
        Desktop desktop = null;
        if (desktop.isDesktopSupported()){
            desktop = Desktop.getDesktop();
        }
        desktop.open(dir);
    }

    public void setData (String login){
        this.login = login;
    }
}
