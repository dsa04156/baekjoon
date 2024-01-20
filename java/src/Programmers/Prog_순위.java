package Programmers;

public class Prog_순위 {
    public static void main(String[] args) {
        System.out.println(solution(5,new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        for(int i=0;i<results.length;i++){
            int win = results[i][0];
            int lose = results[i][1];
            arr[lose][win]=-1;
            arr[win][lose]=1;

        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                for(int x=1;x<n+1;x++){
                    if(arr[i][j]==1&&arr[j][x]==1){
                        arr[i][x]=1;
                        arr[x][i]=-1;
                    }
                    else if(arr[i][j]==-1&&arr[j][x]==-1){
                        arr[i][x]=-1;
                        arr[x][i]=1;
                    }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            int cnt=0;
            for(int j=1;j<n+1;j++){
                if(arr[i][j]==1||arr[i][j]==-1){
                    cnt++;
                }
            }
            if(cnt==n-1){
                answer++;
            }
        }
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<n+1;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        return answer;
    }

}
