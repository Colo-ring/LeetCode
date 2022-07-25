package HuaWei;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/7/13 18:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] w = new int[N];
        int[] t = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            t[i] = in.nextInt();
        }

        int sizeA = 100, sizeB = 80, sizeC = 60;
        Queue<Integer> A = new LinkedList<>();
        Queue<Integer> B = new LinkedList<>();
        Queue<Integer> C = new LinkedList<>();
        Queue<Integer> Block = new LinkedList<>();

        int i = 0, st = 30;
        while (i < N) {
            int time = t[i];
            // 通过
            int d = time - st;
            for (int j = 0; j < i; j++) {
                if (time == 60) break;
                if (d >= 0 && t[j] <= d) {
                    if (!A.isEmpty() && A.peek() == w[j]) {
                        sizeA += A.poll();
                        break;
                    } else if (!B.isEmpty() && B.peek() == w[j]) {
                        sizeB += B.poll();
                        break;
                    } else if (!C.isEmpty() && C.peek() == w[j]) {
                        sizeC += C.poll();
                        break;
                    }
                }
            }
            while (!Block.isEmpty() && time != 60) {
                if (sizeA >= Block.peek()) {
                    int bl = Block.poll();
                    A.add(bl);
                    sizeA -= bl;
                } else if (sizeB >= Block.peek()) {
                    int bl = Block.poll();
                    B.add(bl);
                    sizeB -= bl;
                } else if (sizeC >= Block.peek()) {
                    int bl = Block.poll();
                    C.add(bl);
                    sizeC -= bl;
                } else {
                    break;
                }
            }
            int wi = w[i];
            if (Block.isEmpty() && sizeA >= wi) {
                A.add(wi);
                sizeA -= wi;
            } else if (Block.isEmpty() && sizeB >= wi) {
                B.add(wi);
                sizeB -= wi;
            } else if (Block.isEmpty() && sizeC >= wi) {
                C.add(wi);
                sizeC -= wi;
            } else {
                Block.add(wi);
            }
            i++;
        }

        for (int j = 0; j < t.length; j++) {
            if (t[j] <= 30 && t[N - 1] != 60) {
                if (!A.isEmpty() && A.peek() == w[j]) {
                    sizeA += A.poll();
                } else if (!B.isEmpty() && B.peek() == w[j]) {
                    sizeB += B.poll();
                } else if (!C.isEmpty() && C.peek() == w[j]) {
                    sizeC += C.poll();
                }
            }
        }

        while (!Block.isEmpty()) {
            if (sizeA >= Block.peek()) {
                int bl = Block.poll();
                A.add(bl);
                sizeA -= bl;
            } else if (sizeB >= Block.peek()) {
                int bl = Block.poll();
                B.add(bl);
                sizeB -= bl;
            } else if (sizeC >= Block.peek()) {
                int bl = Block.poll();
                C.add(bl);
                sizeC -= bl;
            } else {
                break;
            }
        }
        int res1 = 0, res2 = 0, res3 = 0;
        while (!A.isEmpty()) {
            res1 += A.poll();
        }
        while (!B.isEmpty()) {
            res2 += B.poll();
        }
        while (!C.isEmpty()) {
            res3 += C.poll();
        }

        System.out.println(res1 + " " + res2 + " " + res3);

    }
}
