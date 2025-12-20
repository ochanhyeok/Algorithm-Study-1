class Solution {
	public String solution(String s, int n) {
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < arr.length; i++){
			if(arr[i] >= 'a' && arr[i] <= 'z'){
				char ch = (char)((arr[i] - 'a' + n) % ('z' - 'a' + 1) + 'a');
				sb.append(ch);
			} else if(arr[i] >= 'A' && arr[i] <= 'Z'){
				char ch = (char)((arr[i] - 'A' + n) % ('Z' - 'A' + 1) + 'A');
				sb.append(ch);
			} else {
				sb.append(' ');
			}
		}

		return sb.toString();
	}
}