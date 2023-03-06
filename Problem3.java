import java.util.List;
/*
Replace Words
approach: constrcut a trie and a search method, then iterate over sentence words,
form a word with each character in sentence and search for it in trie.
time: O((no. of words in sentence x length of sentence) + (words in dictionary x avg length of words))
space: O(no. of words x avg length of words in dictionary)
 */
public class Problem3 {
    class TrieNode {
        boolean end;
        TrieNode[] root;
        public TrieNode() {
            root = new TrieNode[26];
        }
    }
    TrieNode trie;
    public Problem3() {
        this.trie = new TrieNode();
    }
    StringBuilder res = new StringBuilder();

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
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s: dictionary) {
            insert(s);
        }

        String[] str = sentence.split(" ");

        for(String s:str) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++) {
                sb.append(s.charAt(i));
                if(search(sb.toString())) {
                    flag = true;
                    break;
                }
            }
            if(flag) res = res.append(sb);
            else res=res.append(s);
            res.append(" ");
        }

        return res.toString().trim();
    }
}
