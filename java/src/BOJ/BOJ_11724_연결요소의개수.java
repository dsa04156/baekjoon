package BOJ;/* package 구문을 넣으면 안됩니다 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

    //표준입력을 수행할 Scanner를 선언한다 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr= new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }
        v=new boolean[N+1];
        res=0;
        for(int i=1;i<=N;i++){
            if(v[i]) continue;

            sol(i,arr,N,M);

            res++;
        }
        System.out.println(res);
    }
    static int res;
    static boolean[] v;
    static void sol(int num,int[][] arr,int N,int M){
        v[num]=true;
        for(int i=1;i<=N;i++){
            if(v[i]) continue;
            if(arr[num][i]==1){
                v[i]=true;
                sol(i,arr,N,M);
            }
        }
    }

}