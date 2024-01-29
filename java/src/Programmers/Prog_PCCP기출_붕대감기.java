package Programmers;

class Prog_PCCP기출_붕대감기 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{5,1,5},4,new int[][]{{1,1},{2,3}}));

    }

    public static int solution(int[] bandage, int health, int[][] attacks) {

        int time=1;
        int nowHealth = health;
        int bandageTime=0;
        for(int i=0;i<attacks.length;i++){


            while(time!=attacks[i][0]){
                bandageTime++;

                if(nowHealth<health){
                    nowHealth+=bandage[1];
                    if(bandageTime==bandage[0]){
                        nowHealth+=bandage[2];
                        bandageTime=0;
                    }
                }
                if(nowHealth>health) nowHealth = health;

                time++;

            }
            bandageTime=0;
            nowHealth-=attacks[i][1];
            if(nowHealth<=0) return -1;

            time++;
        }

        return nowHealth;
    }


    }
