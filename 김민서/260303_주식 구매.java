package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n][2];
       
        for(int i = 0; i < n; i++) {
        	price[i][0] = Integer.parseInt(br.readLine());
        	price[i][1] = i + 1;
        }
        
        Arrays.sort(price, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            }
            return a[1] - b[1];      
        });
        
        int max = 0;
        
        for(int i = 0; i < price.length; i++) {
        	int first = 0;
            int second = 0;
        	int firstbuy = price[i][0];
        	int fd = -1;
        	
        	
        	for(int j = i + 1; j < price.length; j++) {
        		if(price[j][0] > price[i][0] && price[j][1] > price[i][1]) {
        			first = price[j][0] - firstbuy;
        			
        			fd = j;
        			
        			for(int a = i + 1; a < price.length; a++) {
        				if(a == fd && price[i][1] > price[a][1]) {
        					continue;
        				}
        				int secondbuy = price[a][0];
        				
        				for(int b = a + 1; b < price.length; b++) {
        					if(b != fd && price[b][0] > price[a][0] && price[b][1] > price[a][1]) {
        						second = price[b][0] - secondbuy;
        						
        					}
        					
        					int sum = first + second;
                			if(sum > max) {
                        		max = sum;
                        	}
        				}
        			}
        		
        		}
        		
        	}
        
        	
        }
        
        System.out.print(max);
    }
}