class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        char[] arr = new_id.toCharArray();
        int sbPointer = -1;
        
        for (int i = 0; i < new_id.length(); i++) {
            int code = arr[i];
            char c = arr[i];
            
            // 3. 마침표 반복 체크 
            if ( sbPointer > 0 && c == '.' && sb.charAt(sbPointer) == '.') {
                continue;
            };
            
            // 1. 대문자 -> 소문자
            if ( (code >= 65 && code <= 90) || (code >= 97 && code <= 122) ) {
                sb.append(Character.toLowerCase(c));
                sbPointer++;
                continue;
            }
            
            // 2. 사용 불가 문자 제거
            if ( (c >= 48 && c <= 57) || (c == '-') || (c == '_') || (c == '.')) {
                sb.append(c);
                sbPointer++;
                continue;
            }
        }
        
        // 4. 처음, 끝 마침표 제거
        StringBuilder sb2 = removeDot(sb);
        
        // 5~7. 문자열 길이 체크
        StringBuilder sb3 = new StringBuilder();
        if (sb2.length() == 0) {
            return "aaa";
        } else if (sb2.length() >= 16) {
            sb3.append(sb2.substring(0, 15));
            return removeDot(sb3).toString();
        } else if (sb2.length() <= 2) {
            sb3.append(sb2);
            while (sb3.length() <= 2) {
                sb3.append(sb2.charAt(sb2.length() - 1));
            }
            return removeDot(sb3).toString();
        } 
        
        
        return sb2.toString();
    }
    
    static StringBuilder removeDot (StringBuilder sb) {
        int startIndex = 0;
        int endIndex = sb.length() - 1;
        
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            startIndex = i;
            if ( c != '.' ) break;
        }
        
        for (int i = sb.length() - 1; i >= 0; i--) {

            char c = sb.charAt(i);
            endIndex = i;
            if ( c != '.' ) break;
        }
        
        if (sb.charAt(startIndex) == '.' && sb.charAt(endIndex) == '.') return new StringBuilder();
        
        return new StringBuilder(sb.substring(startIndex, endIndex + 1));
    }
}