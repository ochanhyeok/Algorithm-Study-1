import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    static String recursion(String input, int l, int r, int cnt) {
        StringBuilder sb = new StringBuilder();
        if (l >= r) {
            sb.append(Integer.toString(1)).append(" ").append(Integer.toString(cnt));
            return sb.toString();
        }
        else if (input.charAt(l) != input.charAt(r)) {
            sb.append(Integer.toString(0)).append(" ").append(Integer.toString(cnt));
            return sb.toString();
        }
        else 
            return recursion(input, l+1, r-1, cnt+1);
    }
    
    static String isPalindrome(String input) {
        return recursion(input, 0, input.length()-1, 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bf.readLine());
        
        for (int i=0; i<T; i++) {
            String str = bf.readLine();
            System.out.println(isPalindrome(str));
        }
    }
}