package projects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void switchForm(ActionEvent event) {
        if(event.getSource() == signIn_createAccount){
            signIn_form.setVisible(false);
            signUp_form.setVisible(true);
        }else if(event.getSource() == signUp_alreadyHaveAccount){
            signIn_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }
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
    // database
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;




    public void signup() {
        String sql ="INSERT INTO admin (email,username,password) VALUEs (?,?,?";
        connect = Database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1,signUp_email.getText());
            prepare.setString(2,signUp_username.getText());
            prepare.setString(3,signUp_password.getText());

            Alert alert;

            if(signUp_email.getText().isEmpty() || signUp_username.getText().isEmpty() || signUp_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }
            else if(signUp_password.getText().length() < 8){

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid password");
                alert.showAndWait();

            }else {

                if (validEmail()) {

                    prepare.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully create a new account!");
                    alert.showAndWait();

                    signUp_email.setText("");
                    signUp_username.setText("");
                    signUp_password.setText("");
                }
                    prepare.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully create a new account!");
                    alert.showAndWait();

                    signUp_email.setText("");
                    signUp_username.setText("");
                    signUp_password.setText("");

            }
        }catch(Exception e)
        {e.printStackTrace();}
    }


    public void signin(){
        String sql = "SELECT * FROM admin WHERE username = ? and password =?";
        connect = Database.connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signIn_username.getText());
            prepare.setString(2, signIn_password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if(signIn_username.getText().isEmpty() || signIn_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blacnk field");
                alert.showAndWait();

            }else {
                if(result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully Login");
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/password");
                    alert.showAndWait();
                }
            }

        }catch(Exception e) {e.printStackTrace();}


    }
    public  boolean validEmail(){
        //admin_123@gmail.com[FIRST LETTER] [SECOND LETTER -> BEFORE @] [@]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-0]+([.][a-zA-Z]+)+");
        Matcher match = pattern.matcher(signUp_email.getText());
        Alert alert;
        if(match.find() && match.group().matches(signUp_email.getText())){
            return true;

        }else{
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email");
            alert.showAndWait();
        }
        return false;
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
