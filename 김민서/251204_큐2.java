import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
	    int n = Integer.parseInt(br.readLine());
        int answer = 0;
	    for(int i=0; i<n; i++) {
	    	String str = br.readLine();
	    	if(str.startsWith("push")) {
	    		que.add(Integer.parseInt(str.split(" ")[1]));
	    		continue;
	    	} else if ("size".equals(str)) {
	    		answer = que.size();
	    	} else if ("empty".equals(str)) {
	    		if(!que.isEmpty()) answer = 0;
	    		else answer = 1;
	    	} else if (que.isEmpty()){
                answer = -1;
            } else if ("pop".equals(str)) {
	    		answer = que.poll();
	    	} else if ("front".equals(str)) {
	    		answer = que.peek();
	    	} else if ("back".equals(str)) {
	    		answer = ((LinkedList<Integer>) que).getLast();
	    	} else continue;
            sb.append(String.valueOf(answer)+"\n");
	    }
        System.out.println(sb.toString());
    }
}