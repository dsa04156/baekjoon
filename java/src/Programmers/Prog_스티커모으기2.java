package Programmers;
import java.io.*;
import java.util.*;
class Prog_스티커모으기2 {
	public static void main(String[] args) throws IOException{
		Solution s = new Solution();
		s.solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10});
		
	}
	static class Solution {
	    public int solution(int sticker[]) {
	        int answer = 0;
	        
	        int[] d1 = new int[sticker.length+2];
	        int[] d2 = new int[sticker.length+2];
	       
	        for(int i=2;i<sticker.length+2;i++) {
	        	d1[i]=Math.max(d1[i-2]+sticker[i-2],d1[i-1]);
	        }
	        for(int i=3;i<sticker.length+2;i++) {
	        	d2[i]=Math.max(d2[i-2]+sticker[i-2],d2[i-1]);
	        }
	        
	        System.out.println(Arrays.toString(d1));
	        System.out.println(Arrays.toString(d2));
	        System.out.println(Math.max(d1[d1.length-2], d2[d2.length-1]));
	        return answer;
	    }
	}
	
}