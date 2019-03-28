/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.leetcode;

/**
 *
 * @author U0121565
 */
public class AddTwoNumbers {

    static boolean testing = true;

    private static String getNumberString(ListNode l) {
        StringBuffer s = new StringBuffer("[");
        ListNode display = l;
        while (display != null) {
            s.append(display.val + ",");
            display = display.next;
        }
        s.deleteCharAt(s.length()-1);
        s.append("]");
        return s.toString();
    }

    private static void log(String s) {
        if (testing) {
            System.out.println(s);
        }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode currentNode = null;
        int remainder = 0;

        System.out.println("--- addTwoNumbers2 ------");
        System.out.println("l1: " + getNumberString(l1));
        System.out.println("l2: " + getNumberString(l2));

        do {
            System.out.println("Entering Do loop, remainder=" + remainder);            
            
            int valueL1 = (l1 == null) ? 0 : l1.val;
            int valueL2 = (l2 == null) ? 0 : l2.val;
            int total = valueL1 + valueL2 + remainder;
            
            remainder = total / 10;
            total = total % 10;
            
            if (testing) {
                System.out.println("valueL1=" + valueL1);
                System.out.println("valueL2=" + valueL2);
                System.out.println("total=" + total);
                System.out.println("remainder=" + remainder);
            }
            
            ListNode newNode = new ListNode(total);
            if (root == null) {
                root = newNode;
                currentNode = root;
            } else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
            
            //Move to next position
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            System.out.println(" ");

        } while (l1 != null || l2 != null || remainder != 0);
        return root;
    }    
    

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode answer = null;
        answer = addTwoNumbers(l1, l2);
        System.out.println("ANSWER: " + getNumberString(answer));
        
        l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l2 = new ListNode(0);
        answer = addTwoNumbers(l1, l2);
        System.out.println("ANSWER: " + getNumberString(answer));        

    }

}
