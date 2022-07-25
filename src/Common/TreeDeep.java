package Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author IntelliYJC
 * @create 2022/4/15 20:46
 */
public class TreeDeep {

    static List<Integer> mid = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();
    static int ans, idx;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();

        for (int i = 0; i < m; i++) {
            mid.add(in.nextInt());
        }
        in.nextLine();
        for (int i = 0; i < m; i++) {
            post.add(in.nextInt());
        }
        idx = post.size() - 1;
        int root = post.get(idx);
        int t = dfs(root, mid);
        System.out.println(t);
    }

    public static int dfs(int u, List<Integer> submid) {
        int m = submid.indexOf(u);
        if(m == -1) return 0;
        int res = 0, ldeep, rdeep;
        List<Integer> lchild = new ArrayList<>(), rchild = new ArrayList<>();
        if(m < mid.size()) {
            lchild = submid.subList(0, m);
            rchild = submid.subList(m + 1, submid.size());
        }

        int l = lchild.size(), r= rchild.size();
        if(l > 0 || r > 0) {
            res++;
            int id = idx;
            if(r > 0) {
                if(idx - 1 > 0) {
                    rdeep = dfs(post.get(--idx), rchild);
                    res += rdeep;
                }
            }
            if(l > 0) {
                if(id - r - 1 > 0) {
                    ldeep = dfs(post.get(id - r - 1), lchild);
                    res += ldeep;
                }
            }
        }
        ans = Math.max(res + 1, ans);
        return res;
    }
}
