package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/contains-duplicate-ii/">LeetCode Q219</>
 *
 * Thinking process:
 *
 * As a followup of Q217, it requires maintaining a window of width k. It is then just implementation.
 */
public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) return true;
            else seen.add(nums[i]);
            if (seen.size() > k) seen.remove(nums[i - k]);
        }
        return false;
    }
}
