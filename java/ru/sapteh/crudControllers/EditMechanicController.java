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
import ru.sapteh.models.Mechanics;
import ru.sapteh.service.MechanicsServ;

public class EditMechanicController {
    private SessionFactory factory;
    private DAO<Mechanics, Integer> mechanicsDAO;
    private ObservableList<Mechanics> mechanicsObservableList;
    private Mechanics mechanics;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        mechanics.setFio(fioTxt.getText());
        mechanics.setPhone(phoneTxt.getText());
        mechanics.setEmail(emailTxt.getText());
        mechanics.setAddress(addressTxt.getText());
        mechanicsDAO.update(mechanics);
        mechanicsObservableList.clear();
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
        buttonEdit.getScene().getWindow().hide();
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        mechanicsDAO = new MechanicsServ(factory);
        mechanicsObservableList = FXCollections.observableArrayList();
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
    }
    public void setData(Mechanics mechanics, ObservableList mechanicsObservableList){
        this.mechanicsObservableList = mechanicsObservableList;
        this.mechanics = mechanics;
        fioTxt.setText(mechanics.getFio());
        phoneTxt.setText(mechanics.getPhone());
        emailTxt.setText(mechanics.getEmail());
        addressTxt.setText(mechanics.getAddress());
    }

}
