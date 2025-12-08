import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static int[] recursion(String s, int l, int r, int[] arr){
		
        if(l >= r) {
        	arr[0]++;
        	return arr;
        }
        else if(s.charAt(l) != s.charAt(r)) return arr;
        else {
        	arr[1]++;
        	return recursion(s, l+1, r-1, arr);
        }
    }
    public static int[] isPalindrome(String s){
    	int[] arr = {0, 1};
        return recursion(s, 0, s.length()-1, arr);
    }
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int i =0; i<n; i++) {
    		String str = br.readLine();
    		int[] arr = isPalindrome(str);
    		sb.append(String.valueOf(arr[0])+" "+String.valueOf(arr[1])+"\n");
    	}
    	System.out.println(sb.toString());
    }
}