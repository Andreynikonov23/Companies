package ru.sapteh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Managers;
import ru.sapteh.service.ManagersServ;

import java.io.IOException;

public class RegistrationController {
    Stage stage = new Stage();
    Managers managers = new Managers();
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Managers, Integer> dao = new ManagersServ(factory);

    @FXML
    private Button buttonOk;

    @FXML
    private Label defaultLbl;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private TextField loginTxt;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button buttonExit;

    @FXML
    void initialize(){

    }

    @FXML
    void actionExit(ActionEvent event) {
        buttonExit.getScene().getWindow().hide();
       exit();
    }

    @FXML
    void actionOk(ActionEvent event) {
        String fio = fioTxt.getText();
        String phone = phoneTxt.getText();
        String email = emailTxt.getText();
        String address = addressTxt.getText();
        String login = loginTxt.getText();
        String password = passwordField.getText();
        if (fio.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setFio(fioTxt.getText());
        if (phone.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setPhone(phoneTxt.getText());
        if (email.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setEmail(emailTxt.getText());
        if (address.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setAddress(addressTxt.getText());
        if (login.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setLogin(loginTxt.getText());
        if (password.isEmpty()){
            defaultLbl.setText("Одно из полей не заполнено");
            return;
        } else
            managers.setPassword(passwordField.getText());
        dao.create(managers);
        buttonOk.getScene().getWindow().hide();
        exit();
    }
    public void exit () {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/entrance.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Караван");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
