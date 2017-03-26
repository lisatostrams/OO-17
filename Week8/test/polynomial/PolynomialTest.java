/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import polynomial.Polynomial;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * Test klasse voor polynomial
 */
public class PolynomialTest {
    

    /**
     * Test of plus method, of class Polynomial.
     * 
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial a = new Polynomial("3 1 3 4");
        Polynomial b = new Polynomial();
        b.plus(a); 
        assertEquals(b, a);  //0 + a = a
        Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p1m = new Polynomial("-3 1 -2 3");
        Polynomial p2 = new Polynomial(p1);
        Polynomial p2m = new Polynomial(p1m);
        p1m.plus(p1);
        assertEquals(p1m, new Polynomial()); //p1 + (-p1) = 0
        p2.plus(p2m);
        assertEquals(p2,p1m); // test commutativiteit
        b = new Polynomial("2 1");
        Polynomial c = new Polynomial("1 2 3 4");
        Polynomial a1 = new Polynomial(a);
        Polynomial b1 = new Polynomial(b);
        Polynomial c1 = new Polynomial(c);
        a.times(b);
        a.times(c);
        b1.times(c1);
        a1.times(b1);
        assertEquals(a, a1); //test associativiteit
       
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial (p1);
        p1.minus(p2);
        assertEquals(p1, new Polynomial()); //p1 - p1 = 0
        p1 = new Polynomial(p2); 
        Polynomial n_one = new Polynomial("-1 0");
        p1.times(n_one);
        p2.plus(p1);
        assertEquals(p2, new Polynomial()); // p1 + ((-1)*p1) = p1 - p1 
       
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial (p1);
        Polynomial p3 = new Polynomial( "4 0 5 3" );
        Polynomial p4 = new Polynomial( "12 1 8 3 15 4 10 6" );
        Polynomial p5 = new Polynomial(p1);
        Polynomial p6 = new Polynomial(p3); 
        Polynomial one = new Polynomial("1 0");
        Polynomial zero = new Polynomial(); 
        p1.times(one);
        assertEquals(p1, p2); //p1 * 1 = p1
        p1.times(zero);
        assertEquals(p1, zero); //p1 * 0 = 0
        p2.times(p3);
        assertEquals(p2, p4); //test distributie
        p6.times(p5);
        assertEquals(p2, p6); //test commutativiteit
        
        Polynomial a = new Polynomial("3 1 3 4");
        Polynomial b = new Polynomial("2 1");
        Polynomial c = new Polynomial("1 2 3 4");
        Polynomial a1 = new Polynomial(a);
        Polynomial b1 = new Polynomial(b);
        Polynomial c1 = new Polynomial(c);
        a.times(b);
        a.times(c);
        b1.times(c1);
        a1.times(b1);
        assertEquals(a, a1); //test associativiteit
        
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial (p1);
        p1.divide(p2);
        assertEquals(p1, new Polynomial("1 0")); //p1 / p1 = 1
    }

   
 
    
}
