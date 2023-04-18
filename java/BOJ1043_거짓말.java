package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1043_°ÅÁþ¸» {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] nList;
	static ArrayList<List<Integer>> pList;
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		nList = new int[N+1];
		int party[] = new int[M];
		pList = new ArrayList<>();
		for(int i=0;i<M;i++) {
			pList.add(new ArrayList<Integer>());
		}
		for(int i=0;i<know;i++) {
			int a =Integer.parseInt(st.nextToken());
			nList[a]=a;
		}
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0;j<a;j++) {
				pList.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		

		int res=0;
		
		dfs();
		for(int i=0;i<pList.size();i++) {
			int cnt=0;
			for(int j=0;j<pList.get(i).size();j++) {
				if(nList[pList.get(i).get(j)]!=0) {
					continue;
				}
				cnt++;
				if(cnt==pList.get(i).size()) {
					res++;
				}
			}
		}
		
		System.out.println(res);
	}
	static void dfs() {
		for(int i=0;i<pList.size();i++) {
			for(int j=0;j<pList.get(i).size();j++) {
				for(int x=1;x<nList.length;x++) {
					if(pList.get(i).get(j)==nList[x]) {
						for(int y=0;y<pList.get(i).size();y++) {
							int a = pList.get(i).get(y);
							if(nList[a]==0) {
								nList[a]=a;
								dfs();
							}
						}
					}
				}
			}
		}
	}
}
