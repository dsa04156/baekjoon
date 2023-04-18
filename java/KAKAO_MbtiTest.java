package algo;

import java.util.Arrays;

public class KAKAO_MbtiTest {

	public static void main(String[] args) {
		solution(new String[]{},new int[] {});
	}
	 static String solution(String[] survey, int[] choices) {
		 	int[] Point = new int[] {0,1,2,3};
		 	int[] res = new int[8];
		 	char[] mbti = new char[] {'R','T','C','F','J','M','A','N'};
		 	for(int i=0;i<survey.length;i++) {
		 		String a = survey[i];
		 		char a1 = a.charAt(0);
		 		char a2 = a.charAt(1);
		 		int  c = choices[i]%4;
		 		if(choices[i]>4) {
		 			for(int j=0;j<8;j++) {
		 				if(a2==mbti[j]) {
		 					res[j]+=c;
		 					break;
		 				}
		 			}
		 		}
		 		else if(choices[i]<4) {
		 			for(int j=0;j<8;j++) {
		 				if(a1==mbti[j]) {
		 					res[j]+=Math.abs(c-4);
		 					break;
		 				}
		 			}
		 		}
		 		else {
		 			
		 		}
		 	}
		 	String answer = "";
		 	for(int i=0;i<8;i+=2) {
		 		if(res[i]>res[i+1]) {
		 			answer+=mbti[i];
		 		}
		 		else if(res[i]<res[i+1]) {
		 			answer+=mbti[i+1];
		 		}
		 		else {
		 			if(mbti[i]<mbti[i+1]) {
		 				answer+=mbti[i];
		 			}
		 			else {
		 				answer+=mbti[i+1];
		 			}
		 		}
		 	}
		 	System.out.println(answer);
	        return answer;
	    }
}