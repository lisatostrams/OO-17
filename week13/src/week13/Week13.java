/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week13;
import oo16mergesort.MergeSort;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class Week13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = new int[10000000];
        for (int i=0; i<10000000; i++){
            int n = (int)(Math.random()*9999999 + 1);
            list[i] = n;

            //System.out.println(list[i] + " ");
        }
        
        MergeSort sort = new MergeSort(list);
        Thread t = new Thread(sort);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
        System.out.println(MergeSort.isSorted(list));
        if(sort.isSorted(list)) {
            for(int i = 0; i < 1000; i++) {
                System.out.println(list[i]);
            }
            for(int i = 9999900; i < 10000000; i++) {
                System.out.println(list[i]); 
            }
        }
    }
    
}
