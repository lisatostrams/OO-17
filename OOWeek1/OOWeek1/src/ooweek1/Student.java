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
 * klasse bevat data van student 
 */
public class Student {
    
    private String voornaam;
    private String achternaam;
    private int studentnummer;
    
        
    /**
     * constructor maakt object van klasse student
     * @param voor
     * @param achter
     * @param nummer 
     */
    public Student(String voor, String achter, int nummer){
        this.voornaam = voor;
        this.achternaam = achter;
        this.studentnummer = nummer;
    }
    
    /**
     * set voor en achternaam
     * @param voor
     * @param achter 
     */
    public void setNaam(String voor, String achter){
        this.voornaam = voor;
        this.achternaam = achter;
    }
    
    /**
     * 
     * @return student object als string weergave 
     */
    @Override
    public String toString(){
        return voornaam + " " + achternaam + " s" + studentnummer;
    }
}
