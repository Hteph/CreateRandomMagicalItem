package com.github.hteph.createthings.guistuff;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {
    
    
    public static void display(Text text)
    {
        Stage popupwindow=new Stage();
        
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");
        
        Label label1= new Label("Pop up window now displayed");
        
        Button button1= new Button("Close this pop up window");
        
        button1.setOnAction(e -> popupwindow.close());
        
        VBox vBoxResults= new VBox(10);
        
        vBoxResults.getChildren().addAll(label1,text, button1);
        vBoxResults.setAlignment(Pos.CENTER);
        
        Scene scene1= new Scene(vBoxResults, 300, 250);
        
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }
    
}
