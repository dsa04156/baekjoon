import java.util.*;
class 코테2ㅈ번 {
	public static void main(String[] args) {
		solution(new String[]{"sofa red long", "blanket red long cheap"
				+ "", "towel red",
				"mattress long blue", "curtain blue long cheap"},new String[]{"towel", 
						"mattress", "curtain"});
	}
	static  ArrayList<List<String>> notPurchased;
	static List<Map.Entry<String, Integer>> sortedMap;
    public static String solution(String[] products, String[] purchased) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        notPurchased = new ArrayList<>();
        int k = products.length-purchased.length;
        boolean isPurchased = false;
        for(int i=0;i<products.length;i++){
            String s = products[i];
            String srr[] = s.split(" ");
            for(int j=1;j<srr.length;j++){
                map.put(srr[j],0);
            }
            for(int j=0;j<purchased.length;j++){
                 if (srr[0].equals(purchased[j])) {
                    isPurchased = true;
                    break;
                }
            }
            if (!isPurchased) {
                notPurchased.add(new ArrayList<>(Arrays.asList(srr)));
            }
        }
        System.out.println(notPurchased);


        for(int i=0;i<products.length;i++){
            String[] srr = products[i].split(" ");
            String s = srr[0];
            for(int j=0;j<purchased.length;j++){
                if(purchased[j].equals(s)){
                    for(int x=1;x<srr.length;x++){
                        map.put(srr[x],map.get(srr[x])+1);
                    }
                    break;
                }
            }
        }
        sortedMap = new LinkedList<>(map.entrySet());
        sortedMap.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        System.out.println(sortedMap);
      
     
     
        dfs();
        answer = srr[0];
        System.out.println(answer);
        return answer;
    }
    static ArrayList<Node> point;
    static String[] srr;
    static void dfs(){
        point = new ArrayList<>();
        int w=-1;
        for(int i=0;i<notPurchased.size();i++){
            int max = -1;
            for(int j=1;j<notPurchased.get(i).size();j++){
                for(int x = 0;x<sortedMap.size();x++){
                    String s = notPurchased.get(i).get(j);                    
                    if(s.equals(sortedMap.get(x).getKey())){
                    	if(max<sortedMap.get(x).getValue()) {
                    		max = sortedMap.get(x).getValue();
                    		w = j;
                    	}
                        
                    }
                }
            }
            point.add(new Node(i,w,max));
        }
        
        
        
        int mm = -1;
        for(int i=0;i<point.size();i++){
            mm = Math.max(mm,point.get(i).point);
        }
        ArrayList<Integer> removeList = new ArrayList<>();
        for(int i=0;i<point.size();i++){
            if(mm!=point.get(i).point){
                removeList.add(i);
            }
        }
        System.out.println(notPurchased);
        System.out.println(point.toString());
        for(int i=0;i<point.size();i++) {
        	if(point.get(i).point==-1) continue;
        	notPurchased.get(point.get(i).x).remove(point.get(i).y);
        }
        
        System.out.println("123"+notPurchased);
        for(int i=0;i<removeList.size();i++) {
        	int a =removeList.get(i);
        	notPurchased.remove(a);
        }
        System.out.println("rrrr"+notPurchased);
        srr = new String[notPurchased.size()];
        if(notPurchased.size()==1) {
        	System.out.println("end1");
        	srr[0]=notPurchased.get(0).get(0);
        	return;
        }else if(notPurchased.get(0).size()==1) {
        	//정렬하고 리턴
        	for(int i=0;i<srr.length;i++) {
        		srr[i]=notPurchased.get(i).get(0);
        	}
        	Arrays.sort(srr);
        	return;
        	
        }else {
        	dfs();
        }

    }
    static class Node{
    	int x;
    	int y;
    	int point;
    	public Node(int x,int y,int point) {
    		this.x=x;
    		this.y=y;
    		this.point=point;
    	}
    	public String toString() {
    		return x + " "+y+" " + point;
    	}
    }
    
}