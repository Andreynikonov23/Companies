package ru.sapteh.crudControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Transport;
import ru.sapteh.models.TransportType;
import ru.sapteh.service.TransportServ;
import ru.sapteh.service.TransportTypeServ;

public class EditTransportController {
    private SessionFactory factory;
    private DAO<Transport, Integer> transportDAO;
    private DAO<TransportType, Integer> transportTypeDAO;
    private ObservableList<Transport> transportObservableList;
    private ObservableList<TransportType> transportTypeObservableList;
    private Transport transport;
    private TransportType transportType;

    @FXML
    private TextField markTxt;

    @FXML
    private TextField fuelTxt;

    @FXML
    private ComboBox<TransportType> typeBox;

    @FXML
    private TextField ptsTxt;

    @FXML
    private TextField photoTxt;

    @FXML
    private DatePicker dateTOPicker;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        transport.setMark(markTxt.getText());
        transport.setTransportType(typeBox.getValue());
        transport.setPts(ptsTxt.getText());
        transport.setPhoto(photoTxt.getText());
        transport.setDateTO(dateTOPicker.getValue());
        transport.setFuelConsumption(fuelTxt.getText());
        transportDAO.update(transport);
        transportObservableList.clear();
        transportObservableList.addAll(transportDAO.findByAll());
    }
    public void initData() {
        factory = new Configuration().configure().buildSessionFactory();
        transportDAO = new TransportServ(factory);
        transportTypeDAO = new TransportTypeServ(factory);
        transportObservableList = FXCollections.observableArrayList();
        transportTypeObservableList = FXCollections.observableArrayList();
        transportObservableList.addAll(transportDAO.findByAll());
        transportTypeObservableList.addAll(transportTypeDAO.findByAll());
        typeBox.setItems(transportTypeObservableList);
    }
    public void setData(Transport transport, ObservableList transportObservableList){
        this.transport = transport;
        this.transportObservableList = transportObservableList;
        markTxt.setText(transport.getMark());
        typeBox.setValue(transport.getTransportType());
        ptsTxt.setText(transport.getPts());
        photoTxt.setText(transport.getPhoto());
        dateTOPicker.setValue(transport.getDateTO());
        fuelTxt.setText(transport.getFuelConsumption());
    }
}
