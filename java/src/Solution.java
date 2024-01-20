import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
}
    public static String[] solution(String[][] tickets) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(map.get(start)==null){
                map.put(start,new ArrayList<>());
            }
            map.get(start).add(end);
        }
       res = new String[tickets.length+1];
        for(String s : map.keySet()){
            if(map.get(s).size()>1){
                Collections.sort(map.get(s));
            }
        }
        int k = tickets.length;
        check=false;
        res[0]="ICN";
        String[] answer = new String[k+1];
        answer[0]="ICN";
        sol("ICN",map,k,0,answer);
        return res;
    }
    static String res[];
    static boolean check;
    static void sol(String start, Map<String, ArrayList<String>> map, int k, int cnt,String[] answer){
        if(check) return;

        if(map.get(start)== null||map.get(start).size()==0){
            for(String s : map.keySet()){
                for(String d : map.get(s)){
                    if(d!=null) {

                        return;

                    }
                }
            }
            check=true;
            for(int i=0;i<res.length;i++){
                res[i]=answer[i];
            }
            return;
        }
        for(int i=0;i<map.get(start).size();i++){
            String des = map.get(start).get(i);
            map.get(start).remove(des);
            answer[cnt+1] = des;
            sol(des,map,k,cnt+1,answer);
            map.get(start).add(i,des);

        }
    }


}
