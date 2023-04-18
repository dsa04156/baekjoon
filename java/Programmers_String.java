package algo;

public class Programmers_String {

	public static void main(String[] args) {
		solution("try hello world");
	}
    public static String solution(String s) {
    	String answer = "";
    	int cnt =0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)==' ') {
    			cnt=0;
    			answer+=" ";
    			continue;
    		}
    		if(cnt%2==0) {
    			char a=s.charAt(i);
    			String b ="";
    			b+=a;
    			answer+= b.toUpperCase();
    		}
    		else {
    			char a=s.charAt(i);
    			String b ="";
    			b+=a;
    			
    			answer+= b.toLowerCase();
    		}
    		cnt++;
    	   
    	}
    	System.out.println(answer);
    	
        return answer;
    }

}
