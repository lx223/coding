package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lanxiao on 27/10/2016.
 */

public class Q415Test {
    Q415 sut = new Q415();

    @Test(expected = IllegalArgumentException.class)
    public void addStrings_withNullStrings_shouldThrowException() {
        String a = null;
        String b = "string";

        sut.addStrings(a, b);
    }

    @Test
    public void addStrings_withEmptyString_shouldReturnTheOtherString() {
        String a = "";
        String b = "string";

        String result = sut.addStrings(a, b);

        Assert.assertEquals(result, b);
    }

    @Test
    public void addStrings_withNonEqualLengthString_returnCorrectSumString() {
        String a = "123";
        String b = "1";
        String ans = "124";

        String result = sut.addStrings(a, b);

        Assert.assertEquals(result, ans);
    }

    @Test
    public void addStrings_withEqualLengthString_returnCorrectSumString() {
        String a = "123";
        String b = "123";
        String ans = "246";

        String result = sut.addStrings(a, b);

        Assert.assertEquals(result, ans);
    }
}
