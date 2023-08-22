package goorm;
import java.io.*;
import java.util.*;
class 문자열나누기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		HashSet<String> set = new HashSet<>();
		ArrayList<String[]> wordList = new ArrayList<>();
		
		for(int i=1;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				String a = S.substring(0,i);
				String b = S.substring(i,j);
				String c = S.substring(j,N);
				wordList.add(new String[] {a,b,c});
				set.add(a);
				set.add(b);
				set.add(c);
				
			}
		}

		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		int res=0;
		for(int i=0;i<wordList.size();i++) {
			String[] arr = wordList.get(i);
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				for(int x=0;x<list.size();x++) {
					if(arr[j].equals(list.get(x))) {
						sum+=x+1;
						break;
					}
				}
			}
			if(res<sum)
				res=sum;
		}
		System.out.println(res);
	}
}