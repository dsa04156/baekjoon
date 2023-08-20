package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사물인식최소면적산출프로그램 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0;i<=K;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list.get(k).add(new Node(x,y));
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).get(N));
        }

    }
    
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}
