package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Graph;

public class MainController extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
//        primaryStage.setTitle("Circuit Engineering For Kids");
//        primaryStage.setScene(new Scene(root, 900, 600));
//        primaryStage.show();
    }
    public static void main(String[] args, Graph graph) {
        MainWindow.setGraph(graph);
        launch(args);
    }
}
