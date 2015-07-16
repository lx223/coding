package leetcode.medium;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/product-of-array-except-self/">LeetCode
 * 238</>
 *
 * Thinking process:
 *
 * It is easy to do this in O(n * n). Doing it in O(n) requires some thoughts. By observing that each element in the
 * answer array if the product of the elements to its left and to its right, a solution with two pass would solve it.
 */
public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int sideProd = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = sideProd;
            sideProd *= nums[i];
        }
        sideProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= sideProd;
            sideProd *= nums[i];
        }
        return ans;
    }
}
