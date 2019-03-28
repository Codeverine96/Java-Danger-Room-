/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.leetcode;

import static ac.leetcode.AddTwoNumbers.addTwoNumbers;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * @author U0121565
 */
public class LlengthOfLongestSubstring {
    
    public static int lengthOfLongestSubstringString(String s) {
        // Safety check
        if (null == s || s.length() == 0) { return 0; }

        String longestSubstring = "";
        String lStr = "";
        //System.out.println("\nlengthOfLongestSubstring="+s);

        for (int i=0; i<s.length(); i++) {
            String charAt = s.substring(i, i+1);
            
            //System.out.println("i="+i);
            //System.out.println("charAt(i)=" + charAt);
            //System.out.println("longestSubstring - current: " + lStr);
            
            if (lStr.length() == 0) {
                lStr = charAt;
            } else {
                int charPos = lStr.indexOf(charAt);
                if (charPos > -1) {
                    lStr = lStr.substring(charPos+1, lStr.length());
                }
                lStr = lStr.concat(charAt);
            }
            
            if (lStr.length() > longestSubstring.length()) {
                longestSubstring = lStr;
            }
            
        } //for
        
        //System.out.println(s + " - longest substring: " + longestSubstring);
        return longestSubstring.length();
    }    
   
    
   public static int lengthOfLongestSubstring(String s) {
        // Safety check
        if (null == s || s.length() == 0) { return 0; }

        String longestSubstring = "";
        StringBuffer lStr = new StringBuffer();

        for (int i=0; i<s.length(); i++) {
            String charAt = s.substring(i, i+1);
            
            //System.out.println("i="+i);
            //System.out.println("charAt(i)=" + charAt);
            //System.out.println("longestSubstring - current: " + lStr);
            
            if (lStr.length() == 0) {
                lStr.append(charAt);
            } else {
                int charPos = lStr.indexOf(charAt);
                if (charPos > -1) {
                    lStr.delete(0, charPos+1);
                    //lStr = lStr.substring(charPos+1, lStr.length());
                }
                lStr.append(charAt);
            }
            
            if (lStr.length() > longestSubstring.length()) {
                longestSubstring = lStr.toString();
            }
            
        } //for
        
        System.out.println(s + " - longest substring: " + longestSubstring);
        return longestSubstring.length();
    }        
    
    public static void main(String[] args) {
        String[] tests = {null, "", "abcabcbb", "bbbbb", "pwwkew"};
        for (String t : tests) {
            System.out.println("lengthOfLongestSubstring(" + t + ") = " + lengthOfLongestSubstring(t));
        }
    }    
    
    
}
