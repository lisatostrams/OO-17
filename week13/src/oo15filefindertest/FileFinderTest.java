package oo15filefindertest;

import java.io.File;
import java.io.IOException;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @author pieterkoopman
 */
public class FileFinderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OO15FileFinderTest fft = new OO15FileFinderTest();
         FileFinderTest();
    }

    public FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "/Users/mauri/Desktop/OO-17/week13";
            FileFinder ff = new FileFinder(root, goal);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.find(new File(root),goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }

    
    public static void FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "/Users/mauri/Desktop/OO-17/week13";
            FileFinder ff = new FileFinder(root, goal);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.find(new File(root),goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }
    
    /*
    public OO15FileFinderTest() {
        try {
            String goal = "FileFinderSeq.java";
            FileFinderSeq ff = new FileFinderSeq("/Users/pieterkoopman/Documents/onderwijs/OO/OO 2015/OO 2015 projects");
            File file = ff.findFile(goal);
            if (file != null) {
                System.out.println("found: " + file.getAbsolutePath());
            } else {
                System.out.println(goal + " not found.");
            }
        } catch (IOException e) {
            System.err.println( e );
        }
    }
*/
}