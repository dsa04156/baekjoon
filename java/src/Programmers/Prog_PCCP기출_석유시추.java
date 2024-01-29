package Programmers;

import java.util.*;

class Prog_PCCP기출_석유시추 {

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{1,1},{1,1}}));

    }

    public static int solution(int[][] land) {
        int answer=0;
        arr = new int[501];
        v = new boolean[land.length][land[0].length];
        for(int j=0;j<land[0].length;j++){
            for(int i=0;i<land.length;i++){
                if(land[i][j]==1){
                    if(!v[i][j]){
                        bfs(land,i,j);


                    }
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)
                answer = Math.max(answer,arr[i]);
        }
        return answer;
    }
    static int[] arr;
    static int dx[] = new int[]{-1,0,1,0};
    static int dy[] = new int[]{0,1,0,-1};
    static boolean[][] v;
    static void bfs(int[][] land,int x,int y){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        v[x][y]=true;
        int cnt =1;
        int start = y;
        int end = y;
        while(!q.isEmpty()){
            int xx = q.poll();
            int yy = q.poll();
            for(int c=0;c<4;c++){
                int nx = xx+dx[c];
                int ny = yy+dy[c];
                if(nx<0||ny<0||nx>=land.length||ny>=land[0].length) continue;
                if(v[nx][ny]) continue;
                if(land[nx][ny]==0) continue;
                v[nx][ny]=true;
                cnt++;
                q.add(nx);
                q.add(ny);
                start = Math.min(start,ny);
                end = Math.max(end,ny);
            }
        }
        // System.out.println(start+" "+end+" "+cnt);
        for(int i=start;i<=end;i++){
            arr[i]+=cnt;
        }
    }


    }
