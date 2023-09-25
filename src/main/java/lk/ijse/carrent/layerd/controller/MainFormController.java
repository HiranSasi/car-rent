package lk.ijse.carrent.layerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    @FXML
    private AnchorPane anchorpaneChanges;

    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    void btnCarCategoryOnAction(ActionEvent event) throws IOException {

        Parent root =FXMLLoader.load(getClass().getResource("/view/car_category_form.fxml"));
        this.anchorpaneChanges.getChildren().clear();
        this.anchorpaneChanges.getChildren().add(root);

    }

    @FXML
    void btnCarDetailsOnAction(ActionEvent event) throws IOException {

        Parent root =FXMLLoader.load(getClass().getResource("/view/car_details_from.fxml"));
        this.anchorpaneChanges.getChildren().clear();
        this.anchorpaneChanges.getChildren().add(root);


    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        this.anchorpaneChanges.getChildren().clear();
        this.anchorpaneChanges.getChildren().add(root);


    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        this.anchorpaneChanges.getChildren().clear();
        this.anchorpaneChanges.getChildren().add(root);

    }

}
