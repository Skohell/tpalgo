package tpalgo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tpalgo {

    public static void main(String[] args) throws IOException {   
       
       
        System.out.println("-------Test liste circulaire donne 5-4-2 --------");
        
        CircularList<Integer> cl = new CircularList<>();
        
        cl.pushBack(1);
        cl.pushBack(2);
        cl.pushBack(3);
        System.out.println(cl.toString());
        
        cl.pushFront(4);
        cl.pushFront(5);
        cl.pushFront(6);
        System.out.println(cl.toString());
        
        cl.popFront();
        System.out.println(cl.toString());        
        cl.popBack();
        System.out.println(cl.toString());        
        cl.popData(1);
        System.out.println(cl.toString());
        System.out.println("----------------------------------------"); 
        System.out.println("");
        
        
        TestElection t = new TestElection();
       
        System.out.println("----------Test exemple ( retourne 4 )------------");
        //Test de l'exemple de l'énoncé devant renvoyer 4
        t.testExample();
        System.out.println("----------------------------------------"); 
        System.out.println("");
        
        
        System.out.println("---------------Tests question e -----------------");
        //Test pour les différentes valeurs de la question e
        int[] k = {2, 3, 5, 10};
        int[] n = {(int) Math.pow(10, 3), (int) Math.pow(10, 4), (int) Math.pow(10, 5), (int) Math.pow(10, 6)};
        for (int i : n) {
            for (int j : k) {
                t.testElection(j, i, false);
            }
        }
        
        System.out.println("----------------------------------------"); 
        System.out.println("");
        
        System.out.println("---------------Tests question f -----------------");
        //Test pour les différentes valeurs de la question f
        for(int i = 0; i<=200; i++) 
        {
            t.testElection(i, 100, false);
        }
       
        System.out.println("----------------------------------------"); 
        System.out.println("");
       
      
     

        System.out.println("---------------Tests tris -----------------");
        SortClass sc = new SortClass();
       
        System.out.println("Dich");
        sc.fillList(10);
        System.out.println(sc.list.toString());
        sc.dichInsertionSort();
        System.out.println(sc.list.toString());
        
        System.out.println("shell");
        sc.fillList(10);
        System.out.println(sc.list.toString());
        sc.shellSort();
        System.out.println(sc.list.toString());
        
        System.out.println("shaker");
        sc.fillList(100);
        System.out.println(sc.list.toString());
        sc.shakerSort();
        System.out.println(sc.list.toString());
        
        System.out.println("----------------------------------------"); 
        System.out.println("");

        // Cet portion de code a servi durant les extraction de données 
        // pour générer les graphes.
//        FileWriter shakerfw = new FileWriter("shaker.csv");
//        BufferedWriter shakeroutput = new BufferedWriter(shakerfw);
//        
//        FileWriter shellfw = new FileWriter("shell.csv");
//        BufferedWriter shelloutput = new BufferedWriter(shellfw);
//        
//        FileWriter dichfw = new FileWriter("dich.csv");
//        BufferedWriter dichoutput = new BufferedWriter(dichfw);
// 
//        int[] sizes = {5000,20000,50000,75000};
//        for (int i : sizes) {
//            
//            sc.fillList(i);
//            shelloutput.write(sc.shellSort());
//            
//            sc.fillList(i);
//            dichoutput.write(sc.dichInsertionSort());
//
//            sc.fillList(i);
//            shakeroutput.write(sc.shakerSort());
//
//        }
//        shakeroutput.flush();
//        shakeroutput.close();
//        
//        shelloutput.flush();
//        shelloutput.close();
//        
//        dichoutput.flush();
//        dichoutput.close();

    }
}