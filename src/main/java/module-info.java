module com.github.hteph.createrandommagicalitem {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires org.controlsfx.controls;
    
    opens com.github.hteph.createthings to javafx.fxml;
    exports com.github.hteph.createthings;
    exports com.github.hteph.createthings.factories;
    opens com.github.hteph.createthings.factories to javafx.fxml;
}