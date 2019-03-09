package leetcode;

import java.util.*;

public class findRedundantDirectedConnection {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(
//            new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}
//            new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}}
//            new int[][]{{1, 2}, {1, 3}, {2, 3}}
            new int[][]{{4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}}
        )));
    }

    static class Solution {

        List<Integer>[] graph;
        List<Integer>[] froms;
        Set<int[]>      rst     = new HashSet<>();
        int[]           visited = new int[1000 * 2];

        int[] findRedundantDirectedConnection(int[][] edges) {

            graph = new ArrayList[edges.length * 2];
            froms = new ArrayList[edges.length * 2];

            for (int[] edge : edges) {
                List<Integer> nextList = this.graph[edge[0]];
                if (nextList == null) {
                    nextList = this.graph[edge[0]] = new ArrayList<Integer>();
                }
                nextList.add(edge[1]);

                if (froms[edge[1]] == null) {
                    froms[edge[1]] = new ArrayList<>();
                }
                froms[edge[1]].add(edge[0]);

            }

            int root = 0;
            for (int[] edge : edges) {
                if (froms[edge[0]] == null) {
                    root = edge[0];
                }
            }
            if (root == 0) {
                root = edges[0][0];
            }
            travel(0, root);


            for (int i = edges.length - 1; i >= 0; i--) {
                for (int[] edgeRst : rst) {
                    if (edges[i][0] == edgeRst[0] && edges[i][1] == edgeRst[1]) {
                        return edges[i];
                    }
                }
            }

            return null;
        }

        LinkedList<int[]> visitPath = new LinkedList<>();

        void travel(int parent, int node) {
            if (visited[node] == 1) {
                return;
            }
            if (parent != 0) {
                visitPath.push(new int[]{parent, node});
            }
            visited[node] = 1;
            List<Integer> nextNodes = graph[node];

            if (nextNodes != null) {
                for (Integer nextNode : nextNodes) {
                    if (visited[nextNode] == 1) {
//                        rst.add(new int[]{node, nextNode});
                        visitPath.push(new int[]{node, nextNode});
                        while (!visitPath.isEmpty()) {
                            int[] line = visitPath.pop();
                            for (Integer fromNode : froms[nextNode]) {
                                if (!visitPath.isEmpty() && line[0] == fromNode && line[1] == nextNode) {
                                    rst.add(new int[]{fromNode, nextNode});
                                }
                            }
                        }
                        visitPath.clear();
                    } else {
                        travel(node, nextNode);
                    }
                }
            }
        }


    }


}
