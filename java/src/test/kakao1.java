package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class kakao1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = solution(new String[]{"muzi", "ryan", "frodo", "neo"},new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
        System.out.println(res);
    }

    public static int solution(String[] friends, String[] gifts) {
            int answer = 0;
            int[][] send = new int[friends.length][friends.length];
            int[][] receive = new int[friends.length][friends.length];
            int[] arr = new int[friends.length];
            for(int i =0;i<gifts.length;i++){
                String[] srr = gifts[i].split(" ");
                int x = getPoint(srr[0],friends);
                int y = getPoint(srr[1],friends);
                send[x][y]+=1;
                receive[y][x]+=1;
            }
            print(send);
            System.out.println();
            print(receive);

            for(int i=0;i<send.length;i++){
                for(int j=i;j<send[i].length;j++){
                    if(i==j) continue;
                    if((send[i][j]!=0||send[j][i]!=0)&&send[i][j]!=send[j][i]){
                        if(send[i][j]>send[j][i]){
                            arr[i]++;
                        }else if(send[i][j]<send[j][i]){
                            arr[j]++;
                        }
                    }else if((send[i][j]==0&&send[j][i]==0)||send[i][j]==send[j][i]){

                            int ic = getCount(send,receive,i);
                            int jc = getCount(send,receive,j);
                            if(ic>jc){
                                arr[i]++;
                            }else if(jc>ic){
                                arr[j]++;
                            }
                    }
                }
            }
            int max = -1;
            for(int i=0;i<arr.length;i++){
                if(max<arr[i]){
                    max=arr[i];
                }
            }
            System.out.println(Arrays.toString(arr));
            return max;
    }

    private static int getCount(int[][] send, int[][] receive, int i) {
        int s = 0;
        for(int x=0;x<send[i].length;x++){
            s+=send[i][x];
        }
        int r = 0;
        for(int x=0;x<receive[i].length;x++){
            r+=receive[i][x];
        }
        return s-r;
    }

    static void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }


    private static int getPoint(String s, String[] friends) {
        for(int i=0;i<friends.length;i++){
            if(s.equals(friends[i])){
                return i;
            }
        }
        return -1;
    }

}
