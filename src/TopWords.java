import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopWords {

	public static List<String> top3(String s) {
		// Your code here
		int x = 0;
		int y = 0;
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals(" ") || s.substring(i, i + 1).equals(",")
					|| s.substring(i, i + 1).equals(".")) {
				y = i;
				if (i > 0) {
					if (s.substring(i - 1, i).equals(" ") || s.substring(i - 1, i).equals(",")
							|| s.substring(i - 1, i).equals(".")) {
					} else {
						words.add(s.substring(x, y));
					}
				}

				x = i + 1;
			}
		}
		HashMap<String, Integer> h = new HashMap<String, Integer>();

		for (String ss : words) {
			String test = ss;
			int f = 0;
			ArrayList<Integer> delete = new ArrayList<Integer>();
			for (int j = 0; j < words.size(); j++) {
				if (test.equalsIgnoreCase(words.get(j))) {
					f += 1;
					delete.add(j);
				}
			}
			for (int i : delete) {
				words.remove(delete);
			}
			h.put(test.toLowerCase(), f);

		}
		int maxsizes = 0;
		String maxkey1 = "err";
		if (h.size() > 0) {
			maxsizes += 1;
			int max1 = 0;

			for (String key : h.keySet()) {
				if (h.get(key) > max1) {
					max1 = h.get(key);
					maxkey1 = key;
				}
			}
			h.remove(maxkey1);
		}
		String maxkey2 = "err";
		if (h.size() > 1) {
			maxsizes += 1;
			int max2 = 0;

			for (String key : h.keySet()) {
				if (h.get(key) > max2) {
					max2 = h.get(key);
					maxkey2 = key;
				}
			}
			h.remove(maxkey2);
		}
		String maxkey3 = "err";
		if (h.size() > 2) {
			maxsizes += 1;
			int max3 = 0;

			for (String key : h.keySet()) {
				if (h.get(key) > max3) {
					max3 = h.get(key);
					maxkey3 = key;
				}
			}
			h.remove(maxkey3);
		}
		ArrayList<String> r = new ArrayList<String>();

		if (maxsizes == 0) {

		}
		if (maxsizes > 0) {
			r.add(maxkey1);

		}
		if (maxsizes > 1) {
			r.add(maxkey2);
		}
		if (maxsizes > 2) {
			r.add(maxkey3);
		}

		return r;

	}

	public static void main(String[] args) {
		System.out.println(top3(" e e e e e a a a b b b b l"));
	}
}