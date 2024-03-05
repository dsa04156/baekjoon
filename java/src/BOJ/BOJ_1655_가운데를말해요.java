package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class BOJ_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> MaxPq = new PriorityQueue<>((o1,o2) -> o1-o2 );
        PriorityQueue<Integer> MinPq = new PriorityQueue<>((o1,o2) -> o2-o1);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(MinPq.size()==MaxPq.size())
                MinPq.add(x);
            else
                MaxPq.add(x);

            if(!MinPq.isEmpty() && !MaxPq.isEmpty()){
                if(MinPq.peek()>MaxPq.peek()){
                    int tmp = MinPq.poll();
                    MinPq.add(MaxPq.poll());
                    MaxPq.add(tmp);
                }
            }
            sb.append(MinPq.peek()+"\n");
        }
        System.out.println(sb);


    }


}
