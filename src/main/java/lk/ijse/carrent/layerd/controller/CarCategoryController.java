package lk.ijse.carrent.layerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.carrent.layerd.dto.CarCategoryDto;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.CarCategoryService;

public class CarCategoryController {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

static String userName;
    CarCategoryService carCategoryService = (CarCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CARCATEGORY);


    public void runUserId(String id){

        System.out.println("new="+id);
        userName = id;
    }
    @FXML
    void btnAddOnAction(ActionEvent event) {


        System.out.println("newnip="+userName);


        CarCategoryDto carCategoryDto = new CarCategoryDto(txtId.getText(),txtName.getText(),userName);

        try {
            String result = carCategoryService.addCarCategory(carCategoryDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
}
