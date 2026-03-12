import java.util.*;
import java.io.*;

class Main{
    static int result, N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<String[]> list = new ArrayList<>();
        visited = new boolean[10];
        result=0; 
        
        N = Integer.parseInt(br.readLine().trim());
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());   
            list.add(new String[]{
                st.nextToken(),
                st.nextToken(),
                st.nextToken()
            });
        }
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, 0);
       
        System.out.println(result);
  
    }
    
    public static void dfs(List<String[]> list, StringBuilder sb, int idx){
        if(sb.length() == 3) {
            int cnt = 0;
            for(int i=0; i<list.size(); i++){
               String question = list.get(i)[0];
               int strike=0, ball=0; 
                
                for(int j=0; j<sb.length(); j++){
                    int index = question.indexOf(sb.charAt(j));
                    if(index != -1){
                        if(index == j) strike++;
                        else ball++;
                    }
                }
                if(Integer.parseInt(list.get(i)[1]) == strike 
                   && Integer.parseInt(list.get(i)[2]) == ball) cnt ++; 
            }
            if(cnt == N) result++;
            return;
        }
        
        for(int i=1; i<=9; i++){
            if(visited[i]) continue; 
            
            visited[i] = true;
            sb.append(i);
            
            dfs(list, sb, idx+1);
            
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
    
}