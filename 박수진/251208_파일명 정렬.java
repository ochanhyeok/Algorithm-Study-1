import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = splitFileName(o1);
            String[] file2 = splitFileName(o2);
            
            // 1. HEAD 비교 (대소문자 무시)
            int headCompare = file1[0].compareToIgnoreCase(file2[0]);
            
            // HEAD가 같으면(==0) 숫자 비교, 다르면 HEAD 비교 결과 반환
            if (headCompare == 0) {
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                return num1 - num2;
            } else {
                return headCompare;
            }
        });
        
        return files;
    }
            
    
    static String[] splitFileName(String file) {
        String head = "";
        String number = "";
        
        int level = 0;
        
        for (int i=0; i<file.length(); i++) {
            char c = file.charAt(i);
            
            // level 0: HEAD 구간
            if (level == 0) {
                if (c >= '0' && c <= '9') {
                    level = 1;
                    number += c;
                }
                else {
                    head += c;
                }
            }
            // level 1: NUMBER 구간
            else if (level == 1) {
                if (c >= '0' && c <= '9') {
                    if (number.length() < 5)
                        number += c;
                    else {
                        break; // 5글자 넘으면 종료 
                    }
                } else {
                    break;
                }
            }
        }

        return new String[] { head, number };
    }        
}