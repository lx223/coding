package leetcode.medium;

/**
 * Created by lanxiao on 12/05/15.
 */
public class Q209 {
    /*
    LeetCode Q209:
        Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of
        which the sum ≥ s. If there isn't one, return 0 instead
    Thinking process:
        Two methods:
            1. maintain a minimum window O(N)
            2. use cumulative sum and binary search O(NLogN)
    */

    private int solveN(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (end < nums.length && sum < s) sum += nums[end++];
            if (sum < s) break;
            while (start < end && sum >= s) sum -= nums[start++];
            minLen = Math.min(end - start + 1, minLen);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            minLen = Math.min(end - i, minLen);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * This method returns the smallest index of elements that are >= key
     * It returns sums.length if no such elements exist
     *
     * @param lo   the lower index
     * @param hi   the higher index
     * @param key  the key value to be searched
     * @param sums the target array
     * @return the smallest possible index or sums.length
     */
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
