package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEX_삼각김밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<12000;i++){
            list.add(new ArrayList<>());
        }
        int start=1;
        int startp=1;
        int max =1;
        int maxp = 2;
        int k=1;
        for(int i=1;i<=10000;i++){
            if(i+k<=10000)
                list.get(i).add(i+k);
            if(i+k+1<=10000)
                list.get(i).add(i+k+1);
            if(i!=start){
                list.get(i).add(i-1);
            }else if(i==start){
                start+=startp;
                startp++;
            }
            if(i!=max){
                list.get(i).add(i+1);
            }
            else if(i==max){
                max+=maxp;
                maxp++;
                k++;
            }
        }
//        int left = 1;
//        int right = 2;
//        int ss=1;
//        int ee=1;
//        while(ee<20000){
//            ss+=left;
//            ee+=right;
//            left++;
//            right++;
//            System.out.println(ss+" "+ee);
//        }
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(e<s){
                int tmp=s;
                s=e;
                e=tmp;
            }
            int ans= bfs(s,e,list);

            System.out.println("#"+tc+ " "+ ans);
        }
    }

    private static int bfs(int s, int e, ArrayList<ArrayList<Integer>> list) {
        Queue<Node> q = new LinkedList<>();
        boolean[] v = new boolean[12000];
        v[s]=true;
        q.add(new Node(s,0));
        System.out.println(list.get(9860));
        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i=0;i<list.get(n.no).size();i++){
                int no =list.get(n.no).get(i);
                if(v[no]) continue;
//                System.out.println(n.cnt+1 + " "+ no);
                if(no==e) {
                    return n.cnt+1;
                }
                v[no]=true;
                q.add(new Node(no,n.cnt+1));
            }

        }
        return 0;

    }
     private static class Node{
        int no;
        int cnt;
        public Node(int no, int cnt){
            this.no=no;
            this.cnt=cnt;
        }
        public String toString(int no,int cnt){
            return no+" "+cnt;
        }
    }

}
