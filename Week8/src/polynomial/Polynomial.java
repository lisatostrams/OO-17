package polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @date 10-03-2015
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an
     * empty list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {
        terms = new ArrayList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     * scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial( String s ) {
        terms = new ArrayList<>();
        Scanner scan = new Scanner(s);

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     *
     */
    public Polynomial( Polynomial p ) {
        terms = new ArrayList<>(p.terms.size());
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
    }
    
    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        if(terms.size() == 0) return "0";
        String str = "";
        for(int i = 0; i < terms.size(); i++) {
            if(terms.get(i).getCoef() > 0 && i != 0) str +=  " + "  + terms.get(i); 
            else if(terms.get(i).getCoef() < 0 ) str += " " + terms.get(i);
            else str += terms.get(i); 
        }
        
        return str;
    }

    /**
     * add poly b to this
     * @param b 
     */
    public void plus(Polynomial b) {
        boolean match = false; 
        ListIterator<Term> lita = terms.listIterator(),
                           litb = b.terms.listIterator(); 
        for (Term t : b.terms) {
            for (Term s : terms) {
                if(s.getExp() == t.getExp()) { //match exponents
                    s.plus(t); //add terms
                    match = true; 
                }
            }
            if(!match) { //if no match found, add term
                insertTerm(t); 
            }
            match = false; 
        }
        removeZero(); // remove terms with coeff 0
    }

    /**
     * insert term t at right place in poly
     * @param t 
     */
    private void insertTerm(Term t) {
        for(Term s: terms) {
            if(t.getExp() < s.getExp()) {
                terms.add(terms.indexOf(s), t);
                return; 
            }
        }
        terms.add(t); 
        
    }
    
    /**
     * substract poly b from this
     * @param b 
     */
    public void minus(Polynomial b) {
        Polynomial min = new Polynomial("-1 0");
        b.times(min);
        this.plus(b);
    }

    /**
     * multiply this with poly b
     * @param b 
     */
    public void times(Polynomial b) { 
        ListIterator<Term> lita = terms.listIterator(),
                           litb = b.terms.listIterator(); 
        Polynomial result = new Polynomial();
        Polynomial copy = new Polynomial(this);
        for(Term t:  b.terms) {
            for(Term s : terms) { // multiply each term from b with each term from this
                s.times(t); 
            }
            result.plus(this);
            terms = copy.terms; 
        }
        terms = result.terms;
    }

    /**
     * divide using long division method steps from: https://www.mathsisfun.com/algebra/polynomials-division-long.html
     * @param b 
     */
    public void divide(Polynomial b) {
        Polynomial result = new Polynomial(); 
        Polynomial denom = new Polynomial(b);
        
        for(Term t : b.terms) {
            for(int i = 0; i < terms.size() && !terms.isEmpty() ; i++) {  //could not use iterator here because list is altered during loop
                Term term = new Term(t.getCoef()/terms.get(i).getCoef(), t.getExp() - terms.get(i).getExp()); //step 1: divide
                result.insertTerm(term);
     
                Polynomial temp = new Polynomial();
                temp.insertTerm(term);
                b.times(temp);  //step 2: multiply result from division with denominator
                this.minus(b); //step 3: substract from poly
                b.terms = denom.terms; 
    
            }
        }
        terms = result.terms;
        
    }

    /**
     * 
     * @param other_poly
     * @return true if other poly is equal to this 
     */
    @Override
    public boolean equals(Object other_poly) {
        if( other_poly == null || !(other_poly instanceof Polynomial)) {
            return false;
        }
        else {
            Polynomial p2 = (Polynomial) other_poly; 
            if(p2.terms.size() != terms.size()) {
                return false;
            } 
            for(int i = 0; i < terms.size(); i++) {
                if(!terms.get(i).equals(p2.terms.get(i))) {
                    return false;
                } 
            }
        }
        return true;
    }
    
    /**
     * remove terms with coeff 0
     */
    private void removeZero() {
        for(int i = 0; i < terms.size() ; i++) {
            if(terms.get(i).getCoef() == 0) {
                terms.remove(i);
                removeZero(); 
            } 
        }
    }
    
    /**
     * apply int x to polynomial
     * @param x
     * @return result
     */
    public double apply(int x) {
        double result = 0;
        int term; 
        for(Term s: terms) {
            if(s.getExp() > 0) {
                term = x; 
                for(int i = 1; i < s.getExp(); i++) {
                    term = term *x;
                }
            }
            else term = 1; 
            result += (term*s.getCoef());

        }
        return result; 
    }

}
