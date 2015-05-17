import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by lanxiao on 17/05/15.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JUnitTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
