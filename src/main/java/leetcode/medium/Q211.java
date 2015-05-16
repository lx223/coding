package leetcode.medium;

import lombok.Setter;

public class Q211 {
    /*
    LeetCode Q211:
        https://leetcode.com/problems/add-and-search-word-data-structure-design/
    Thinking process:
        This is a standard data structure implementation question.
    */
    private final TrieNode root;

    public Q211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getChild(c) == null) node.setChild(c, new TrieNode());
            node = node.getChild(c);
        }
        node.setItem(word);
    }

    public boolean search(String word) {
        return searchByDFS(word, 0, root);
    }

    private boolean searchByDFS(String word, int i, TrieNode node) {
        if (node == null) return false;
        if (i >= word.length()) return node.hasItem();
        char c = word.charAt(i);
        if (c == '.') {
            for (char cc = 'a'; cc <= 'z'; cc++) {
                if (searchByDFS(word, i + 1, node.getChild(cc))) return true;
            }
            return false;
        } else {
            return searchByDFS(word, i + 1, node.getChild(c));
        }
    }

    private class TrieNode {
        private final int R = 256;
        @Setter
        private String item;
        private TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[R];
            item = null;
        }

        public TrieNode getChild(int i) {
            return children[i];
        }

        public void setChild(int i, TrieNode node) {
            children[i] = node;
        }

        public boolean hasItem() {
            return item != null;
        }
    }

    public static void main(String[] args) {
        Q211 q211 = new Q211();
        q211.addWord("at");
        q211.search("a");
    }
}
