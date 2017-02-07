/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Lisa Tostrams s4386167
 * view klasse voor interactie met gebruiker
 */
public class View {
    private Galg model; 
    private String hangman []; 
    private Vector<String> guesses; 
    Scanner in;
    
    /**
     * constructor
     */
    public View() {
        makeAsciiArt();
        model = new Galg("programmeeropdracht");
        in = new Scanner(System.in); 
        guesses = new Vector();
    }
    
    /**
     * uitvoerende functie
     */
    public void runView() {
        System.out.println("Welcome to Hangman!");
        while(!model.isDead() && !model.guessedRight()) {
            System.out.println(hangman[10-model.getGuesses()]);
            System.out.println(model.getCurrent());
            System.out.println("You have " + model.getGuesses() + " guesses left.");
            if(!guesses.isEmpty()) {
                System.out.print("Wrong guesses: ");
                for(String s : guesses) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            getGuess(); 
        }
        System.out.println(hangman[10-model.getGuesses()]);
        System.out.println(model.getCurrent());
    }
    
    /**
     * ontvangt input van gebruiker
     */
    private void getGuess(){
        String g = in.nextLine();
        while(g.length() != 1 || guesses.contains(g)) {
            System.out.println("Guess again.");
            g = in.nextLine(); 
        }
        if(!model.letterGuess(g))
            guesses.add(g);
    }

    /**
     * maakt visueel hoe ver het spel is
     */
    private void makeAsciiArt() {
        hangman = new String[] {"\n\n       \n       \n       \n       \n       \n       \n         ",
"\n\n       \n       \n       \n       \n       \n       \n=========", 
"\n\n       \n      |\n      |\n      |\n      |\n      |\n=========", 
"\n\n  +---+\n      |\n      |\n      |\n      |\n      |\n=========", 
"\n\n  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
"\n\n  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========", 
"\n\n  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========", 
"\n\n  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========", 
"\n\n  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========", 
"\n\n  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========", 
"\n\n  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="};
    }
}
