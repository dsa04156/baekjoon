package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BookStack {

    private static final int MAX_BOOKS = 6;

    public static int getMinimumForce(int[] orders) {
        int[][] force = new int[MAX_BOOKS][MAX_BOOKS];

        for (int i = 0; i < MAX_BOOKS; i++) {
            for (int j = 0; j < MAX_BOOKS; j++) {
                if (i == j) {
                    force[i][j] = 0;
                } else {
                    force[i][j] = orders[j] * (i + 1);
                }
            }
        }

        for (int i = 1; i < MAX_BOOKS; i++) {
            for (int j = 0; j < MAX_BOOKS; j++) {
                for (int k = 0; k < j; k++) {
                    force[i][j] = Math.min(force[i][j], force[i - 1][k] + force[0][j - k]);
                }
            }
        }

        int minForce = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_BOOKS; i++) {
            minForce = Math.min(minForce, force[MAX_BOOKS - 1][i]);
        }

        return minForce;
    }

    public static void main(String[] args) {
        int[] orders = {1, 2, 1, 3, 3, 2};
        System.out.println(getMinimumForce(orders));
    }

}




