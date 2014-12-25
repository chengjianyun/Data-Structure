package personal.jianyun.algo;

import java.awt.List;
import java.awt.print.Printable;
import java.util.ArrayList;

import javax.swing.JMenu;

public class Recursion {
	public void fullPermutation(int n, int start, char[] s) {
		if (start >= n)
			System.out.println(s);

		for (int i = start; i < n; i++) {
			char temp = s[i];
			s[i] = s[start];
			s[start] = temp;
			fullPermutation(n, start + 1, s);
			temp = s[i];
			s[i] = s[start];
			s[start] = temp;
		}
	}

	public static void combine(char[] cs, int begin, int number,
			ArrayList<Character> list) {
		if (number == 0) {
			System.out.println(list.toString());
			return;
		}
		if (begin + number > cs.length) {
			return;
		}
		list.add(cs[begin]);
		combine(cs, begin + 1, number - 1, list);
		list.remove((Character) cs[begin]);
		combine(cs, begin + 1, number, list);
	}

	public static int getLIS(int[] a, int len) {
		int[] count = new int[len];
		count[0] = 1;
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] <= a[i] && count[j] >= max) {
					max = count[j] + 1;
				}
			}
			count[i] = max;
		}
		for (int i = 0; i < len; i++) {
			if (count[i] > max)
				max = count[i];
		}
		return max;
	}
}
