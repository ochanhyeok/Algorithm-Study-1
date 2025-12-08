import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 재귀의 귀재{
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            cnt = 0;
            int isRe = isPalindrome(str);
            sb.append(isRe + " " + cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length() - 1);
    }
}