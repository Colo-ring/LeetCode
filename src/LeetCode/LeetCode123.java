package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/4/26 16:35
 * 123. 买卖股票的最佳时机 III
 *
 * [1,2,4,2,5,7,2,4,9,0]
 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int n = prices.length, buy = prices[0];
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for(int i = 1; i < n; i++) {
            int price = prices[i];
            if(price > buy) t += price - buy;
            else {
                res.add(t);
                t = 0;
            }
            buy = price;
        }
        res.add(t);
        res.sort((o1, o2) -> o2 - o1);
        int ans = 0;
        for(int i = 0; i < res.size(); i++) {
            ans += res.get(i);
            if(i == 1) {
                return ans;
            }
        }
        return ans;
    }

    @Test
    public void test123() {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
