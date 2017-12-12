public class Pangram {

	private static boolean isPangram(String str) {
		boolean[] pangram = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				pangram[str.charAt(i) - 'A'] = true;
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				pangram[str.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < 26; i++)
			if (!pangram[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPangram("The quick brown fox jumps over the lazy dog") ? "The given string is Pangram" : "The given string is not a Pangram");
	}

}
