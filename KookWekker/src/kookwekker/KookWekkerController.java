/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kookwekker;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class KookWekkerController {
    
    @FXML private Text actiontarget;
    @FXML private Text timer; 
    @FXML private ProgressBar bar; 
    @FXML private TextField textfield; 
    @FXML private GridPane gridPane; 
    private int SECONDS = 0; 
    private double progress = 0.0; 
    Timeline timeLine;
    private ProgressBar pb; 
    
    @FXML protected void handleStartButtonAction(ActionEvent event) {
        if(progress <= 0) {
        String s = textfield.getText(); 
        try { 
            progress = Double.parseDouble(s);
            SECONDS = (int) progress; 
        } catch(NumberFormatException ex) {
            System.out.println("idiot"); 
        }
       
        bar.setProgress(1);
        timeLine = new Timeline(new KeyFrame(Duration.seconds(1), ae -> tickHandler(ae)));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play(); 
        }
        else {
            timeLine.play(); 
        }
    }    
    
    @FXML protected void handleStopButtonAction(ActionEvent event) {
        timeLine.stop(); 
    }
    
    @FXML protected void handleQuitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private KeyFrame tickHandler(ActionEvent ae) {
        bar.setProgress(progress/SECONDS);
        timer.setText("" + (int) progress--);
        if(progress < 0) {
            timeLine.stop();
            bar.setProgress(1);
            gridPane.setStyle("-fx-background-color: #ff0000");
        } 
        
        return null;
    }
}
