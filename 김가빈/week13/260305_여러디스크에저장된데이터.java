import java.util.*;

public class Main6 {
    static class Entry{
        int disk, data, ref, order;
        boolean alive = true; //디스크에 남았는지 아닌지

        Entry(int disk, int data, int ref, int order) {
            this.disk = disk;
            this.data = data;
            this.ref = ref;
            this.order = order;
        }
    }

    public static void main(String[] args) {
        int[][][] records = {
                { {1, 1, 5}, {2, 4, 7}, {1, 5, 10}, {3, 1, 10}, {2, 1, 5}, {1, 3, 3}, {3, 2, 8}, {2, 2, 8}, {3, 4, 7}},
                {{1, 2, 7}, {1, 1, 7}, {1, 3, 9}, {2, 1, 3}, {2, 2, 9}, {2, 3, 1}}
        };
        int[] n = {3,2};
        int[] m = {5, 3};

        for (int i = 0; i < 2; i++) {
            int[][]answer = solution(n[i], m[i], records[i]);
            System.out.println(Arrays.deepToString(answer));
        }
    }

    private static int[][] solution(int n, int m, int[][] records) {
        List<Entry> entries = new ArrayList<>();
        int[] dataCount = new int[m + 1];
        int[] diskSize = new int[n + 1];

        for (int i = 0; i < records.length; i++) {
            //디스크 번호
            int d = records[i][0];
            //데이터 번호
            int x = records[i][1];
            int r = records[i][2];
            Entry e = new Entry(d, x, r, i + 1);
            entries.add(e);

            dataCount[x]++;
            diskSize[d]++;
        }

        List<int[]> answer = new ArrayList<>();
        while(true){
            Entry best = null;

            for (Entry e : entries) {
                if(!e.alive) continue;
                if(dataCount[e.data] <2) continue; //유일하니까 삭제 불가

                if(best == null || isHigherPriority(e,best,diskSize)){
                    best = e;
                }
            }
            if(best == null) break; // 삭제 후볻 없은까 종료

            //삭제 해야 하는 경우
            best.alive = false;
            dataCount[best.data]--;
            diskSize[best.disk]--;
            answer.add(new int[]{best.disk, best.data});
        }
        int[][] ans = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    //각 우선순위를 구해서 true인 경우 먼저 삭제
    private static boolean isHigherPriority(Entry a, Entry b, int[] diskSize) {
        if(a.ref != b.ref) return a.ref > b.ref;
        if(diskSize[a.disk] != diskSize[b.disk]) return diskSize[a.disk] > diskSize[b.disk];
        return a.order < b.order;
    }

}
