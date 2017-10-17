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
public class testElection {
    
    
    public void testExemple()
    {
         CircularList<Integer> cl = new CircularList<>();

            cl.pushBack(1);
            cl.pushBack(2);
            cl.pushBack(3);
            cl.pushBack(4);
            cl.pushBack(5);
            cl.pushBack(6);
            cl.pushBack(7);

            System.out.println(cl.toString()+"\n");


            cl.elect(3,true);
 
    }
    
    public void testElection(int step, int n, boolean output)
    {
        CircularList<Integer> cl = new CircularList<>();
        
        for(int i = 1; i<=n;i++)
        {
            cl.pushBack(i);
        }
        
        System.out.println(n + "candidates with k ="+step);
        
        cl.elect(step,output);
    }
}
