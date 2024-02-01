package Programmers;

import java.io.IOException;
import java.util.ArrayList;

class Prog_표병합 {


    static int[] parent;
    static String[] value;

    public static void main(String[] args) throws IOException {
        solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});


    }

    static void print() {
        System.out.println();
        for (int i = 0; i < 16; i++) {
            if (i >= 4 && i % 4 == 0)
                System.out.println();
            System.out.print(value[i] + " ");

        }
        System.out.println();
    }

    public static String[] solution(String[] commands) {

        parent = new int[2501];
        value = new String[2501];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            value[i] = "EMPTY";
        }
        for (int i = 0; i < commands.length; i++) {
            String[] srr = commands[i].split(" ");

            // print();


            if (srr[0].equals("UPDATE")) {
                if (srr.length == 4) {
                    int idx = convert(srr[1], srr[2]);
                    value[find(idx)] = srr[3];
                } else {
                    for (int x = 0; x < value.length; x++) {
                        if (value[x].equals(srr[1]))
                            value[x] = srr[2];
                    }
                }

            } else if (srr[0].equals("MERGE")) {
                int idx1 = convert(srr[1], srr[2]);
                int idx2 = convert(srr[3], srr[4]);
                if (find(idx1) == find(idx2)) continue;
                String s = "";
                if (value[find(idx1)].equals("EMPTY")) {
                    s = value[find(idx2)];
                } else {
                    s = value[find(idx1)];
                }
                value[find(idx2)] = "EMPTY";
                value[find(idx1)] = "EMPTY";
                union(find(idx1), find(idx2));

                value[find(idx1)] = s;


            } else if (srr[0].equals("UNMERGE")) {
                int idx = convert(srr[1], srr[2]);
                String s = value[find(idx)];
                value[find(idx)] = "EMPTY";
                ArrayList<Integer> dlist = new ArrayList<>();
                for (int a = 0; a < 2501; a++) {
                    if (find(a) == find(idx)) {
                        dlist.add(a);
                        value[a] = "EMPTY";
                    }
                }
                for (Integer x : dlist) {
                    parent[x] = x;
                }
                value[idx] = s;

            } else if (srr[0].equals("PRINT")) {
                int idx = convert(srr[1], srr[2]);
                list.add(value[find(idx)]);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static int convert(String a, String b) {
        int x = Integer.parseInt(a) - 1;
        int y = Integer.parseInt(b);
        return x * 50 + y;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }

    }
}



