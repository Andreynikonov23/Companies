package ru.sapteh.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.crudControllers.*;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.*;
import ru.sapteh.service.*;

import java.io.IOException;
import java.time.LocalDate;

public class DataBaseController {
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
    private DAO<License, Integer> licenseDAO;
    private DAO<CargoType, Integer> cargoTypeDAO;
    private DAO<Mechanics, Integer> mechanicsDAO;
    private ObservableList<Orders> ordersObservableList;
    private ObservableList<Drivers> driversObservableList;
    private ObservableList<Managers> managersObservableList;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Consignee> consigneeObservableList;
    private ObservableList<License> licenseObservableList;
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
    private License license;

    @FXML
    private TableView<Orders> ordersTab;

    @FXML
    private TableColumn<Orders, Integer> idOrderColumn;

    @FXML
    private TableColumn<Orders, String> addressOrderColumn;

    @FXML
    private TableColumn<Orders, Integer> distanceOrderColumn;

    @FXML
    private TableColumn<Orders, LocalDate> daеуOrderColumn;

    @FXML
    private TableColumn<Orders, String> driverOrderColumn;

    @FXML
    private TableColumn<Orders, String> tranportOrderColumn;

    @FXML
    private TableColumn<Orders, String> trailerOrderColumn;

    @FXML
    private TableColumn<Orders, String> managerOrderColumn;

    @FXML
    private TableColumn<Orders, Integer> costOrderColumn;

    @FXML
    private Button buttonOrderEdit;

    @FXML
    private TableView<Client> ClientTab;

    @FXML
    private TableColumn<Client, Integer> idClientColumn;

    @FXML
    private TableColumn<Client, String> fioClientColumn;

    @FXML
    private TableColumn<Client, String> phoneClientColumn;

    @FXML
    private TableColumn<Client, String> emailClientColumn;

    @FXML
    private Button buttonCreateClient;

    @FXML
    private Button buttonEditClient;

    @FXML
    private TableView<Consignee> consigneeTab;

    @FXML
    private TableColumn<Consignee, Integer> idConsColumn;

    @FXML
    private TableColumn<Consignee, String> fioConsColumn;

    @FXML
    private TableColumn<Consignee, String> phoneConsColumn;

    @FXML
    private TableColumn<Consignee, String> emailConsColumn;

    @FXML
    private TableColumn<Consignee, String> clientConsColumn;

    @FXML
    private Button buttonCreateCons;

    @FXML
    private Button buttonEditCons;

    @FXML
    private TableView<Drivers> DriverTab;

    @FXML
    private TableColumn<Drivers, Integer> idDriverColumn;

    @FXML
    private TableColumn<Drivers, String> fioDriverColumn;

    @FXML
    private TableColumn<Drivers, String> phoneDriverColumn;

    @FXML
    private TableColumn<Drivers, String> emailDriverColumn;

    @FXML
    private TableColumn<Drivers, String> licenseDriverColumn;

    @FXML
    private Button buttonCreateDriver;

    @FXML
    private Button buttonEditDriver;

    @FXML
    private TableView<Transport> transportTab;

    @FXML
    private TableColumn<Transport, Integer> idTSColumn;

    @FXML
    private TableColumn<Transport, String> markTSColumn;

    @FXML
    private TableColumn<Transport, String> typeTSColumn;

    @FXML
    private TableColumn<Transport, String> ptsTSColumn;

    @FXML
    private TableColumn<Transport, String> photoTSColumn;

    @FXML
    private TableColumn<Transport, LocalDate> dateTOTSColumn;

    @FXML
    private TableColumn<Transport, String> fuelTSColumn;

    @FXML
    private Button buttonCreateTS;

    @FXML
    private TableView<Trailer> trailerTab;

    @FXML
    private TableColumn<Trailer, Integer> idTrailerColumn;

    @FXML
    private TableColumn<Trailer, String> markTrailerColumn;

    @FXML
    private TableColumn<Trailer, String> typeTrailerColumn;

    @FXML
    private TableColumn<Trailer, String> numberTrailerColumn;

    @FXML
    private TableColumn<Trailer, String> garNumberTrailerColumn;

    @FXML
    private TableView<Cargo> cargoTab;

    @FXML
    private TableColumn<Cargo, Integer> idCargoColumn;

    @FXML
    private TableColumn<Cargo, String> nameCargoColumn;

    @FXML
    private TableColumn<Cargo, String> typeCargoColumn;

    @FXML
    private TableColumn<Cargo, Double> weightCargoColumn;

    @FXML
    private TableColumn<Cargo, String> gabCargoColumn;

    @FXML
    private TableColumn<Cargo, Integer> quantityCargoColumn;

    @FXML
    private TableColumn<Cargo, String> packageCargoColumn;

    @FXML
    private TableColumn<Cargo, Integer> costCargoColumn;

    @FXML
    private TableView<Mechanics> mechanicsTab;

    @FXML
    private TableColumn<Mechanics, Integer> idMechanicColumn;

    @FXML
    private TableColumn<Mechanics, String> fioMechanicColumn;

    @FXML
    private TableColumn<Mechanics, String> phoneMechanicColumn;

    @FXML
    private TableColumn<Mechanics, String> emailMechanicColumn;

    @FXML
    private TableColumn<Mechanics, String> addressMechanicColumn;

    @FXML
    private TableView<License> licenseColumn;

    @FXML
    private TableColumn<License, Integer> idColumn;

    @FXML
    private TableColumn<License, String> seriesNumberColumn;

    @FXML
    private TableColumn<License, String> categoryColumn;

    @FXML
    private TableColumn<License, LocalDate> dateIssueColumn;

    @FXML
    private TableColumn<License, LocalDate> endDateColumn;

    @FXML
    private TableColumn<License, String> gibddColumn;

    @FXML
    private TableColumn<License, String> placeIssue;

    @FXML
    private Button buttonCreateLicense;

    @FXML
    private Button buttonExit;

    @FXML
    void initialize(){
        initData();
        ordersTable();
        clientTable();
        consigneeTable();
        driverTable();
        transportTable();
        trailerTable();
        cargoTable();
        mechanicsTable();
        licenseTable();
    }
    @FXML
    void createLicense(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createLicense.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateLicenseController createLicenseController = loader.getController();
        createLicenseController.setData(licenseObservableList);
        stage.show();
    }

    @FXML
    void editLicense(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editLicense.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditLicenseController editLicenseController = loader.getController();
        editLicenseController.setData(license, licenseObservableList);
        stage.show();
    }
    @FXML
    void deleteLicense(ActionEvent event) {
        licenseDAO.delete(license);
        licenseObservableList.clear();
        licenseObservableList.addAll(licenseDAO.findByAll());
    }
    @FXML
    void actionExit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Караван");
        stage.getIcons().add(new Image("/image/logo.jpg"));
        stage.setScene(new Scene(root));
        stage.show();
        buttonExit.getScene().getWindow().hide();
    }

    @FXML
    void actionCons(ActionEvent event) {
        consigneeDAO.delete(consignee);
        consigneeObservableList.clear();
        consigneeObservableList.addAll(consigneeDAO.findByAll());
    }

    @FXML
    void actionCreateCargo(ActionEvent event) {

    }

    @FXML
    void actionCreateClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createClient.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateClientController createClientController = loader.getController();
        createClientController.setData(clientObservableList);
        stage.show();
    }

    @FXML
    void actionCreateCons(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createConsignee.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateConsigneeController createConsigneeController = loader.getController();
        createConsigneeController.setData(consigneeObservableList);
        stage.show();
    }

    @FXML
    void actionCreateDriver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createDriver.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateDriversController createDriversController = loader.getController();
        createDriversController.setData(driversObservableList);
        stage.show();
    }

    @FXML
    void actionCreateTS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createTransport.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateTransportController createTransportController = loader.getController();
        createTransportController.setData(transportObservableList);
        stage.show();
    }

    @FXML
    void actionCreateTrailer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createTrailer.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        CreateTrailerController createTrailerController = loader.getController();
        createTrailerController.setData(trailerObservableList);
        stage.show();
    }

    @FXML
    void actionDeleteClient(ActionEvent event) {
        clientDAO.delete(client);
        clientObservableList.clear();
        clientObservableList.addAll(clientDAO.findByAll());
    }

    @FXML
    void actionDeleteDriver(ActionEvent event) {
        driversDAO.delete(drivers);
        driversObservableList.clear();
        driversObservableList.addAll(driversDAO.findByAll());
    }

    @FXML
    void actionDeleteTS(ActionEvent event) {
        transportDAO.delete(transport);
        transportObservableList.clear();
        transportObservableList.addAll(transportDAO.findByAll());
    }

    @FXML
    void actionEditClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editClient.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditClientController editClientController = loader.getController();
        editClientController.setData(client, clientObservableList);
        stage.show();
    }

    @FXML
    void actionEditColumn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editDriver.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditDriverController editDriverController = loader.getController();
        editDriverController.setData(drivers, driversObservableList);
        stage.show();
    }

    @FXML
    void actionEditCons(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editConsignee.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditConsigneeController editConsigneeController = loader.getController();
        editConsigneeController.setData(consignee, consigneeObservableList);
        stage.show();
    }

    @FXML
    void actionEditTS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editTransport.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditTransportController editTransportController = loader.getController();
        editTransportController.setData(transport, transportObservableList);
        stage.show();
    }

    @FXML
    void actionEditTrailer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editTrailer.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        EditTrailerController editTrailerController = loader.getController();
        editTrailerController.setData(trailer, trailerObservableList);
        stage.show();
    }

    @FXML
    void actionOrderDelete(ActionEvent event) {
        ordersDAO.delete(orders);
        ordersObservableList.clear();
        ordersObservableList.addAll(ordersDAO.findByAll());
    }

    @FXML
    void actionOrderEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/ordersEdit.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Изменение данных");
        stage.setScene(new Scene(pane));
        OrdersEditController ordersEditController = loader.getController();
        ordersEditController.setData(orders, ordersObservableList);
        stage.show();
    }

    @FXML
    void createMechanic(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/createMechanic.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Изменение данных");
        stage.setScene(new Scene(pane));
        CreateMechanicController createMechanicController = loader.getController();
        createMechanicController.setData(mechanicsObservableList);
        stage.show();
    }

    @FXML
    void deleteCargo(ActionEvent event) {
        cargoDAO.delete(cargo);
        cargoObservableList.clear();
        cargoObservableList.addAll(cargoDAO.findByAll());
    }

    @FXML
    void deleteMechanic(ActionEvent event) {
        mechanicsDAO.delete(mechanics);
        mechanicsObservableList.clear();
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
    }

    @FXML
    void deleteTrailer(ActionEvent event) {
        trailerDAO.delete(trailer);
        trailerObservableList.clear();
        trailerObservableList.addAll(trailerDAO.findByAll());
    }

    @FXML
    void editCargo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editCargo.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Изменение данных");
        stage.setScene(new Scene(pane));
        EditCargoController editCargoController = loader.getController();
        editCargoController.setData(cargo, cargoObservableList);
        stage.show();
    }

    @FXML
    void editMechanic(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/crud/editMechanic.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Изменение данных");
        stage.setScene(new Scene(pane));
        EditMechanicController editMechanicController = loader.getController();
        editMechanicController.setData(mechanics, mechanicsObservableList);
        stage.show();
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
        licenseDAO = new LicenseServ(factory);
        licenseObservableList = FXCollections.observableArrayList();
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
        licenseObservableList.addAll(licenseDAO.findByAll());
        cargoTypeObservableList.addAll(cargoTypeDAO.findByAll());
        mechanicsObservableList.addAll(mechanicsDAO.findByAll());
    }
    public void ordersTable(){
        ordersTab.setItems(ordersObservableList);
        idOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        addressOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getAddress()));
        distanceOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDistance()));
        daеуOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDateSending()));
        driverOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDrivers().getFio()));
        tranportOrderColumn.setCellValueFactory(a ->new SimpleObjectProperty<>(a.getValue().getTransport().getMark()));
        trailerOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getTrailer().getMark()));
        managerOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getManagers().getFio()));
        costOrderColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCost()));
        ordersTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue)->{
            orders = newValue;
        });
    }
    public void clientTable(){
        ClientTab.setItems(clientObservableList);
        idClientColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        fioClientColumn.setCellValueFactory(a-> new SimpleObjectProperty<>(a.getValue().getFio()));
        phoneClientColumn.setCellValueFactory(a-> new SimpleObjectProperty<>(a.getValue().getPhone()));
        emailClientColumn.setCellValueFactory(a-> new SimpleObjectProperty<>(a.getValue().getEmail()));
        ClientTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) ->{
            client = newValue;
        });
    }
    public void consigneeTable(){
        consigneeTab.setItems(consigneeObservableList);
        idConsColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        fioConsColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFio()));
        phoneConsColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhone()));
        emailConsColumn.setCellValueFactory(a-> new SimpleObjectProperty<>(a.getValue().getEmail()));
        consigneeTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue)->{
            consignee = newValue;
        });
    }
    public void driverTable(){
        DriverTab.setItems(driversObservableList);
        idDriverColumn.setCellValueFactory(a-> new SimpleObjectProperty<>(a.getValue().getId()));
        fioDriverColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFio()));
        phoneDriverColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhone()));
        emailDriverColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getEmail()));
        licenseDriverColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getLicense().getSeriesNumber()));
        DriverTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            drivers = newValue;
        });
    }
    public void transportTable(){
        transportTab.setItems(transportObservableList);
        idTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        markTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getMark()));
        typeTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getTransportType().getName()));
        ptsTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPts()));
        photoTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhoto()));
        dateTOTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDateTO()));
        fuelTSColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFuelConsumption()));
        transportTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            transport = newValue;
        });
    }
    public void trailerTable(){
        trailerTab.setItems(trailerObservableList);
        idTrailerColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        markTrailerColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getMark()));
        typeTrailerColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getTrailerType().getName()));
        numberTrailerColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getGosNumber()));
        garNumberTrailerColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getGarageNumber()));
        trailerTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            trailer = newValue;
        });
    }
    public void cargoTable(){
        cargoTab.setItems(cargoObservableList);
        idCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        nameCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getName()));
        typeCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCargoType().getName()));
        weightCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getWeight()));
        gabCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getOverallDimensions()));
        quantityCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getQuantity()));
        packageCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPackages()));
        costCargoColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCost()));
        cargoTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            cargo = newValue;
        });
    }
    public void mechanicsTable(){
        mechanicsTab.setItems(mechanicsObservableList);
        idMechanicColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        fioMechanicColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFio()));
        phoneMechanicColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhone()));
        emailMechanicColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getEmail()));
        addressMechanicColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getAddress()));
        mechanicsTab.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) ->{
            mechanics = newValue;
        });
    }
    public void licenseTable(){
        licenseColumn.setItems(licenseObservableList);
        idColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        seriesNumberColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getSeriesNumber()));
        categoryColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCategory()));
        dateIssueColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDateIssue()));
        endDateColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getEndDate()));
        gibddColumn.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getGibdd()));
        placeIssue.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPlaceIssue()));
        licenseColumn.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) ->{
            license = newValue;
        });
    }
}
