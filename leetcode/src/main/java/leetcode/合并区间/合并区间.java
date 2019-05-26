package leetcode.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

/**
 * Created by fuxiao(付笑) on 2019/5/11.
 */
public class 合并区间 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(
//            new Gson().fromJson("[[2,6],[8,10],[15,18],[1,3]]", int[][].class)
//            new Gson().fromJson("[[1,4],[4,5]]", int[][].class)
//            new Gson().fromJson("[[1,4],[0,4]]", int[][].class)
//            new Gson().fromJson("[[1,4],[1,4]]", int[][].class)
//            new Gson().fromJson("[[1,4],[2,3]]", int[][].class)
            new Gson().fromJson("[[2,3],[4,5],[6,7],[8,9],[1,10]]", int[][].class)
        )));
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] rst = new int[intervals.length][2];
        int len = 0;
        for (int[] arr : intervals) {
            boolean merge = false;
            for (int i = 0; i < len; i++) {
                int[] next = rst[i];
                if (arr[0] >= next[0] && arr[0] <= next[1] || next[0] >= arr[0] && next[0] <= arr[1]) {
                    rst[i][0] = Math.min(arr[0], next[0]);
                    rst[i][1] = Math.max(arr[1], next[1]);
                    merge = true;
                }
            }
            if (merge == false) {
                rst[len++] = arr;
            }
        }

        int[][] rst2 = new int[len][2];
        for (int i = 0; i < len; i++) {
            rst2[i] = rst[i];
        }
        return rst2;
    }
}

/*
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] rst = new int[intervals.length][2];
        int len = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; ) {
            int j = i + 1;
            int tmp[] = intervals[i];
            while (j <= intervals.length - 1
                && intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1]) {
                if (intervals[j][1] >= intervals[i][1]) {
                    tmp[1] = intervals[j][1];
                }
                j++;
            }
            rst[len++] = tmp;
            i = j;
        }
        return Arrays.copyOf(rst, len);
    }
}
*/
