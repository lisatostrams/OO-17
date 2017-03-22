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

/**
 *
 * @author mauri
 */
public class PolynomialTest {
    
    public PolynomialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial();
        String expResult = "0";
        String result = instance.toString();
        assertEquals(expResult, result); // 2 lege polynomen met elkaar vergelijken
        Polynomial a = new Polynomial("1 0 2 2");
        String expResult2 = "1.0 + 2.0x^2";
        String result2 = a.toString();
        assertEquals(expResult2,result2); // het geval dat een exponent 0 is
        Polynomial p1 = new Polynomial("0 2 3 4");
        String expResultp1 = "3.0x^4";
        String resultp1 = p1.toString();
        assertEquals(expResultp1,resultp1); // het geval dat een coefficient 0 is
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial a = new Polynomial("4 1 3 2");
        Polynomial b = new Polynomial();
        b.plus(a);
        assertEquals(b,a); // een polynoom bij een lege polynoom optellen
        Polynomial c = new Polynomial("-4 1 -3 2");
        c.plus(a);
        System.out.println(c.toString());
        assertEquals(c,new Polynomial()); // een polynoom bij zijn eigen inverse opgeteld moet de lege polynoom opleveren
        
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.minus(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.times(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = null;
        Polynomial instance = new Polynomial();
        instance.divide(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = new Polynomial("1 2 3 4");
        Polynomial instance = new Polynomial("1 2 3 4");
        boolean expResult = true;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
    }
    
}
