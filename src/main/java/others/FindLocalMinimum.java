package others;

/**
 * Created by lanxiao on 17/05/15.
 */
public class FindLocalMinimum {
    /*
    Question:
        Given an array nums[1...n], n >= 3, nums[1] >= nums[2] && nums[n] >= nums[n - 1]
        return the index i such that nums[i - 1] >= nums[i] && nums[i + 1] >= nums[i]
     */

    public int solve(int[] nums) {
        if (nums.length < 3) throw new IllegalArgumentException("The length of the array must be >= 3");
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] <= nums[mid - 1] && nums[mid] <= nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return -1;
    }
}
