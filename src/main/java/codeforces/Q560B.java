package codeforces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by lanxiao on 22/07/15.
 */
public class Q560B {
    static public void main(String[] arg) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // Solution here

        int[] a = new int[3];
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }

        // Four cases for the paintings
        boolean success = false;
        int aa = Math.max(a[1], b[2]);
        int bb = b[1] + a[2];
        if ((aa <= a[0] && bb <= b[0]) || (aa <= b[0] && bb <= a[0])) success = true;

        aa = Math.max(a[1], a[2]);
        bb = b[1] + b[2];
        if ((aa <= a[0] && bb <= b[0]) || (aa <= b[0] && bb <= a[0])) success = true;

        bb = Math.max(b[1], a[2]);
        aa = a[1] + b[2];
        if ((aa <= a[0] && bb <= b[0]) || (aa <= b[0] && bb <= a[0])) success = true;

        bb = Math.max(b[1], b[2]);
        aa = a[1] + a[2];
        if ((aa <= a[0] && bb <= b[0]) || (aa <= b[0] && bb <= a[0])) success = true;

        if (success) out.println("YES");
        else out.println("NO");
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
