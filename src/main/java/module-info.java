module com.example.advanced_random_password_generator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advanced_random_password_generator to javafx.fxml;
    exports com.example.advanced_random_password_generator;
}