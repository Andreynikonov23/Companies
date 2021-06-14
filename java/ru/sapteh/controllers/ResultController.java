package ru.sapteh.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResultController {
    CreateOrderController createOrderController = new CreateOrderController();

    @FXML
    Label costLbl;

    @FXML
    private Button buttonOk;

    @FXML
    void initialize(){
        System.out.println(result);
        costLbl.setText(String.valueOf(result));
    }

    @FXML
    void actionOK(ActionEvent event) {
        createOrderController.create();
    }
    Integer result;
    public void setData(Integer result){
       this.result = result;
       
    }
}
