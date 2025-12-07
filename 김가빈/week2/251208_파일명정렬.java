import java.util.*;

public class FileName {
    public int idx;
    public String head;
    public String number;
    public String tail;
    public String text;
    
    public FileName(int idx, String head, String number, String tail, String text){
        this.idx = idx;
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.text = text;
    }
}

class Solution {
    public String[] solution(String[] files) {
        List<FileName> list = new ArrayList<>();
        
        for (int i=0; i<files.length; i++) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            
            for (int j=0; j<files[i].length(); j++) {
                String s = String.valueOf(files[i].charAt(j));
                
                if(s.matches("[0-9]")) {
                    // 처음 나온 숫자 
                    if(!flag) {
                        sb.append(",");
                        sb.append(s);
                        flag = true;
                    // 나중에 나온 숫자   
                    } else {
                        sb.append(s);
                    }
                // 헤더랑 테일 구분
                } else {
                    // 숫자가 안 나왔으면 헤더
                    if(!flag) sb.append(s);
                    // 나왔으면 테일 
                    else {
                        sb.append(",");
                        sb.append(files[i].substring(j, files[i].length()));
                        break;
                    }
                }
            }
            //헤더, 숫자, 테일 구분한 것을 객체리스트화
            String[] str = sb.toString().split(",");
            String tail = (str.length == 3) ? str[2] : "";
            list.add(new FileName(i, str[0], str[1], tail, files[i]));
        }
     
        //정렬
        Collections.sort( list, (o1,o2)->{
            //기준2
            if (o1.head.toUpperCase().equals(o2.head.toUpperCase())){
                //기준3
                if(Integer.parseInt(o1.number)==Integer.parseInt(o2.number)){
                   return o1.idx - o2.idx; 
                }
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            }
            return o1.head.toUpperCase().compareTo(o2.head.toUpperCase());
        });

        return list.stream().map(FileName->FileName.text).toArray(String[]::new);
    }
}