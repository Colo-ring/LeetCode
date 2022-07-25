package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author IntelliYJC
 * @create 2022/4/24 21:37
 */
public class dangying {

    public static int n,m, res = Integer.MIN_VALUE;
    public static int[] v;

    public static void dfs(int index, int sum, int m,int num) {
        if(m<0||num<0)return;
        if(index==n)res=Math.max(res,sum);
        for(int i=index;i<n;i++){
            //买入股票
            num++;
            m=m-v[i];
            dfs(i+1,m+num*v[i],m,num);
            num--;
            m=m+v[i];
            //卖出股票
            num--;
            m=m+v[i];
            dfs(i+1,m+num*v[i],m,num);
            num++;
            m=m-v[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        dfs(0,m,m,0);
        System.out.println(res);
    }
}
