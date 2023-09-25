package lk.ijse.carrent.layerd.controller;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.carrent.layerd.dto.CustomerDto;
import lk.ijse.carrent.layerd.dto.tm.CustomerTm;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;


    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableView<CustomerTm> tblGetAllCustomer;

    @FXML
    private AnchorPane anchorPaneTbl;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblShowDetails;

    static String userName;

    static List<String> mobiles = new ArrayList<>();

    CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    public void initialize() {

        setValueFactory();
        getAllTable();
        lblBack.setVisible(false);
        backTbl();

    }

    private void backTbl() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.8),anchorPaneTbl);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        lblShowDetails.setVisible(true);
        lblBack.setVisible(false);

    }

    @FXML
    void showAllDetailsOnAction(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),anchorPaneTbl);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
        lblShowDetails.setVisible(false);
        lblBack.setVisible(true);

    }

    @FXML
    void lblBackOnAction(MouseEvent event) {

        backTbl();

    }

    private void getAllTable() {
        try {
            List<CustomerDto> customerDtos =  customerService.getAllCustomer();
            setCustomerTable(customerDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCustomerTable(List<CustomerDto> customerDtos) {
        ObservableList<CustomerTm> obl = FXCollections.observableArrayList();

        for (CustomerDto dto:customerDtos
             ) {
            var tm = new CustomerTm(dto.getId(), dto.getNic(), dto.getName(), dto.getAddress(), dto.getDob());
            obl.add(tm);
        }
        tblGetAllCustomer.setItems(obl);
    }

    private void setValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));

    }



    public void runUserId(String id){


        userName = id;
    }

    @FXML
    void btnAddMobileOnAction(ActionEvent event) {
    mobiles.add(txtMobile.getText());
        for (String s:mobiles
             ) {
            System.out.print("mobils=="+s);
        }


    }

    @FXML
    void btnAddCusOnAction(ActionEvent event) {

        CustomerDto customerDto = new CustomerDto(txtId.getText(),txtNic.getText(),txtName.getText(),txtAddress.getText(),txtDob.getText(),userName,mobiles);
        try {
            String result = customerService.addCustomer(customerDto);
            mobiles.clear();
            getAllTable();
            new Alert(Alert.AlertType.CONFIRMATION,result).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }



    @FXML
    void btnDeleteCusOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCusOnAction(ActionEvent event) {

    }
}
