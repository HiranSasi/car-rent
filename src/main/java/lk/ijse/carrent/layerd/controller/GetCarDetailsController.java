package lk.ijse.carrent.layerd.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.carrent.layerd.dto.CarCategoryDto;
import lk.ijse.carrent.layerd.dto.CarDetailsDto;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.CarCategoryService;
import lk.ijse.carrent.layerd.service.custom.CarDetailsSrevice;

import java.util.ArrayList;
import java.util.List;

public class GetCarDetailsController {


    @FXML
    private ComboBox<String> cmbCarCategory;

    @FXML
    private ComboBox<String> cmbCarModel;

    @FXML
    private TextField txtCarCategoryId;

    @FXML
    private ComboBox<String> cmbCarModel1;


    CarDetailsSrevice carDetailsSrevice = (CarDetailsSrevice) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CARDETAILS);
    CarCategoryService carCategoryService = (CarCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CARCATEGORY);

    public void initialize() {

        getAllCarCategory();
    }
    private void getAllCarCategory() {
        List<CarCategoryDto> categoryDtos = new ArrayList<>();
        try {
            categoryDtos = carCategoryService.getAll();
            setCarCategoryName(categoryDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void setCarCategoryName(List<CarCategoryDto> categoryDtos) {
        ObservableList<String> obList = FXCollections.observableArrayList();

        for (CarCategoryDto dto : categoryDtos
        ) {
            obList.add(dto.getName());

        }
        cmbCarCategory.setItems(obList);

    }
    @FXML
    void cmbCarCategoryOnAction(ActionEvent event) {
        String CarCategoryName = cmbCarCategory.getValue();
        try {
            CarCategoryDto carCategoryDto = carCategoryService.search(CarCategoryName);
            txtCarCategoryId.setText(carCategoryDto.getId());
            getCarBrand(carCategoryDto.getId());


        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            throw new RuntimeException(e);
        }


    }

    void getCarBrand(String id){



        try {
            List<String> carModel =carDetailsSrevice.getBrand(id);
            ObservableList<String> obl = FXCollections.observableArrayList();

            for (String brand:carModel
                 ) {
                obl.add(brand);
            }
            cmbCarModel.setItems(obl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbCarBrandOnAction(ActionEvent event) {
        String brand = cmbCarModel.getValue();
        String carCategoryId = txtCarCategoryId.getText();

        CarDetailsDto carDetailsDto = new CarDetailsDto();
        carDetailsDto.setBrand(brand);
        carDetailsDto.setCarCategoryId(carCategoryId);

        try {
            List<String> carModel =carDetailsSrevice.getCarModel(carDetailsDto.getCarCategoryId(),carDetailsDto.getBrand());
            setCarMode(carModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void setCarMode(List<String> carModel) {
        ObservableList<String> obl = FXCollections.observableArrayList();
        for (String model:carModel
             ) {
            obl.add(model);
        }
        cmbCarModel1.setItems(obl);
    }
}
