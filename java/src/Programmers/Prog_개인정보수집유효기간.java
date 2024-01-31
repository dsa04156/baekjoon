package Programmers;

import java.io.IOException;
import java.util.ArrayList;

class Prog_개인정보수집유효기간 {


    public static void main(String[] args) throws IOException {
        solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {

        String[] todayArr = today.split("\\.");
        int todayYear = Integer.parseInt(todayArr[0]);
        int todayMonth = Integer.parseInt(todayArr[1]);
        int todayDay = Integer.parseInt(todayArr[2]);
        String[][] tArr = new String[terms.length][2];
        for (int i = 0; i < terms.length; i++) {
            tArr[i] = terms[i].split(" ");
        }

        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] pArr = privacies[i].split(" ");
            int addMonth = 0;
            for (int j = 0; j < tArr.length; j++) {
                if (pArr[1].equals(tArr[j][0])) {
                    addMonth = Integer.parseInt(tArr[j][1]);
                    break;
                }
            }
            String[] sss = pArr[0].split("\\.");
            int pYear = Integer.parseInt(sss[0]);
            int pMonth = Integer.parseInt(sss[1]);
            int pDay = Integer.parseInt(sss[2]);
            pMonth += addMonth;
            while (pMonth > 12) {
                pMonth -= 12;
                pYear++;
            }
            if (todayYear > pYear) count.add(i + 1);
            else if (todayYear == pYear) {
                if (todayMonth > pMonth) count.add(i + 1);
                else if (todayMonth == pMonth) {
                    if (todayDay >= pDay) {
                        count.add(i + 1);
                    }
                }
            }
        }

        System.out.println(count);
        int[] answer = new int[count.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count.get(i);
        }
        return answer;

    }


}

