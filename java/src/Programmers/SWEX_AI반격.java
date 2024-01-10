package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEX_AI반격 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] agents = new int[n][3];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                agents[i][0]=Integer.parseInt(st.nextToken());
                agents[i][1]=Integer.parseInt(st.nextToken());
                agents[i][2]=Integer.parseInt(st.nextToken());
            }
            arr=new int[3];
            v=new boolean[n];
            min=Integer.MAX_VALUE;
            dfs(0,n,agents);
            if(min==Integer.MAX_VALUE) min = -1;
            System.out.println("#"+tc+ " "+ min);
        }
    }
    static int[] arr;
    static int min;
    static boolean[] v;
    static void dfs(int idx,int n,int[][] agents){
        if(idx==3){
            int sum=0;
            int power = arr[0];
            int intelligence = arr[1];
            int Agility = arr[2];
            sum+= agents[arr[0]][1]+agents[arr[0]][2];
            sum+= agents[arr[1]][0]+agents[arr[1]][2];
            sum+= agents[arr[2]][0]+agents[arr[2]][1];
            boolean[] v2 = new boolean[agents.length];
            v2[arr[0]]=true;
            v2[arr[1]]=true;
            v2[arr[2]]=true;
            for(int i=0;i<v2.length;i++){
                if(!v2[i]){
                    v2[i]=true;
                    int maxP=-1;
                    int maxNo=-1;
                    for(int j=0;j<3;j++){
                        if(maxP<agents[i][j]){
                            maxP=agents[i][j];
                            maxNo=j;
                        }
                    }
                    for(int j=0;j<3;j++){
                        if(j==maxNo) continue;
                        sum+=agents[i][j];
                    }
                }
            }
            if(min>sum){
                min=sum;
            }

            return;
        }
        for(int i=0;i<n;i++){
            if(v[i]) continue;
            arr[idx]=i;
            v[i]=true;
            dfs(idx+1,n,agents);
            v[i]=false;

        }
    }


}
