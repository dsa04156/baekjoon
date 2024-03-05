import java.io.IOException;
import java.util.*;



public class test {
	
    public static void main(String[] args) throws IOException
    {
    	Solution s = new Solution();
    	int[][] dice = new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
		Queue<Integer> q = new LinkedList<>();

    	System.out.println(Arrays.toString(s.solution(dice)));
    	
    }
    static class Solution {
    	static boolean[] v;
    	static int n;
    	static int maxWin;
    	static int[] res;

        static void chooseDice(int idx,int cnt,int[][] dice) {
        	if(cnt==n/2) {
        		ArrayList<Integer> list1 = new ArrayList<Integer>();
        		ArrayList<Integer> list2 = new ArrayList<Integer>();

        		for(int i=0;i<n;i++) {
        			if(v[i])
        				list1.add(i);

        			else
        				list2.add(i);
        		}
        		if(list1.size()!=n/2) return;
        		ArrayList<Integer> resultList1 = new ArrayList<Integer>();
        		ArrayList<Integer> resultList2 = new ArrayList<Integer>();
        		rollDice(dice, list1,resultList1, n/2,0,0);
        		rollDice(dice, list2,resultList2, n/2,0,0);

        		Collections.sort(resultList1);
        		Collections.sort(resultList2);
        		int win = 0;
        		int c=0;
//	탐색 방법 바꾸기
//        		for(int i=0;i<resultList1.size();i++) {
//        			for(int j=0;j<resultList2.size();j++) {
//        				if(resultList1.get(i)<=resultList2.get(j)) {
//        					win += j;
//        					break;
//        				}else if(j==resultList2.size()-1) {
//        					win+=j+1;
//        				}
//        			}
//        		}
        		for(int i=0;i<resultList1.size();i++) {
        			int x =0 ;
        			int y =resultList2.size();
        			while(x<y) {
        				int n = (x+y)/2;
        				if(resultList1.get(i)>resultList2.get(n)) {
        					x = n+1;
        				}else {
        					y = n;
        				}
        			}
        			win += x;

        		}
        		if(win>maxWin) {
        			maxWin = win;
        			for(int i=0;i<list1.size();i++) {
        				res[i]=list1.get(i)+1;
        			}
        		}
        		return;
        	}
        	if(idx==n) return;
        	v[idx]=true;
        	chooseDice(idx + 1,cnt+1, dice);
        	v[idx]=false;
        	chooseDice(idx + 1,cnt, dice);
        }

        static void rollDice(int[][] dice, ArrayList<Integer> list,ArrayList<Integer> resultList,int n,int k, int sum) {
        	if(k==n) {
        		resultList.add(sum);
        		return;
        	}
        	int x = list.get(k);
        	for(int i=0;i<dice[x].length;i++) {
        		rollDice(dice, list, resultList, n, k+1, sum+dice[x][i]);
        	}

        }
        
        public int[] solution(int[][] dice) {
            n = dice.length;
            v=new boolean[n];
            maxWin=0;
            res = new int[n/2];
            chooseDice(0,0,dice);
            return res;
        }
       
    }
}

	