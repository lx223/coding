package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lanxiao on 29/04/15.
 */
public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> mapping = new HashMap<Character, Character>();
        Set<Character> used = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            char mapFrom = s.charAt(i);
            char mapTo = t.charAt(i);
            if (!mapping.containsKey(mapFrom)) {
                if (used.contains(mapTo)) return false;
                mapping.put(mapFrom, mapTo);
                used.add(mapTo);
            } else {
                if (mapping.get(mapFrom) != mapTo) return false;
            }
        }
        return true;
    }

    /**
     * This method used two mappings to map each pair of characters to the same group
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
