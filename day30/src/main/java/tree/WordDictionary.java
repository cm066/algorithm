package tree;

import javax.xml.soap.Node;

/**
 * @author cm
 * @create 2022/1/8-7:30 下午
 * 211、 加与搜索单词 - 数据结构设计
 */
public class WordDictionary {
    private Trie root;
    public WordDictionary() {
       root= new Trie();
    }

    public void addWord(String word) {
      root.insert(word);
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)){
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word,index+1,child)){
                return true;
            }
        }else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word,index+1,child)){
                    return true;
                }
            }
        }
        return false;
    }

}
