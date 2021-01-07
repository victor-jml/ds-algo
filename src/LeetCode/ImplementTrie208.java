/**
 * @Author yang.zhao
 * Date: 2021/1/7
 * Description:
 **/
public class ImplementTrie208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));

    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length() ; i++){
            char x = word.charAt(i);
            if(cur.nodes[x - 'a'] == null){
                cur.nodes[x - 'a'] = new TrieNode(x);
            }
            cur = cur.nodes[x - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length() ; i++){
            char x = word.charAt(i);
            if(cur.nodes[x - 'a'] == null){
                return false;
            }
            cur = cur.nodes[x - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            char x = prefix.charAt(i);
            if(cur.nodes[x - 'a'] == null){
                return false;
            }
            cur = cur.nodes[x - 'a'];
        }
        return true;
    }
}
class TrieNode{
    char val;
    TrieNode[] nodes;
    boolean isWord;
    public TrieNode(char val){
        isWord = false;
        nodes = new TrieNode[26];
        this.val = val;
    }
}