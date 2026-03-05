import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int n = 3, m = 5;
        int[][] records = {
                {1, 1, 5},
                {2, 4, 7},
                {1, 5, 10},
                {3, 1, 10},
                {2, 1, 5},
                {1, 3, 3},
                {3, 2, 8},
                {2, 2, 8},
                {3, 4, 7}
        };

        int[][] ans = solution(n, m, records);
        System.out.println(Arrays.deepToString(ans)); 
    }

    static class Item {
        int id;
        int disk;
        int data;
        int days;
        int order;
        boolean alive = true;

        Item(int id, int disk, int data, int days, int order) {
            this.id = id;
            this.disk = disk;
            this.data = data;
            this.days = days;
            this.order = order;
        }
    }

    static class Disk {
        int itemId;
        int diskCntSnapshot;

        Disk(int itemId, int diskCntSnapshot) {
            this.itemId = itemId;
            this.diskCntSnapshot = diskCntSnapshot;
        }
    }

    public static int[][] solution(int n, int m, int[][] records) {
        int L = records.length;

        Item[] items = new Item[L];
        List<Integer>[] diskItems = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) diskItems[i] = new ArrayList<>();

        int[] diskCnt = new int[n + 1];
        int[] dataCnt = new int[m + 1];

        for (int i = 0; i < L; i++) {
            int disk = records[i][0];
            int data = records[i][1];
            int days = records[i][2];
            int order = i + 1;

            items[i] = new Item(i, disk, data, days, order);
            diskItems[disk].add(i);
            diskCnt[disk]++;
            dataCnt[data]++;
        }

        int needDelete = 0;
        for (int data = 1; data <= m; data++) {
            if (dataCnt[data] > 1) needDelete += (dataCnt[data] - 1);
        }

        // PQ: (days desc) -> (diskCnt desc) -> (order asc)
        PriorityQueue<Disk> pq = new PriorityQueue<>((a, b) -> {
            Item ia = items[a.itemId];
            Item ib = items[b.itemId];

            if (ia.days != ib.days) return Integer.compare(ib.days, ia.days); // days 큰게 먼저
            if (a.diskCntSnapshot != b.diskCntSnapshot) return Integer.compare(b.diskCntSnapshot, a.diskCntSnapshot); // diskCnt 큰게 먼저
            return Integer.compare(ia.order, ib.order);
        });

        for (int i = 0; i < L; i++) {
            Item it = items[i];
            if (dataCnt[it.data] > 1) {
                pq.offer(new Disk(i, diskCnt[it.disk]));
            }
        }

        List<int[]> deleted = new ArrayList<>(needDelete);

        while (deleted.size() < needDelete) {
            Disk node = pq.poll();

            Item it = items[node.itemId];
            if (!it.alive) continue;
            if (dataCnt[it.data] <= 1) continue;
            if (node.diskCntSnapshot != diskCnt[it.disk]) continue; // 디스크 개수 스냅샷이 구버전

            it.alive = false;
            deleted.add(new int[]{it.disk, it.data});

            dataCnt[it.data]--;
            diskCnt[it.disk]--;

            for (int itemId : diskItems[it.disk]) {
                Item other = items[itemId];
                if (!other.alive) continue;
                if (dataCnt[other.data] > 1) {
                    pq.offer(new Disk(itemId, diskCnt[other.disk]));
                }
            }
        }

        int[][] answer = new int[deleted.size()][2];
        for (int i = 0; i < deleted.size(); i++) {
            answer[i] = deleted.get(i);
        }
        return answer;
    }
}