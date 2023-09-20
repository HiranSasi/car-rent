package lk.ijse.carrent.layerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carrent.layerd.dto.CarCategoryDto;

import java.io.IOException;
import java.util.List;

public class CarDetailsController {

CarCategoryController carCategoryController;




    @FXML
    private AnchorPane anchorPaneChange;

    @FXML
    void btnCarAddOrUpdateOnAction(ActionEvent event) throws IOException {

       Parent root = FXMLLoader.load(getClass().getResource("/View/car_add_update_form.fxml"));
     this.anchorPaneChange  .getChildren().clear();
      this.anchorPaneChange.getChildren().add(root);

    }

    @FXML
    void btnCarDetailsOnAction(ActionEvent event) {

    }

}
