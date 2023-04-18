package algo;

public class KAKAO_CodingTestStudy_Fail {
	static int res=0;
	public static void main(String[] args) {
		solution(10,10,new int[][] {{10,15,2,1,2},{20,20,3,3,4}});
	}
	public static int solution(int alp, int cop, int[][] problems) {
		int max_a = 0;
		int max_c = 0;
				
		for(int i=0;i<problems.length;i++) {
			if(max_a<problems[i][0]) {
				max_a=problems[i][0];
			}
			if(max_c<problems[i][1]) {
				max_c=problems[i][1];
			}
		}
		
        int answer = 0;
        return answer;
    }
	
}
