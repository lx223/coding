package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/contains-duplicate/">LeetCode Q217</>
 *
 * Thinking process:
 *
 * Simple use of hashset will do.
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }
}
