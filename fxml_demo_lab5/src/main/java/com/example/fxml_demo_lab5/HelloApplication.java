package com.example.fxml_demo_lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       HelloModel model = new HelloModel();
       HelloController controller = new HelloController();

        controller.init(model);

       if(controller.returner() == null)
       {
           System.out.println("There aint shit there");
       }
       else if(controller.returner() == model)
       {
           System.out.println("It's fuckin' there mate");
       }
        System.out.println(model.getCounter());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        fxmlLoader.setController(controller);



        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}