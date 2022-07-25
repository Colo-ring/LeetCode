package test;

import org.junit.Test;

/**
 * @author IntelliYJC
 * @create 2022/4/26 17:18
 */
public class Tencent03 {
    /*public int maxProfit(int[] prices, int m) {
        int n = prices.length;
        int M = m, cnt = 0, last = prices[n - 1], ans = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int p = prices[i];
            buy = Math.min(buy, p);
            if(m >= p) {
                m -= buy;
                cnt++;
                continue;
            }
            if(p + m > M) {
                if(M < last && cnt - 1 > 0) {
                    continue;
                }
                ans = Math.max(m + p,ans);
                m += p;
                cnt--;
            }
        }
        ans = Math.max(ans, last * cnt + m);
        return ans;
    }*/

    public int maxProfit(int[] prices, int m) {
        int n = prices.length;
        int last = prices[n - 1], res = 0 ,ans = 0;
        int i= 0;
        for(; i < n; i++) {
            if(prices[i] <= m) break;
        }
        int buy = prices[i];

        for(i = i + 1; i < n - 1; i++) {
            int p = prices[i];
                if(p < buy) {
                    m = res;
                    buy = p;
                    m -= buy;
                } else {
                    if(m >= buy) {
                        res = Math.max(res, p - buy + m);
                    }
                }
        }
        return ans;
    }

    @Test
    public void testTencent03() {
        System.out.println(maxProfit(new int[]{1,1,4,1}, 2));
    }
}
