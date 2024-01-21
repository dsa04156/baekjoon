package Programmers;

import java.util.ArrayList;

class Prog_n더하기1카드게임 {

    public static void main(String[] args) {

        System.out.println(solution(4,new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));

    }


    public static int solution(int coin, int[] cards) {
        int n = cards.length/3;
        int answer=0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> addList = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(cards[i]);
        }
        int target = cards.length+1;
        while(true){
            answer++;
            if(n>=cards.length) break;
            boolean flag = false;
            addList.add(cards[n]);
            addList.add(cards[n+1]);
            n+=2;
            for(int i : list){
                if(list.contains(target-i)){
                    Integer k = target - i;
                    Integer ii = i;
                    list.remove(k);
                    list.remove(ii);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(coin>0){
                    for(int i : list){
                        if(addList.contains(target-i)){
                            Integer k = target - i;
                            Integer ii = i;
                            addList.remove(k);
                            list.remove(ii);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag){
                if(coin>1){
                    for(int i : addList){
                        if(addList.contains(target-i)){
                            Integer k = target - i;
                            Integer ii = i;
                            addList.remove(k);
                            addList.remove(ii);
                            coin--;
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag)
                break;
        }
        return answer;
    }


    }
