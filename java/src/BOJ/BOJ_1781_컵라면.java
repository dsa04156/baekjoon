package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class BOJ_1781_컵라면 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st =new StringTokenizer(br.readLine());
            int[] arr = new int[K];
            for(int i=0;i<K;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder("123");
        if(sb.equals("123")){
            System.out.println(123);
        }

    }


}
