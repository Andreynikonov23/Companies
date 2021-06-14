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
import ru.sapteh.models.Consignee;
import ru.sapteh.models.Drivers;
import ru.sapteh.service.DriversServ;

public class CreateDriversController {
    private SessionFactory factory;
    private DAO<Drivers, Integer> driversDAO;
    private ObservableList<Drivers> driversObservableList;
    private Drivers drivers;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField licenseTxt;

    @FXML
    private Button buttonCreate;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionCreate(ActionEvent event) {
        drivers = new Drivers();
        drivers.setFio(fioTxt.getText());
        drivers.setPhone(phoneTxt.getText());
        drivers.setEmail(emailTxt.getText());
        driversDAO.create(drivers);
        driversObservableList.clear();
        driversObservableList.addAll(driversDAO.findByAll());
        buttonCreate.getScene().getWindow().hide();
    }

    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        driversDAO = new DriversServ(factory);
        driversObservableList = FXCollections.observableArrayList();
        driversObservableList.addAll(driversDAO.findByAll());
    }
    public void setData(ObservableList driversObservableList){
        this.driversObservableList = driversObservableList;
    }

}
