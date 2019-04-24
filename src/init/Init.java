package init;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Init extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewInit.fxml"));
        Parent root = (Parent)loader.load();
        ControllerInit crtl = (ControllerInit)loader.getController();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        System.out.println("Started");
        crtl.setStage(primaryStage);
    }
    
}
