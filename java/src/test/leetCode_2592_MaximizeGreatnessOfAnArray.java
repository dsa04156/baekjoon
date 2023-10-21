package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetCode_2592_MaximizeGreatnessOfAnArray {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

//        int[] arr = new int[]{1, 3, 5, 2, 1, 3, 1};
//            int n = arr.length;
//            int[] sortedArr = Arrays.copyOf(arr, n);

            // 배열을 정렬
//            Arrays.sort(sortedArr);

//            int greatness = 0;
        int n = 100000; // 최대 n 값
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i); // 최대 arr[i] 값
        }
      
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(3);
//        arr.add(5);
//        arr.add(2);
//        arr.add(1);
//        arr.add(3);
//        arr.add(1);
        // 배열을 재배열하는 과정
        /* 1번풀이 - 투포인터*/
        Collections.sort(arr);
        int res=0;
        int left=0;
        int right=0;
        System.out.println(arr);
        while(right<arr.size()){
            if(left==right){
                right++;
                continue;
            }

            if(arr.get(left)<arr.get(right)){
                res++;
                left++;
                right++;
            }else{
                right++;
            }
        }
        System.out.println(res);













    }

}