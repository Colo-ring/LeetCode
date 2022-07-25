package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IntelliYJC
 * @create 2022/4/17 16:13
 */
public class Solition {
    static int res, idx; // res：结果，idx：邻接表当前下标
    static int[] h = new int[10], ne = new int[200]; // 数组模拟邻接表 h：邻接表1~6的头节点下标，ne：next数组
    static Yuhun[] path = new Yuhun[10]; // 每次深搜到底的御魂路径
    static Yuhun[] e = new Yuhun[200]; // e：存储每个编号对应的御魂对象

    static void add(int p, Yuhun y) { // 把御魂添加进入邻接表
        e[idx] = y; ne[idx] = h[p]; h[p] = idx++;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();

        while (T-- > 0) {
            Arrays.fill(h,-1); // 初始化邻接表头节点，一开始指向-1下标
            int N = in.nextInt();
            for(int i = 0; i < N; i++) {
                int p = in.nextInt(), c = in.nextInt(), d = in.nextInt();
                Yuhun t = new Yuhun(p,c,d);
                add(p, t);
            }
            dfs(e[h[1]]); // 从编号1开始深搜

            if(res == 0) System.out.println("TAT");
            else System.out.println(res);
            idx = res = 0; // 清空结果和临界表
        }
    }

    public static void dfs(Yuhun y) {
        int cc = 0, dd = 0;
        // 如果当前御魂编号已经搜到了6，则将御魂路径path中的暴率和爆伤相加
        if(y.p == 6) {
            for(int i = 1; i < 6; i++) {
                cc += path[i].c;
                dd += path[i].d;
            }
            // 当前6号御魂还没被加入到path中，所以得把6号也加进去
            cc += y.c;
            dd += y.d;
            if(cc >= 100) {
                //暴率够了再更新res
                res = Math.max(dd,res);
            }
            return;
        }
        // 遍历当前编号的邻接链表
        for(int i = h[y.p]; i != -1; i = ne[i]) {
            Yuhun t = e[i];
            // 如果没有被访问过，则把当前御魂放到path中
            if(!t.f) {
                path[t.p] = t;
                t.f = true; // 被访问设置为true
                dfs(e[h[t.p + 1]]); // 搜下一层编号
                t.f = false; // 搜完出来恢复状态
            }
        }
    }
}

class Yuhun
{
    int p, c, d; // 编号，暴率，暴伤
    boolean f; // 用于剪枝，判断当前御魂是否被访问过

    public Yuhun(int p, int c, int d) {
        this.p = p;
        this.d = d;
        this.c = c;
        this.f = false;
    }
}