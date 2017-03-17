package qtrees;

import java.io.StringReader;
import java.io.StringWriter;

public class Qtrees {

    public static void main(String[] args) {
        System.out.println("Test 3->2 and 2->3"); 
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input ); // to test readQTree -- from representation 3 to 2
        StringWriter output = new StringWriter(); 
        qt.writeQTree(output); // to test writeNode -- from representation 2 to 3
        System.out.println(test_tekst);
        System.out.println(output.toString() + '\n'); //equal to test_tekst so 3->2 and 2->3 work

        System.out.println("Test 2->1 and 1->2"); 
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap( bitmap ); //to test fillBitmap -- from representation 2 to 1
        System.out.println(bitmap); //this is now the correct bitmap
        
        QTree test =  new QTree(bitmap); //test bitmap2Qtree -- from representation 1 to 2
        
        
        Bitmap bittest = new Bitmap(8,8); //go back from 2 to 1..
        test.fillBitmap(bittest); 
        System.out.println(bittest); //equal to bitmap so 2->1 and 1->2 work
        
    }

}
