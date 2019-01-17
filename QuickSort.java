package ac.algorithms.sorts;

import ac.tests.TestData;
import java.util.Arrays;

public class QuickSort {

    private static final boolean debug = true;
    
    private static void exchange(Comparable[] a, int pos1, int pos2) {
        Comparable c = a[pos2];
        a[pos2] = a[pos1];
        a[pos1] = c;
    }
    
    public static void quickSort3Way (Comparable[] a) {
        //First step is to shuffle the array
        quickSort3Way(a, 0, a.length-1);
    }
    
    public static void quickSort3Way (Comparable[] a, int low, int high) {
        // Assumption: a has been shuffled and is in random order
        
        // If low index equal to or past high 
        // index we've finished shuffling
        if (low >= high) { return; }
        
        int lt = low;
        int gt = high;
        Comparable v = a[low];
        int i = low;
      
        while (i <= gt) {
            
            if (debug) {
                // The 5 between the % and s specifies that
                // we should create a column 5 characters 
                // wide for this 'field'.
                System.out.println(String.format("%5s %5s %5s %5s     %s", lt, gt, v, i, Arrays.toString(a)));
            }
            
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exchange(a, lt, i);
                lt++;
                i++;
            } else if (cmp > 0) {
                exchange(a, i, gt);
                gt--;
            } else {
                i++;
            }
        } //while
        quickSort3Way(a, low, lt-1);
        quickSort3Way(a, gt+1, high);
    }
    
    public static void main(String[] args){
        
        Comparable[] testArray = TestData.getArrayOfUppercaseLettersAsStrings(20);
        System.out.println(Arrays.toString(testArray));
        //For debugging and undersanding
        if (debug) {
            System.out.println(String.format("%5s %5s %5s %5s     %s", "lt", "gt", "v", "i", "Current Array"));
        }          
        quickSort3Way(testArray);
        System.out.println(Arrays.toString(testArray));
        
    }
    
}
