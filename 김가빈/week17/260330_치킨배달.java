import java.util.*;
import java.io.*;

class Main{
    static int[][] city;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int N, M, answer;
    static List<Loc> chickens;

    static class Loc {
        int i;
        int j;
        int dist;

        Loc(int i, int j){
            this.i = i;
            this.j = j;
        }
        Loc(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Loc> curList = new ArrayList<>();
        chickens = new ArrayList<>();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 2) chickens.add(new Loc(i,j));
            }
        }

        answer=Integer.MAX_VALUE;
        findMin(0, 0, curList);

        System.out.println(answer);
    }

    static void findMin(int depth, int start, List<Loc> curList){
        if(depth == M ){
            //각 경우의 치킨 거리를 구하고, 최솟값인지 비교
            int num = getDistance(curList);
            answer = Math.min(answer, num);

            return;
        }

        //chicken집 리스트 중에서 M개 골라서 curList에 담기
        for(int i=start; i<chickens.size(); i++){

            curList.add(chickens.get(i));
            findMin(depth+1, i+1, curList);
            curList.remove(curList.size()-1);
        }
    }

    static int getDistance(List<Loc> curList){
        int distSum = 0;
        int[][] cloneCity = new int[N][N];

        for(int i=0; i<N; i++){
            cloneCity[i] = city[i].clone();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(city[i][j] == 2) cloneCity[i][j] = 0;
                else cloneCity[i][j] = city[i][j];
            }
        }

        for(Loc loc : curList){
            cloneCity[loc.i][loc.j] = 2;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloneCity[i][j] == 1) {
                    int minDist = Integer.MAX_VALUE;
                    for(Loc cur : curList){
                        minDist = Math.min(minDist,(Math.abs(i-cur.i) + Math.abs(j-cur.j)));
                    }
                    distSum += minDist;
                }
            }
        }
        return distSum;

    }
}