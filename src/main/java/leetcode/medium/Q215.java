package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/kth-largest-element-in-an-array/">LeetCode
 * Q215</>
 *
 * Thinking process:
 *
 * One simple way is to reduce the problem to sorting. Hence, its complexity will very much depend on that of the basic
 * sorting used.
 */
public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        return solveByLinearSort(nums, k);
    }

    // ~NLogN
    private int solveByBuiltInSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // ~NLogK
    private int solveByPQ(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }

    // ~N
    private int solveByLinearSort(int[] nums, int k) {
        final int R = (1 << 8);
        final int bitmask = R - 1;
        int[] aux = new int[nums.length];
        for (int i = 0; i < 4; i++) {
            int[] count = new int[R + 1];
            for (int num : nums) {
                int c = (num >>> (i * 8)) & bitmask;
                count[c + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            if (i == 3) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            for (int num : nums) {
                int c = (num >>> (i * 8)) & bitmask;
                aux[count[c]++] = num;
            }

            System.arraycopy(aux, 0, nums, 0, nums.length);
        }
        return nums[nums.length - k];
    }
}
