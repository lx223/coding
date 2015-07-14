package codeforces;

import java.io.*;
import java.util.*;

/**
 * Created by lanxiao on 14/07/15.
 */
public class Q558A {
    static public void main(String[] arg) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // Solution here

        int n = in.nextInt();
        List<Integer> posX = new ArrayList<>();
        List<Integer> negX = new ArrayList<>();
        Map<Integer, Integer> numOfApples = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), a = in.nextInt();
            numOfApples.put(x, a);
            if (x > 0) posX.add(x);
            if (x < 0) negX.add(-x);
        }
        Collections.sort(posX);
        Collections.sort(negX);
        long sum = 0;
        int size = Math.min(posX.size(), negX.size()) + 1;
        for (int i = 0; i < size; i++) {
            if (i < posX.size()) sum += numOfApples.get(posX.get(i));
            if (i < negX.size()) sum += numOfApples.get(-negX.get(i));
        }
        out.println(sum);
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
