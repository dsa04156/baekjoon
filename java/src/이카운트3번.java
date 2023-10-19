/* package 구문을 넣으면 안됩니다 */
import java.util.*;
import java.io.*;

public class 이카운트3번{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {   
    	String input = br.readLine();
    	ArrayList<String> list = new ArrayList<>();
    	for(int i=0;i<input.length();i++) {
    		if(input.charAt(i)=='[') {
    			String s = input.substring(i+2,input.length());
    			String k = "";
    					
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)==']') {
						break;
					}
					if(s.charAt(j)==' ') continue;
					k+=s.charAt(j);
				}
				String[] srr= k.split(",");
				for(int j=0;j<srr.length;j++) {
					if(list.contains(srr[j])) continue;
					list.add(srr[j]);
				}
    		}
    	}
//    	for(int i=0;i<list.size();i++) {
//    		input = input.replaceAll(list.get(i), String.valueOf(i+1));
//    		System.out.println(list.get(i));
//    	}
    	String res = input;
    	for(int i=0;i<input.length();i++) {
    		if(input.charAt(i)=='[') {
    			int k=0;
    			for(int j=i+1;j<input.length();j++) {
    				if(input.charAt(j)==']') {
    					k=j;
    					break;
    				}
    			}
    			String change = input.substring(i+1,k);
    			String before = input.substring(0,i+1);
    			String after = input.substring(k,input.length());
    			for(int j=0;j<list.size();j++) {
    				if(change.contains(" "+list.get(j)+",")) {
    					change = change.replace(" "+list.get(j)+","," "+String.valueOf(j+1)+",");
    				}else if(change.contains(" "+list.get(j)+" ")) {
    					change = change.replace(" "+list.get(j)+" "," "+String.valueOf(j+1)+" ");
    				}
    			}
    			ArrayList<Integer> sortList = new ArrayList<>();
    			String number = "";
    			for(int j=0;j<change.length();j++) {
    				if(change.charAt(j)==' ') continue;
    				if(change.charAt(j)==',') {
    					if(sortList.contains(Integer.parseInt(number))) continue;
    					sortList.add(Integer.parseInt(number));
    					number="";
    					continue;
    				}
    				number+=change.charAt(j);
    				if(j==change.length()-2) {
    					if(sortList.contains(Integer.parseInt(number))) continue;
    					sortList.add(Integer.parseInt(number));
    				}
    			}
    			Collections.sort(sortList);
    			change = ""; 
    			for(int j=0;j<sortList.size();j++) {
    				String s = sortList.get(j).toString();
    				if(j!=sortList.size()-1)
    					change+= " "+s+",";
    				else
    					change+=" "+s+" ";
    			}
    			res= before + change + after;
    			i=k-(input.length()-res.length());
    			input=res;
    		}
    	}
    	System.out.println(input);
    	
    	for(int i=0;i<list.size();i++) {
    		System.out.println("["+(i+1)+"]"+" "+list.get(i));
    	}
    	
    }
}