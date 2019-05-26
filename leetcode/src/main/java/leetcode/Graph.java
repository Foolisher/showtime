package leetcode;

import java.util.LinkedList;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/15.
 */
public class Graph {

    public int                   nVertices;
    public LinkedList<Integer>[] adjacencyList;
    public int[]                 inDegrees;

    Graph(int n) {
        nVertices = n;
        adjacencyList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        inDegrees = new int[n];
    }

    public void addEdge(int src, int destination) {
        adjacencyList[src].add(destination);
        inDegrees[destination]++;
    }

}
