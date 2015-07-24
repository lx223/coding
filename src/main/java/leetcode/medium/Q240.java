package leetcode.medium;

/**
 * Created by lanxiao on 24/07/15.
 */
public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) j++;
            else i--;
        }
        return false;
    }
}
