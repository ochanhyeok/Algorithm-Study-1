import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        String[] arr = nums.split(" ");
        int[] intarr = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            intarr[i] = Integer.parseInt(arr[i]);
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int x = 0; x< arr.length; x++){
            for(int y=x+1; y<arr.length; y++){
                for(int z=y+1; z<arr.length; z++){
                    int first = (intarr[x]*intarr[y])/maxnum(intarr[x],intarr[y]); //앞의 두 수 최소공배수 먼저 구함
                    result = (first * intarr[z])/maxnum(first, intarr[z]);  // 마지막 수와의 최소공배수 구함
                    if(result <= min) min = result;          // 최솟값 찾기
                }
            }
        }
        System.out.println(min);
    }
    public static int maxnum(int a, int b){
        int temp = 0;
        while(b != 0){      //두 수의 최대공약수 공식
            temp = b;  
            b = a%b;       
            a = temp;     
        }
        return a;
    }
}