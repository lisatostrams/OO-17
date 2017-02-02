/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek1;

/**
 *
 * @author Maurice Swanenberg
 * @author Lisa Tostrams
 * 
 * Klasse bevat een rij van studenten
 */
public class Groep {
    int n;
    private Student[] studenten;
    
    public Groep(int aantal){
        this.n = aantal;
        this.studenten = new Student[aantal];
    }
    
     /**
     * voegt een student aan het rijtje toe
     * @param s
     * @return toevoeging succesvol
     */
    
    public boolean voegToe(Student s){
        for(int i = 0; i < studenten.length; i++){
            if(studenten[i]== null){
                studenten[i] = s;
                return true;
            }
        }
        System.out.println("De groep zit al vol, de student kan niet meer worden toegevoegd.");
        return false;
    }
        
    /**
     * 
     * @param i
     * @return i'de student uit het rijtje 
     */
    public Student getStudent(int i){
        if(studenten[i]== null){
            return null;
        }
        else return studenten[i];
    }
    
    /**
     * 
     * @return rij object als string 
     */
    @Override
    public String toString(){
        String dummy = "";
        for (int i = 0; i < studenten.length ; i++) {
            dummy += studenten[i];
            dummy += "\n";
        }
        return dummy;       
    }
}
