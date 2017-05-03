/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave11;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * 
 *
 * @author Lisa Tostrams s4386167
 */
public class View extends Application {
   @Override
  public void start(Stage primaryStage) throws Exception {
    Label label = new Label("Hello OO");
    Scene scene = new Scene(label, 150, 80);
    primaryStage.setTitle("label GUI");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

 
}
