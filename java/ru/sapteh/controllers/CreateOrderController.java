package ru.sapteh.controllers;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.ParagraphStyle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import javafx.stage.Stage;
import org.apache.xmlbeans.XmlException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.*;
import ru.sapteh.service.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class CreateOrderController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Orders, Integer> ordersDAO = new OrdersServ(factory);
    DAO<Transport, Integer> transportDAO = new TransportServ(factory);
    DAO<IdTransport, Integer> idTransportIntegerDAO = new IdTransportServ(factory);
    DAO<Client, Integer> clientDAO = new ClientServ(factory);
    DAO<Consignee, Integer> consigneeDAO = new ConsigneeServ(factory);
    DAO<Drivers, Integer> driversDAO = new DriversServ(factory);
    DAO<Cargo, Integer> cargoDAO = new CargoServ(factory);
    DAO<Managers, Integer> managersDAO = new ManagersServ(factory);
    DAO<Trailer, Integer> trailerDAO = new TrailerServ(factory);
    DAO<Mechanics, Integer> mechanicsDAO = new MechanicsServ(factory);
    DAO<CargoType, Integer> cargoTypeDAO = new CargoTypeServ(factory);
    ObservableList<Managers> managers = FXCollections.observableArrayList();
    ObservableList<Trailer> trailers = FXCollections.observableArrayList();
    ObservableList<Drivers> drivers = FXCollections.observableArrayList();
    ObservableList<Orders> orders = FXCollections.observableArrayList();
    ObservableList<IdTransport> idTransports = FXCollections.observableArrayList();
    ObservableList<Transport> transportList = FXCollections.observableArrayList();
    ObservableList<Client> clients = FXCollections.observableArrayList();
    ObservableList<Mechanics> mechanics = FXCollections.observableArrayList();
    ObservableList<Consignee> consignees = FXCollections.observableArrayList();
    ObservableList<Cargo> cargos = FXCollections.observableArrayList();
    ObservableList<CargoType> cargoTypes = FXCollections.observableArrayList();
    IdTransport idTransport = new IdTransport();
    Transport transport;

    @FXML
    private TextField fromTxt;

    @FXML
    private TextField where;

    @FXML
    private TextField distanceTxt;

    @FXML
    private DatePicker dateSendingPicket;

    @FXML
    private TextField costGasolineTxt;

    @FXML
    private Button selectTransportButton;

    @FXML
    TextField transportTxt;

    @FXML
    private TextField clientFioTxt;

    @FXML
    private TextField clientPhoneTxt;

    @FXML
    private TextField clientEmailTxt;

    @FXML
    private TextField consigneeFioTxt;

    @FXML
    private TextField consigneePhoneTxt;

    @FXML
    private TextField consigneeEmailTxt;

    @FXML
    private TextField nameCargoTxt;

    @FXML
    private ComboBox<CargoType> cargoTypeTxt;

    @FXML
    private TextField weightTxt;

    @FXML
    private TextField overallTxt;

    @FXML
    private TextField quantityTxt;

    @FXML
    private TextField packagesTxt;

    @FXML
    private Button buttonOk;
    @FXML
    private Button buttonExit;
    @FXML
    private ComboBox<Transport> comboTransport;

    @FXML
    private ComboBox<Trailer> comboTrailer;
    @FXML
    private TextField costCargoTxt;
    @FXML
    private Button buttonCost;

    @FXML
    private Label costLbl;

    @FXML
    private ComboBox<Drivers> driverBox;

    @FXML
    private ComboBox<Managers> comboManager;

    @FXML
    private ComboBox<Mechanics> mechanicsBox;

    @FXML
    private TextField fuelConsumptionTxt;

    @FXML
    void initialize() throws IOException {
        orders.addAll(ordersDAO.findByAll());
        transportList.addAll(transportDAO.findByAll());
        clients.addAll(clientDAO.findByAll());
        consignees.addAll(consigneeDAO.findByAll());
        cargos.addAll(cargoDAO.findByAll());
        cargoTypes.addAll(cargoTypeDAO.findByAll());
        idTransports.addAll(idTransportIntegerDAO.findByAll());
        trailers.addAll(trailerDAO.findByAll());
        drivers.addAll(driversDAO.findByAll());
        managers.addAll(managersDAO.findByAll());
        mechanics.addAll(mechanicsDAO.findByAll());
        comboTransport.setItems(transportList);
        driverBox.setItems(drivers);
        comboManager.setItems(managers);
        comboTrailer.setItems(trailers);
        mechanicsBox.setItems(mechanics);
        cargoTypeTxt.setItems(cargoTypes);
    }


    public void create() {
        Orders orders = new Orders();
        Transport transport = new Transport();
        Client client = new Client();
        Consignee consignee = new Consignee();
        Cargo cargo = new Cargo();
        CargoType cargoType = new CargoType();
        orders.setAddress(fromTxt.getText() + "-" + where.getText());
        orders.setDistance(Integer.parseInt(distanceTxt.getText()));
        orders.setDateSending(dateSendingPicket.getValue());
        orders.setTransport(comboTransport.getValue());
        orders.setTrailer(comboTrailer.getValue());
        orders.setDrivers(driverBox.getValue());
        orders.setManagers(comboManager.getValue());
        cargo.setName(nameCargoTxt.getText());
        cargo.setCargoType(cargoTypeTxt.getValue());
        cargo.setWeight(Integer.parseInt(weightTxt.getText()));
        cargo.setOverallDimensions(overallTxt.getText());
        cargo.setPackages(packagesTxt.getText());
        cargo.setQuantity(Integer.parseInt(quantityTxt.getText()));
        cargo.setCost(Integer.parseInt(costCargoTxt.getText()));
        client.setFio(clientFioTxt.getText());
        client.setPhone(clientPhoneTxt.getText());
        client.setEmail(clientEmailTxt.getText());
        consignee.setFio(consigneeFioTxt.getText());
        consignee.setPhone(consigneePhoneTxt.getText());
        consignee.setEmail(consigneeEmailTxt.getText());
        ordersDAO.create(orders);
        cargoDAO.create(cargo);
        clientDAO.create(client);
        consigneeDAO.create(consignee);

    }
    @FXML
    void actionCost(ActionEvent event) {
        int sd = (Integer.parseInt(distanceTxt.getText())/100*Integer.parseInt(costGasolineTxt.getText()))*3;
        Integer res = ((Integer.parseInt(weightTxt.getText())*Integer.parseInt(quantityTxt.getText()))*4) + sd;
        Integer res2 = res;
        System.out.println(res2);
        costLbl.setText(String.valueOf(res2) + " руб.");
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
    String dir = "C:/Users/User/IdeaProjects/Диплом/directory";
    File file = new File(dir);
    @FXML
    void actionOK(ActionEvent event) throws IOException, InvalidFormatException, XmlException {
        create();
        createDoc();
        if (file.mkdir()){
            System.out.println("Есть");
        } else
            System.out.println("Уже есть");
        Desktop desktop = null;
        if(desktop.isDesktopSupported()){
            desktop = Desktop.getDesktop();
        }
        desktop.open(file);
        clear();
    }
    public void createDoc(){
        Document document = new Document();
        Section section = document.addSection();
        Paragraph paragraph1 = section.addParagraph();
        paragraph1.appendText("Путевой лист");
        Paragraph paragraph2 = section.addParagraph();
        paragraph2.appendText("Серия__ №__");
        Paragraph paragraph3 = section.addParagraph();
        paragraph3.appendText("Дата: " + dateSendingPicket.getValue());
        //Заголовок
        paragraph1.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph2.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph3.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        //Добавление стиля для заголовка
        ParagraphStyle style1 = new ParagraphStyle(document);
        style1.setName("titleStyle");
        style1.getCharacterFormat().setFontName("Times New Roman");
        style1.getCharacterFormat().setBold(true);
        style1.getCharacterFormat().setFontSize(16f);
        document.getStyles().add(style1);
        ParagraphStyle style2 = new ParagraphStyle(document);
        style2.setName("titleStyle2");
        style2.getCharacterFormat().setFontName("Times New Roman");
        style2.getCharacterFormat().setBold(true);
        style2.getCharacterFormat().setFontSize(11f);
        document.getStyles().add(style2);
        ParagraphStyle style3 = new ParagraphStyle(document);
        style3.setName("paraStyle");
        style3.getCharacterFormat().setFontName("Times New Roman");
        style3.getCharacterFormat().setFontSize(14f);
        document.getStyles().add(style3);
        ParagraphStyle style4 = new ParagraphStyle(document);
        style4.setName("titleStyle3");
        style4.getCharacterFormat().setFontName("Times New Roman");
        style4.getCharacterFormat().setBold(true);
        style4.getCharacterFormat().setFontSize(14f);
        document.getStyles().add(style4);
        //Добавление стиля
        paragraph1.applyStyle(style1.getName());
        paragraph2.applyStyle(style2.getName());
        paragraph3.applyStyle(style2.getName());
        paragraph3.getFormat().setAfterSpacing(20f);
        Paragraph paragraph4 = section.addParagraph();
        paragraph4.appendText("Организация: ООО «Караван», Юдов А.С.");
        paragraph4.applyStyle(style3.getName());
        paragraph4.getFormat().setAfterSpacing(60f);
        Paragraph paragraph5 = section.addParagraph();
        paragraph5.applyStyle(style3.getName());
        paragraph5.appendText("Марка автомобиля: " + comboTransport.getValue().getMark() + "               Гос. номер: " + comboTransport.getValue().getGosNumber());
        Paragraph paragraph6 = section.addParagraph();
        paragraph6.applyStyle(style3.getName());
        paragraph6.appendText("Водитель: " + driverBox.getValue().getFio() + "               Удостоверение №: " + driverBox.getValue().getLicense().getSeriesNumber());
        Paragraph paragraph7 = section.addParagraph();
        paragraph7.applyStyle(style3.getName());
        paragraph7.appendText("Прицеп: " + comboTrailer.getValue().getMark() + "               Гос. номер: " + comboTrailer.getValue().getGosNumber());
        paragraph7.getFormat().setAfterSpacing(60);
        Paragraph paragraph8 = section.addParagraph();
        paragraph8.applyStyle(style4.getName());
        paragraph8.appendText("Задание водителю");
        paragraph8.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        Paragraph paragraph9 = section.addParagraph();
        paragraph9.applyStyle(style3.getName());
        paragraph9.appendText("Заказчик: " + clientFioTxt.getText());
        Paragraph paragraph10 = section.addParagraph();
        paragraph10.applyStyle(style3.getName());
        paragraph10.appendText("Адрес: " + fromTxt.getText() + "-" + where.getText());
        Paragraph paragraph11 = section.addParagraph();
        paragraph11.applyStyle(style3.getName());
        paragraph11.appendText("Название груза: " + nameCargoTxt.getText());
        Paragraph paragraph12 = section.addParagraph();
        paragraph12.applyStyle(style3.getName());
        paragraph12.appendText("Растояние: " + distanceTxt.getText() + " км");
        Paragraph paragraph13 = section.addParagraph();
        paragraph13.applyStyle(style3.getName());
        paragraph13.appendText("Вес: " + weightTxt.getText() + " кг");
        Paragraph paragraph14 = section.addParagraph();
        paragraph14.applyStyle(style3.getName());
        paragraph14.appendText("Грузополучатель: " + consigneeFioTxt.getText());
        paragraph14.getFormat().setAfterSpacing(130);
        Paragraph paragraph15 = section.addParagraph();
        paragraph15.applyStyle(style3.getName());
        paragraph15.appendText("Диспетчер:_____(Подпись) " + comboManager.getValue().getFio());
        Paragraph paragraph16 = section.addParagraph();
        paragraph16.applyStyle(style3.getName());
        paragraph16.appendText("Автомобиль технически исправен.");
        Paragraph paragraph17 = section.addParagraph();
        paragraph17.applyStyle(style3.getName());
        paragraph17.appendText("Въезд разрешен. Механик_____(Подпись) " + mechanicsBox.getValue().getFio());
        Paragraph paragraph18 = section.addParagraph();
        paragraph18.applyStyle(style3.getName());
        paragraph18.appendText("Автомобиль принял:");
        Paragraph paragraph19 = section.addParagraph();
        paragraph19.applyStyle(style3.getName());
        paragraph19.appendText("Водитель_____(Подпись) " + driverBox.getValue().getFio());
        Paragraph paragraph20 = section.addParagraph();
        paragraph20.applyStyle(style3.getName());
        paragraph20.appendText("Отметки от грузополучателя:");
        Paragraph paragraph21 = section.addParagraph();
        paragraph21.applyStyle(style3.getName());
        Paragraph paragraph22 = section.addParagraph();
        paragraph22.appendText("____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        document.saveToFile("C:/Users/User/IdeaProjects/Диплом/directory/" + fromTxt.getText() + "-" +where.getText() + ". Путевой лист.docx", FileFormat.Docx);
    }
    public void clear(){
        fromTxt.clear();
        where.clear();
        distanceTxt.clear();
        dateSendingPicket.getEditor().clear();
        comboTransport.getEditor().clear();
        driverBox.getEditor().clear();
        comboTrailer.getEditor().clear();
        costGasolineTxt.clear();
        mechanicsBox.getEditor().clear();
        nameCargoTxt.clear();
        cargoTypeTxt.getEditor().clear();
        weightTxt.clear();
        overallTxt.clear();
        quantityTxt.clear();
        packagesTxt.clear();
        costCargoTxt.clear();
        clientFioTxt.clear();
        clientPhoneTxt.clear();
        clientEmailTxt.clear();
        consigneeFioTxt.clear();
        consigneePhoneTxt.clear();
        consigneeEmailTxt.clear();
        comboManager.getEditor().clear();
        costLbl.setText("");
    }
}
