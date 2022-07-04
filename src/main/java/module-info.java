module com.github.hteph.createrandommagicalitem {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens com.github.hteph.createrandommagicalitem to javafx.fxml;
    exports com.github.hteph.createrandommagicalitem;
}