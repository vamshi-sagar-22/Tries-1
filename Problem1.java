/*
Implement Trie(Prefix Tree)
approach: create map of map using TrieNode
time: insertion: search: startsWith: O(length)
space: O(number of words in dictionary x avg length)
 */
public class Problem1 {
    class TrieNode {
        boolean end;
        TrieNode[] root;
        public TrieNode() {
            root = new TrieNode[26];
        }
    }
    TrieNode trie;
    public Problem1() {
        this.trie = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currTrie = trie;
        for(int i=0;i<word.length();i++) {
            char curr = word.charAt(i);
            if(currTrie.root[curr-'a']==null) {
                currTrie.root[curr-'a'] = new TrieNode();
            }
            currTrie = currTrie.root[curr-'a'];
        }
        currTrie.end = true;
    }

    public boolean search(String word) {
        TrieNode currTrie = trie;
        for(int i=0;i<word.length();i++) {
            char curr = word.charAt(i);
            if(currTrie.root[curr-'a']==null) return false;
            currTrie = currTrie.root[curr-'a'];
        }
        if(currTrie.end) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode currTrie = trie;
        for(int i=0;i<prefix.length();i++) {
            char curr = prefix.charAt(i);
            if(currTrie.root[curr-'a']==null) return false;
            currTrie = currTrie.root[curr-'a'];
        }

        return true;
    }
}
