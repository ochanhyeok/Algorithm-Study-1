import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
        for(String i : files) {
            map = new HashMap<>();
            map.put("head", i.split("\\d+")[0]);    //숫자가 나오기 전 문자열
            int num = Integer.parseInt(i.replaceAll("^[^0-9]+", "").replaceAll("[^0-9].*$", "")); //첫번째 숫자 덩어리만 남기고 없앰
            map.put("num", num);
            map.put("file", i);    //파일 원래이름 같이 저장
            list.add(map);
        }
        list.sort((a, b) -> {
            int compare = ((String)a.get("head")).compareToIgnoreCase((String)b.get("head")); //대소문자 무시하고 비교, 음수, 양수는 이동, 0은 동일
            if(compare != 0) return compare;
            return ((Integer)a.get("num")) - ((Integer)b.get("num")); //head가 같으면 num으로 정렬
        });
        for(int j = 0; j < files.length; j++){
            answer[j] = (String)list.get(j).get("file");
        }
		// for (Map m : list) {
		// 	System.out.println(m);
		// }
        return answer;
    }
}