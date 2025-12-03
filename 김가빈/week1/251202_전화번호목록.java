import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        Map<Integer,String> map = new HashMap<>();
        
        map.put(0,phone_book[0]);
        for(int i=1;i<phone_book.length ;i++){
            if(phone_book[i].startsWith(map.get(i-1))) return false;
            else map.put(i,phone_book[i]);
        }

        return true;
    }
}