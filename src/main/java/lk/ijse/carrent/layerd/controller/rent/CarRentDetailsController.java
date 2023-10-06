package lk.ijse.carrent.layerd.controller.rent;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.carrent.layerd.dto.RentDto;
import lk.ijse.carrent.layerd.dto.tm.CustomerRentDetailsTM;
import lk.ijse.carrent.layerd.dto.tm.RentCarDetailsTm;
import lk.ijse.carrent.layerd.dto.tm.RentDetailsTm;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.RentService;

import java.util.List;

public class CarRentDetailsController {

    @FXML
    private AnchorPane anchorPaneSearch;

    @FXML
    private AnchorPane anchorPaneTbl;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colFromDate;

    @FXML
    private TableColumn<?, ?> colRentId;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colToDate;

    @FXML
    private Label lblSearchDetails;

    @FXML
    private TableView<RentDetailsTm> tblCar;

    @FXML
    private TextField txtCarId;

    @FXML
    private Label lblCarRentDetails;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private Label lblCustomerRentDetails;

    @FXML
    private TableColumn<?, ?> colCarId;

    @FXML
    private TableColumn<?, ?> colFromDate2;

    @FXML
    private TableColumn<?, ?> colRentId2;

    @FXML
    private TableColumn<?, ?> colReturnDate2;

    @FXML
    private TableColumn<?, ?> colToDate2;

    @FXML
    private TableView<CustomerRentDetailsTM> tblCustomer;




    RentService rentService = (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);

    public void initialize() {
        anchorPaneSearch.setVisible(false);
        anchorPaneTbl.setVisible(false);
        setValueFactory();


    }

    @FXML
    void lblCarRentDetailsOnAction(MouseEvent event) {
        anchorPaneSearch.setVisible(true);
        txtCustomerId.setVisible(false);
        txtCarId.setVisible(true);
        lblSearchDetails.setVisible(false);
        anchorPaneTbl.setVisible(false);

    }

    private void setValueFactory() {
        colRentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colFromDate.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        colToDate.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colRentId2.setCellValueFactory(new PropertyValueFactory<>("id1"));
        colFromDate2.setCellValueFactory(new PropertyValueFactory<>("fromDate1"));
        colToDate2.setCellValueFactory(new PropertyValueFactory<>("toDate1"));
        colReturnDate2.setCellValueFactory(new PropertyValueFactory<>("returnDate1"));
        colCarId.setCellValueFactory(new PropertyValueFactory<>("carId1"));

    }

    @FXML
    void btnOnCarIdAction(ActionEvent event) {
        lblSearchDetails.setVisible(true);
        getPane();
        tblCustomer.setVisible(false);
        tblCar.setVisible(true);

        lblSearchDetails.setText("");

        try {
            List<RentDto> rentDtos = rentService.getList(txtCarId.getText());
           setCarDetails(rentDtos);
            for (RentDto dto:rentDtos
                 ) {

                lblSearchDetails.setText("     "+dto.getCarBrand()+"  "+dto.getCarModel()+"  "+dto.getVehicleNumber());
                break;
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            throw new RuntimeException(e);
        }

    }

    private void setCarDetails(List<RentDto> rentDtos) {
        ObservableList<RentDetailsTm>obl = FXCollections.observableArrayList();
        for (RentDto dto:rentDtos
             ) {
            if (dto.getRetunDate() != null) {
                obl.add(new RentDetailsTm(dto.getId(), dto.getToDate().toString(), dto.getFromDate().toString(), dto.getRetunDate().toString(), dto.getCustId()));
            }else {
                obl.add(new RentDetailsTm(dto.getId(), dto.getToDate().toString(), dto.getFromDate().toString(), "Not Yet", dto.getCustId()));
            }
        }
        tblCar.setItems(obl);
    }

    void getPane() {
        anchorPaneTbl.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),anchorPaneTbl);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();


    }
    void BackPane(){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),anchorPaneTbl);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }



    @FXML
    void btnCustRentDetailsOnAction(ActionEvent event) {
        lblSearchDetails.setVisible(true);
        lblSearchDetails.setText("");
        getPane();
        tblCar.setVisible(false);
        tblCustomer.setVisible(true);
        tblCustomer.setItems(null);

        try {
            List<RentDto> rentDtos = rentService.getCustomerRentDetailsList(txtCustomerId.getText());
            setCustomerDetails(rentDtos);
            for (RentDto dto:rentDtos
                 ) {
                lblSearchDetails.setText("     "+dto.getCustName()+"   "+dto.getCustNic());
                break;
            }

            setCustomerDetails(rentDtos);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

            throw new RuntimeException(e);
        }

    }

    private void setCustomerDetails(List<RentDto> rentDtos) {
        ObservableList<CustomerRentDetailsTM> obl = FXCollections.observableArrayList();
        for (RentDto dto:rentDtos
             ) {
            if (dto.getRetunDate() != null) {
                obl.add(new CustomerRentDetailsTM(dto.getId()
                        , dto.getToDate().toString(),
                        dto.getFromDate().toString(),
                        dto.getRetunDate().toString(),
                        dto.getCarId()));
            }else {
                obl.add(new CustomerRentDetailsTM(dto.getId()
                        , dto.getToDate().toString(),
                        dto.getFromDate().toString(),
                        "Not Yet",
                        dto.getCarId()));

            }
            tblCustomer.setItems(obl);
        }
    }

    @FXML
    void lblCustomerRentDetailsOnAction(MouseEvent event) {
        anchorPaneSearch.setVisible(true);
        txtCarId.setVisible(false);
        lblSearchDetails.setVisible(false);
        txtCustomerId.setVisible(true);
        anchorPaneTbl.setVisible(false);

    }


}
