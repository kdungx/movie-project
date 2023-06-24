
package moviebook;



import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class DashboardController implements Initializable {


    
    

    @FXML
    private TableView<?> addScreening_tableView;

    @FXML
    private Button addMovies_update;

    @FXML
    private Button signout;

    @FXML
    private Button addMovies_insert;

    @FXML
    private Label avaliableMovie_nomaClass_price;

    @FXML
    private Label avaliableMovies_date;

    @FXML
    private SplitMenuButton avaliableMovie_nomaClass_quantitys;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableColumn<?, ?> avaliableMovie_col_movieTitle;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button editScreening_btn;

    @FXML
    private Button addMovies_delete;

    @FXML
    private TableColumn<?, ?> avaliableMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;

    @FXML
    private Button editScreening_delete;

    @FXML
    private TableColumn<?, ?> customers_col_genre;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button avaliableMovie_buyBtn;

    @FXML
    private Button avaliableMovie_clearBtn;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Label avaliableMovies_moviesTitle;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TextField addMovies_search;

    @FXML
    private ImageView avaliableMovies_imageView;

    @FXML
    private Label avaliableMovie_specialClass_price;

    @FXML
    private TableColumn<?, ?> editScreening_col_genre;

    @FXML
    private AnchorPane topForm;

    @FXML
    private Label customers_genre;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private TableView<moviesData> addMovies_tableView;

    @FXML
    private Button customers_btn;

    @FXML
    private TableColumn<?, ?> editScreening_col_current;

    @FXML
    private TableColumn<?, ?> customers_col_time;

    @FXML
    private TableColumn<?, ?> avaliableMovie_col_showingDate;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private TableView<?> avaliableMovies_tableView;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private Label avaliableMovie_total;

    @FXML
    private Label customers_date;

    @FXML
    private Label avaliableMovies_title;

    @FXML
    private TableColumn<?, ?> editScreening_col_movieTitle;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private TextField customers_search;

    @FXML
    private Button avaliableMovie_recceiptBtn;

    @FXML
    private TableColumn<?, ?> editScreening_col_duration;

    @FXML
    private Label avaliableMovies_genre;

    @FXML
    private Button avaliableMovies_selectMovie;

    @FXML
    private TableColumn<?, ?> customers_col_date;

    @FXML
    private Button addMovies_btn;

    @FXML
    private Label editScreening_title;

    @FXML
    private TableColumn<?, ?> customers_col_ticketNumber;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private Button editScreening_update;

    @FXML
    private DatePicker addMovies_date;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_date;

    @FXML
    private Button dashboard_btn;

    @FXML
    private SplitMenuButton avaliableMovie_specialClass_quantitys;

    @FXML
    private Label customers_time;

    @FXML
    private Label customers_tickeNumber;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;

    @FXML
    private Button addMovies_clear;

    @FXML
    private TableColumn<?, ?> customers_col_movieTitle;

     @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label dashboard_totalEarnToday;

    @FXML
    private Label dashboard_availableMovies;

    @FXML
    private ImageView addMovies_imageView;

    @FXML
    private TextField addMovies_genre;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private AnchorPane dashboard_totalSoldTicket;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private Label username;


   
    
    private Image image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    public void importImage(){
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("image File","*png","*jpg"));
        
        Stage stage = (Stage)addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);
           if(file != null){
            image = new Image(file.toURI().toString(),188,232,false,true);
            addMovies_imageView.setImage(image);
            getData.path =  file.getAbsolutePath();
        }
    }
    

    
    public void movieId(){
        String sql = "SELECT count(id) FROM movie";
	
	connect = database.connectDb();
        try{
		prepare = connect.prepareStatement(sql);
		result = prepare.executeQuery();
                
		if(result.next()){
			getData.movieId = result.getInt("count(id)");
		}
		
	} catch(Exception e) {e.printStackTrace(); }
      }
    
    
    
      public void insertAddMovies(){
      
          String sql1 = "SELECT movieTitle FROM movie WHERE movieTitle = '" + addMovies_movieTitle.getText() + "'";
        
        connect = database.connectDb();
          Alert alert;
          try{
            statement = connect.createStatement();
            result = statement.executeQuery(sql1);
            
            if(result.next()){
                
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText()+"was already exist");
                alert.showAndWait();
                
            }else{
                if(addMovies_movieTitle.getText().isEmpty()
                      ||addMovies_genre.getText().isEmpty()
                      ||addMovies_duration.getText().isEmpty()
                      ||addMovies_imageView.getImage() == null
                      ||addMovies_date.getValue() == null ){
                    
                
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                   String sql = "INSERT INTO movie (id,movieTitle, genre, duration,image,date) VALUES(?,?,?,?,?,?)";  
                   
                   String uri = getData.path;
                   uri = uri.replace("\\", "\\\\");
                   
            movieId();
                   
            String mID = String.valueOf(getData.movieId+1);
            
            prepare = connect.prepareStatement(sql);
            
             prepare.setString(1, mID);
            prepare.setString(2, addMovies_movieTitle.getText());
            prepare.setString(3, addMovies_genre.getText());
            prepare.setString(4, addMovies_duration.getText());
            prepare.setString(5, uri);
            prepare.setString(6, String.valueOf(addMovies_date.getValue()));
            
            
            prepare.execute();
            
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully add new movie!");
                alert.showAndWait();
                
                clearAddMoviesList();
                showAddMoviesList();
                }
             }
             
            
        }catch( Exception e){e.printStackTrace();}
        
          
      }
      
    public void updateAddMovies(){
        String uri = getData.path;
        uri = uri.replace("\\","\\\\");
        
        String sql = "UPDATE movie SET movieTitle = '" + addMovies_movieTitle.getText()
                + "', genre = '" + addMovies_genre.getText()
                + "', duration = '" + addMovies_duration.getText()
                + "', image= '" + uri 
                + "', date = '" + addMovies_date.getValue() 
                + "' WHERE id = '" + String.valueOf(getData.movieId)+ "'";
                
        connect = database.connectDb();
        try{
                    
                statement = connect.createStatement();
                Alert alert;
                if(addMovies_movieTitle.getText().isEmpty()
                   || addMovies_genre.getText().isEmpty()
                   || addMovies_duration.getText().isEmpty()
                   || addMovies_imageView.getImage()==null
                   || addMovies_date.getValue()==null
                        ){
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select the movie first");
                    alert.showAndWait();
                }else{
                    statement.executeUpdate(sql);
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully updated" + addMovies_movieTitle.getText());
                    alert.showAndWait();
                    
                    showAddMoviesList();
                    clearAddMoviesList();
                }
        }catch (Exception e){e.printStackTrace();
    }
    }
      
    public void deleteAddMovies(){
        String sql = "DELETE FROM movie WHERE movieTitle = '" 
                        + addMovies_movieTitle.getText() + " ' ";
	connect = database.connectDb();
        	try {
		statement = connect.createStatement();
		Alert alert;
		if(addMovies_movieTitle.getText().isEmpty() 
                        || addMovies_genre.getText().isEmpty() 
                        || addMovies_duration.getText().isEmpty() 
                        || addMovies_date.getValue() ==null 
                        || addMovies_imageView.getImage()==null){
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select the movie first");
			alert.showAndWait();
		} else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confimation Message");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure to want delete"
                                +addMovies_movieTitle.getText() + "?");
			Optional<ButtonType> option = alert.showAndWait();
			if(ButtonType.OK.equals(option.get())){
				statement.executeUpdate(sql);
                                
				showAddMoviesList();
                                
				clearAddMoviesList();
                                
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully delete!");
				alert.showAndWait();
			} else {
				return;
			}
		}
	} catch (Exception e){e.printStackTrace(); }
        
        
        
        
    }
    
    
    
    public void clearAddMoviesList(){
        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_imageView.setImage(null);
        addMovies_date.setValue(null);
    }
      
    
    public ObservableList<moviesData> addMoviesList(){
        ObservableList<moviesData> listData = FXCollections.observableArrayList();
        String sql = "SELECT* FROM movie";
        connect = database.connectDb();
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            moviesData movD;
            while(result.next()){
                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"));
                listData.add(movD);
            }
        }catch (Exception e){e.printStackTrace();}
        return listData;
    }
    
    private ObservableList<moviesData> listAddMovies;
    public void showAddMoviesList(){
        listAddMovies = addMoviesList();
        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        addMovies_tableView.setItems(listAddMovies);
    }
        
    public void selectAddMoviesList(){
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();
        
        if ((num-1)< -1){
            return;
        }
        
        getData.path = movD.getImage();
        
        getData.movieId =movD.getId();
        
        
        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());
        String getDate = String.valueOf(movD.getDate());
        
        
        String uri = "file:" + movD.getImage();
        image = new Image(uri, 188, 232,false,true);
        addMovies_imageView.setImage(image);
        
        addMovies_date.setValue(movD.getDate().toLocalDate());
    }
    
    
    public void switchForm(ActionEvent event){
        if(event.getSource() == dashboard_btn){
            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:#ae2d3c");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

        }else if(event.getSource()==addMovies_btn){
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            addMovies_btn.setStyle("-fx-background-color:#ae2d3c");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

        }else if(event.getSource()==availableMovies_btn){
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            availableMovies_btn.setStyle("-fx-background-color:#ae2d3c");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == editScreening_btn) {
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(true);
            customers_form.setVisible(false);

            editScreening_btn.setStyle("-fx-background-color:#ae2d3c");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == customers_btn) {
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(true);

            customers_btn.setStyle("-fx-background-color:#ae2d3c");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");

        }
    }
    
    
    
    public void displayUsername() {
        username.setText(getData.username);
    }

    public void close() {
        System.exit(0);

    }
    public void minimize(){

        Stage stage =(Stage)topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();
        showAddMoviesList();
    }
}