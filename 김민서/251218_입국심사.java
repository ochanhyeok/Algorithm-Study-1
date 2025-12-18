import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		long start = 1;
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		long end = (long)list.get(list.size() - 1) * m;

		long min = end;

		while (start <= end) {
			long mid = (start + end) / 2;

			if (find(mid)) {
				min = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(min);
	}

	public static boolean find(long time) {
		long sum = 0;
		for (int i : list) {
			sum += time / i;
			if (sum >= m)
				return true;
		}
		return false;
	}
}