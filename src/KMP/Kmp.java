package KMP;

/**
 * @author IntelliYJC
 * @create 2022/4/1 17:30
 */
public class Kmp {
    // s[]是长文本，p[]是模式串，n是s的长度，m是p的长度
    private char[] s, p;
    private int [] ne;
    private int n, m;
    public Kmp(int n, int m) {
        s = new char[n + 1];
        p = new char[m + 1];
        ne = new int[n];
        this.n = n;
        this.m = m;
    }

    public void match() {

        // 求next
        for (int i = 2, j = 0; i <= n; i++) {
            while(j > 0 && p[i] != p[j + 1]) j = ne[j];
            if(p[i] == p[j + 1]) j++;
            ne[i] = j;
        }

        // 匹配
        for (int i = 1, j = 0; i <= n; i ++ )
        {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j ++ ;
            if (j == m)
            {
                j = ne[j];
                // 匹配成功后的逻辑
            }
        }
    }
}
