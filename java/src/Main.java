import java.util.ArrayList;
import java.util.Collections;

class Main {

    public static int solution(int coin, int[] cards) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<cards.length/3;i++){
            list.add(cards[i]);
        }
        Collections.sort(list);

        int n = -1;
        for(int i : cards){
            if(n<i){
                n=i;
            }
        }
        dfs(list,cards,cards.length/3,coin,n,1);
        return cnt;

    }
    static int cnt =1;

    static void dfs(ArrayList<Integer> list, int[] cards, int index, int coin,int n,int round){
        if(cnt<round){
            cnt = round;
        }


        if(list.size()<1||index>=cards.length) return;
        int a = cards[index];
        int b = cards[index+1];

        if(coin>=2){
            System.out.println("round : "+round+" "+ coin);
            getTwoCards(list,cards,index,coin-2,a,b,n,round+1);
        }
        if(coin>=1){
            System.out.println("round : "+round+" "+ coin);
            getOneCard(list,cards,index,coin-1,a,n,round+1);
            System.out.println("round : "+round+" "+ coin);
            getOneCard(list,cards,index,coin-1,b,n,round+1);
        }
        System.out.println("round : "+round+" "+ coin);
        getAnyCard(list,cards,index,coin,n,round+1);



    }

    private static void getAnyCard(ArrayList<Integer> list, int[] cards, int index, int coin, int n, int round) {
        if(list.size()<2) return;
        ArrayList<Integer> newList = new ArrayList<>(list); // 새로운 list 생성
        Collections.sort(newList);
        int start =0;
        int end = newList.size()-1;

        while(start<=end){
            if(newList.get(start)+newList.get(end)>n+1){
                end--;
            }else if(newList.get(start)+newList.get(end)<n+1){
                start++;
            }else{
                break;
            }
        }

        System.out.println("get Any Card "+newList);
        System.out.println(start+" "+end);
        if(start>=newList.size()) return;
        if(newList.get(start)+newList.get(end)<n+1) return;
        if(end<start){

            newList.remove(start);
            newList.remove(end);
        }else{
            newList.remove(end);
            newList.remove(start);

        }
        dfs(newList,cards,index+2,coin,n,round);
    }

    private static void getOneCard(ArrayList<Integer> list, int[] cards, int index, int coin, int a, int n, int round) {
        if(list.size()<1) return;
        ArrayList<Integer> newList = new ArrayList<>(list); // 새로운 list 생성
        newList.add(a);
        Collections.sort(newList);
        int start =0;
        int end = newList.size()-1;

        while(start<=end){
            if(newList.get(start)+newList.get(end)>n+1){

                end--;
            }else if(newList.get(start)+newList.get(end)<n+1){

                start++;
            }else{
                break;
            }
        }

        System.out.println("get One Card "+newList);
        System.out.println(start+" "+end);
        if(start>=newList.size()) return;
        if(newList.get(start)+newList.get(end)<n+1) return;
        System.out.println("성공");
        if(end<start){
            newList.remove(start);
            newList.remove(end);
        }else{
            newList.remove(end);
            newList.remove(start);

        }
        dfs(newList,cards,index+2,coin,n,round);
    }

    private static void getTwoCards(ArrayList<Integer> list, int[] cards, int index, int coin, int a, int b, int n,
                                    int round) {
        ArrayList<Integer> newList = new ArrayList<>(list); // 새로운 list 생성
        newList.add(a);
        newList.add(b);
        Collections.sort(newList);
        int start =0;
        int end = newList.size()-1;


        while(start<=end){
            if(newList.get(start)+newList.get(end)>n+1){

                end--;
            }else if(newList.get(start)+newList.get(end)<n+1){

                start++;
            }else{
                break;
            }
        }

        System.out.println("get Two Card "+newList);
        System.out.println(start+" "+end);
        if(start>=newList.size()) return;
        if(newList.get(start)+newList.get(end)<n+1) return;
        if(end<start){
            newList.remove(start);
            newList.remove(end);
        }else{
            newList.remove(end);
            newList.remove(start);

        }
        dfs(newList,cards,index+2,coin,n,round);
    }

    public static void main(String[] args) {
        int res = solution(4,new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
        System.out.println(res);
    }


}
