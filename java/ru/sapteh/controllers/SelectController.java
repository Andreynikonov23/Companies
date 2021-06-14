package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.IdTransport;
import ru.sapteh.models.Transport;
import ru.sapteh.service.TransportServ;

import java.io.IOException;

public class SelectController {
    private SessionFactory factory;
    private DAO<Transport, Integer> dao;
    private ObservableList<Transport> observableList;
    private Transport transport;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    @FXML
    void initialize(){
        initData();
        scrollPane.widthProperty().addListener((obj, oldValue, newValue)->{
            tilePane.setPrefWidth(newValue.doubleValue());
        });
        tileGenerate(observableList);
    }

    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        dao = new TransportServ(factory);
        observableList = FXCollections.observableArrayList();
        observableList.addAll(dao.findByAll());
        tileGenerate(observableList);
    }

    public void tileGenerate(ObservableList<Transport> observableList) {
        tilePane.getChildren().clear();
        for (Transport transport : observableList){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/buttons/tileTransport.fxml"));
            AnchorPane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            TileTransportController tileTransportController = loader.getController();
            tileTransportController.setData(transport);
            tilePane.getChildren().add(pane);
        }
    }
}
