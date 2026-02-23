import java.util.*;

class Solution {
    Map<String, List<String>> load = new HashMap<>();
    String[] answer;
    int total;
    
    public String[] solution(String[][] tickets) {
        total = tickets.length + 1;
        
        for(String[] s : tickets) {
            load.computeIfAbsent(s[0], k -> new ArrayList<>()).add(s[1]);
        }
        
        for(List<String> list : load.values()) {
            Collections.sort(list);
        }
        
        answer = new String[total];
        
        dfs("ICN", 1);
        
        return answer;
    }
    
    boolean dfs(String airport, int cnt) {
        answer[cnt - 1] = airport;
        
        if(cnt == total) {
            return true;
        }
        
        if(load.containsKey(airport) && !load.get(airport).isEmpty()) {
            List<String> nextList = load.get(airport);

            for (int i = 0; i < nextList.size(); i++) {
                String next = nextList.get(i);
                nextList.remove(i);

                if(dfs(next, cnt + 1)) {
                    return true;
                }

                nextList.add(i, next);
            }
            
            return false;
        
        } else {
            return false;
        }
    }
}