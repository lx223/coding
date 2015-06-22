package leetcode.easy;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/rectangle-area/">LeetCode Q223</>
 *
 * Thinking process:
 *
 * The difficulty of this problem lies how to compute the overlap area of the two triangles. If you think of a rectangle
 * of two sets of parallel lines, you will find why the following algorithm works by considering the cases when two sets
 * of parallel lines overlap.
 */
public class Q223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int top = Math.min(D, H), bot = Math.max(B, F), left = Math.max(A, E), right = Math.min(C, G);
        int area = (C - A) * (D - B) + (H - F) * (G - E);
        if (top > bot && right > left) {
            area -= (top - bot) * (right - left);
        }
        return area;
    }
}
