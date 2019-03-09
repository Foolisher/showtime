package leetcode.heap;

import java.util.Arrays;

import com.sun.java.swing.action.NextAction;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/5.
 */
public class BuildHeap {

    public static void main(String[] args) {

        int heap[] = new int[]{1, 2, 5, 6, 3, 4, 0};
        int len = heap.length;

        /*for (int i = (len / 2) - 1; i >= 0; i--) {
            int left = 2 * i + 1;
            while (left <= len - 1) {
                int next = left + 1 < len && heap[left + 1] > heap[left] ? left : left + 1;
                if (heap[i] > heap[next]) {
                    int t = heap[i];
                    heap[i] = heap[next];
                    heap[next] = t;
                }
                left = 2 * next + 1;
            }
        }*/

        for (int N = len; N >= 1; N--) {
            int t = heap[0];
            heap[0] = heap[N - 1];
            heap[N - 1] = t;

            for (int j = ((N + 1) / 2) - 1; j >= 0; j--) {
                int left = 2 * j + 1;
                while (left <= N - 1) {
                    int next = left + 1 < N && heap[left + 1] > heap[left] ? left : left + 1;
                    if (heap[j] > heap[next]) {
                        int t2 = heap[j];
                        heap[j] = heap[next];
                        heap[next] = t2;
                    }
                    left = 2 * next + 1;
                }
            }

        }


        System.out.println(Arrays.toString(heap));

    }


}
