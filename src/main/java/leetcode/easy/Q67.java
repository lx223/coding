package leetcode.easy;

/**
 * Created by lanxiao on 11/05/15.
 */
public class Q67 {
    /*
    LeetCode Q67:
        Given two binary strings, return their sum (also a binary string)
    Thinking:
        This is a simple computation from strings
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
