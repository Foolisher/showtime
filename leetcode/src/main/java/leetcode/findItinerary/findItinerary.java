package leetcode.findItinerary;

import java.util.*;

import com.google.gson.Gson;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/17.
 */
public class findItinerary {

    public static void main(String[] args) {
        System.out.println(new Solution().findItinerary(
            new Gson().fromJson(
                "[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]",
//                "[[\"MUC\", \"LHR\"], [\"JFK\", \"MUC\"], [\"SFO\", \"SJC\"], [\"LHR\", \"SFO\"]]",
                String[][].class
            )
        ));
    }

}


class Solution {

    List<String>                 path = new LinkedList<>();
    Map<String, TreeSet<String>> nei  = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            nei.computeIfAbsent(ticket[0], (v) -> new TreeSet<>()).add(ticket[1]);
        }
        find("JFK");
        return path;
    }

    void find(String start) {
        path.add(start);
        TreeSet<String> l = nei.getOrDefault(start, new TreeSet<>());
        while (!l.isEmpty()) {
            find(l.pollFirst());
        }
    }

}