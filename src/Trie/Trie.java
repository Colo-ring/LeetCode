package Trie;

/**
 * @author IntelliYJC
 * @create 2022/4/4 16:09
 *
 * Trie树，用于高效存储和查询字符串集合的数据结构。
 */
public class Trie {

    private final int[][] son;
    private final int[] cnt ;
    private int idx; // 下标是0的点，既是根结点，又是空结点

    public Trie(int n) {
        son = new int[n][26];
        cnt = new int[n];
        idx = 0;
    }

    public void insert(char[] str) {
        int p = 0;
        for(int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if(son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    public int query(char[] str) {
        int p = 0;
        for(int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if(son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
