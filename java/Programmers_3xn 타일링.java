package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = 4;
		solution(6);
	}
	static public int solution(int n) {
        int answer = 0;
        long[] tile = new long[5001];
       tile[0]=1;
       tile[2]=3;
       int mod = 1000000007;
       for(int i=4;i<=n;i+=2) {
    	   tile[i]=(tile[i-2]*4%mod - tile[i-4]%mod +mod)%mod;
       }
        return answer=(int) tile[n];
    }
}

