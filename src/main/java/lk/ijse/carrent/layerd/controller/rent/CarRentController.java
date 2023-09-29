package lk.ijse.carrent.layerd.controller.rent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.carrent.layerd.dto.CarDetailsDto;
import lk.ijse.carrent.layerd.dto.CustomerDto;
import lk.ijse.carrent.layerd.dto.RentDto;
import lk.ijse.carrent.layerd.entity.CustomerEntity;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.CarDetailsSrevice;
import lk.ijse.carrent.layerd.service.custom.CustomerService;
import lk.ijse.carrent.layerd.service.custom.RentService;

import java.rmi.ServerError;
import java.time.LocalDate;
import java.util.Date;

public class CarRentController {

    @FXML
    private TextField txtCarId;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtPricePerDay;

    @FXML
    private TextField txtRentId;

    @FXML
    private Label lblDetailsCar;

    @FXML
    private Label lblDetailsCust;

    @FXML
    private DatePicker datePickerFromDate;

    @FXML
    private DatePicker datePickerToDate;

    @FXML
    private TextField txtDeposit;

    @FXML
    private TextField txtAdvancedPay;


    CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    CarDetailsSrevice carDetailsSrevice = (CarDetailsSrevice) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CARDETAILS);
    RentService rentService = (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    static String userName;
    public void initialize() {

        datePickerFromDate.setDayCellFactory(datePicker -> new DateCell(){
            public void updateItem(LocalDate date,boolean empty){
                super.updateItem(date,empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0);
            }
        });
    }

    public void runUserId(String id){


        userName = id;
    }
    @FXML
    void btnOnSearchCust(ActionEvent event) {


        try {
            CustomerDto customerDto = customerService.searchCustomer(txtCustId.getText());

                lblDetailsCust.setText(customerDto.getName()+","+customerDto.getNic()+", "+customerDto.getAddress());

        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer Id is not valid please try again").show();
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnSearchCar(ActionEvent event) {

        try {
            CarDetailsDto carDetailsDto = carDetailsSrevice.search(txtCarId.getText());
            lblDetailsCar.setText(carDetailsDto.getCarCategoryName()+", "+carDetailsDto.getBrand()+", "+carDetailsDto.getModel()+", "+carDetailsDto.getVehicleNumber());
            txtPricePerDay.setText(String.valueOf(carDetailsDto.getPricePerDay()));
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,"Car Id is not valid please try again").show();
            txtPricePerDay.setText("");

            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

        RentDto rentDto = new RentDto(txtRentId.getText(),
                Double.parseDouble(txtPricePerDay.getText()),
                datePickerFromDate.getValue(),
                datePickerToDate.getValue(),
                Double.parseDouble(txtAdvancedPay.getText()),
                Double.parseDouble(txtDeposit.getText()),
                userName,
                txtCustId.getText()
               ,txtCarId.getText() );

        try {
            String result = rentService.addRent(rentDto);
            new Alert(Alert.AlertType.CONFIRMATION,result).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            throw new RuntimeException(e);
        }

    }

    @FXML
    void dpGetFromDateOnAction(ActionEvent event) {



        datePickerToDate.setDayCellFactory(datePicker -> new DateCell(){
            public void updateItem(LocalDate date,boolean empty){
                super.updateItem(date,empty);
                LocalDate fromDateValue = datePickerFromDate.getValue();
                LocalDate upDate = datePickerFromDate.getValue().plusDays(15);
                if(date.isBefore(fromDateValue)|| date.isAfter(upDate)){
                    setDisable(true);

                }else {
                    setDisable(false);
                    setStyle("-fx-background-color:#a29bfe;");
                }
            }
        });




    }
}
