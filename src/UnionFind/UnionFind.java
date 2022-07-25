package UnionFind;

/**
 * @author IntelliYJC
 * @create 2022/4/4 16:50
 */
public class UnionFind {
    private int[] p;

    public UnionFind(int n) {
        p = new int[n + 1];

        // 初始化，假定节点编号是1~n
        for (int i = 1; i <= n; i ++ )
        {
            p[i] = i;
        }
    }

    // 返回x的祖宗节点，并路径压缩
    public int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
