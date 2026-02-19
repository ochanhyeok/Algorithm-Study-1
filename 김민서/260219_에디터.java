import java.util.*;
import java.io.*;

class Main {
    
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        
        for(char c : N.toCharArray()) {
            left.push(c);
        }
        
        int M = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i < M; i++){
            String edit = br.readLine();
            
            editor(edit);
        }
        
        while(!left.isEmpty()) {
            char p = left.pop();
            right.push(p);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
    }
    
    static void editor(String edit) {
        String[] arr = edit.split(" ");
        
        if("L".equals(arr[0])) {
            if(left.isEmpty()) {
                return;
            }
            
            char p = left.pop();
            right.push(p);
            
        } else if("D".equals(arr[0])) {
            if(right.isEmpty()) {
                return;
            }
            
            char p = right.pop();
            left.push(p);
            
        } else if("B".equals(arr[0])) {
            if(left.isEmpty()) {
                return;
            }
            
            left.pop();
            
        } else if("P".equals(arr[0])) {
            left.push(arr[1].charAt(0));
        }
    }
    
}