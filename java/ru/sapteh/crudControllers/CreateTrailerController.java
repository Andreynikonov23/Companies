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
import ru.sapteh.models.Trailer;
import ru.sapteh.models.TrailerType;
import ru.sapteh.models.Transport;
import ru.sapteh.service.TrailerServ;
import ru.sapteh.service.TrailerTypeServ;

public class CreateTrailerController {
    private SessionFactory factory;
    private DAO<TrailerType, Integer> trailerTypeDAO;
    private DAO<Trailer, Integer> trailerDAO;
    private ObservableList<Trailer> trailerObservableList;
    private ObservableList<TrailerType> trailerTypeObservableList;

    @FXML
    private TextField markTxt;

    @FXML
    private ComboBox<TrailerType> typeBox;

    @FXML
    private TextField gosNumberTxt;

    @FXML
    private TextField garageNumberTxt;

    @FXML
    private Button buttonCreate;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionCreate(ActionEvent event) {
        Trailer trailer = new Trailer();
        trailer.setMark(markTxt.getText());
        trailer.setTrailerType(typeBox.getValue());
        trailer.setGosNumber(gosNumberTxt.getText());
        trailer.setGarageNumber(garageNumberTxt.getText());
        trailerDAO.create(trailer);
        trailerObservableList.clear();
        trailerObservableList.addAll(trailerDAO.findByAll());
        buttonCreate.getScene().getWindow().hide();
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        trailerDAO = new TrailerServ(factory);
        trailerTypeDAO = new TrailerTypeServ(factory);
        trailerObservableList = FXCollections.observableArrayList();
        trailerTypeObservableList = FXCollections.observableArrayList();
        trailerObservableList.addAll(trailerDAO.findByAll());
        trailerTypeObservableList.addAll(trailerTypeDAO.findByAll());
        typeBox.setItems(trailerTypeObservableList);
    }
    public void setData(ObservableList trailerObservableList){
        this.trailerObservableList = trailerObservableList;
    }

}
