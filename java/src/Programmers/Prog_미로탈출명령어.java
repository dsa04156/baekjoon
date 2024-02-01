package Programmers;

import java.io.IOException;
import java.util.ArrayList;

class Prog_미로탈출명령어 {


    static int[] parent;
    static String[] value;
    static int[][] arr;
    static ArrayList<String> list;
    static String answer;
    static int[] dx = new int[]{1, 0, 0, -1};
    static int[] dy = new int[]{0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        solution(3, 4, 2, 3, 3, 1, 5);


    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        list = new ArrayList<>();
        arr = new int[n][m];

        int distance = Math.abs(x - r) + Math.abs(c - y);
        if ((k - distance) % 2 == 1 || k < distance) return "impossible";
        dfs(x - 1, y - 1, r - 1, c - 1, k, 0, "");
        if (answer == null) return "impossible";


        return answer;
    }

    static int getDistance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(c - y);
    }

    static void dfs(int x, int y, int r, int c, int k, int cnt, String dir) {
        if (!answer.equals("")) {
            return;
        }
        if ((((k - cnt) - getDistance(x, y, r, c)) % 2) == 1 || (k - cnt) < getDistance(x, y, r, c)) {
            return;
        }
        if (cnt > k) return;

        if (x == r && y == c && cnt == k) {
            answer = dir;
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;
            String s = "";
            if (d == 0) s = "d";
            else if (d == 1) s = "l";
            else if (d == 2) s = "r";
            else if (d == 3) s = "u";
            dfs(nx, ny, r, c, k, cnt + 1, dir + s);
        }
    }
}




