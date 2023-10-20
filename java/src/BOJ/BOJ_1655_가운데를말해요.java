package BOJ;/* package 구문을 넣으면 안됩니다 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {

    //표준입력을 수행할 Scanner를 선언한다 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>((o1,o2)->o1-o2);
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1,o2)->o2-o1);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            int a = Integer.parseInt(br.readLine());
            if(minPq.size()==maxPq.size()){
                maxPq.add(a);
            }else{
                minPq.add(a);
            }
            if(!minPq.isEmpty()&&!maxPq.isEmpty()){
                if(minPq.peek()<maxPq.peek()){
                    int tmp = minPq.poll();
                    minPq.add(maxPq.poll());
                    maxPq.add(tmp);
                }
            }
            sb.append(maxPq.peek()+"\n");

        }
        System.out.println(sb);

    }

}