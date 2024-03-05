package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class BOJ_11286_절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1,Integer o2){
                if(Math.abs(o1)==Math.abs(o2))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int cnt =0;
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.add(x);
        }

    }


}
