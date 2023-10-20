package BOJ;/* package 구문을 넣으면 안됩니다 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

    //표준입력을 수행할 Scanner를 선언한다
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = 0;
        int max = arr[N-1];
        while(min<max){
            int mid = (min+max)/2;
            long sum=0;
            for(int i : arr){
                if(i-mid>0){
                    sum += (i-mid);
                }
            }
            if(sum<M){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min-1);

    }

}