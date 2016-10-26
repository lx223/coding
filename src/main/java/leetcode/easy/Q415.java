package leetcode.easy;

/**
 * Created by lanxiao on 27/10/2016.
 */
public class Q415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException();
        }

        int num1Len = num1.length();
        int num2Len = num2.length();
        if (num1Len == 0 || num2Len == 0) {
            return num1Len == 0 ? num2 : num1;
        }

        StringBuilder ans = new StringBuilder();
        int num1Head = num1Len - 1;
        int num2Head = num2Len - 1;
        int carry = 0;
        while(num1Head >= 0 || num2Head >= 0 || carry != 0) {
            int digit1 = 0;
            int digit2 = 0;
            if (num1Head >= 0) {
                digit1 = Character.getNumericValue(num1.charAt(num1Head));
            }
            if (num2Head >= 0) {
                digit2 = Character.getNumericValue(num2.charAt(num2Head));
            }

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;

            ans.insert(0, (char)('0' + remainder));

            num1Head--;
            num2Head--;
        }
        return ans.toString();
    }
}
