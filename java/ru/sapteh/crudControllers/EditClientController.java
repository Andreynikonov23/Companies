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
import ru.sapteh.models.Client;
import ru.sapteh.service.ClientServ;

public class EditClientController {
    private SessionFactory factory;
    private DAO<Client, Integer> clientDAO;
    private ObservableList<Client> clientObservableList;
    private Client client;

    @FXML
    private TextField fioTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        client.setFio(fioTxt.getText());
        client.setPhone(phoneTxt.getText());
        client.setEmail(emailTxt.getText());
        clientDAO.update(client);
        clientObservableList.clear();
        clientObservableList.addAll(clientDAO.findByAll());
        buttonEdit.getScene().getWindow().hide();
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        clientDAO = new ClientServ(factory);
        clientObservableList = FXCollections.observableArrayList();
        clientObservableList.addAll(clientDAO.findByAll());
    }
    public void setData(Client client, ObservableList clientObservableList){
        this.client = client;
        this.clientObservableList = clientObservableList;
        fioTxt.setText(client.getFio());
        phoneTxt.setText(client.getPhone());
        emailTxt.setText(client.getEmail());
    }
}
