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
public class ZigZagConversion {
    
    public static String convert(String s, int numRows) {
        
        if (null==s || s.length() == 0) { return ""; }
        if (numRows <= 1) { return s; }
        
        String EMPTY = "";
        String SPACE = " ";

        Output.log("\nInput string '" + s + "'");
        Output.log("Input length: " + s.length());
        Output.log("rows: " +numRows);
        Output.log("/: " +s.length()/numRows);
        Output.log("%: " +s.length()%numRows);

        boolean headingDown = true;
        int row = 0;
        String[] o = new String[numRows];
        for (int k=0; k<o.length; k++) {
            o[k] = EMPTY;
        }

        for (int i = 0; i < s.length(); i++) {
            
            if (row < 1) { headingDown = true; }
            if (row >= numRows-1) { headingDown = false; }
            
            //Get current character
            String c = s.substring(i, i+1);
            
            //System.out.println(String.format("%2s",i) + " " + String.format("%3s", c) + ", " + headingDown+ ", " + row);

            if (headingDown) {
                o[row] = o[row] + c;
                row++;
            } else {
                for (int k=0; k<o.length; k++) {
                    if (k>0 && k<numRows && k==row) {
                        o[k] = o[k] + c;
                    } else {
                        o[k] = o[k] + " ";
                    }
                }
                row--;
            }
        }

        StringBuilder sb = new StringBuilder();
        Output.log("Grid result:");
        for (int k=0; k<o.length; k++) {
            sb.append(o[k].replace(" ", ""));
            Output.log(o[k]);
        }
        return sb.toString();
    }    
    
    public static String convert2Orig(String s, int numRows) {
        if (null==s || s.length() == 0) { return ""; }
        if (numRows <= 1) { return s; }
        
        int sLen = s.length();
        int step = numRows + Math.max(0, numRows-2);
        Output.log("String: " + s);
        Output.log("String length: " + sLen);
        Output.log("numRows: " + numRows);
        Output.log("Step: " + step);
        
        StringBuilder result = new StringBuilder();
        for (int col=0; col<numRows; col++) {
            for (int r=0; r <=numRows; r++) {
                int pos = r * step + col;
                int zig = pos - (col*2);
                
                if ((zig>0) && (zig < sLen) &&(col > 0) && (col< numRows-1)) {
                    result.append(s.substring(zig, zig+1));
                    String z = s.substring(zig, zig+1);
                    Output.log ("col = " + col + ",r = " + r + ", zig = " + zig + " char = " + z + "*");
                }
                
                if (pos < sLen) {
                    result.append(s.substring(pos, pos+1));
                    String c = s.substring(pos, pos+1);
                    Output.log ("col = " + col + ",r = " + r + ", pos = " + pos + " char = " + c);
                } 
            }
        }
        return result.toString();
    }
    
      public static String convert2(String s, int numRows) {
        if (null==s || s.length() == 0) { return ""; }
        if (numRows <= 1) { return s; }
        
        int sLen = s.length();
        int step = numRows + Math.max(0, numRows-2);
        Output.log("String: " + s);
        Output.log("String length: " + sLen);
        Output.log("numRows: " + numRows);
        Output.log("Step: " + step);
        
        StringBuilder result = new StringBuilder();
        for (int col=0; col<numRows; col++) {
            for (int r=0; r <=sLen/numRows; r++) {
                int pos = r * step + col;
                int zig = pos - (col*2);
                
                if ((zig>0) && (zig < sLen) &&(col > 0) && (col< numRows-1)) {
                    result.append(s.substring(zig, zig+1));
                    String z = s.substring(zig, zig+1);
                    Output.log ("col = " + col + ",r = " + r + ", zig = " + zig + " char = " + z + "*");
                }
                
                if (pos < sLen) {
                    result.append(s.substring(pos, pos+1));
                    String c = s.substring(pos, pos+1);
                    Output.log ("col = " + col + ",r = " + r + ", pos = " + pos + " char = " + c);
                } 
            }
        }

        
        return result.toString();
    }
      
    
    public static void main(String[] args) {
        String test1 = "PAYPALISHIRING";
        int rows = 3;
        //Output.log( convert2(test1, 3) );
        //Output.log( convert2(test1, 4) );
        Output.log( convert2(test1, 2) );   // "PAYPALISHIRING", 2 ---> Should return "PYAIHRNAPLSIIG"
        //Output.log( convert(test1, 3) );
        //Output.log( convert(test1, 4) );
        //Output.log( convert("AB", 1) );

    }
    
}
