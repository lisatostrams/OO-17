package oo15filefindertest;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @author pieterkoopman
 */
public class FileFinder implements Runnable{
    private final File rootDir;
    private String name;
    
    public FileFinder(String root, String name) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
        this.name = name;
    }
    
    public void find (File rootDir, String fileName) throws IOException {
        File [] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    Thread t1 = new Thread(new FileFinder(file.getAbsolutePath(), name));
                    t1.start();
                    //find(file, fileName);
                }
            }
        }
    }

    @Override
    public void run() {
        
        try {
            find(rootDir,name);
        } catch (IOException ex) {
            Logger.getLogger(FileFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
