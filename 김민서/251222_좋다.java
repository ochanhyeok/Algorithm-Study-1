import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;

        for (int k = 0; k < n; k++) {
            int target = arr[k];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == k) { 
                	left++; 
                	continue; 
                }
                
                if (right == k) { 
                	right--; 
                	continue; 
                }

                int sum = arr[left] + arr[right];

                if (sum == target) {
                    cnt++;
                    break; // k는 한 번만 카운트
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
		
		System.out.println(cnt);
	}

}
