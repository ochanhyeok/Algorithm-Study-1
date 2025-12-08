import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] file = new String[files.length][3];

        for(int i = 0; i < files.length; i++){
            String temp = files[i];
            int headIdx = 0;
            int numIdx = 0;

            int cnt = 0;
            // 숫자 인덱스 찾기
            for(int j = 0; j < temp.length(); j++){
                char ch = temp.charAt(j);

                if(ch >= '0' && ch <= '9'){
                    cnt++;
                    if(cnt == 1){
                        headIdx = j;
                    }

                    if(cnt <= 5){
                        numIdx = j + 1;
                    }
                } else {
                    if(cnt > 0){
                        break;
                    }
                }
            }

            // HEAD 부분
            file[i][0] = temp.substring(0, headIdx);
            // NUMBER 부분
            file[i][1] = temp.substring(headIdx, numIdx);
            // TAIL 부분
            file[i][2] = temp.substring(numIdx, temp.length());
            // System.out.println(file[i][0] + ", " + file[i][1] + ", " + file[i][2]);
            // System.out.println("headIdx : " + headIdx + ", numIdx :" + numIdx);
            // System.out.println("===============");
        }

        Arrays.sort(file, (a, b) -> {
            // 1순위: HEAD(대소문사 무시) 사전순 오름차순
            String headA = a[0].toLowerCase();
            String headB = b[0].toLowerCase();

            int hCmp = headA.compareTo(headB);
            // hCmp가 음수면 a가 앞, 양수면 b가 앞, 0이면 같음
            if(hCmp != 0) {
                return hCmp;
            }

            // 2순위: NUMBER 오름차순
            int numA = Integer.parseInt(a[1]);
            int numB = Integer.parseInt(b[1]);
            return Integer.compare(numA, numB);
        });

        for(int i = 0; i < files.length; i++){
            answer[i] = file[i][0] + file[i][1] + file[i][2];
        }

        return answer;
    }
}