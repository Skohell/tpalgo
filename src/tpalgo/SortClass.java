/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gravallg
 */
public class SortClass {
    
    List<Integer> list;
    Random r;
    
    public SortClass()
    {
        list = new ArrayList<>();
        r = new Random();
    }
    
    public void fillList(int n)
    {
        list.clear();
        
        for(int i = 0; i<n; i++)
        {
            list.add(r.nextInt(n));
        }
    }
    
    
}
