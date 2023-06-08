package projects;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class  FXMLDocumentController implements Initializable {
    @FXML
    private Button signIn_loginBtn;

    @FXML
    private Button signIn_minimize;

    @FXML
    private TextField signUp_username;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private Button signUp_minimize;

    @FXML
    private AnchorPane signIn_form;

    @FXML
    private Button signUp_btn;

    @FXML
    private Button signIn_close;

    @FXML
    private TextField signIn_password;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private Hyperlink signIn_createAccount;

    @FXML
    private TextField signIn_username;

    @FXML
    private TextField signUp_email;

    @FXML
    private Hyperlink signUp_alreadyHaveAccount;

    @FXML
    private Button signUp_close;
    public void signIn_close(){
        System.exit(0);
    };

    public void signIn_minimize(){
        Stage stage = (Stage)signIn_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void SignUp_close(){
        System.exit(0);

    }
    public void SignUp_minimize(){
        Stage stage = (Stage)signUp_form.getScene().getWindow();
        stage.setIconified(true);

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
