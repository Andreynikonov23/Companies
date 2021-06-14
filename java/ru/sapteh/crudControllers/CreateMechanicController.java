package ru.sapteh.crudControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Managers;
import ru.sapteh.models.Mechanics;
import ru.sapteh.service.MechanicsServ;

public class CreateMechanicController {
    private SessionFactory factory;
    private DAO<Mechanics, Integer> mechanicsDAO;
    private ObservableList<Mechanics> mechanicsObservableList;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private Button buttonCreate;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionCreate(ActionEvent event) {
        Mechanics mechanics = new Mechanics();
        mechanics.setFio(fioTxt.getText());
        mechanics.setPhone(phoneTxt.getText());
        mechanics.setEmail(emailTxt.getText());
        mechanics.setAddress(addressTxt.getText());
        mechanicsDAO.create(mechanics);
        mechanicsObservableList.clear();
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
        buttonCreate.getScene().getWindow().hide();
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        mechanicsDAO = new MechanicsServ(factory);
        mechanicsObservableList = FXCollections.observableArrayList();
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
    }
    public void setData(ObservableList mechanicsObservableList){
        this.mechanicsObservableList = mechanicsObservableList;
    }
}
