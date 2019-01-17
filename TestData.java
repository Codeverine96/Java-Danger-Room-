package ac.tests;

import java.util.Random;

/**
 * @author Codeverine96
 */
public class TestData {
 
    public static final int[] TEST_ARRAY_INT_10 = new int[] {251, 286, 662, 168, 297, 520, 170, 519, 653, 720};
    public static final int[] TEST_ARRAY_INT_20 = new int[] {6569, 9962, 3610, 2975, 376, 6325, 9873, 7115, 5344, 4369, 8617, 4721, 2740, 6179, 6078, 5528, 5348, 1880, 445, 7927};
    
    public static String[] getArrayOfUppercaseLettersAsStrings(int arrayLength) {
        int firstUppercaseIndex = (int)'A'; // for uppercase
        String[] rslt = new String[arrayLength];
        Random r = new Random();
        for (int i = 0; i < arrayLength; i++) {
            int letterIndex = r.nextInt(26); // random number between 0 and 26
            char randomUppercase = (char) (firstUppercaseIndex + letterIndex);
            rslt[i] = randomUppercase + "";
        }
        return rslt;
    }
    
    public static int[] getArrayOfInts(int arrayLength, int maxValue) {
        int[] rslt = new int[arrayLength];
        for (int i=0; i<arrayLength; i++) {
            rslt[i] = Double.valueOf(Math.round(Math.random() * maxValue)).intValue();
        }
        return rslt;
    }
    
    
}
