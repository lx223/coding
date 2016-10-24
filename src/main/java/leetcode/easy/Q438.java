package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lanxiao on 24/10/2016.
 */
public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] charCounts = new int[26];
        for (char c: p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        List<Integer> answer = new ArrayList<>();
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']--;

            int head = i - windowSize + 1;
            if (head < 0) {
                continue;
            }

            long largerZeroCount = Arrays.stream(charCounts).filter(c -> c > 0).count();
            if (largerZeroCount == 0) {
                answer.add(head);
            }

            char headChar = s.charAt(head);
            charCounts[headChar - 'a']++;
        }
        return answer;
    }

}
