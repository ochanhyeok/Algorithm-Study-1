import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String uid = parts[1];

            if (cmd.equals("Enter")) {
                nickMap.put(uid, parts[2]);
                logs.add(new String[]{uid, "Enter"});
            } else if (cmd.equals("Leave")) {
                logs.add(new String[]{uid, "Leave"});
            } else if (cmd.equals("Change")) {
                nickMap.put(uid, parts[2]);
            }
        }

        String[] answer = new String[logs.size()];
        int idx = 0;

        for (String[] log : logs) {
            String uid = log[0];
            String type = log[1];
            String nick = nickMap.get(uid);

            if (type.equals("Enter")) {
                answer[idx++] = nick + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nick + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
