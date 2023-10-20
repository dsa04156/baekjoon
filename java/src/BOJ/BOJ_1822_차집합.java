package BOJ;/* package 구문을 넣으면 안됩니다 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1822_차집합 {

    //표준입력을 수행할 Scanner를 선언한다 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {   //프로그램의 시작부

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        st=new StringTokenizer(br.readLine());
        int[] arr =new int[A];
        for(int i=0;i<A;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            int b=Integer.parseInt(st.nextToken());
            set.add(b);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr) {
            if(!set.contains(i)){
                list.add(i);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list){
            System.out.print(i+" ");
        }

    }

}