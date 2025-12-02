class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] arr = new String[m][n];
        boolean[][] remove;

        // board를 배열로 변환
        for(int i = 0; i < m; i++){
            String[] temp = board[i].split("");
            for(int j = 0; j < n; j++){
                arr[i][j] = temp[j];
            }
        }

        // 지워지는 블록찾기
        while(true){
            // remove 배열 초기화
            remove = new boolean[m][n];

            // 겹치는 블록 찾기
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    String s = arr[i][j];

                    if(s.equals("")){
                        continue;
                    }

                    // 3방향 모두 같은 블록일 때
                    if(s.equals(arr[i][j + 1]) && s.equals(arr[i + 1][j + 1]) && s.equals(arr[i + 1][j])){
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j + 1] = true;
                        remove[i + 1][j] = true;
                    }
                }
            }

            // 지워진블록 찾기
            int removeCnt = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(remove[i][j]){
                        removeCnt++;
                        arr[i][j] = "";
                    }
                }
            }

            // 더이상 겹치는 블록이 없으면 반복문 종료
            if(removeCnt == 0){
                break;
            }
            answer += removeCnt;

            // 빈칸 채우기 (열마다 반복)
            for(int j = 0; j < n; j++){
                // 해당열에서 아래에서 위로 탐색할 인덱스
                int emptyIdx = m - 1;

                for(int i = m - 1; i >= 0; i--){
                    // 빈문자열이 아닐 때 (temp에 문자열 저장 -> 해당 블록을 빈문자열로 변경 -> emptyIdx칸에 저장 -> 인덱스--)
                    if(!arr[i][j].equals("")){
                        String temp = arr[i][j];
                        arr[i][j] = "";
                        arr[emptyIdx][j] = temp;
                        emptyIdx--;
                    }
                }
            }
        }

        return answer;
    }
}