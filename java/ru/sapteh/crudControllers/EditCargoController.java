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
import ru.sapteh.models.Cargo;
import ru.sapteh.models.CargoType;
import ru.sapteh.service.CargoServ;
import ru.sapteh.service.CargoTypeServ;

public class EditCargoController {
    private SessionFactory factory;
    private DAO<Cargo, Integer> cargoDAO;
    private DAO<CargoType, Integer> cargoTypeDAO;
    private ObservableList<Cargo> cargoObservableList;
    private ObservableList<CargoType> cargoTypeObservableList;
    private Cargo cargo;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField costTxt;

    @FXML
    private ComboBox<CargoType> typeBox;

    @FXML
    private TextField weightTxt;

    @FXML
    private TextField gabTxt;

    @FXML
    private TextField quantityTxt;

    @FXML
    private TextField packageTxt;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        cargo.setName(nameTxt.getText());
        cargo.setCost(Integer.parseInt(costTxt.getText()));
        cargo.setCargoType(typeBox.getValue());
        cargo.setWeight(Integer.parseInt(weightTxt.getText()));
        cargo.setOverallDimensions(gabTxt.getText());
        cargo.setQuantity(Integer.parseInt(quantityTxt.getText()));
        cargo.setPackages(packageTxt.getText());
        cargoDAO.update(cargo);
        cargoObservableList.clear();
        cargoObservableList.addAll(cargoDAO.findByAll());
    }
    public void initData(){
        factory = new Configuration().configure().buildSessionFactory();
        cargoDAO = new CargoServ(factory);
        cargoTypeDAO = new CargoTypeServ(factory);
        cargoObservableList = FXCollections.observableArrayList();
        cargoTypeObservableList = FXCollections.observableArrayList();
        cargoObservableList.addAll(cargoDAO.findByAll());
        cargoTypeObservableList.addAll(cargoTypeDAO.findByAll());
        typeBox.setItems(cargoTypeObservableList);
    }
    public void setData(Cargo cargo, ObservableList cargoObservableList){
        this.cargo = cargo;
        this.cargoObservableList = cargoObservableList;
    }
}
