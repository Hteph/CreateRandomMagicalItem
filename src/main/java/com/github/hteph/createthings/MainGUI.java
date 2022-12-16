package com.github.hteph.createthings;

import com.github.hteph.createthings.factories.MagicalThings;
import com.github.hteph.createthings.guistuff.PopUp;
import com.github.hteph.createthings.tableloader.DirectoryLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainGUI extends Application {
    
    static final String ID_1 = "Magical Items";
    static final String TEST2 = "test2";
    static final String TEST3 = "test3";
    static final String TEST4 = "test4";
    
    private final MagicalThings magicalThings = new MagicalThings();
    
    @Override
    public void start(Stage primaryStage) {
        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Tables Utilities");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedDirectory = chooser.showDialog(primaryStage);
        
        DirectoryLoader.collectAllFiles(selectedDirectory.getPath());
        
        //Scene scene = getArtifactScene();
        Scene scene = getChoiceScene();
        
        //Setting title to the Stage
        primaryStage.setTitle("Sample Application");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    private Text getArtifacts() {

        Text text = new Text();
        
        StringBuilder artefactStringBuilder = new StringBuilder("Artifacts: \n");
    
        for (int i = 0; i < 5; i++) {
            artefactStringBuilder.append(magicalThings.getArtefactBaseText()).append("\n");
        }
        
        //Setting the text to be added.
        text.setText(artefactStringBuilder.toString());
        
        //setting the position of the text
        text.setX(50);
        text.setY(50);

        return text;

    }
    
    private Scene getChoiceScene() {
        
        RadioButton radioButton1 = new RadioButton("Magical Artifacts");
        RadioButton radioButton2 = new RadioButton("Right");
        RadioButton radioButton3 = new RadioButton("Up");
        RadioButton radioButton4 = new RadioButton("Down");
    
        ToggleGroup radioGroup = new ToggleGroup();
    
        radioButton1.setToggleGroup(radioGroup);
        radioButton1.setId(ID_1);
        radioButton1.setSelected(true);
        radioButton2.setToggleGroup(radioGroup);
        radioButton2.setId(TEST2);
        radioButton3.setToggleGroup(radioGroup);
        radioButton3.setId(TEST3);
        radioButton4.setToggleGroup(radioGroup);
        radioButton4.setId(TEST4);
    
        VBox choices = new VBox(radioButton1, radioButton2, radioButton3, radioButton4);
    
        Label label = new Label("Not clicked");
        Button button = new Button("Click");
        
        button.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            Text displayText = getDisplayText(selectedRadioButton);
            PopUp.display(displayText);
        });
    
        HBox buttonBox = new HBox(button, label);
    
        GridPane gridPane = new GridPane();
    
        gridPane.add(choices, 0, 0, 1, 1);
        gridPane.add(buttonBox, 1, 1, 1, 1);
        
        //Creating a scene object
        return new Scene(gridPane, 600, 300);
    }
    
    private Text getDisplayText(RadioButton selectedRadioButton) {
        return switch (selectedRadioButton.getId()) {
            case ID_1 -> getArtifacts();
            case TEST2 -> new Text("test2");
            case TEST3 -> new Text("test3");
            case TEST4 -> new Text("test4");
            default -> new Text("Bleep, wrong value");
        };
    }
    
    public static void main(String[] args) {
        launch();
    }
}