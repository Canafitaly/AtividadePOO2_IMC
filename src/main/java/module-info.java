module org.example.poo2_telaprafazer {
    requires javafx.controls;
    requires javafx.fxml;


    opens controller to javafx.fxml;
    opens model to javafx.fxml;
    opens inicializacao to javafx.graphics, javafx.fxml;
}