import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적어도대부분의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 1;
        while(true){
            int cnt = 0;

            for(int k = 0; k < arr.length; k++){
                if(i % arr[k] == 0){
                    cnt++;
                }
            }

            if(cnt >= 3){
                break;
            }
            i++;
        }

        System.out.println(i);
    }
}
