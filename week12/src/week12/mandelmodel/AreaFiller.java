/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.mandelmodel;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

/**
 * A skeleton class illustrating the use of a pixelWriter
 * @author Lisa Tostrams
 * @author Maurice Swanenberg - s4331095
 * @author Sjaak Smetsers
 * @version 06-05-2016
 */
public class AreaFiller {
    private Color [] colors = {Color.DARKORANGE,Color.GREENYELLOW,Color.AQUA};
    private Point [][] coords = new Point [500][500];
    
    /**
     * fills the canvas with a mandelbrot
     */
    public void fill( Canvas canvas, double startX, double endX, double startY, double endY ) {
                
        double imageWith   = (double) canvas.getWidth();
        double imageHeight = (double) canvas.getHeight();
        
        final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
     
        for (int i = 0; i < imageWith; i++) {
            for (int j = 0; j < imageHeight; j++) {  
                MandelBrot mand = new MandelBrot(startX + (endX - startX) * i/imageWith, startY + (endY - startY) * j/imageHeight);
                coords[j][i] = new Point(startX + (endX - startX) * i/imageWith, startY + (endY - startY) * j/imageHeight);
                if(mand.mandelGetal()%2==0)
                    pixelWriter.setColor(i, j, Color.BLACK  );
                else pixelWriter.setColor(i, j, Color.WHITE  );
            }               
        }
    }
    /**
     * Fills the canvas with a mandelbrot given the scale and coordinates of the center
     * @param canvas
     * @param x
     * @param y
     * @param scale 
     */
    public void fill2( Canvas canvas, double x, double y, int scale ) {
            double width = canvas.getWidth()/scale;
            double height = canvas.getHeight()/scale;
            double startX = x - 0.5*width;
            double endX = x + 0.5*width;
            double startY = y - 0.5*height;
            double endY = y + 0.5*height;
            double imageWith   = (double) canvas.getWidth();
            double imageHeight = (double) canvas.getHeight();
            final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
            for (int i = 0; i < imageWith; i++) {
                for (int j = 0; j < imageHeight; j++) {  
                    MandelBrot mand = new MandelBrot(startX + (endX - startX) * i/imageWith, startY + (endY - startY) * j/imageHeight);
                    coords[i][j] = new Point(startX + (endX - startX) * i/imageWith, startY + (endY - startY) * j/imageHeight);
                    if(mand.mandelGetal()%2==0)
                        pixelWriter.setColor(i, j, Color.BLACK);
                    else pixelWriter.setColor(i, j, Color.WHITE);
                }               
        }
    }    
    
    public Point getPoint(int x, int y) {
        return coords[x][y];
    }
    
    
}
