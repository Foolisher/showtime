package leetcode.numBusesToDestination;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/14.
 */
public class numBusesToDestination {

    public static void main(String[] args) {
        System.out.println(new Solution().numBusesToDestination(
            new Gson().fromJson(
                "[[1, 2, 7], [3, 6, 7]]",
                int[][].class
            ),
            1,
            6
        ));
    }

}


class Solution {

    Set<Integer> edges     = new HashSet<>();
    int          visited[] = new int[10 ^ 6];

    public int numBusesToDestination(int[][] routes, int S, int T) {

        int n = 0;

        ArrayList<Integer> graph[] = new ArrayList[10 ^ 6];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length - 1; j++) {
                int curr = routes[i][j];
                int next = routes[i][j + 1];
                ArrayList<Integer> nexts = graph[curr];
                if (nexts == null) {
                    nexts = graph[routes[i][j]] = new ArrayList<>();
                }
                if (!nexts.contains(next)) {
                    nexts.add(next);
                }
                if (j == routes[i].length - 2) {
                    j += 1;
                    curr = routes[i][j];
                    next = routes[i][0];
                    nexts = graph[curr];
                    if (nexts == null) {
                        nexts = graph[routes[i][j]] = new ArrayList<>();
                    }
                    if (!nexts.contains(next)) {
                        nexts.add(next);
                    }
                }


            }
        }

        return n;
    }
}
