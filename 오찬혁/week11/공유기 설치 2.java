package baekjoon;

import java.util.*;
import java.io.*;

public class 공유기설치{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] houses = new int[N];

		for(int i = 0; i < N; i++){
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		int left = 1;
		int right = houses[N - 1] - houses[0];

		while(left <= right){
			int mid = (left + right) / 2;

			if (canWifi(houses, mid, C)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}

	private static boolean canWifi(int[] houses, int mid, int C) {
		int prev = houses[0];
		int wifiCnt = 1;

		for(int house : houses){
			int len = house - prev;

			if(len >= mid){
				wifiCnt++;
				prev = house;
			}
		}

		return wifiCnt >= C;
	}
}