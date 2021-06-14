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
import ru.sapteh.models.*;
import ru.sapteh.service.*;

public class OrdersEditController {
    private SessionFactory factory;
    private DAO<Orders, Integer> ordersDAO;
    private DAO<Client, Integer> clientDAO;
    private DAO<Consignee, Integer> consigneeDAO;
    private DAO<Drivers, Integer> driversDAO;
    private DAO<Managers, Integer> managersDAO;
    private DAO<Transport, Integer> transportDAO;
    private DAO<TransportType, Integer> transportTypeDAO;
    private DAO<TrailerType, Integer> trailerTypeDAO;
    private DAO<Trailer, Integer> trailerDAO;
    private DAO<Cargo, Integer> cargoDAO;
    private DAO<CargoType, Integer> cargoTypeDAO;
    private DAO<Mechanics, Integer> mechanicsDAO;
    private ObservableList<Orders> ordersObservableList;
    private ObservableList<Drivers> driversObservableList;
    private ObservableList<Managers> managersObservableList;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Consignee> consigneeObservableList;
    private ObservableList<Transport> transportObservableList;
    private ObservableList<TransportType> transportTypeObservableList;
    private ObservableList<Trailer> trailerObservableList;
    private ObservableList<TrailerType> trailerTypeObservableList;
    private ObservableList<Cargo> cargoObservableList;
    private ObservableList<CargoType> cargoTypeObservableList;
    private ObservableList<Mechanics> mechanicsObservableList;
    private Orders orders;
    private Client client;
    private Consignee consignee;
    private Transport transport;
    private TransportType transportType;
    private Trailer trailer;
    private TrailerType trailerType;
    private Cargo cargo;
    Drivers drivers = new Drivers();
    Managers managers = new Managers();
    private CargoType cargoType;
    private Mechanics mechanics;

    @FXML
    private TextField addressTxt;

    @FXML
    private TextField distanceTxt;

    @FXML
    private TextField costTxt;

    @FXML
    private ComboBox<Drivers> driversBox;

    @FXML
    private ComboBox<Transport> transportBox;

    @FXML
    private ComboBox<Trailer> trailerBox;

    @FXML
    private ComboBox<Managers> managerBox;

    @FXML
    private DatePicker dateSendingPicker;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        orders.setAddress(addressTxt.getText());
        orders.setDistance(Integer.parseInt(distanceTxt.getText()));
        orders.setCost(Integer.parseInt(costTxt.getText()));
        orders.setDrivers(driversBox.getValue());
        orders.setTransport(transportBox.getValue());
        orders.setTrailer(trailerBox.getValue());
        orders.setManagers(managerBox.getValue());
        orders.setDateSending(dateSendingPicker.getValue());
        ordersDAO.update(orders);
        ordersObservableList.clear();
        ordersObservableList.addAll(ordersDAO.findByAll());
        buttonEdit.getScene().getWindow().hide();
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        ordersDAO = new OrdersServ(factory);
        clientDAO = new ClientServ(factory);
        consigneeDAO = new ConsigneeServ(factory);
        driversDAO = new DriversServ(factory);
        managersDAO = new ManagersServ(factory);
        trailerDAO = new TrailerServ(factory);
        transportDAO = new TransportServ(factory);
        transportTypeDAO = new TransportTypeServ(factory);
        trailerTypeDAO = new TrailerTypeServ(factory);
        cargoDAO = new CargoServ(factory);
        cargoTypeDAO = new CargoTypeServ(factory);
        mechanicsDAO = new MechanicsServ(factory);
        ordersObservableList = FXCollections.observableArrayList();
        clientObservableList = FXCollections.observableArrayList();
        driversObservableList = FXCollections.observableArrayList();
        managersObservableList = FXCollections.observableArrayList();
        consigneeObservableList = FXCollections.observableArrayList();
        trailerObservableList = FXCollections.observableArrayList();
        transportObservableList = FXCollections.observableArrayList();
        transportTypeObservableList = FXCollections.observableArrayList();
        trailerTypeObservableList = FXCollections.observableArrayList();
        cargoObservableList = FXCollections.observableArrayList();
        cargoTypeObservableList = FXCollections.observableArrayList();
        mechanicsObservableList = FXCollections.observableArrayList();
        driversObservableList.addAll(driversDAO.findByAll());
        managersObservableList.addAll(managersDAO.findByAll());
        ordersObservableList.addAll(ordersDAO.findByAll());
        clientObservableList.addAll(clientDAO.findByAll());
        consigneeObservableList.addAll(consigneeDAO.findByAll());
        trailerObservableList.addAll(trailerDAO.findByAll());
        trailerTypeObservableList.addAll(trailerTypeDAO.findByAll());
        transportObservableList.addAll(transportDAO.findByAll());
        transportTypeObservableList.addAll(transportTypeDAO.findByAll());
        cargoObservableList.addAll(cargoDAO.findByAll());
        cargoTypeObservableList.addAll(cargoTypeDAO.findByAll());
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
        driversBox.setItems(driversObservableList);
        transportBox.setItems(transportObservableList);
        trailerBox.setItems(trailerObservableList);
        managerBox.setItems(managersObservableList);
    }
    public void setData(Orders orders, ObservableList ordersObservableList){
        this.orders = orders;
        this.ordersObservableList = ordersObservableList;
        addressTxt.setText(orders.getAddress());
        distanceTxt.setText(String.valueOf(orders.getDistance()));
        dateSendingPicker.setValue(orders.getDateSending());
        driversBox.setValue(orders.getDrivers());
        transportBox.setValue(orders.getTransport());
        trailerBox.setValue(orders.getTrailer());
        managerBox.setValue(orders.getManagers());
        costTxt.setText(String.valueOf(orders.getCost()));
    }
}
