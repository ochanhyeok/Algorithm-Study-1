package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Atm {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));     //string으로 받아서 int list 만들기
		}
		Collections.sort(arr);   //정렬
		int sec = 0;
		for(int a=0; a<n; a++) {
			sec += (arr.get(a)*(n-a));    //앞에사람 다 곱해서 더하기
		}
		System.out.println(sec);
	}

}