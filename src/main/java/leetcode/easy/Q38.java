package leetcode.easy;

/**
 * Created by lanxiao on 26/04/15.
 */
public class Q38 {
    public String countAndSay(int n) {
        String ans = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] ansChars = ans.toCharArray();
            for (int i = 0; i < ansChars.length; i++) {
                int count = 1;
                while (i + 1 < ansChars.length && ansChars[i] == ansChars[i + 1]) {
                    i++;
                    count++;
                }
                sb.append(String.valueOf(count) + String.valueOf(ansChars[i]));
            }
            ans = sb.toString();
        }
        return ans;
    }

    static public void main(String[] args) {
        Q38 q38 = new Q38();
        System.out.println(q38.countAndSay(5));
    }
}
