import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(123);
        System.out.println(solution(0,5,30,0,7,0));

    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int nowH = h1;
        int nowM = m1;
        int nowS = s1;
        boolean flagM = false;
        boolean flagH = false;
        if(m1<s1){
            flagM=true;
        }
        if(h1<s1){
            flagH=true;
        }

        int cnt=0;
        while(nowH == h2 && nowM == m2 && nowS == s2){
            System.out.println(11111111);
            if(nowS==60){
                nowS=0;
                nowM++;
                flagM=false;
                flagH=false;
                if(nowM==60){
                    nowM=0;
                    nowH++;
                    if(nowH==12){
                        nowH=0;
                    }
                }
            }
            if(flagM==false&&nowM<=nowS){
                cnt++;
                flagM=true;
            }
            if(flagH==false&&nowH<=nowS){
                cnt++;
                flagH=true;
            }
            nowS++;
            System.out.println(nowH+" "+nowM+" " +nowS);
        }
        System.out.println(cnt);
        return cnt;
    }


    }
