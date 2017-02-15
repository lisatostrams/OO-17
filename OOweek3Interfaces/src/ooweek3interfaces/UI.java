/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

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
        while(true) {
            input = in.next(); 
            switch(input.toLowerCase()) {
                case "show":
                    for (int i = 0; i < 10; i++) {
                        if(shapes[i] != null)
                            System.out.println(shapes[i].toString());
                    }
                    break;
                case "circle":
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int r = in.nextInt(); 
                    Circle circle = new Circle(x,y,r); 
                    for (int i = 0; i < 10; i++) {
                        if(shapes[i] == null) {
                            shapes[i] = circle;
                            break; 
                        } 
                    }
                    break;
                case "rectangle":
                    break;
                case "move":
                    break;
                case "remove":
                    break;
                case "sort":
                    break;
                case "quit":
                    return; 
                default: 
                    System.out.println("did not compute, please enter again.");                           
                    break;
                    
            }
        }
    }
    
    
}
