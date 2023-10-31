package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_1992_쿼드트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr=  new int[N][N];
        for(int i=0;i<N;i++){
            String s = (br.readLine());
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        res="";
        dfs(arr,0,0,N);
        System.out.println(res);
        }
        static int N;
        static String res;
        static void dfs(int[][] arr, int x,int y,int size){
            if(isPossible(arr,x,y,size)){
                res+=String.valueOf(arr[x][y]);
                return;
            }
            int newsize=size / 2;
            res+="(";
            dfs(arr,x,y,newsize);
            dfs(arr,x,y+newsize,newsize);
            dfs(arr,x+newsize,y,newsize);
            dfs(arr,x+newsize,y+newsize,newsize);
            res+=")";
        }

    private static boolean isPossible(int[][] arr, int x, int y, int size) {
            int value = arr[x][y];
            for(int i=x;i<x+size;i++){
                for(int j=y;j<y+size;j++){
                    if(arr[i][j]!=value){
                        return false;
                    }
                }
            }
            return true;
    }
}
