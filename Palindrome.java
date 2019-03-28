package ac.leetcode;

import ac.utils.Output; 
import java.util.HashSet;


public class Palindrome {

    private static boolean isPalindrome(final String p) {
        if (null == p || "".equals(p)) { return false; }
        if (1 == p.length()) { return true; }
        
        int start = 0;
        int end = p.length()-1;
        while (start <= end) {
            if (p.charAt(start) != p.charAt(end)) { return false; }
            start++;
            end--;
        }
        return true;
    }

    

    public static String longestPalindrome(final String s) {

        // Safety checks
        if (null==s || s.length() == 0) { return null; }
        if (s.length() == 1) { return s; }
        
        Output.log("\n\nSearching for palindromes: " + s);
        int sLength = s.length();

        // Palindrome - smallest is 1 character.  Take first.
        String longestP = s.substring(0, 1);
        
        // Performance sucked at faster than only 14%
        HashSet<String> hs = new HashSet<String>();
        
        // Iterate over all letters looking for combinations
        for (int i=0; i < sLength; i++) {
            String currentChar = s.substring(i, i+1);
            if (!hs.contains(currentChar)) {
                hs.add(currentChar);

                int pos2 = s.indexOf(currentChar, i+1);
                while (pos2 > -1 && pos2 < sLength && (pos2-i) > longestP.length()) {
                    String substring = s.substring(i, pos2+1);
                    //Output.log("   ---pos1: " + i);
                    //Output.log("   ---pos2: " + pos2);
                    //Output.log("   ---check palindrome: '" + substring + "'");
                    //Output.log("   --- is palindrome? " + isPalindrome(substring));

                    if (substring.length() > longestP.length() && isPalindrome(substring)) {
                        longestP = substring;
                    }

                    //pos1 = pos2;
                    pos2 = s.indexOf(currentChar, pos2+1);
                } //while
            } //if
        } //for
        
        // Palindrome of 2 characters has to be the same character repeated: aa, dd
        // Palindrome of 3 characters can be repeated or sandwich: aa, dd, ada, dad
        // Palindrome of 4 characters can be repeated or mirror: aaaa, dddd, adda, daad
        // Palidromee with odd # of characters can have any letter in middle
        // Palindrome with even # of characters must have a pair in middle 
        
        return longestP;
    }
    
    public static void main(String[] args) {
        String[] tests = new String[] {"babad", "cbbd","babadcdbbbbeaaebbbxy"}; // 
        //String[] tests = new String[] {"babad"}; 
        //String[] tests = new String[] {"babaddab"}; 
        for (String t : tests) {
            System.out.println("String '" + t + "' contains largest palindrome '" + longestPalindrome(t) + "'");
        }
    }
    

    
}
