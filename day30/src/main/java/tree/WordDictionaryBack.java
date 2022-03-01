package tree;

/**
 * @author cm
 * @create 2022/1/8-7:30 下午
 * 211、 加与搜索单词 - 数据结构设计
 */
public class WordDictionaryBack {
    private WordDictionaryBack[] children;
    private boolean isEnd;
    public WordDictionaryBack() {
        //这里和前缀树有点区别，前缀树中只有26个字母，然而这个有"."它可以表示任意的字母
        children = new WordDictionaryBack[27];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionaryBack node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = 0;
            if (ch =='.'){
                index = 26;
            }else {
                index = ch- 'a';
            }
            if (node.children[index] == null){
                node.children[index] = new WordDictionaryBack();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        WordDictionaryBack node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private WordDictionaryBack searchPrefix(String word) {
        WordDictionaryBack node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.'){
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null){
                        node = children[j];
                        break;
                    }
                    if(j == 25 && node.children[25] == null){
                        return null;
                    }
                }
            }else {
                int index = ch-'a';
                if (node.children[index] == null){
                    return null;
                }
                node = node.children[index];
            }
        }
        return node;
    }

    /**
     * 这个方法还有点问题，在处理"."的时候没有考虑周全
     * @param word
     * @return
     */
    public boolean search1(String word) {
        WordDictionaryBack node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch == '.' ? 26 : ch-'a';
            if (node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
