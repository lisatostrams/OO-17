/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mauri
 */
public class UI {
    List<Vraag> verkeerdBeantwoordeVragen;
    Scanner scan;
    public UI(){
        verkeerdBeantwoordeVragen = new LinkedList<>();
        speel();
    }
    
    public void speel(){
        List<Vraag> vragen = new LinkedList<>();
        vragen.add(new OpenVraag("Wat is de complexiteit van binair zoeken?" , "O(log N)" , 2 ) );
        vragen.add(new OpenVraag("Hoeveel constructoren moet je minstens maken bij een klasse in Java?" , "0") ) ;
        vragen.add(new OpenVraag("Hoeveel is 2 + 2?", "4"));
        vragen.add(new MeerkeuzeVraag("Wat is de complexiteit van slim in situ sorteren?",new String [] {"O(N^2)","O(N log N)","O(N)","O(log N)"},1,4));
        vragen.add(new MeerkeuzeVraag("Hoe print je \"Hello world\" op een regel in Java?",new String [] {"System.out.print(\"Hello world\");","System.out.println(\"Hello world\");","cout << \"Hello world\";"}, 1));
        vragen.add(new MeerkeuzeVraag("Hoe lees je in Java een niet leeg woord uit scanner s?",new String []{"s.nextline()","s.next(\"\\S+\")","s.next(\"\\a*\")","s.next(\"\\S*\")","s.next(\"\\\\s+\")","s.next(\"\\s+\")","s.nextString(\"\\s*\")","s.next(\"\\\\S+\")","s.nextString()"},7,1));

        for(Vraag v: vragen){
            System.out.println(v);
            scan = new Scanner(System.in);
            String antwoord = scan.nextLine();
            if(!v.isCorrect(antwoord)){
                Vraag x = duplicate(v);
                verkeerdBeantwoordeVragen.add(x);
            }
                
        }
    }
    
    public void speel2(List<Vraag>verkeerdBeantwoordeVragen){
        List<Vraag> verkeerdBeantwoordeVragen2 = new LinkedList<>();
        for(Vraag v: verkeerdBeantwoordeVragen){
            System.out.println(v);
            scan = new Scanner(System.in);
            String antwoord = scan.nextLine();
            if(!v.isCorrect(antwoord)){
                Vraag x = duplicate(v);
                verkeerdBeantwoordeVragen2.add(x);
            }
        if(!verkeerdBeantwoordeVragen2.isEmpty())
            speel2(verkeerdBeantwoordeVragen2);
    }
    
    public Vraag duplicate(Vraag v){
        Random random = new Random();
        int bound = random.nextInt();
        int shift = random.nextInt(bound);
        
    }
}
