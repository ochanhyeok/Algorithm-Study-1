import java.util.*;

class Solution {

  // 레코드 구조: 입력 records[i]의 정보를 객체로 보관
  static class Rec {
    int disk;      // 디스크 번호
    int data;      // 데이터 번호
    int last;      // 최근 참조된 일자
    int order;     // 입력 순서(= 저장 순서로 간주)
    
    Rec(int disk, int data, int last, int order) {
      this.disk = disk;
      this.data = data;
      this.last = last;
      this.order = order;
    }
  }
  
  public int[][] solution(int n, int m, int[][] records) {
    int R = records.length;

    // 1) records -> Rec[] (order 부여)
    Rec[] recs = new Rec[R];
    for (int i = 0; i < R; i++) {
      recs[i] = new Rec(records[i][0], records[i][1], records[i][2], i);
    }

    // 2) data별 복제본 개수 카운트
    int[] dataCnt = new int[m + 1];
    for (Rec r : recs) {
      dataCnt[r.data]++;
    }

    // 3) alive 배열: 레코드 삭제 여부 관리
    boolean[] alive = new boolean[R];
    Arrays.fill(alive, true);

    // 4) 삭제 우선순위 PQ
    //    1. last 내림차순 (오래된 것 먼저)
    //    2. order 오름차순 (먼저 저장된 것 우선)
    PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
      Rec a = recs[i];
      Rec b = recs[j];

      if (a.last != b.last) return b.last - a.last; // last desc
      return a.order - b.order;                     // order asc
    });

    // PQ에 모든 레코드 인덱스 넣어둠
    for (int i = 0; i < R; i++) pq.add(i);

    // 삭제 결과 저장: (disk, data)
    List<int[]> out = new ArrayList<>();
  
    // 5) 시뮬레이션
    while (!pq.isEmpty()) {
      int idx = pq.poll();
      if (!alive[idx]) continue; // 이미 삭제된 레코드면 패스

      Rec cur = recs[idx];

      // 유일본이면 삭제 불가
      if (dataCnt[cur.data] <= 1) continue;

      // 삭제 수행
      alive[idx] = false;
      dataCnt[cur.data]--;
      out.add(new int[]{cur.disk, cur.data});
    }

    // 6) List<int[]> -> int[][]
    return out.toArray(new int[out.size()][]);

  }
}