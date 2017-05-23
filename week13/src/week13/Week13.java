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
        int[] list1 = new int[10000000];
        int[] list2 = new int[10000000];
        for (int i=0; i<10000000; i++){
            int n = (int)(Math.random()*9999999 + 1);
            list1[i] = n;
            list2[i] = n;

            //System.out.println(list[i] + " ");
        }
        System.out.println("Sort list without multithreading first..");
        long firstTime = System.currentTimeMillis();
        MergeSort srt = new MergeSort(list1);
        srt.sort(list1); 
        long secondTime = System.currentTimeMillis();
        long runTime = secondTime - firstTime;
        System.out.println("List sorted in: " + runTime + "ms"); 
        System.out.println("" + Runtime.getRuntime().availableProcessors() + " available cores for multithreading");
        firstTime = System.currentTimeMillis();
        MergeSort sort = new MergeSort(list2);
        Thread t = new Thread(sort);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
        if(sort.isSorted(list2)) {
            secondTime = System.currentTimeMillis();
            runTime = secondTime - firstTime;
            System.out.println("List sorted in: " + runTime + " ms"); 
            for(int i = 0; i < 5; i++) 
                System.out.println(list2[i]);
            System.out.println(":"); 
            for(int i = 9999995; i < 10000000; i++) 
                System.out.println(list2[i]); 
            
        }
    }
    /**
     * Sort list without multithreading first..
     * List sorted in: 2309ms
     * 4 available cores for multithreading
     * List sorted in: 1210ms
     * 
     * 
     * 
     * 
     * 
     */
}
