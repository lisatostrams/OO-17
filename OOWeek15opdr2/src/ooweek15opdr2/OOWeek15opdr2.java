/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek15opdr2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mauri
 */
public class OOWeek15opdr2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Stage secondaryStage = new Stage();
        Button save = new Button();
        Button check = new Button();
        Button stop = new Button();
        save.setText("save");
        check.setText("check");
        stop.setText("stop");
        save.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        TextField tf = new TextField();
        StackPane root = new StackPane();
        root.getChildren().addAll(save,tf);
        root.setAlignment(save, Pos.BOTTOM_CENTER);
        root.setAlignment(tf,Pos.CENTER);
        
        GridPane root2 = new GridPane();
        //root2.getChildren().addAll(check, stop);
        //root2.setAlignment(Pos.CENTER);
        root2.add(check, 0, 2);
        root2.add(stop, 0, 3);
        
        Scene scene = new Scene(root, 300, 250);
        Scene scene2 = new Scene(root2, 300, 250);
        
        primaryStage.setTitle("Enter password");
        secondaryStage.setTitle("Check password");
        primaryStage.setScene(scene);
        secondaryStage.setScene(scene2);
        primaryStage.show();
        secondaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
