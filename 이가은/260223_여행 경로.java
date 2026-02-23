import java.util.*;

class Solution {

    static PriorityQueue<String> route_list = new PriorityQueue<>();

    public String[] solution(String[][] tickets) {
        route_list.clear();

        int n = tickets.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!tickets[i][0].equals("ICN")) continue;
            dfs(i, tickets, visited, new ArrayDeque<>());
        }

        return route_list.poll().split(",");
    }

    static void dfs(int i, String[][] tickets, boolean[] visited, ArrayDeque<String> routes) {
        int n = tickets.length;

        String arrival = tickets[i][1];

        visited[i] = true;

        if (routes.isEmpty()) routes.addLast("ICN");
        routes.addLast(arrival);

        if (routes.size() == n + 1) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = routes.iterator();
            sb.append(it.next());
            while (it.hasNext()) sb.append(",").append(it.next());

            route_list.add(sb.toString());

            routes.pollLast();
            visited[i] = false;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[j]) continue;
            if (!tickets[j][0].equals(arrival)) continue;

            dfs(j, tickets, visited, routes);
        }

        routes.pollLast();
        visited[i] = false;
    }
}