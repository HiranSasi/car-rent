package lk.ijse.carrent.layerd.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.carrent.layerd.dto.CarCategoryDto;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.CarCategoryService;

import java.util.List;

public class CarAddController {

    @FXML
    private ComboBox<String> cmbCarCategory;

    @FXML
    private TextField txtCarCategoryId;
    CarCategoryService carCategoryService = (CarCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CARCATEGORY);

    public void initialize() {

        List<CarCategoryDto> categoryDtos = null;
        try {
            categoryDtos = carCategoryService.getAll();
            setCarCategoryName(categoryDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    private void setCarCategoryName(List<CarCategoryDto> categoryDtos) {
        ObservableList<String> obList = FXCollections.observableArrayList();

        for (CarCategoryDto dto:categoryDtos
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
