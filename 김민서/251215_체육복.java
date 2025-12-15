import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lo = new ArrayList<>();
        for(int i : lost) lo.add(i);
        List<Integer> re = new ArrayList<>();
        for(int j: reserve) re.add(j);
        // for(int a: lo){
        //     if(re.contains(a)){
        //         lo.remove(Integer.valueOf(a));
        //         re.remove(Integer.valueOf(a));
        //     }
        // }
        int idx = 0;
        while(idx < lo.size()){
            if(re.contains(lo.get(idx))){
                re.remove(Integer.valueOf(lo.get(idx)));
                lo.remove(Integer.valueOf(lo.get(idx))); //순서 중요
            } else idx++;
        }
        Collections.sort(lo);
        Collections.sort(re);
        for(int b: lo){
            if(re.contains(b+1) && re.contains(b-1)){
                re.remove(Integer.valueOf(b-1));
            } else if(re.contains(b-1)){
                re.remove(Integer.valueOf(b-1));
            } else if(re.contains(b+1)){
                re.remove(Integer.valueOf(b+1));
            } else{
                n--;
                continue;
            }
        }
        
        return n;
    }
}