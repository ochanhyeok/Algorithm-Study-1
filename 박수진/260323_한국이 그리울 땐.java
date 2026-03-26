import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        
        String[] pattern = bf.readLine().split("\\*");
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String file = bf.readLine();
            
            if (file.length() < pattern[0].length() + pattern[1].length()) {
                answer.append("NE\n");
            } else if (file.startsWith(pattern[0]) && file.endsWith(pattern[1])) {
                answer.append("DA\n");
            } else {
                answer.append("NE\n");
            }
        }
        
        System.out.println(answer);
    }
}