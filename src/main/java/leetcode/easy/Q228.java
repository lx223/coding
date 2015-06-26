package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/summary-ranges/">LeetCode Q228</>
 *
 * Thinking process:
 *
 * This is a simple implementation problem.
 */
public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(nums[i]));
            if (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                sb.append("->");
                while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) i++;
                sb.append(Integer.toString(nums[i]));
            }
            i++;
            ans.add(sb.toString());
        }
        return ans;
    }
}
