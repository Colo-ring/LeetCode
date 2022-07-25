package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author IntelliYJC
 * @create 2022/5/4 21:06
 */
public class LeetCode46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, nums.length - 1);
        return res;
    }

    public void dfs(int[] a, int l, int r) {
        if (l == r) res.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
        else {
            for (int i = l; i <= r; i++) {
                if(i != l && a[i] == a[l]) continue;

                int tem = a[i];
                a[i] = a[l];
                a[l] = tem;

                dfs(Arrays.copyOf(a, a.length), l + 1, r);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> permute = permuteUnique(new int[]{1, 1, 2});
        int a = 1;

    }
}
