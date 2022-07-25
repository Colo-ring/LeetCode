package test;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/5/3 22:13
 */
public class TestBitSet {
    public static void main(String[] args) {
        BitSet bs = new BitSet();

        bs.set(1, 4,true);

        for(int i = 0; i < 5; i++) {
            System.out.println(bs.get(i));
        }

        Integer[] test = {1,2,3};


        System.out.println(Arrays.toString(test));

        int[][] tt = new int[2][2];

       List<List<Integer>> l = new ArrayList<>();

    }
}
