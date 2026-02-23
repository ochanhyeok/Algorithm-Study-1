import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(numList);
        
        int X = Integer.parseInt(br.readLine());
        int left = 0;
        int right = N - 1;
        int cnt = 0;
        
        while(left < right) {
            int sum = numList.get(left) + numList.get(right);
            
            if(sum == X){
                cnt++;
                left++;
                right--;
            } else if(sum < X) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(cnt);
    }
}