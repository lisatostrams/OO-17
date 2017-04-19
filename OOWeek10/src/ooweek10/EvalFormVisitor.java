/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

import java.util.Map;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class EvalFormVisitor implements FormVisitor<Boolean> {
    private Map<String, Boolean> environ; 
    
    /**
     * constructor
     * @param environ 
     */
    public EvalFormVisitor (Map<String, Boolean> environ) {
        this.environ = environ; 
    }
    
    /**
     * evalueert binaire operators
     * @param form
     * @return 
     */
    @Override
    public Boolean visit(BinOpForm form) {
        boolean lres = (boolean) form.getLeft().accept(this);
        boolean rres = (boolean) form.getRight().accept(this);
        switch(form.getOp()) {
            case AndOp: return lres && rres;
            case OrOp:  return lres || rres; 
            case ImpliesOp: return !lres || rres; 
        }
        return true; 
    }
        
    /**
     * evalueert not operator
     * @param form
     * @return 
     */
    @Override
    public Boolean visit(NotForm form) {
        return !((boolean) form.get().accept(this)); 
    }

    @Override
    public Boolean visit(Form form) {
        return (Boolean) form.accept(this); 
    }

    /**
     * 
     * @param form
     * @return true
     */
    @Override
    public Boolean visit(TrueForm form) {
        return true;
    }

    /**
     * 
     * @param form
     * @return false 
     */
    @Override
    public Boolean visit(FalseForm form) {
        return false; 
    }
    
    /**
     * 
     * @param form
     * @return ??
     */
    @Override
    public Boolean visit(StringForm form) {
        return (Boolean) form.accept(this);
    }

  
    
}
