package codeforces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by lanxiao on 24/07/15.
 */
public class Q559A {

    static public void main(String[] arg) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // Solution here
        int[] a = new int[6];
        for (int i = 0; i < 6; i++) a[i] = in.nextInt();
        out.println((int) (Math.pow(a[0] + a[1] + a[2], 2) - Math.pow(a[0], 2) - Math.pow(a[2], 2) - Math.pow(a[4], 2)));

        in.close();
        out.close();
    }

    static private class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static private class GeometryUtils {
        public double epsilon = 1e-8;
    }
}
