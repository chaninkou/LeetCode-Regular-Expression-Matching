package leetcode10;

public class CheckIfMatchesFunction {
	// Runtime O(m + n) where number of elements in s and n is the number of elements in p
	public boolean isMatch(String s, String p) {
		// Dynamic programming
		// s is the text
		// p is the patterns
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		// Empty string is equal to empty string
		dp[0][0] = true;

		// Make any patterns to true if * for the previous previous element
		for (int j = 1; j < dp[0].length; j++) {
			if (p.charAt(j - 1) == '*') {
				// Since a* could be nothing, if previous is empty character too
				dp[0][j] = dp[0][j - 2];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// Condition 1: check if they are equal or pattern is . (. could be any letters)
				if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
					// Check if previous is true
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') { // Condition 2, if its * (* could be nothing or repeat the previous element)
					// aa* = a
					dp[i][j] = dp[i][j - 2];

					// condition 3: if previous element is . or s and p (element before *) are both equal to each other
					if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
						dp[i][j] = dp[i - 1][j] || dp[i][j];
					}
				} else { // Don't really need this since the array is already false default
					dp[i][j] = false;
				}
			}
		}

		// This will show if its match or not
		return dp[s.length()][p.length()];
	}
}
