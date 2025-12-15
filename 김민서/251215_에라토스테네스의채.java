import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Aristo {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> ns = new ArrayList<>();
        for(int i=2; i<=n; i++) {
        	ns.add(i);
        }
        int cnt = 0;
        while (cnt < k) {
        	int s = ns.get(0);
        	int idx = 0;
        	while(idx < ns.size() && cnt < k) {
        		if(ns.get(idx)%s == 0) {
        			cnt++;
        			if(cnt == k) {
        				System.out.println(ns.get(idx));
        			} else 
        				ns.remove(idx);
        		} else idx++;
        	}
        }
	}

}