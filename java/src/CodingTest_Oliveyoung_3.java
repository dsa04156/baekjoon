import java.util.ArrayList;
import java.util.List;

public class CodingTest_Oliveyoung_3 {

	public static void main(String [] args) {
		String[][] folders = {{"animal","root"},{"fruit","root"}};
		String[][] files = {{"cat","1B","animal"},{"dog","2B","animal"},
								{"apple","4B","fruit"}};
		String[] selected = {"animal"};
		String[] excepted = {"apple"};
		solution(folders, files, selected,excepted);
	}
	static int[] solution(String[][] folders,String[][] files, String[] selected,String[] excepted) {
		int[] answer = {};
		String s = folders[0][1];
		
		ArrayList<List<String>> list = new ArrayList<>();
		
		for(int i=0;i<folders.length;i++) {
			list.add(new ArrayList<>());
		}
		int[][] arr = new int[folders.length][folders.length];
		for(int i=0;i<folders.length;i++) {
			for(int j=0;j<folders.length;j++) {
				if(i==0&&folders[j][1].equals("root")) {
					arr[i][j]=1;
				}
				if(i>0&&folders[j][1].equals(arr));
			}
		}
		

		
		return answer;
		
	}
	
}
