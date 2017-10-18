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
    
    ArrayList<Integer> list;
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
    

    public void shakerSort()
    {
        boolean swapped = true;
        
        while(swapped)
        {
            swapped = false;
            
            for(int i = 0; i<list.size()-2; i++)
            {
                if(list.get(i) > list.get(i+1))
                {
                    swap(i,i+1);
                    swapped = true;
                }
            }
            for(int i=list.size()-2; i>=0; i--)
            {
                if(list.get(i) > list.get(i+1))
                {
                    swap(i,i+1);
                    swapped = true;
                }
            }
        }
        
    }
    
    private void swap(int i,int j)
    {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,tmp);
    }
    

    public void shellSort() 
    {     
        int k;
        int i, j, save;
        k = list.size() / 2;
        while(k > 0)     
        {         
           for (i = k; i < list.size(); i++)         
            {             
                save = list.get(i);    // Current item to be inserted             
                for ( j = i - k; j >= 0; j = j - k)             
                {
                    if(list.get(j) > save)
                        list.set(j+k, list.get(j));
                    else                         
                        break;                     
                }
                list.set(j+k, save);
            }         
            k = k / 2;     
        } 
    }

}
