/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek11poging2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.util.Duration.seconds;

/**
 *
 * @author mauri
 */
public class OOweek11poging2 extends Application {
    private ProgressBar p1;
    private double counter;
    private double userInput;
    Scene scene;
    Timeline timeLine;
    GridPane grid;
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField time = new TextField();
        
        //counter = 60;
        
        timeLine = new Timeline(new KeyFrame(Duration.seconds(1) , ae -> tickHandler(ae))) ;
        timeLine.setCycleCount(Timeline.INDEFINITE);
        
        p1 = new ProgressBar();
        p1.setMaxWidth(250);
        
        Button start = new Button();
        start.setText("start");
        start.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                userInput = Double.valueOf(time.getText());
                counter = userInput;
                timeLine.play();
            }
        });
        
        Button stop = new Button();
        stop.setText("stop");
        stop.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                timeLine.pause();
            }
        });
        
        Button quit = new Button();
        quit.setText("quit");
        quit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                System.exit(0);
            }
        });
        
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        
        HBox h1 = new HBox();
        h1.setAlignment(Pos.CENTER);
        h1.setSpacing(5);
        h1.getChildren().addAll(time,start);
        
        HBox h2 = new HBox();
        h2.setAlignment(Pos.CENTER);
        h2.setSpacing(150);
        h2.getChildren().addAll(stop,quit);
        
        grid.add(p1, 0, 0);
        grid.add(h1, 0, 1);
        grid.add(h2, 0, 2);
        
        scene = new Scene(grid, 300, 150);
        
        primaryStage.setTitle("Time flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private KeyFrame tickHandler(ActionEvent ae) {
        System.out.println("hi");
        if(counter == 0){
            
            scene.setFill(Color.RED);
            
            timeLine.stop();
        }
        counter--;
        p1.setProgress(counter/userInput);
        System.out.println(counter/userInput);
        return null;
    }
    
}
