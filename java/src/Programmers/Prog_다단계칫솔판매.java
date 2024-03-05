package Programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Prog_다단계칫솔판매 {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
            new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
            new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10})));

    }

        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            Map<String, String> map = new HashMap<>();
            Map<String, Integer> moneyMap = new HashMap<>();

            for(int i=0;i<enroll.length;i++){
                map.put(enroll[i],referral[i]);
                moneyMap.put(enroll[i],0);
            }

            for(int i=0;i<seller.length;i++){
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(seller[i],amount[i]*100));
                while(!q.isEmpty()){
                    Node n = q.poll();

                    String name = n.name;
                    if(name.equals("-")) break;

                    int m = moneyMap.get(n.name);
                    if(n.money<10) {
                        moneyMap.put(n.name,m+n.money);
                        break;
                    }
                    else{
                        moneyMap.put(n.name,m+n.money-(n.money/10));
                    }
                    q.add(new Node(map.get(n.name),n.money/10));

                }

            }

            for(int i=0;i<answer.length;i++){
                answer[i] = moneyMap.get(enroll[i]);
            }

            return answer;
        }
        static class Node{
            String name;
            int money;
            public Node(String name, int money){
                this.name=name;
                this.money=money;
            }
            public String toString(){
                return name + " "+ money;
            }
        }
    }


