import java.util.*;
class Solution {
    //좌하우
    int[][] dir = {{0,1},{1,0},{0,-1}};
    char[][] arr;
    int blockCnt =0;
    
    //리스트에 있는 좌표셋을 꺼내서 해당 위치의 블록만 지우고 카운팅 하기.
    public void removeBlock(int m, int n, List<int[]> removeList){
        for(int[] pos : removeList){
            int i = pos[0];
            int j = pos[1];
            
            if(arr[i][j] != '0'){
                arr[i][j] = '0';
                blockCnt++;
            }
        }
    }
    
    //열 기준으로 아래서부터 현재블록이 0이 아닌 블록이면 옮겨야 하니까 블록들을 리스트에 담고
    //아래서부터 블록을 쌓아올림
    //블록을 다 쌓고 그 위로부터는 0으로 다시 채움. 
    public void moveBlock(int m, int n){
        for(int j=0; j<n; j++){
            List<Character> list = new ArrayList<>();
            
            for(int i=m-1; i>=0; i-- ){
                if('0'!=arr[i][j]) list.add(arr[i][j]);
            }
            
            int idx = m - 1;
            for (char block : list) {
                arr[idx--][j] = block;
            }
            
            while(idx>=0){
                arr[idx--][j] = '0';
            }
        }
    }
    
    //현재 위치 기준으로 좌,우,대각선 확인하고 똑같은 블록이면 지울목록에 담기. 
    //지울 때, 리스트에서 꺼내서 해당 위치만 지우기(순회X)
    //이동하기
    //지울 목록 초기화! -> 반복하면서 중복되지 않게 
    //지우기 전에 지울 목록이 있는지 확인하고 없으면 이동이 다 끝난 것이기에 종료
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int idx=0;
        arr = new char[m][n];
        List<int[]> removeList = new ArrayList<>();;
        
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                arr[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    char curBlock = arr[i][j];
                    if(curBlock!='0' && curBlock==arr[i][j+1] && curBlock==arr[i+1][j] && curBlock==arr[i+1][j+1]){
                        removeList.add(new int[]{i,j});
                        removeList.add(new int[]{i,j+1});
                        removeList.add(new int[]{i+1,j});
                        removeList.add(new int[]{i+1,j+1});
                    }
                }
            }
            
            //블럭 지우기 전에 지울 블럭이 있는지 검사 -> 없으면 종료
            if(removeList.isEmpty()) break;
            
            removeBlock(m,n,removeList);
            moveBlock(m,n);
            
            removeList.clear();
        
        }//while
        answer = blockCnt;
        return answer;
    }
}

