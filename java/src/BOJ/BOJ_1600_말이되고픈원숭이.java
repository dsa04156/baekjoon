package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_1600_말이되고픈원숭이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] arr = new int[W][H];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < H; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res=Integer.MAX_VALUE;
        bfs(K, arr);
        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(res);

    }
    static int res;
    static int[] dx = new int[]{-2,-1,2,1,-1,-2,1,2};
    static int[] dy = new int[]{1,2,1,2,-2,-1,-2,-1};
    static int[] dx2 = new int[]{-1,0,1,0};
    static int[] dy2 = new int[]{0,1,0,-1};
    static void bfs(int k , int[][] arr){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0,0));
        int[][][] v =new int[arr.length][arr[0].length][k+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                for(int x =0; x<k+1;x++){
                    v[i][j][x]=987654321;
                }
            }
        }
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.nowX == arr.length-1 && n.nowY==arr[0].length-1){
                res = Math.min(res,n.moveCount);
                continue;
            }
            if(n.moveCount>=res) continue;
            for(int c=0;c<8;c++){
                if(n.nowK >= k) break;
                int nx = n.nowX + dx[c];
                int ny = n.nowY + dy[c];
                if(nx<0||ny<0||nx>=arr.length||ny>=arr[0].length) continue;
                if(arr[nx][ny]==1) continue;
                if(v[nx][ny][n.nowK+1]>n.moveCount+1){
                    v[nx][ny][n.nowK+1]=n.moveCount+1;
                    q.add(new Node(nx,ny,n.nowK+1,n.moveCount+1));
                }
            }
            for(int c=0;c<4;c++){
                int nx = n.nowX + dx2[c];
                int ny = n.nowY + dy2[c];
                if(nx<0||ny<0||nx>=arr.length||ny>=arr[0].length) continue;
                if(arr[nx][ny]==1) continue;
                if(v[nx][ny][n.nowK]>n.moveCount+1){
                    v[nx][ny][n.nowK]= n.moveCount+1;
                    q.add(new Node(nx,ny,n.nowK,n.moveCount+1));
                }
            }
        }
    }
    static class Node{
        int nowX;
        int nowY;
        int nowK;
        int moveCount;
        public Node(int nowX,int nowY,int nowK,int moveCount){
            this.moveCount=moveCount;
            this.nowX=nowX;
            this.nowY=nowY;
            this.nowK=nowK;

        }
    }
}