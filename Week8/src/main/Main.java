package main;

import polynomial.Polynomial;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial( "4 0 5 3" );
        Polynomial p3 = new Polynomial( "4 0 -5 3" );
        Polynomial p4 = new Polynomial( "6 1" );
        Polynomial p5 = new Polynomial();
        //p3.minus(p2);
        Polynomial a = new Polynomial("4 1 3 2");
        Polynomial c = new Polynomial("-4 1 -3 2");
        c.plus(a);
        p2.times(p3);

        System.out.println( p1 );
        System.out.println( p2 );
        System.out.println( p3 );
        System.out.println( p4 );
        System.out.println( p5 );
        System.out.println( c );
   }

}
