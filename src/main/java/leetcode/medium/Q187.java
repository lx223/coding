package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lanxiao on 21/05/15.
 */
public class Q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList<>();

        final int bitMask = (1 << 20) - 1;
        Set<Integer> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();
        Set<Integer> found = new HashSet<>();
        int code = 0;
        for (int i = 0; i < 10; i++) {
            code <<= 2;
            code |= encode(s, i);
        }
        seen.add(code);
        for (int i = 10; i < s.length(); i++) {
            code = (code << 2) & bitMask;
            code |= encode(s, i);
            if (found.contains(code)) continue;
            if (seen.contains(code)) {
                ans.add(s.substring(i - 10 + 1, i + 1));
                found.add(code);
            } else {
                seen.add(code);
            }
        }
        return ans;
    }

    private int encode(String s, int i) {
        char c = s.charAt(i);
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c == 'T') return 3;
        return -1;
    }
}
