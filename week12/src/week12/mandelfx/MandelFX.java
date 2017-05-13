/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.mandelfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import week12.mandelmodel.AreaFiller;
import week12.mandelmodel.Point;

/**
 * @author Lisa Tostrams
 * @author Maurice Swanenberg - s4331095
 * @author Sjaak
 */
public class MandelFX extends Application {
    
    Group root;
    public static final int GRID_WIDTH = 500, GRID_HEIGHT = 500;    
    private Canvas canvas;
    private int scale = 100;                                        // default scale
    private double xCoordinate = 0.0, yCoordinate = 0.0;            // defaul coordinates of the center
    AreaFiller areaFiller = new AreaFiller();
    private Rectangle rect = new Rectangle();                       // rectangle shown while dragging
    double dx, dy;                                                  // difference in coordinates when dragging
    double px, py;                                                  // coordinates when mouse is pressed
    double rx, ry;                                                  // coordinates when mouse is released
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene( makeScene() ); 
        primaryStage.show();
    }

    private Scene makeScene() {
        BorderPane border = new BorderPane();         
        border.setPadding(new Insets(6));
        
        GridPane grid = new GridPane();
        
        Label xc = new Label("x-coordinate");           // Labels to indicate what the textfields are for
        Label yc = new Label("y-coordinate");
        Label factor = new Label("scale factor");
        xc.setTextFill(Color.LIME); yc.setTextFill(Color.LIME); factor.setTextFill(Color.LIME);
        
        TextField x = new TextField();                  // Textfiels for the coordinates of the center and the scale
        TextField y = new TextField();
        TextField schaal = new TextField();
        x.setMaxWidth(100); y.setMaxWidth(100); schaal.setMaxWidth(100);
        
        Button go = new Button("Go");                   // button to adjust the scale and the coordinates
        go.setOnAction(e -> {
            xCoordinate = Double.parseDouble(x.getText());
            yCoordinate = -1*(Double.parseDouble(y.getText()));
            scale = Integer.parseInt(schaal.getText());
            areaFiller.fill2( canvas , xCoordinate, yCoordinate, scale);
        });
        
        grid.add(xc, 0, 0);                             // adding buttons to gridpane
        grid.add(yc, 0, 1);
        grid.add(x,1,0);
        grid.add(y, 1, 1);
        grid.add(factor, 0, 2);
        grid.add(schaal, 1, 2);
        grid.add(go, 0, 3);
        border.setTop(grid);
        
        canvas = new Canvas(GRID_WIDTH, GRID_HEIGHT);
        /**
         * When clicked on the canvas an empty rectangle will be added but not shown untill you start dragging
         */
        canvas.setOnMousePressed(e -> {
            px = e.getX(); py = e.getY();
            addRect(e);
        });
        /**
         * If the coordinates of the mouse are the same when the mouse is released as when it was pressed (so no dragging)
         * then you'll zoom on the point where you clicked. If dragged, a rectangle will be shown and you'll zoom in on
         * that rectangle
         */
        canvas.setOnMouseReleased(e -> {
            if(e.getX() == px && e.getY() == py) {
                if(!e.isShiftDown()) {
                    scale = scale * 2;
                    Point p = areaFiller.getPoint((int)e.getX(), (int)e.getY());
                    xCoordinate = p.getX();
                    yCoordinate = p.getY();
                    areaFiller.fill2( canvas , xCoordinate, yCoordinate, scale); // creates the mandelbrot with coordinates from the center
                }
                else {
                    if(e.isShiftDown()) {
                    scale = scale / 2;
                    Point p = areaFiller.getPoint((int)e.getX(), (int)e.getY());
                    xCoordinate = p.getX();
                    yCoordinate = p.getY();
                    areaFiller.fill2( canvas , xCoordinate, yCoordinate, scale);
                    }
                }
            }
            else {
                int oldWidth = (int) areaFiller.getPoint(499, 0).getX() - (int) areaFiller.getPoint(0, 0).getX();
                int oldHeight = (int) areaFiller.getPoint(0, 0).getY() + (int) areaFiller.getPoint(0, 499).getY();
                Point r = areaFiller.getPoint((int)e.getX(), (int)e.getY());
                rx = r.getX();
                ry = r.getY();
                Point p = areaFiller.getPoint((int)px, (int)py);
                px = p.getX();
                py = p.getY();
                int newWidth = (int)rx - (int)px;
                int newHeight = (int)ry - (int)py;
                int newScale = (int) (oldWidth/ newWidth) + (oldHeight/newHeight)/2;
                scale = (int) newScale * scale;
                areaFiller.fill(canvas, px, rx, py, ry);
                
            }
            x.setText(String.valueOf(xCoordinate));
            y.setText(String.valueOf(yCoordinate));
            schaal.setText(String.valueOf(scale));
            finishRect(e);
        });
        canvas.setOnMouseDragged(e -> dragRect(e));
        
        areaFiller.fill2(canvas, xCoordinate, yCoordinate, scale);

        root = new Group( canvas, border );
        Scene scene = new Scene(root);
        
        return scene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Adds an invisible rectangle to the scene
     * @param e 
     */
    private void addRect(MouseEvent e) {
        double x = e.getX(); double y = e.getY();
        rect = new Rectangle(x,y,0,0);
        rect.setFill(Color.AQUA.deriveColor(0, 0.5, 1, 0.8));
        rect.setStroke(Color.AQUA);
        root.getChildren().add(rect);
    }
    /**
     * Removes the rectangle when dragging stops
     * @param e 
     */
    private void finishRect(MouseEvent e) {
        root.getChildren().remove(rect);
    }
    /**
     * Adjusts the size of the rectangle while dragging
     * @param e 
     */
    private void dragRect(MouseEvent e) {
        if(e.getX() > rect.getX())
            rect.setWidth(e.getX() - rect.getX());
        else {
            rect.setWidth(rect.getWidth() - e.getX() + rect.getX());
            rect.setX(e.getX());
        }
        if(e.getY() > rect.getY())
            rect.setHeight(e.getY() - rect.getY());
        else {
            rect.setHeight(rect.getHeight() - e.getY() + rect.getY());
            rect.setY(e.getY());
        }
    }
    
  
    
    
}
