/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.leetcode;

import ac.utils.Output;
import java.util.Arrays;

/**
 *
 * @author U0121565
 */
public class MedianSortedArrays {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Output.log("\nnums1: " + Arrays.toString(nums1));
        Output.log("nums2: " + Arrays.toString(nums2));
        
        int totalSize = nums1.length + nums2.length;
        int midPoint = totalSize / 2;
        int remainder = totalSize % 2;
        Output.log("totalSize:" + totalSize);
        Output.log("midPoint:" + midPoint);
        Output.log("remainder:" + remainder);
        
        int[] mergedArray = new int[totalSize];
        int nums1Index = 0;
        int nums2Index = 0;
        for (int k=0; k<totalSize; k++) {
            if (nums1Index < nums1.length && nums2Index < nums2.length) {
                if (nums1[nums1Index] < nums2[nums2Index]) {
                    mergedArray[k] = nums1[nums1Index];
                    nums1Index++;
                } else {
                    mergedArray[k] = nums2[nums2Index];
                    nums2Index++;
                }
            } else if (nums1Index >= nums1.length) {
                    mergedArray[k] = nums2[nums2Index];
                    nums2Index++;
            } else {
                    mergedArray[k] = nums1[nums1Index];
                    nums1Index++;
            }
        }
        Output.log("Merged array: " + Arrays.toString(mergedArray));
        
        if (1 == remainder) {
            return mergedArray[midPoint];
        } else {
            return (mergedArray[midPoint] + mergedArray[midPoint-1]) / 2.0;
        }
    }
    
    
    public static void main(String[] args) {
        int[] n1 = new int[] {1, 3};
        int[] n2 = new int[] {2};
        Output.log("Median of " + Arrays.toString(n1) + " and " + Arrays.toString(n2) + " is " + findMedianSortedArrays(n1, n2));

        n1 = new int[] {1, 2};
        n2 = new int[] {3,4};
        Output.log("Median of " + Arrays.toString(n1) + " and " + Arrays.toString(n2) + " is " + findMedianSortedArrays(n1, n2));
    }     
    
    
    
}
