
package moviebook;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class  FXMLDocumentController implements Initializable {
    @FXML
    private FontAwesomeIcon signin_close;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signUp_username;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private TextField signin_username;

    @FXML
    private FontAwesomeIcon signUp_minimize;

    @FXML
    private Button signUp_btn;

    @FXML
    private FontAwesomeIcon signin_minimize;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private FontAwesomeIcon signin_close1;

    @FXML
    private Button signin_loginBtn;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private TextField signUp_email;

    @FXML
    private Button signUp_close;

    @FXML
    private Hyperlink signUp_alreadyHaveAccount;

    // database
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void signup() {
        String sql ="INSERT INTO admin (email,username,password) VALUEs (?,?,?)";
        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1,signUp_email.getText());
            prepare.setString(2,signUp_username.getText());
            prepare.setString(3,signUp_password.getText());

            Alert alert;
            if(signUp_email.getText().isEmpty() || signUp_username.getText().isEmpty() || signUp_password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else if(signUp_password.getText().length() < 8){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid password");
                alert.showAndWait();
            }else{
                prepare.execute();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Succesfully create a new account!");
                alert.showAndWait();


                signUp_email.setText("");
                signUp_username.setText("");
                signUp_password.setText("");
            }

        }catch(Exception e) {e.printStackTrace();}
    }


    public void switchForm(ActionEvent event) {
        if(event.getSource() == signin_createAccount){
            signin_form.setVisible(false);
            signUp_form.setVisible(true);
        }else if(event.getSource() == signUp_alreadyHaveAccount){
            signin_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }
    private double x = 0;
    private double y = 0;

    public void signin(){
        String sql = "SELECT * FROM admin WHERE username = ? and password =?";
        connect = database.connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signin_username.getText());
            prepare.setString(2, signin_password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if(signin_username.getText().isEmpty() || signin_password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();



            }else {

                if(result.next()){

                    getData.username = signin_username.getText();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully Login");
                    alert.showAndWait();
                    //giau login form sau khi dang nhap
                    signin_loginBtn.getScene().getWindow().hide();
                    //chuyen giao giua login form va dashboard


                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event)->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event)-> {
                        stage.setX(event.getScreenX()-x);
                        stage.setY(event.getScreenY()-y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/password");
                    alert.showAndWait();
                }
            }

        }catch(Exception e) {e.printStackTrace();}


    }

    public void signIn_close(){
        System.exit(0);
    }
    public void signIn_minimize(){
        Stage stage = (Stage)signin_form.getScene().getWindow();
        stage.setIconified(true);
    }
    public void signUp_close(){
        System.exit(0);

    }
    public void signUp_minimize(){
        Stage stage = (Stage)signUp_form.getScene().getWindow();
        stage.setIconified(true);

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
