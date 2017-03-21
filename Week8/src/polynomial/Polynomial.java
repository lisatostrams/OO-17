package polynomial;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @date 19-04-2016
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
        terms = new LinkedList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     * scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial( String s ) {
        terms = new LinkedList<>();
        Scanner scan = new Scanner( s );

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
        terms = new LinkedList<>();
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
        StringBuilder sb = new StringBuilder();
        for(Term t : terms){
            sb.append(t.getCoef());
            if(t.getExp()==0)
                sb.append(" + ");
            else if(t.getExp()==1)
                sb.append("x + ");
            else
                sb.append("x^").append(t.getExp()).append(" + ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void plus(Polynomial b) {
        List<Term> terms2 = b.terms;
        //List<Term> terms3 = new LinkedList<>();
        for(Term t : terms){
            //boolean eq = false;
            // checken of de exp van terms in b voorkomt
            for(Term t2 : terms2){
                if(t.getExp()==t2.getExp()){
                    t.plus(t2);
                    terms2.remove(t2);
                }
            }
        }
        for(Term t2 : terms2){
            terms.add(t2);
        }
        
            // zoja coeff optellen en aan terms 2 toevoegen
            // zonee aan terms 2 toevoegen
            // rangschik de terms op oplopende exponenten
            
    }


    public void minus(Polynomial b) {
    }


    public void times(Polynomial b) {
    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object other_poly) {
        return false;
    }

}
