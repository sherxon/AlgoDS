public class Anagram {

	private static boolean isAnagram(String str1, String str2) {
		
		if (str1.length() != str2.length())
			return false;

		int[] str1Characters = new int [256];
		int[] str2Characters = new int [256];

		for (int i = 0; i < str1.length(); i++) {
			++str1Characters[str1.charAt(i)];
			++str2Characters[str2.charAt(i)];
		}

		for (int i = 0; i < 256; i++)
			if (str1Characters[i] != str2Characters[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("LISTEN", "SILENT") ? "The given strings are Anagram of each other" : "The given strings are not Anagram of each other");
	}

}
