package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mahendra Tennakoon
 */
public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        Scene login_scene = new Scene(root);

        stage.setScene(login_scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        // bypass login
//        Parent root = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
//        Scene home = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(home);
//        stage.setMaximized(true);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
