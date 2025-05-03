module org.example.lesson18_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lesson18_0 to javafx.fxml;
    exports org.example.lesson18_0;
}