package org.example;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = (Y * 100) / X;
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long lo = 1, hi = 1_000_000_000L;
        long ans = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long nz = ((Y + mid) * 100) / (X + mid);

            if (nz > Z) { 
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
