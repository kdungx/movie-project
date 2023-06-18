

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class dashboardController implements Initializable {
    @FXML
    private Button avaliableMovies_btn;

    @FXML
    private Button addMovies_update;

    @FXML
    private FontAwesomeIcon signout;

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
    private TableColumn<?, ?> addMovies_col_duration;

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
    private Label customers_genre;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private TableView<?> addMovies_tableView;

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
    private FontAwesomeIcon minimize;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private Button editScreening_update;

    @FXML
    private TextField addMovies_date;

    @FXML
    private TableColumn<?, ?> addMovies_col_date;

    @FXML
    private Button dashboard_btn;

    @FXML
    private SplitMenuButton avaliableMovie_specialClass_quantitys;

    @FXML
    private Label customers_time;

    @FXML
    private Label customers_tickeNumber;

    @FXML
    private TableColumn<?, ?> addMovies_col_genre;

    @FXML
    private Button addMovies_clear;

    @FXML
    private TableColumn<?, ?> customers_col_movieTitle;

    @FXML
    private TableColumn<?, ?> addMovies_col_movieTitle;

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


    public dashboardController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
