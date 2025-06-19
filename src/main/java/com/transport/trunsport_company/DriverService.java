package com.transport.trunsport_company;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DriverService extends Application {
    @Override
    public void start(Stage primaryStage) {
        RouteAssignmentController controller = new RouteAssignmentController();
        Scene scene = new Scene(controller.getView(), 800, 400);
        primaryStage.setTitle("Учет водителей");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}