module org.example.poo2_telaprafazer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;



    opens org.controller to javafx.fxml;
    opens org.model to javafx.fxml;
    opens org.view to javafx.fxml, javafx.graphics;
    opens org.example  to javafx.graphics, javafx.fxml;
}