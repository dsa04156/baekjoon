package Programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Prog_도넛과막대그래프 {
	
    public static void main(String args[]) throws IOException
    {
    	Solution s = new Solution();
    	int[][] edges = new int[][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}}; 
//    			{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
    	System.out.println(Arrays.toString(s.solution(edges)));
    	
    }
    static class Solution {
        public int[] solution(int[][] edges) {
            
            int a;
            a=0;
            int m=0,e=0;
            int max =0;
            
            for(int i=0;i<edges.length;i++) {
            	for(int j=0;j<2;j++) {
            		max = Math.max(max, edges[i][j]);
            	}
            }
            int arr[][] = new int[max+1][2];
            
            
            int k=0;
            for(int i=0;i<edges.length;i++) {
        		int x = edges[i][0];
        		int y = edges[i][1];
        		
        		arr[x][1]++;
        		arr[y][0]++;
            }
            for(int i=1;i<arr.length;i++) {
            	int in = arr[i][0];
            	int out = arr[i][1];
            	
            	if(in==0&&out>=2) {
            		a=i;
            		k=out;
            	}
            	if(in>=1&&out==0) {
            		m++;
            	}
            	if(in>=2&&out>=2) {
            		e++;
            	}
            	
            }
            
            
            int[] answer = {a,k-m-e,m,e};
            return answer;
        }
       
    }
   
}

	