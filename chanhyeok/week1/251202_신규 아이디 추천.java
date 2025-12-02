import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1단계 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        System.out.println("1: " + new_id);

        // 2단계 (소문자, 숫자, -, _, .) 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
        System.out.println("2: " + new_id);

        // 3단계 .가 2번이상 연속된 부분을 하나의 .로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        System.out.println("3: " + new_id);

        // 4단계 .가 처음이나 끝에 위치하면 제거
        if(new_id.length() > 1 && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        System.out.println("4: " + new_id);

        // 5단계 빈 문자열이라면 "a" 대입
        if("".equals(new_id)){
            new_id = "a";
        }
        System.out.println("5: " + new_id);

        // 6단계 길이가 16이상이면 첫 15개 문자 제외한 나머지 문자 모두 제거, 제거 후 .이 끝에 위치하면 .제거
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.'){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        System.out.println("6: " + new_id);

        // 7단계 길이가 2이하라면 마지막문자를 길이가 3이 될 때까지 반복
        if(new_id.length() <= 2){
            String s = String.valueOf(new_id.charAt(new_id.length() - 1));
            while(new_id.length() < 3){
                new_id += s;
            }
        }
        System.out.println("7: " + new_id);

        return new_id;
    }
}