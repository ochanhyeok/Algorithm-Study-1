import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	public String[] solution(String[] record) {
		List<Record> result = new ArrayList<>();
		HashMap<String, String> userList = Record.userList;

		for (String rec : record) {
			String[] tokens = rec.split(" ");
			String type = tokens[0];
			String uid = tokens[1];

			if (!type.equals("Leave")) {
				String nickname = tokens[2];
				userList.put(uid, nickname);
			}

			if (!type.equals("Change")) {
				Record r = new Record(uid, type);
				result.add(r);
			}
		}

		return result.stream().map(v -> v.getResult()).toArray(String[]::new);
	}
	
	static class Record {
		String uid;
		String type;
		static HashMap<String, String> userList = new HashMap<>();
		
		Record(String uid, String type) {
			this.uid = uid;
			this.type = type;
		}
		
		String getResult() {
			String nickname = userList.get(uid);
			if (type.equals("Enter")) {
				return nickname + "님이 들어왔습니다.";
			} else {
				return nickname + "님이 나갔습니다.";
			}
		}
	}
}