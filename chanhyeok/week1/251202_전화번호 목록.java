import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        // System.out.println(Arrays.toString(phone_book));

        // contains로 하면 번호 중간에 앞에 번호가 포함되어도 true를 반환함
        // 접두어인 경우니까 startsWith() 사용
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }

        return true;
    }
}