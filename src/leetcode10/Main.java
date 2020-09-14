package leetcode10;

public class Main {
	public static void main(String[] args) {
		// text
		String s = "aab";
		
		// patterns
		String p = "c.*";
		
		System.out.println("s: " + s + " p: " + p);
		
		CheckIfMatchesFunction solution = new CheckIfMatchesFunction();
		
		System.out.println(solution.isMatch(s, p));
	}
}
