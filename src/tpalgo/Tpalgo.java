package tpalgo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tpalgo {

    public static void main(String[] args) throws IOException {   
       
       
       TestElection t = new TestElection();
       
//       //Test de l'exemple de l'énoncé
//       t.testExemple();
       
//        //Test pour les différentes valeurs de la question e
//        int[] k = {2, 3, 5, 10};
//        int[] n = {(int) Math.pow(10, 3), (int) Math.pow(10, 4), (int) Math.pow(10, 5), (int) Math.pow(10, 6)};
//        for (int i : n) {
//            for (int j : k) {
//                t.testElection(j, i, false);
//            }
//        }
        
//        //Test pour les différentes valeurs de la question f
//        for(int i = 0; i<=200; i++) 
//        {
//            t.testElection(i, 100, false);
//        }
       
       
      
//        SortClass sc = new SortClass();
//
//        sc.fillList(100000);
//        sc.shakerSort();
//        sc.fillList(100000);
//        sc.shellSort();
//
//        sc.fillList(100000);
//        sc.dichInsertionSort();

        
        SortClass sc = new SortClass()
                ;
        FileWriter shakerfw = new FileWriter("shaker.csv");
        BufferedWriter shakeroutput = new BufferedWriter(shakerfw);
        
        FileWriter shellfw = new FileWriter("shell.csv");
        BufferedWriter shelloutput = new BufferedWriter(shellfw);
        
        FileWriter dichfw = new FileWriter("dich.csv");
        BufferedWriter dichoutput = new BufferedWriter(dichfw);
 
        int[] sizes = {5000,20000,50000,75000};
        for (int i : sizes) {
            
            sc.fillList(i);
            shelloutput.write(sc.shellSort());
            
            sc.fillList(i);
            dichoutput.write(sc.dichInsertionSort());

            sc.fillList(i);
            shakeroutput.write(sc.shakerSort());

        }
        shakeroutput.flush();
        shakeroutput.close();
        
        shelloutput.flush();
        shelloutput.close();
        
        dichoutput.flush();
        dichoutput.close();
    }
    

}