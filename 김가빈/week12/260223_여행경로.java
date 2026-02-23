import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Map<String, Deque<String>> map = new HashMap();
        Arrays.sort(tickets, (a,b)-> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }    
            return a[0].compareTo(b[0]);
        });
        
        for (int i=0; i< tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            map.computeIfAbsent(from, k-> new ArrayDeque()).addLast(to);
            
        }
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        List<String> route = new ArrayList<>();
        
        stack.push("ICN");
        
        while (!stack.isEmpty()){
            String cur = stack.peek();
            Deque<String> nexts = map.get(cur);
            
            //cur에서 갈 곳이 있으면 티켓 하나 꺼내서 이동
            if(nexts != null && !nexts.isEmpty()){
                String next =  nexts.removeFirst(); 
                stack.push(next);
            } else {
                route.add(stack.pop());
            }
        }
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}