package tpalgo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class containing the sorting methods.
 * @author gravallg
 */
public class SortClass {

    ArrayList<Integer> list;
    Random r;

    /**
     * Default constructor of the SortClass class.
     */
    public SortClass() {
        list = new ArrayList<>();
        r = new Random();
    }

    /**
     * Fills a list with 'n' random items.
     * @param n 
     */
    public void fillList(int n) {
        list.clear();

        for (int i = 0; i < n; i++) {
            list.add(r.nextInt(n));
        }
    }

    /**
     * Implementation of the shaker sorting method.
     * @return A csv formatted string of the size of the list, time of 
     * execution, number of comparisons and affectations.
     */
    public String shakerSort() {
        
        // Variables used to measure the method performance.
        long duration = System.currentTimeMillis();
        long comp = 0;
        long affect = 0;

        int b = 0;
        int newB;
        int e = list.size() - 1;
        int newE;

        
        //While we have unsorted values.
        while (b <= e) {
            
            boolean swapped = false;

            newB = e;
            newE = b;
            
            //Bubble sort from left to right.
            for (int i = b; i < e; i++) {
                comp++;
                if (list.get(i) > list.get(i + 1)) {
                    swap(i, i + 1);
                    affect += 3;
                    newE = i+1;
                    swapped = true;
                }
            }

            //Stop if the list is sorted.
            if (!swapped) {
                break;
            }
            
            //We are sure that one item was sorted an moved to the right.
            e = newE - 1;
            swapped = false;

            //Bubble sort from right to left.
            for (int i = e; i >= b; i--) {
                comp++;
                if (list.get(i) > list.get(i + 1)) {
                    affect += 3;
                    swap(i, i + 1);
                    newB = i;
                    swapped = true;
                }
            }

            //Stop if the list is sorted.
            if (!swapped) {
                break;
            }

            //We are sure that one item was sorted an moved to the left.
            b = newB + 1;
        }

        duration = (System.currentTimeMillis() - duration);
        System.out.println("shakerSort(" + list.size() + ") : " + duration + "ms - " + comp + " comparisons - " + affect + " affectations.");
        return (list.size() + "," + duration + "," + comp + "," + affect + ",\n");
    }

    /**
     * Swap two items in the list with given indexes.
     * @param i Index of the first item.
     * @param j Index of the second item;
     */
    private void swap(int i, int j) {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /**
     * Implementation of the shell sorting method.
     * @return A csv formatted string of the size of the list, time of 
     * execution, number of comparisons and affectations.
     */
    public String shellSort() {
        // Variables used to measure the method performance.
        long duration = System.currentTimeMillis();
        long comp = 0;
        long affect = 0;

        int k;
        int i, j, save;
        //For this implementation we chose the original Shell value for k,
        // being a succession of division per 2.
        k = list.size() / 2;
        
        // Until we finished our k list, which will end by 1, ensuring
        // a sorted list ( insertion sort ).
        while (k > 0) {
            // For each sublist.
            for (i = k; i < list.size(); i++) {
                save = list.get(i);
                affect++;
                //For each item of the sublist, we sort the sublist.
                for (j = i - k; j >= 0; j = j - k) {
                    comp++;
                    if (list.get(j) > save) {
                        list.set(j + k, list.get(j));
                        affect++;
                    } else {
                        break;
                    }
                }
                list.set(j + k, save);
                affect++;
            }
            k = k / 2;
        }

        duration = (System.currentTimeMillis() - duration);
        System.out.println("shellSort(" + list.size() + ") : " + duration + "ms - " + comp + " comparisons - " + affect + " affectations.");
        return (list.size() + "," + duration + "," + comp + "," + affect + ",\n");
    }

    /**
     * Implementation of the insertion sort method using the dichotomy.
     * @return A csv formatted string of the size of the list, time of 
     * execution, number of comparisons and affectations.
     */
    public String dichInsertionSort() {
        // Variables used to measure the method performance.
        long duration = System.currentTimeMillis();
        int comp = 0;
        int affect = 0;

        if (list.isEmpty()) {
            return null;
        }

        //For all the items in the array ( considering the first one already
        //sorted at the end of the array ).
        for (int i = list.size() - 2; i >= 0; i--) {

            int start = i + 1;
            int indice;
            int end = list.size() - 1;

            affect++;
            int val = list.get(i);

            //we find the insertion index by dichotomy.
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

            //We insert the item where it should be.
            affect += (indice - i) + 2;
            list.add(indice, list.get(i));
            list.remove(i);
        }

        duration = (System.currentTimeMillis() - duration);
        System.out.println("dichInsertionSort(" + list.size() + ") : " + duration + "ms - " + comp + " comparisons - " + affect + " affectations.");
        return (list.size() + "," + duration + "," + comp + "," + affect + ",\n");
    }

}
