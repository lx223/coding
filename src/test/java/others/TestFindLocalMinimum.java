package others;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lanxiao on 17/05/15.
 */
public class TestFindLocalMinimum {
    FindLocalMinimum target = new FindLocalMinimum();

    @Test
    public void testSolve() {
        int[] nums = new int[]{2, 1, 3};
        int i = target.solve(nums);
        assertEquals(i, 1);

        nums = new int[]{2, 1, 3, 4, 1, 5};
        i = target.solve(nums);
        assertEquals(i, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        FindLocalMinimum target = new FindLocalMinimum();
        int[] nums = new int[]{2, 1};
        int i = target.solve(nums);
    }
}
