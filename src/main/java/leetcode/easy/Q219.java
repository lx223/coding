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
        int lo = 0, hi = 0;
        Set<Integer> seen = new HashSet<>();
        while (hi < nums.length) {
            while (hi < nums.length && hi - lo <= k) {
                if (seen.contains(nums[hi])) return true;
                else seen.add(nums[hi]);
                hi++;
            }
            while (hi - lo > k) {
                seen.remove(Integer.valueOf(nums[lo++]));
            }
        }
        return false;
    }
}
