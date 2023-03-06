/*
Longest Word in Dictionary
approach: construct a trie and do dfs with backtracking
time: O(
 */
public class Problem2 {
    class TrieNode {
        boolean end;
        TrieNode[] root;
        public TrieNode() {
            root = new TrieNode[26];
        }
    }
    TrieNode trie;
    public Problem2() {
        this.trie = new TrieNode();
    }
    String res = "";

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
    public String longestWord(String[] words) {
        for(String word: words) {
            insert(word);
        }
        trie.end = true;
        dfs(trie, new StringBuilder());
        return res;
    }

    //time: O(no. of branches)
    //space: O(longest word)
    private void dfs(TrieNode curr, StringBuilder sb) {
        if(!curr.end) return;
        if(sb.length()>=res.length()) {
            res = new String(sb.toString());}
        for(int i=25;i>=0;i--) {
            if(curr.root[i]!=null) {
                int le = sb.length();
                sb.append((char)(i+'a'));

                dfs(curr.root[i], sb);


                sb.setLength(le);}
        }

    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"});
    }
}
