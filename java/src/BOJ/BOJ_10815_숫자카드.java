package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

    //표준입력을 수행할 Scanner를 선언한다 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardA = new int[N];
        for (int i = 0; i < N; i++) {
            cardA[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] cardB = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            cardB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardA);

        int a=0;
        int b=0;

        int[] res = new int[M];
        for(int i=0;i<M;i++){
            int start =0;
            int end = N-1;
            int mid = N/2;
            while(true){
                if(cardB[i]==cardA[mid]||cardB[i]==cardA[start]||cardB[i]==cardA[end]) {
                    res[i]=1;
                    break;
                }else if(cardB[i]>cardA[start]&&cardB[i]<cardA[mid]){
                    end = mid;
                    mid = (start+mid)/2;
                    if(end==mid) break;
                }else if(cardB[i]>cardA[mid]&&cardB[i]<cardA[end]){
                    start = mid;
                    mid = (mid+end)/2;
                    if(start==mid) break;
                }else{
                    break;
                }
            }
        }




        for(int i : res){
            System.out.print(i+" ");
        }
    }
}