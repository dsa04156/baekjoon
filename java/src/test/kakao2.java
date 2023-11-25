package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class kakao2 {

    public static int[] solution(int[][] dice) {
        // 주사위의 개수
        int n = dice.length;

        // A가 가져갈 수 있는 모든 주사위 조합
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                combinations.add(Arrays.asList(i + 1, j + 1));
            }
        }

        // A가 승리할 확률
        List<Double> winProbs = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            // A가 가져가는 주사위의 합
            int aSum = 0;
            for (int i : combination) {
                aSum += Arrays.stream(dice[i - 1]).max().getAsInt();
            }

            // B가 가져가는 주사위의 합
            int bSum = 0;
            for (int i = 0; i < n; i++) {
                if (!combination.contains(i + 1)) {
                    bSum += Arrays.stream(dice[i]).min().getAsInt();
                }
            }

            // A가 승리할 확률
            winProbs.add((double) (aSum - bSum) / Math.pow(6, n));
        }

        // A가 승리할 확률이 가장 높은 주사위 조합
        List<Integer> bestCombination = combinations.get(winProbs.indexOf(Collections.max(winProbs)));

        // A가 가져가는 주사위 번호
        int[] answer = new int[bestCombination.size()];
        for (int i = 0; i < bestCombination.size(); i++) {
            answer[i] = bestCombination.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(dice)));
    }
//    public static void main(String[] args) throws IOException {
//        int[] res = solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}});
//        System.out.println(Arrays.toString(res));
//    }
//
//    private static double maxProbability = 0;
//    private static int[] result;
//
//    public static int[] solution(int[][] dice) {
//        int n = dice.length;
//        int halfN = n / 2;
//        result = new int[halfN];
//
//        ArrayList<Integer> indexList = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            indexList.add(i);
//        }
//
//        getCombinations(dice, indexList, new ArrayList<>(), 0, halfN);
//
//        return result;
//    }
//
//    private static void getCombinations(int[][] dice, ArrayList<Integer> list, ArrayList<Integer> current, int start, int r) {
//        if (r == 0) {
//            double currentProbability = calculateWinningProbability(dice, current);
//            if (currentProbability > maxProbability) {
//                maxProbability = currentProbability;
//                result = convertArrayListToArray(current);
//            }
//            return;
//        }
//
//        for (int i = start; i < list.size(); i++) {
//            current.add(list.get(i));
//            getCombinations(dice, list, current, i + 1, r - 1);
//            current.remove(current.size() - 1);
//        }
//    }
//
//    private static double calculateWinningProbability(int[][] dice, ArrayList<Integer> combination) {
//        int halfN = combination.size();
//        ArrayList<Integer> bCombination = new ArrayList<>();
//        for (int i = 1; i <= dice.length; i++) {
//            if (!combination.contains(i)) {
//                bCombination.add(i);
//            }
//        }
//
//        double winCount = 0;
//        double totalCases = Math.pow(6, halfN * 2);
//
//        for (int i = 0; i < Math.pow(6, halfN); i++) {
//            ArrayList<Integer> aResults = getDiceResults(dice, combination, i, halfN);
//            for (int j = 0; j < Math.pow(6, halfN); j++) {
//                ArrayList<Integer> bResults = getDiceResults(dice, bCombination, j, halfN);
//                if (calculateTotalScore(aResults) > calculateTotalScore(bResults)) {
//                    winCount++;
//                }
//            }
//        }
//
//        return winCount / totalCases;
//    }
//
//    private static ArrayList<Integer> getDiceResults(int[][] dice, ArrayList<Integer> combination, int index, int halfN) {
//        ArrayList<Integer> results = new ArrayList<>();
//        for (int i = 0; i < halfN; i++) {
//            results.add(dice[combination.get(i) - 1][index % 6]);
//            index /= 6;
//        }
//        return results;
//    }
//
//    private static int calculateTotalScore(ArrayList<Integer> results) {
//        return results.stream().mapToInt(Integer::intValue).sum();
//    }
//
//    private static int[] convertArrayListToArray(ArrayList<Integer> list) {
//        int[] array = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
//        return array;
//    }

}
