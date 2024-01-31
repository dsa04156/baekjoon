package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class HSAT_7회_정기코딩인증평가기출_순서대로방문하기 {


    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] course = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            course[i][0] = x - 1;
            course[i][1] = y - 1;
        }
        res = 0;
        boolean[][] v = new boolean[n][n];
        v[course[0][0]][course[0][1]] = true;
        dfs(arr, course, v, course[0][0], course[0][1], 1, m);
        System.out.println(res);
    }

    static void dfs(int[][] arr, int[][] course, boolean[][] v, int x, int y, int cnt, int m) {
        if (cnt == m) {
            res++;
            return;
        }
        for (int c = 0; c < 4; c++) {
            int nx = x + dx[c];
            int ny = y + dy[c];
            if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) continue;
            if (v[nx][ny]) continue;
            if (arr[nx][ny] == 1) continue;
            v[nx][ny] = true;
            if (nx == course[cnt][0] && ny == course[cnt][1]) {
                dfs(arr, course, v, nx, ny, cnt + 1, m);
            } else {
                dfs(arr, course, v, nx, ny, cnt, m);
            }
            v[nx][ny] = false;
        }

    }
}

