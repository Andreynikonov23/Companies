package ru.sapteh.crudControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;
import ru.sapteh.models.Consignee;
import ru.sapteh.service.ClientServ;
import ru.sapteh.service.ConsigneeServ;

public class EditConsigneeController {
    private SessionFactory factory;
    private DAO<Consignee, Integer> consigneeDAO;
    private DAO<Client, Integer> clientDAO;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Consignee> consigneeObservableList;
    private Consignee consignee;
    private Client client;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private ComboBox<Client> clientBox;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        consignee.setFio(fioTxt.getText());
        consignee.setPhone(phoneTxt.getText());
        consignee.setEmail(emailTxt.getText());
        consignee.setClient(clientBox.getValue());
        consigneeDAO.update(consignee);
        consigneeObservableList.clear();
        consigneeObservableList.addAll(consigneeDAO.findByAll());
        buttonEdit.getScene().getWindow();
    }
    public void initData() {
        factory = new Configuration().configure().buildSessionFactory();
        clientDAO = new ClientServ(factory);
        consigneeDAO = new ConsigneeServ(factory);
        consigneeObservableList = FXCollections.observableArrayList();
        consigneeObservableList.addAll(consigneeDAO.findByAll());
        clientObservableList = FXCollections.observableArrayList();
        clientObservableList.addAll(clientDAO.findByAll());
        clientBox.setItems(clientObservableList);
    }
    public void setData(Consignee consignee, ObservableList consigneeObservableList){
        this.consignee = consignee;
        this.consigneeObservableList = consigneeObservableList;
        fioTxt.setText(consignee.getFio());
        phoneTxt.setText(consignee.getPhone());
        emailTxt.setText(consignee.getEmail());
        clientBox.setValue(consignee.getClient());
    }
}
