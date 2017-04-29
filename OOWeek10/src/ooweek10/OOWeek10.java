/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class OOWeek10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Form f1 = new BinOpForm(BinOp.AndOp, new StringForm("a"), new StringForm("b"));
        Form f2 = new BinOpForm(BinOp.ImpliesOp, new NotForm(new StringForm("a")), new BinOpForm(BinOp.OrOp, new StringForm("b"), new StringForm("c"))); 
        Form f3 = new BinOpForm(BinOp.AndOp, new TrueForm(), new FalseForm()); 
        PrintFormVisitor printer = new PrintFormVisitor(); 
        f1.accept(printer);
        System.out.println(printer);
        printer = new PrintFormVisitor(); 
        f2.accept(printer);
        System.out.println(printer);
        printer = new PrintFormVisitor();
        f3.accept(printer);
        System.out.println(printer);
        
        

        
    }
    
}
