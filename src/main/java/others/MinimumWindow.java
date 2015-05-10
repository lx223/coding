package others;

/**
 * Created by lanxiao on 09/05/15.
 */
public class MinimumWindow {
    /*
    Question:
        Given two strings, str and query, find the minimum length substring in str that contains all characters in query
    Thinking process:
        Since every character in str has to be checked before a solution is found. The best time complexity is O(n), n
        being the length of the str.
        One possible solution to get a linear time complexity is to maintain a minimum window.
     */

    final private int R = 256;

    public String solve(String str, String query) {
        int[] finding = new int[R];
        int[] found = new int[R];
        for (char c : query.toCharArray()) finding[c]++;
        int start = 0, end = 0;
        String min = str;
        int count = 0;
        while (end < str.length()) {
            while (end < str.length() && count < query.length()) {
                char c = str.charAt(end);
                if (finding[c] > 0) {
                    if (found[c] < finding[c]) count++;
                    found[c]++;
                }
                end++;
            }
            while (start < end && count >= query.length()) {
                char c = str.charAt(start);
                if (finding[c] > 0) {
                    found[c]--;
                    if (found[c] < finding[c]) count--;
                }
                start++;
            }
            if (start == 0) return "";
            String candidate = str.substring(start - 1, end);
            if (min.length() > candidate.length()) min = candidate;
        }
        return min;
    }

    static public void main(String[] args) {
        MinimumWindow solver = new MinimumWindow();
        String str = "12223456123", query = "";
        System.out.println(solver.solve(str, query));
    }
}
