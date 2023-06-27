package moviebook;
import net.sf.jasperreports.engine.design.JasperDesign;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import net.sf.jasperreports.view.JasperViewer;

public class DashboardController implements Initializable {
    @FXML
    private TableView<customerData> customer_tableView;
    
     @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;

    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;

    @FXML
    private TableView<moviesData> addScreening_tableView;

    @FXML
    private Button addMovies_update;

    @FXML
    private Button signout;

    @FXML
    private Button addMovies_insert;

    @FXML
    private Label availableMovie_nomaClass_price;

    @FXML
    private Label availableMovies_date;

    @FXML
    private SplitMenuButton availableMovie_nomaClass_quantitys;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableColumn<moviesData, String> availableMovie_col_movieTitle;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button editScreening_btn;

    @FXML
    private Button addMovies_delete;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;

    @FXML
    private Button editScreening_delete;

    @FXML
    private TableColumn<customerData, String> customers_col_genre;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button availableMovie_buyBtn;

    @FXML
    private Button availableMovie_clearBtn;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Label availableMovies_moviesTitle;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TextField addMovies_search;

    @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private Label availableMovie_specialClass_price;

    @FXML
    private TableColumn<customerData, String> editScreening_col_genre;

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
    private TableColumn<customerData, String> customers_col_time;

    @FXML
    private TableColumn<moviesData, String> availableMovie_col_showingDate;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private TableView<moviesData> availableMovies_tableView;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private Label availableMovie_total;

    @FXML
    private Label customers_date;

    @FXML
    private Label availableMovies_title;

    @FXML
    private TableColumn<?, ?> editScreening_col_movieTitle;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private TextField customers_search;

    @FXML
    private Button availableMovie_recceiptBtn;

    @FXML
    private TableColumn<?, ?> editScreening_col_duration;

    @FXML
    private Label availableMovies_genre;

    @FXML
    private Button availableMovies_selectMovie;

    @FXML
    private TableColumn<customerData, String> customers_col_date;

    @FXML
    private Button addMovies_btn;

    @FXML
    private Label editScreening_title;

    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;

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
    private SplitMenuButton availableMovie_specialClass_quantitys;

    @FXML
    private Label customers_time;

    @FXML
    private Label customers_ticketNumber;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;

    @FXML
    private Button addMovies_clear;

    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;

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
    @FXML
    private Button logout;
    
    

    private Image image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    
    private float price1 = 0;
    private float price2 = 0;
    private float total =0;
    private int qty1 =0;
    private int qty2 = 0;
    //********************//
    //part3 phut:26:51   //
    //******************//
     public ObservableList <customerData> customerList(){
        ObservableList<customerData> customerL = FXCollections.observableArrayList();
        String sql = "SELECT * FROM  customer";
        connect = database.connectDb();
        try{
            customerData customerD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                customerD = new customerData(result.getInt("id")
                        , result.getString("type")
                        , result.getString("movieTitle")
                        , result.getInt("quantity")
                        , result.getDouble("total")
                        , result.getDate("date")
                        , result.getTime("time"));
                customerL.add(customerD);
            }

        }catch (Exception e) {e.printStackTrace();}

        return customerL;
    }
     private  ObservableList <customerData>  custList;
     public void showCustomerList(){
         custList = customerList();
         
         
         customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
         customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
         customers_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
     
         customer_tableView.setItems(custList);
     }
     public void selectCustomerList(){
         customerData custD = customer_tableView.getSelectionModel().getSelectedItem();
         int num = customer_tableView.getSelectionModel().getSelectedIndex();

        if((num-1)<-1){
            return;
        }
        customers_ticketNumber.setText(String.valueOf(custD.getId()));
        customers_movieTitle.setText(custD.getTitle());
        customers_date.setText(String.valueOf(custD.getDate()));
        customers_time.setText(String.valueOf(custD.getTime()));
         
     }  
     public void deleteCustomer(){
         String sql = "DELETE FROM customer WHERE id = '" + customers_ticketNumber.getText()+"'";
        connect = database.connectDb();
        try{
            
            Alert alert;
            statement = connect.createStatement();
            if(customers_ticketNumber.getText().isEmpty()
                    || customers_movieTitle.getText().isEmpty()
                    || customers_date.getText().isEmpty()
                    || customers_time.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the customer first");
                alert.showAndWait();
            }else{
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete"
                + customers_movieTitle.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if(option.get() == ButtonType.OK){
                    statement.executeUpdate(sql);
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully remove");
                    alert.showAndWait();

                    showCustomerList();
                    clearCustomer();
                }else{
                    return;
                }
            }
        }catch (Exception e){e.printStackTrace();}
     }
     
     
     public void clearCustomer(){
        customers_ticketNumber.setText("");
        customers_movieTitle.setText("");
        customers_date.setText("");
        customers_time.setText("");
     }

    //llỗi
    public void receipt(){
        
        if(total>0){
        
            HashMap hash = new HashMap();
            hash.put("receipt", num);
            try {
                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\ACER\\Documents\\NetBeansProjects\\movie\\src\\moviebook\\report2.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, hash, connect);

                JasperViewer.viewReport(jPrint, false);
            } catch (JRException ex) {
            }  
         }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid. ");
                alert.showAndWait();
            
        }
            
    }
    private int num;
    private int qty;
    
    public void buy(){
        String sql = "INSERT INTO customer (type,movieTitle,quantity,total,date,time) VALUES(?,?,?,?,?,?)";
	connect = database.connectDb();
	String type = "";
	if(price1 > 0 && price2==0){
		type = "Special Class";
	} else if(price2 > 0 && price1 == 0){
		type = "Normal Class";
	} else if(price2 > 0 && price1 > 0){
		type = "Special Class & Normal Class";
        }
        
        Date date = new Date();
         java.sql.Date setDate = new java.sql.Date(date.getTime());
        	try{
		
                   // LocalTime localTime = LocalTime.now();
                    
                    //Time tine = Time.(localTime);
		qty = qty1+qty2;
		
		prepare = connect.prepareStatement(sql);
		prepare.setString(1, type);
                prepare.setString(2,availableMovies_title.getText());
                prepare.setString(3, String.valueOf(qty));
		prepare.setString(4, String.valueOf(total));
		prepare.setString(5, String.valueOf(setDate));
               // prepare.setString(6, String.valueOf(time));
		
		Alert alert;
		
		if(availableMovies_imageView.getImage() == null 
                        || availableMovies_title.getText().isEmpty() ){
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select the movie first");
			alert.showAndWait();
		}else if(price1 == 0 && price2 == 0){
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please indicate the quantity of ticket you want to purchase");
			alert.showAndWait();	
		} else {
			
			prepare.executeUpdate();
			
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText(null);
			alert.setContentText("Successfully Purchase!");
			alert.showAndWait();
			
			String sql1 = "SELECT * FROM customer";
			
			prepare = connect.prepareStatement(sql1);
			result = prepare.executeQuery();
			
			int num = 0;
			while(result.next()){
				num = result.getInt("id");
			}
			
			String sql2 = "INSERT INTO customer_info(customer_id,type,quantity ,total,movieTitle) VALUES(?,?,?,?,?)";
			
			prepare = connect.prepareStatement(sql2);
			prepare.setString(1, String.valueOf(num));
			prepare.setString(2, type);
                         prepare.setString(3, String.valueOf(qty));
                        prepare.setString(4, String.valueOf(total));
                        prepare.setString(5,availableMovies_title.getText());
			
			prepare.execute();
			
			clearPurchaseTicketInfo();
		}
	}catch(Exception e) {e.printStackTrace(); }
    }
    
    public void clearPurchaseTicketInfo(){
        
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
	spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
	
	availableMovies_specialClass_quantity.setValueFactory(spinner1);
	availableMovies_normalClass_quantity.setValueFactory(spinner2);
	
	availableMovie_specialClass_price.setText("$0.0");
	availableMovie_nomaClass_price.setText("$0.0");
	availableMovie_total.setText("$0.0");
        
        availableMovies_imageView.setImage(null);
        availableMovies_title.setText("");
        
    }
        
    
    public void showSpinnerValue(){
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10, 0);
         spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10, 0);
         availableMovies_specialClass_quantity.setValueFactory(spinner1);
         availableMovies_normalClass_quantity.setValueFactory(spinner2);
         
    }
    
    public void getSpinnerValue(MouseEvent event){
        	qty1 = availableMovies_specialClass_quantity.getValue();
	qty2 = availableMovies_normalClass_quantity.getValue();
	
	price1 = (qty1 * 25);
	price2 = (qty2 * 10);
	
	total = (price1 + price2);
	
	availableMovie_specialClass_price.setText("$"+String.valueOf(price1));
	availableMovie_nomaClass_price.setText("$"+String.valueOf(price2));
	
	availableMovie_total.setText("$"+String.valueOf(total));
    }

    public ObservableList<moviesData> availbleMoviesList() {
        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie WHERE current = 'Showing'";

        connect = database.connectDb();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {

                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                listAvMovies.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAvMovies;

    }

    private ObservableList<moviesData> availableMoviesList;

    public void showAvailableMovies() {

        availableMoviesList = availbleMoviesList();
        availableMovie_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovie_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        availableMovies_tableView.setItems(availableMoviesList);
    }

    public void selecAvailableMovies() {
        moviesData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
        int num = availableMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        availableMovies_moviesTitle.setText(movD.getTitle());
        availableMovies_genre.setText(movD.getGenre());
        availableMovies_date.setText(String.valueOf(movD.getDate()));

        getData.path = movD.getImage();
        getData.title = movD.getTitle();

    }

    public void selectMovie() {
        Alert alert;
        if (availableMovies_moviesTitle.getText().isEmpty()
                
                || availableMovies_genre.getText().isEmpty()
                ||  availableMovies_date.getText().isEmpty()) {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();

        } else {
            String uri = "file: " + getData.path;
            image = new Image(uri, 156, 203, false, true);
            availableMovies_imageView.setImage(image);
            availableMovies_title.setText(getData.title);
            availableMovies_moviesTitle.setText("");
            availableMovies_genre.setText("");
            availableMovies_date.setText("");

        }
    }

    private String[] currentList = {"Showing", "End Showing"};

    public void comboBox() {

        List<String> listCurrent = new ArrayList<>();

        for (String data : currentList) {
            listCurrent.add(data);
        }
        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editScreening_current.setItems(listC);
    }

    public void updateEditScreening() {
        String sql = "UPDATE movie SET current = '"
                + editScreening_current.getSelectionModel().getSelectedItem()
                + "' WHERE movieTitle = '" + editScreening_title.getText() + " ' ";

        connect = database.connectDb();

        try {
            statement = connect.createStatement();

            Alert alert;
            if (editScreening_title.getText().isEmpty()
                    || editScreening_imageView.getImage() == null
                    || editScreening_current.getSelectionModel().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else {
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Update!");
                alert.showAndWait();

                showEditScreening();
                clearEditScreening();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearEditScreening() {

        editScreening_title.setText("");
        editScreening_imageView.setImage(null);
        //editScreening_current.setSelectionModel(null);

    }

    public void searchEditScreening() {

        FilteredList<moviesData> filter = new FilteredList(editScreeningL, e -> true);
        editScreening_search.textProperty().addListener((obserVable, oldValue, newValue) -> {

            filter.setPredicate(predicateMoviesData -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateMoviesData.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getCurrent().toLowerCase().contains(searchKey)) {
                    return true;
                }
                return false;
            });

        });

        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addScreening_tableView.comparatorProperty());
        addScreening_tableView.setItems(sortData);

    }

    public void selectEditScreening() {
        moviesData movD = addScreening_tableView.getSelectionModel().getSelectedItem();
        int num = addScreening_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }
        String uri = "file:" + movD.getImage();
        image = new Image(uri, 146, 203, false, true);
        editScreening_imageView.setImage(image);

        editScreening_title.setText(movD.getTitle());
    }

    public ObservableList<moviesData> editScreeningList() {
        ObservableList<moviesData> editSList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie ";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {

                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                editSList.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return editSList;
    }
    private ObservableList<moviesData> editScreeningL;

    public void showEditScreening() {

        editScreeningL = editScreeningList();

        editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));

        addScreening_tableView.setItems(editScreeningL);
    }

    public void searchAddMovies() {
        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);
        addMovies_search.textProperty().addListener((obserVable, oldValue, newValue) -> {
            filter.setPredicate(predicateMovieData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String keySearch = newValue.toLowerCase();

                if (predicateMovieData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getDate().toString().contains(keySearch)) {
                    return true;
                }

                return false;

            });
        });

        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());

        addMovies_tableView.setItems(sortData);

    }

    public void importImage() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("image File", "*png", "*jpg"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {
            image = new Image(file.toURI().toString(), 188, 232, false, true);
            addMovies_imageView.setImage(image);
            getData.path = file.getAbsolutePath();
        }
    }

    public void movieId() {
        String sql = "SELECT count(id) FROM movie";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                getData.movieId = result.getInt("count(id)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertAddMovies() {

        String sql1 = "SELECT movieTitle FROM movie WHERE movieTitle = '" + addMovies_movieTitle.getText() + "'";

        connect = database.connectDb();
        Alert alert;
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql1);

            if (result.next()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText() + "was already exist");
                alert.showAndWait();

            } else {
                if (addMovies_movieTitle.getText().isEmpty()
                        || addMovies_genre.getText().isEmpty()
                        || addMovies_duration.getText().isEmpty()
                        || addMovies_imageView.getImage() == null
                        || addMovies_date.getValue() == null) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();
                } else {
                    String sql = "INSERT INTO movie (id,movieTitle, genre, duration,image,date,current) VALUES(?,?,?,?,?,?,?)";

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    movieId();

                    String mID = String.valueOf(getData.movieId + 1);

                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, mID);
                    prepare.setString(2, addMovies_movieTitle.getText());
                    prepare.setString(3, addMovies_genre.getText());
                    prepare.setString(4, addMovies_duration.getText());
                    prepare.setString(5, uri);
                    prepare.setString(6, String.valueOf(addMovies_date.getValue()));
                    prepare.setString(7,"Showing");
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAddMovies() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE movie SET movieTitle = '" + addMovies_movieTitle.getText()
                + "', genre = '" + addMovies_genre.getText()
                + "', duration = '" + addMovies_duration.getText()
                + "', image= '" + uri
                + "', date = '" + addMovies_date.getValue()
                + "' WHERE id = '" + String.valueOf(getData.movieId) + "'";

        connect = database.connectDb();
        try {

            statement = connect.createStatement();
            Alert alert;
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_date.getValue() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {
                statement.executeUpdate(sql);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Succesfully updated" + addMovies_movieTitle.getText());
                alert.showAndWait();

                showAddMoviesList();
                clearAddMoviesList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAddMovies() {
        String sql = "DELETE FROM movie WHERE movieTitle = '"
                + addMovies_movieTitle.getText() + " ' ";
        connect = database.connectDb();
        try {
            statement = connect.createStatement();
            Alert alert;
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_date.getValue() == null
                    || addMovies_imageView.getImage() == null) {
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
                        + addMovies_movieTitle.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (ButtonType.OK.equals(option.get())) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearAddMoviesList() {
        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_imageView.setImage(null);
        addMovies_date.setValue(null);
    }

    public ObservableList<moviesData> addMoviesList() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();
        String sql = "SELECT* FROM movie";
        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            moviesData movD;
            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));
                listData.add(movD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMoviesList();
        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);
    }

    public void selectAddMoviesList() {
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        getData.movieId = movD.getId();

        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());
        String getDate = String.valueOf(movD.getDate());

        String uri = "file:" + movD.getImage();
        image = new Image(uri, 188, 232, false, true);
        addMovies_imageView.setImage(image);

        addMovies_date.setValue(movD.getDate().toLocalDate());
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {
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

        } else if (event.getSource() == addMovies_btn) {
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
            
             showAddMoviesList();

        } else if (event.getSource() == availableMovies_btn) {
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
            
            selecAvailableMovies();

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
            
             showEditScreening();

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
            
            showCustomerList();
        }
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void close() {
        System.exit(0);

    }

    public void minimize() {

        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }
    private double x = 0;
    private double y = 0;
//    public void logout() {
//	signout.getScene().getWindow().hide();
//	try{
//	Parent root = FXMLLoader.load(getClass().getResorce("FXMLDocument.fxml"));
//	
//	Stage stage = new Stage();
//	Scene scene = new Scene(root);
//	
//	root.setOnMousePressed((MouseEvent event)->{
//	x = event.getSceneX();
//	y = event.getSceneY();
//
//
//	});
//
//	
//	root.setOnMouseDragged((MouseEvent event)->{
//	stage.setX(event.getScreenX() - x);
//	stage.setY(event.getScreenY() - y);
//
//	});
//	
//
//	stage.initStyle(StageStyle.TRANSPARENT);	
//
//	stage.setScene(scene);
//	stage.show();
//	
//	}catch(Exception e){e.printStackTrace();}
//}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();
        showAddMoviesList();
        showEditScreening();
        comboBox();
        showAvailableMovies();
        showSpinnerValue();
        showCustomerList();
    }
}
