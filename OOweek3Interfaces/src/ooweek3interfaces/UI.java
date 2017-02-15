/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class UI {
    private geometricObject[] shapes;
    Scanner in; 
    public UI() {
        this.shapes = new geometricObject[10];
        in = new Scanner(System.in); 
        readInput();
    }
    
    private void readInput() {
        String input = "";
        int x,y,r,h,w,i; 
        while(!input.equalsIgnoreCase("quit")) {
            input = in.next(); 
            switch(input.toLowerCase()) {
                case "show":
                    for (int j = 0; j < 10; j++) {
                        if(shapes[j] != null)
                            System.out.println(shapes[j].toString() + " " +  shapes[j].getArea());
                    }
                    break;
                case "circle":
                    x = in.nextInt();
                    y = in.nextInt();
                    r = in.nextInt(); 
                    Circle circle = new Circle(x,y,r); 
                    if(!addShape(circle)) System.out.println("List full.");
                    break;
                case "rectangle":
                    x = in.nextInt();
                    y = in.nextInt();
                    w = in.nextInt();
                    h = in.nextInt(); 
                    Rectangle rect = new Rectangle(x,y,w,h); 
                    if(!addShape(rect)) System.out.println("List full.");
                    break;
                case "move":
                    i = in.nextInt();
                    int dx = in.nextInt();
                    int dy = in.nextInt();
                    shapes[i].moveObject(dx, dy);
                    break;
                case "remove":
                    i = in.nextInt();
                    shapes[i] = null; 
                    break;
                case "sort":
                    Arrays.sort(shapes); 
                    break;
                case "quit":
                    System.out.println("Bye!");
                    return; 
                default: 
                    System.out.println("did not compute, please enter again.");                           
                    break;
                    
            }
        }
    }
    
    private boolean addShape(geometricObject shape) {
        for (int i = 0; i < 10; i++) {
                if(shapes[i] == null) {
                    shapes[i] = shape;
                    return true;  
            } 
        }
        return false; 
    }
    
}
