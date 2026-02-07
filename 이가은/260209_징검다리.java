import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        // 바위 사이 거리가 될 수 있는 최솟값 범위
        int min = 1;
        int max = distance;

        Arrays.sort(rocks);

        // 이분탐색
        while (min <= max) {
            // 현재 최소 바위 사이 거리
            int mid = (min + max) / 2;

            int removeCnt = 0; // 제거한 바위 개수
            int prev = 0; // 앞에 위치한 바위의 위치 (처음 = 0)

            // 바위 순회
            for (int r : rocks) {
                // r = 현재 바위의 위치
                // 현재 바위와 앞에 위치한 바위의 위치가 현재 최소 바위 사이 거리보다 작으면 현재 바위 제거
                // => 최소 사이 거리 성립 위해
                if (r - prev < mid) {   
                    removeCnt++;
                } else {
                    // 그렇지 않으면 앞에 위치한 바위 위치를 현재 바위로 갱신
                    prev = r;
                }
            }

            // 마지막 바위와 도착지점은 위 순회에서 포함 안 되므로 한 번 더 진행
            if (distance - prev < mid) {
                removeCnt++;
            }

            // 만약 최종적으로 제거한 바위 개수가 크면 
            // 설정한 최소 사이 거리가 길다는 것이므로 max 값 -1
            if (removeCnt > n) {
                max = mid - 1;
            } else {
                // 제거한 바위 수가 n 이하라면 mid 조건을 만족할 수 있음 (mid는 가능한 값)
                // 따라서 현재 mid를 정답 후보로 저장 후
                // 더 큰 최소 거리도 가능한지 확인하기 위해 탐색 범위를 오른쪽으로 이동
                answer = mid;
                min = mid + 1;
            }
        }

        return answer;
    }
}
