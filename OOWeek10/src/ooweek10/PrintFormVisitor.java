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
public class PrintFormVisitor implements FormVisitor<String> {
    private StringBuilder str = new StringBuilder(); 
    
    
    @Override
    public String visit(BinOpForm form) { //gaat nog niet helemaal goed met diepere formules: a -> (b \/ c) 
        StringBuilder st = new StringBuilder(); 
        st.append(form.getLeft()); 
        st.append(form.getOp()); 
        st.append(form.getRight()); 
        str.append(st); 
        return st.toString(); 
        
    }

     @Override
    public String visit(TrueForm trueConstant) {
        StringBuilder st = new StringBuilder();
        st.append("true");
        str.append(st);
        return st.toString();
    }

    @Override
    public String visit(FalseForm falseConstant) {
        StringBuilder st = new StringBuilder();
        st.append("false");
        str.append(st);
        return st.toString();
    }
    
    @Override
    public String visit(NotForm not) {
        StringBuilder st = new StringBuilder();
        st.append("NOT ");
        st.append(not.get());
        str.append(st);
        return st.toString();
    }

    @Override
    public String visit(StringForm form) {
        StringBuilder st = new StringBuilder();
        st.append(form.toString());
        str.append(st);
        return st.toString();
    }
    
    
    @Override
    public String visit(Form form) {
        return form.accept(this).toString();
    }
    
    @Override
    public String toString() {
        return str.toString(); 
    }
}
