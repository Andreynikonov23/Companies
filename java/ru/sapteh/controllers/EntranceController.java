package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Managers;
import ru.sapteh.service.ManagersServ;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class EntranceController {
    private List<Managers> managersList;

    @FXML
    private Button buttonOk;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginTxt;

    @FXML
    private Label defaultLbl;

    @FXML
    private Button buttonRegistration;

    @FXML
    void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Managers, Integer> managersIntegerDAO = new ManagersServ(factory);
        managersList = managersIntegerDAO.findByAll();
    }

    @FXML
    void actionOk(ActionEvent event) throws IOException {
        String login = loginTxt.getText();
        loginTxt.copy();
        String password = passwordField.getText();
        for (Managers managers : managersList){
            if (login.equalsIgnoreCase(managers.getLogin()) && password.equals(managers.getPassword())){
                buttonOk.getScene().getWindow().hide();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainWindow.fxml"));
                SplitPane pane = loader.load();
                MainWindowController mainWindowController = loader.getController();
                stage.setTitle("Караван");
                stage.getIcons().add(new Image("/image/logo.jpg"));
                stage.setScene(new Scene(pane));
                stage.show();
                mainWindowController.nameLbl.setText(login);
                mainWindowController.setData(login);
            } else
                defaultLbl.setText("Неверный логин или пароль");
        }
    }

    @FXML
    void actionRegistration(ActionEvent event) throws IOException {
        buttonRegistration.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/view/buttons/registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
