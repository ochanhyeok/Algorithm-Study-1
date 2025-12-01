import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            
            String a = phone_book[i];
            
            for (int j = i + 1; j < phone_book.length; j++) {
                String b = phone_book[j];
                if ( b.startsWith(a) ) {
                    return false;
                } 
                break;
            }
        }
        
        return true;
    }
}