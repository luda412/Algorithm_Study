package 백준.문자열조작;

import java.util.*;

public class 문자열압축 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        sc.nextLine(); // consume newline

        // Map to store the dictionary words with their corresponding index
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i <= K; i++) {
            String word = sc.nextLine();
            dictionary.put(word, i);
        }

        String S = sc.nextLine();
        int n = S.length();

        // Initialize DP array
        List<Integer>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(); // empty sequence for starting point

        for (int i = 0; i < n; i++) {
            if (dp[i] == null) continue; // skip if there's no way to reach this position

            for (int j = i + 1; j <= n; j++) {
                String substring = S.substring(i, j);
                if (dictionary.containsKey(substring)) {
                    int index = dictionary.get(substring);
                    if (dp[j] == null || isLexicographicallySmaller(dp[i], index, dp[j])) {
                        dp[j] = new ArrayList<>(dp[i]);
                        dp[j].add(index);
                    }
                }
            }
        }

        if (dp[n] == null) {
            System.out.println("impossible");
        } else {
            System.out.println(dp[n].size());
            for (int num : dp[n]) {
                System.out.print(num + " ");
            }
        }
    }

    private static boolean isLexicographicallySmaller(List<Integer> list, int num, List<Integer> otherList) {
        int size = Math.min(list.size() + 1, otherList.size());
        for (int i = 0; i < size; i++) {
            int val1 = (i < list.size()) ? list.get(i) : num;
            int val2 = otherList.get(i);
            if (val1 != val2) {
                return val1 < val2;
            }
        }
        return list.size() + 1 < otherList.size();
    }
}
