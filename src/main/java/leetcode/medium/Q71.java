package leetcode.medium;

import java.util.*;

/**
 * Created by lanxiao on 25/04/15.
 */
public class Q71 {
    public String simplifyPath(String path) {
        Set<String> isSkip = new HashSet<String>(Arrays.asList("", ".", ".."));
        Deque<String> stack = new ArrayDeque<String>();
        for (String token : path.split("/")) {
            if (token.equals("..") && !stack.isEmpty()) stack.pop();
            if (isSkip.contains(token)) continue;
            stack.push(token);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Q71 q71 = new Q71();
        System.out.println(q71.simplifyPath("/abc/..."));
    }
}
