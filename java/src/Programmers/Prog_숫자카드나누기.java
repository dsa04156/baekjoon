package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Prog_숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int resA = a(arrayA,arrayB);
        int resB = a(arrayB,arrayA);
        answer = Math.max(resA,resB);
        System.out.println(answer);
        return answer;
    }
    static int a(int[] arrayA,int[] arrayB){
        ArrayList<Integer> list = new ArrayList<>();
        int k=2;
        while(k<=arrayA[0]){
            int cnt=0;
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i]%k==0){
                    cnt++;
                    continue;
                }else{
                    break;
                }
            }
            if(cnt==arrayA.length) {
                list.add(k);
            }
            k++;
        }
        int res =0;

        for(int i=0;i<list.size();i++){
            int cnt=0;
            for(int j=0;j<arrayB.length;j++){
                if(arrayB[j]%list.get(i)==0){
                    break;
                }else{
                    cnt++;
                }
            }
            if(cnt==arrayB.length){
                res = Math.max(res,list.get(i));
            }
        }

        return res;
    }

}