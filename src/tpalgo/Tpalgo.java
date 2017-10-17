/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpalgo;

/**
 *
 * @author gravallg
 */
public class Tpalgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CircularList<Integer> cl = new CircularList<>();
        
        cl.pushBack(1);
        cl.pushBack(2);
        cl.pushBack(3);
        cl.pushBack(4);
        cl.pushBack(5);
        cl.pushBack(6);
        cl.pushBack(7);
        
        System.out.println(cl.toString()+"\n");
       
        
        cl.elect(3);
        
        
        System.out.println(cl.toString()+"\n");

    }
    
}
