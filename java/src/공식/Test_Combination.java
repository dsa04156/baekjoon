package 공식;

import java.util.Arrays;

public class Test_Combination {
	static boolean[] used; // 먼저 호출된 재귀가 가져다 쓴 카드 정보 기록된 배열
	static String[] cards; // 순열에 사용되는 재료
	static String[] result; // 순열 시뮬레이션이 저장되는 배열

	public static void main(String[] args) {
		cards = new String[4];
		cards[0] = "A";
		cards[1] = "B";
		cards[2] = "C";
		cards[3] = "D";

		result = new String[2];
		used = new boolean[4];

		perm(0);
	}

	public static void perm(int idx) {
		if (idx == result.length) {
			// 오 result 다 채웠나본데? idx가 여기까지 왔어? 오키 시뮬 돌려
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < cards.length; i++) {
			if (used[i])
				continue; // 이미 사용중인 카드는 건너뛰기.

			result[idx] = cards[i]; // 건너뛰지 않았네? i번 카드 내 자리에 갖다놓자!
			used[i] = true; // 나 지금 i번 카드 쓰는중이다~~~
			perm(idx + 1); // 나 지금 카드하나 채웠으니까 다음 자리는 다음 쌍둥이가 알아서 채워라. 난 기다릴게.
			used[i] = false; // 드디어 내가 불렀던 쌍둥이가 퇴사했네. 나도 다음 작업을 하자.
		}
	}
}

