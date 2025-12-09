import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 체육복 잃어버리지 않은 사람
        int available = n - lost.length;
        
        // 여벌 체육복 소유 여부
        boolean[] reserveArr = new boolean[n + 1];

        // 최종적으로 누구한테 빌릴지
        int[] finalBorrow = new int[n+1];
        
        // 여벌 체육복 가진 학생 인덱스를 true로 업데이트
        for (int i = 0; i < reserve.length; i++) reserveArr[reserve[i]] = true;
        
        for (int lostStudent: lost) {
            // 여벌 체육복을 가진 학생이 도난 당한 경우
            if (reserveArr[lostStudent]) {
                // 소유 여부 false로 업데이트
                reserveArr[lostStudent] = false;
                // 본인 체육복 입는 것으로 결정
                finalBorrow[lostStudent] = lostStudent;
                available++;
            }
        }
        
        for (int lostStudent: lost) {
            // 위에서 결정된 사람 제외
            if (finalBorrow[lostStudent] > 0) continue;
            
            // 앞 뒤 빌릴 수 있는지 여부
            boolean front = lostStudent > 1 && reserveArr[lostStudent - 1];
            boolean rear = lostStudent < n && reserveArr[lostStudent + 1];
            
            // 두 명 빌릴 수 있다면 나중에 결정
            if (front && rear) {
                finalBorrow[lostStudent] = -1;
                continue;
            } 
            
            // 한 명만 빌릴 수 있다면 바로 결정
            else if (front) {
                finalBorrow[lostStudent] = lostStudent - 1;
                reserveArr[lostStudent - 1] = false;
                available++;
            } else if (rear) {
                finalBorrow[lostStudent] = lostStudent + 1;
                reserveArr[lostStudent + 1] = false;
                available++;
            }
        }
        
        for (int lostStudent: lost) {
            // 두 명 빌릴 수 있었던 사람들 
            if (finalBorrow[lostStudent] == -1) {
                boolean front = lostStudent > 1 && reserveArr[lostStudent - 1];
                boolean rear = lostStudent < n && reserveArr[lostStudent + 1];
                if (front) {
                    reserveArr[lostStudent-1] = false; 
                    available++;
                } else if (rear) {
                    reserveArr[lostStudent+1] = false;
                    available++;
                }
            } 
        }
        return available;
    }
}