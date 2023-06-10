package projects;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorInput;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;


public class MovieTicketBooking extends Application {
    private double x=0;
    private double y=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginDesign.fxml"));


        Scene scene = new Scene(root);

        root.setOnMouseDragged((MouseEvent event) ->{

            x = event.getSceneX();
            y = event.getSceneY();
        });
        Stage stage = new Stage();

        root.setOnMouseDragged((MouseEvent event) ->{

            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
