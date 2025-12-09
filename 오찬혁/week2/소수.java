import java.io.*;

public class 소수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int min = 10000;

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for(int i = M; i <= N; i++){
            if(isPrime(i)){
                sum += i;
                if(i < min){
                    min = i;
                }
            }
        }

        if(sum > 0){
            sb.append(sum).append('\n').append(min);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}