import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hpe {
	static final int no_of_chars = 256;

	static String findSubString(String str, String pat) {
		int start = 0;
		int start_index = -1;
		int min_len = Integer.MAX_VALUE;
		int count = 0;
		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];
		if (str.length() < pat.length()) {
			System.out.println("No such window exists");
			return "";
		}

		for (int i = 0; i < pat.length(); i++)
			hash_pat[pat.charAt(i)]++;

		for (int j = 0; j < str.length(); j++) {
			hash_str[str.charAt(j)]++;
			if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			// If all the characters are matched
			if (count == str.length()) {

				// Try to minimize the window
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		return str.substring(start_index, start_index + min_len);
	}

	public static String smallestWindow(String s, String p) {
		// Your code here
		if (s.isEmpty() || p.isEmpty())
			return "-1";

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int i = 0, j = 0, count = map.size();
		int left = 0, right = 0, min = s.length();
		boolean found = false;

		while (j < s.length()) {
			char endchar = s.charAt(j++);
			if (map.containsKey(endchar)) {
				map.put(endchar, map.get(endchar) - 1);
				if (map.get(endchar) == 0)
					count -= 1;
			}
			if (count > 0)
				continue;

			while (count == 0) {
				char strchar = s.charAt(i++);
				if (map.containsKey(strchar)) {
					map.put(strchar, map.get(strchar) + 1);
					if (map.get(strchar) > 0)
						count += 1;
				}
			}
			if ((j - i) < min) {
				left = i - 1;
				right = j;
				min = j - i;

				found = true;
			}
		}
		return !found ? "-1" : s.substring(left, right);
	}

	// Function
	static String Minimum_Window(char[] s, char[] t) {

		int m[] = new int[256];

		// Answer
		int ans = Integer.MAX_VALUE; // length of ans
		int start = 0; // starting index of ans
		int count = 0;
		// creating map
		for (int i = 0; i < t.length; i++) {
			if (m[t[i]] == 0)
				count++;
			m[t[i]]++;
		}

		// References of Window
		int i = 0;
		int j = 0;

		// Traversing the window
		while (j < s.length) {

			// Calculations
			m[s[j]]--;
			if (m[s[j]] == 0)
				count--;

			// Condition matching
			if (count == 0) {
				while (count == 0) {

					// Sorting ans
					if (ans > j - i + 1) {
						ans = Math.min(ans, j - i + 1);
						start = i;
					}

					// Sliding I
					// Calculation for removing I
					m[s[i]]++;
					if (m[s[i]] > 0)
						count++;

					i++;
				}
			}
			j++;
		}

		if (ans != Integer.MAX_VALUE)
			return String.valueOf(s).substring(start, ans + start);
		else
			return "-1";
	}

	// Driver Method
	public static void main(String[] args) {
		extracted();
		extracted1();
		extracted2();
	}

	private static void extracted2() {
		String str = "this is a test string";
		String pat = "tist";

		System.out.println(Minimum_Window(str.toCharArray(), pat.toCharArray()));
	}

	private static void extracted1() {
		String str = "this is a test string";
		String pat = "tist";

		System.out.println(smallestWindow(str, pat));
	}

	private static void extracted() {
		String str = "this is a test string";
		String pat = "tist";

		System.out.println(findSubString(str, pat));
	}

}
