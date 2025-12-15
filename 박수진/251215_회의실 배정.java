import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

class Main {
    static int N;
    static int[][] meeting;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // [N][0]: 시작 시간, [N][1]: 종료 시간
        meeting = new int[N][2];
        
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                // 종료 시간이 빠른 순으로 정렬
                return o1[1] - o2[1];
            }
        });
        
        long sysdate = 0;
        int answer = 0;

        for(int i=0; i<N; i++) {
            if (meeting[i][0] >= sysdate) {
                sysdate = meeting[i][1];                  
                answer += 1;
            }
        }
        
        System.out.println(answer);
    }
}