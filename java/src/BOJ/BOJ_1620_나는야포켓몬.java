package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> keyName = new HashMap<>();
        HashMap<Integer, String> keyNumber = new HashMap<>();
        for(int i=1;i<=N;i++){
            String s = br.readLine();
            keyName.put(s,i);
            keyNumber.put(i,s);
        }
        for(int i=0;i<M;i++){
            String s = br.readLine();
            char a = s.charAt(0);
            if(a>=48&&a<=57){
                System.out.println(keyNumber.get(Integer.parseInt(s)));
            }else{
                System.out.println(keyName.get(s));
            }

        }


    }

}