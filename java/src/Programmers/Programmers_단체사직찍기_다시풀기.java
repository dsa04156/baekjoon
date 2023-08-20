package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_단체사직찍기_다시풀기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

 
	public static void main(String[] args) throws NumberFormatException, IOException {

		String[] data = new String[]{"N~F=0", "R~T>2"};
		solution(data.length, data);
    }
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static boolean[] v;
	static int answer;
	static public int solution(int n, String[] data) {
        answer = 0;
        char[][] arr = new char[2][5]; 
        for(int i=0;i<data.length;i++) {
        	for(int j=0;j<data[i].length();j++) {
        		arr[i][j]=data[i].charAt(j);
        	}
        }
        v= new boolean[8];
        dfs("",data);
 
        return answer;
    }
	static void dfs(String names, String[] data) {
		if(names.length() == 8 ) {
			if(check(names,data)) {
				answer++;
			}
			return;
		}
		
		for(int i=0;i<8;i++) {
			if(!v[i]) {
				v[i]=true;
				String name = names + friends[i];
				dfs(name,data);
				v[i]=false;
			}
		}
	}
	static boolean check(String names, String[] data) {
		for(String s : data) {
			int position1 = names.indexOf(s.charAt(0));
			int position2 = names.indexOf(s.charAt(2));
			char op = s.charAt(3);
			int index = s.charAt(4)-'0';
			if(op == '=') {
				if(!(Math.abs(position1 - position2) == index+1)) return false;
			}else if(op=='>') {
				if(!(Math.abs(position2-position1)>index+1)) return false;
			}else if(op=='<') {
				if(!(Math.abs(position2-position1) < index+1)) return false;
			}
			}
			return true;
	}
}

