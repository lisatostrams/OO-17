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
import javafx.scene.text.Text;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class KookWekkerController {
    
    @FXML private Text actiontarget;
    @FXML private Text timer; 
    private int SECONDS = 10; 
    Timeline timeLine;
    
    @FXML protected void handleStartButtonAction(ActionEvent event) {
        actiontarget.setText("Start button pressed");
        SECONDS = 10;
        
        
        timeLine = new Timeline(new KeyFrame(Duration.seconds(1), ae -> tickHandler(ae)));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.stop();
        timeLine.play(); 
    }    
    
    @FXML protected void handleStopButtonAction(ActionEvent event) {
        actiontarget.setText("Stop button pressed");
    }
    
    @FXML protected void handleQuitButtonAction(ActionEvent event) {
        actiontarget.setText("Quit button pressed");
    }

    private KeyFrame tickHandler(ActionEvent ae) {
        timer.setText("" + SECONDS--);
        return null;
    }
}
