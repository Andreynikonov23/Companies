package ru.sapteh.controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.IdTransport;
import ru.sapteh.models.Transport;
import ru.sapteh.service.IdTransportServ;
import ru.sapteh.service.TransportServ;

import java.io.IOException;

public class TileTransportController {
    private Transport transport;
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<IdTransport, Integer> dao = new IdTransportServ(factory);
    CreateOrderController createOrderController = new CreateOrderController();
    MainWindowController mainWindowController = new MainWindowController();
    IdTransport idTransport = new IdTransport();
    ActionEvent event;
    ActionEvent event1;

    @FXML
    private ImageView imageView;

    @FXML
    private Button buttonOK;

    @FXML
    private Label nameLbl;

    @FXML
    private Label typeLbl;

    @FXML
    private Label toLbl;

    @FXML
    private Label consumptionLbl;

    public void setData(Transport transport){
        this.transport = transport;
        imageView.setImage(new Image("/transport/" + transport.getPhoto()));
        nameLbl.setText(transport.getMark());
        typeLbl.setText(transport.getTransportType().getName());
        toLbl.setText(String.valueOf(transport.getDateTO()));
        Label label = new Label();
        Integer id;
        consumptionLbl.setText(transport.getFuelConsumption());
        buttonOK.setOnAction(a ->{
            idTransport.setIdTransport(transport.getId());
            dao.create(idTransport);
            label.setText(String.valueOf(transport.getId()));
            System.out.println(label.getText());
            System.out.println(idTransport);
            getTransport();
        });
    }

    public Transport getTransport() {
        return transport;
    }
}
