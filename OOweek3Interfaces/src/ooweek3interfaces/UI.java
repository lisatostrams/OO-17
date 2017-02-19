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
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class UI {
    private geometricObject[] shapes;
    Scanner in; 
    private int size; 
    public UI() {
        this.shapes = new geometricObject[10];
        in = new Scanner(System.in); 
        readInput();
    }
    
    /**
     * Deze functie laat de gebruiker de keuze om verschillende operaties te doen;
     * het laten zien van de tot nu toe gemaakte ruimtefiguren, het aanmaken van een nieuwe cirkel, het aanmaken van een nieuwe rechthoek,
     * het verplaatsen van een ruimtefiguur, het verwijderen van een gegeven ruimtefiguur uit de array, het sorteren van de ruimtefiguren in de array
     * gebaseerd op het gebied en tenslotte het afsluiten van het programma.
     */
    private void readInput() {
        String input = "";
        int x,y,r,h,w,i; 
        while(!input.equalsIgnoreCase("quit")) {
            showShapes(); 
            input = in.next(); 
            switch(input.toLowerCase()) {
                case "show":
                    showShapes(); 
               
                    break;
                case "circle":
                    x = in.nextInt();
                    y = in.nextInt();
                    r = in.nextInt(); 
                    Circle circle = new Circle(x,y,r); 
                    if(!addShape(circle)) System.out.println("List full.");
                    else size++; 
                    break;
                case "rectangle":
                    x = in.nextInt();
                    y = in.nextInt();
                    w = in.nextInt();
                    h = in.nextInt(); 
                    Rectangle rect = new Rectangle(x,y,w,h); 
                    if(!addShape(rect)) System.out.println("List full.");
                    else size++; 
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
                    for (int p = i; p < shapes.length-1; p++)
                        shapes[p] = shapes[p+1]; 
                    shapes[shapes.length-1] = null ;
                    size--; 
                    break;
                case "sort":
                    try {
                    Arrays.sort(shapes, 0, size); 
                    String next = in.nextLine(); 
                    if(next.equals(" x")) Arrays.sort(shapes, geometricObject.ShapeXcomperator);
                    if(next.equals(" y")) Arrays.sort(shapes, geometricObject.ShapeYcomperator);
                    }
                    catch(java.lang.NullPointerException e) {
                        System.out.println("Nothing to sort."); 
                    }
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
    
    /**
     * Deze functie checkt of een ruimtefiguur nog aan de array kan worden toegevoegd.
     * @param shape
     * @return 
     */
    private boolean addShape(geometricObject shape) {
        for (int i = 0; i < 10; i++) {
                if(shapes[i] == null) {
                    shapes[i] = shape;
                    return true;  
            } 
        }
        return false; 
    }

    /**
     * Deze functie laat zien welke figuren er in de array zitten.
     */
    private void showShapes() {
        for (int j = 0; j < shapes.length; j++) {
            if(shapes[j] != null)
                System.out.println(shapes[j].toString() + " " +  shapes[j].getArea());
        }
    }
    
}
