package com.github.hteph.createrandommagicalitem;

import com.github.hteph.createrandommagicalitem.domain.TableArchive;
import com.github.hteph.createrandommagicalitem.tableloader.DirectoryLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Tables Utilities");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedDirectory = chooser.showDialog(primaryStage);
        
        DirectoryLoader.collectAllFiles(selectedDirectory.getPath());
        
        Scene scene = getSampleScene();
        
        //Setting title to the Stage
        primaryStage.setTitle("Sample Application");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    private Scene getSampleScene() {
        //Creating a Text object
        Text text = new Text();
    
        String baseText = "A People\n" + TableArchive.getTable("adjective").getRandomLine() + "\n";
        
        
        //Setting the text to be added.
        text.setText(baseText);
        
        //setting the position of the text
        text.setX(50);
        text.setY(50);
        
        //Creating a Group object
        Group root = new Group(text);
        
        //Creating a scene object
        return new Scene(root, 600, 300);
    }
    
    public static void main(String[] args) {
        launch();
    }
}