package lk.ijse.carrent.layerd.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.carrent.layerd.dto.UserDto;
import lk.ijse.carrent.layerd.service.ServiceFactory;
import lk.ijse.carrent.layerd.service.custom.UserService;

public class LoginFormController {
    @FXML
    private AnchorPane AnchorPaneEmpty;

    @FXML
    private AnchorPane anchorPaneColurSide;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnSignUps;

    @FXML
    private ImageView imageSignIn;

    @FXML
    private Label labelSignIn;

    @FXML
    private Label lblCreateAcount;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUSerId;

    @FXML
    private TextField txtUserName;

    @FXML
    private Button btnSignIns;

    UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public void initialize() {

        lblCreateAcount.setVisible(false);
        txtEmail.setVisible(false);
        txtName.setVisible(false);
        txtUSerId.setVisible(false);
        btnSignUp.setVisible(false);
        btnSignIns.setVisible(false);

    }


    public void btnSingUpChangeOnAction(ActionEvent actionEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.9));
        slide.setNode(AnchorPaneEmpty);

        slide.setToX(256);
        slide.play();

        anchorPaneColurSide.setTranslateX(-450);

        lblCreateAcount.setVisible(true);
        labelSignIn.setVisible(false);
        txtName.setVisible(true);
        txtEmail.setVisible(true);
        txtUSerId.setVisible(true);
        imageSignIn.setVisible(false);
        btnSignIn.setVisible(false);
        btnSignUp.setVisible(true);
        btnSignUps.setVisible(false);
        btnSignIns.setVisible(true);


    }

    @FXML
    void btnSignInChangeOnAction(ActionEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(AnchorPaneEmpty);

        slide.setToX(0);
        slide.play();

        anchorPaneColurSide.setTranslateX(0);

        lblCreateAcount.setVisible(false);
        labelSignIn.setVisible(true);
        txtName.setVisible(false);
        txtEmail.setVisible(false);
        txtUSerId.setVisible(false);
        imageSignIn.setVisible(true);
        btnSignIn.setVisible(true);
        btnSignUp.setVisible(false);
        btnSignUps.setVisible(true);
        btnSignIns.setVisible(false);

    }


    @FXML
    void btnSignUpOnAction(ActionEvent event) {

       UserDto userDto = new UserDto(txtUSerId.getText(),
               txtUserName.getText(),
               txtName.getText(),
               txtEmail.getText(),
               txtPassword.getText());

        try {
            String result = userService.addUser(userDto);
            new Alert(Alert.AlertType.INFORMATION,result).show();
            clear();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            clear();
        }

    }

    private void clear(){
        txtUSerId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
    }
}
