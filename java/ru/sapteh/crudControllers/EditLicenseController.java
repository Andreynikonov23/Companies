package ru.sapteh.crudControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.License;
import ru.sapteh.service.LicenseServ;

public class EditLicenseController {
    private SessionFactory factory;
    private DAO<License, Integer> licenseDAO;
    private ObservableList<License> licenseObservableList;
    private License license;

    @FXML
    private TextField seriesNumberTxt;

    @FXML
    private TextField placeIssueTxt;

    @FXML
    private TextField categryTxt;

    @FXML
    private TextField gibddTxt;

    @FXML
    private DatePicker dateIssuePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button buttonEdit;

    @FXML
    void initialize(){
        factory = new Configuration().configure().buildSessionFactory();
        licenseDAO = new LicenseServ(factory);
        licenseObservableList = FXCollections.observableArrayList();
        licenseObservableList.addAll(licenseDAO.findByAll());
    }

    @FXML
    void actionEdit(ActionEvent event) {
        license.setSeriesNumber(seriesNumberTxt.getText());
        license.setCategory(categryTxt.getText());
        license.setDateIssue(dateIssuePicker.getValue());
        license.setEndDate(endDatePicker.getValue());
        license.setGibdd(gibddTxt.getText());
        license.setPlaceIssue(placeIssueTxt.getText());
        licenseDAO.update(license);
        licenseObservableList.clear();
        licenseObservableList.addAll(licenseDAO.findByAll());
        buttonEdit.getScene().getWindow().hide();
    }

    public void setData(License license, ObservableList licenseObservableList){
        this.license = license;
        this.licenseObservableList = licenseObservableList;
        seriesNumberTxt.setText(license.getSeriesNumber());
        categryTxt.setText(license.getCategory());
        dateIssuePicker.setValue(license.getDateIssue());
        endDatePicker.setValue(license.getEndDate());
        gibddTxt.setText(license.getGibdd());
        placeIssueTxt.setText(license.getPlaceIssue());
    }
}
