
package tpalgo;

import java.util.ArrayList;
import java.util.Random;

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
    
    public String shakerSort()
    {
        long duration = System.currentTimeMillis();
        long comp = 0;
        long affect = 0;
        
        int b = 0;
        int newB;
        int e = list.size()-1;
        int newE;
        
        boolean swapped = false;
        
        while(b<=e)
        {
            newB=e;
            newE=b;
            
            for(int i = b; i< e; i++)
            {
                comp++;
                if(list.get(i) > list.get(i+1))
                {
                    swap(i,i+1);
                    affect+=3;
                    newE = i;
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
            
            e = newE-1;
            
            for(int i = e; i>= b; i--)
            {
                comp++;
                if(list.get(i) > list.get(i+1))
                {
                    affect+=3;
                    swap(i,i+1);
                    newB = i;
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
            
            b=newB+1;
        }
        
        duration = ( System.currentTimeMillis() - duration );
        System.out.println("shakerSort("+list.size()+") : "+duration+ "ms - "+comp+" comparisons - "+affect+" affectations.");
        return(list.size()+","+duration+","+comp+","+affect+",\n");
    }

    private void swap(int i,int j)
    {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,tmp);
    }
    
    public String shellSort() 
    {     
        long duration = System.currentTimeMillis();
        long comp = 0;
        long affect = 0;
        
        int k;
        int i, j, save;
        k = list.size() / 2;
        while(k > 0)     
        {         
           for (i = k; i < list.size(); i++)         
            {             
                save = list.get(i);
                affect++;
                for ( j = i - k; j >= 0; j = j - k)             
                {
                    comp++;
                    if(list.get(j) > save)
                    {
                        list.set(j+k, list.get(j));
                        affect++;
                    }
                    else                         
                        break;                     
                }
                list.set(j+k, save);
                affect++;
            }         
            k = k / 2;
        } 
        
        duration = ( System.currentTimeMillis() - duration );
        System.out.println("shellSort("+list.size()+") : "+duration+ "ms - "+comp+" comparisons - "+affect+" affectations.");
        return(list.size()+","+duration+","+comp+","+affect+",\n");
    }
    
    public String dichInsertionSort() {
        long duration = System.currentTimeMillis();
        int comp = 0;
        int affect = 0;

        if (list.isEmpty()) {
            return null;
        }

        for (int i = list.size() - 2; i >= 0; i--) {

            int start = i + 1;
            int indice;
            int end = list.size() - 1;
            
            affect++;
            int val = list.get(i);

            int mid = (int) (start + end) / 2;
            while (start <= end && val != list.get(mid)) {
                comp++;

                comp++;
                if (val < list.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = (int) (start + end) / 2;
            }

            indice = mid + 1;

            affect += (indice-i)+2;
            list.add(indice, list.get(i));
            list.remove(i);
        }

        duration = (System.currentTimeMillis() - duration);
        System.out.println("dichInsertionSort(" + list.size() + ") : " + duration + "ms - " + comp + " comparisons - " + affect + " affectations.");
        return(list.size()+","+duration+","+comp+","+affect+",\n");
    }
    
 

}
