module com.example.fxml_demo_lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxml_demo_lab5 to javafx.fxml;
    exports com.example.fxml_demo_lab5;
}