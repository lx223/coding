import java.io.UnsupportedEncodingException;

/**
 * Created by lanxiao on 26/04/15.
 */
public class Main {
    static public void main(String[] args) {
        String myString = "\u0048\u0065\u006C\u006C\u006F World";
        System.out.println(myString);

        byte[] myBytes = null;
        try {
            myBytes = myString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        for (int i = 0; i < myBytes.length; i++) {
            System.out.println(myBytes[i]);
        }
    }
}
