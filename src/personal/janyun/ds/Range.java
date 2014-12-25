package personal.janyun.ds;

public class Range {
	float start;
	float end;

	public static void sort(Range[] ranges, int start, int end) {
		if (start < end) {
			int[] pars = partriton(ranges, start, end);
			sort(ranges, start, pars[0]);
			sort(ranges, pars[1] + 1, end);
		}
	}

	public static int[] partriton(Range[] ranges, int start, int end) {
		int i = start, j = start - 1, k = start - 1;
		int[] range_index = new int[2];
		Range pivot = new Range();
		pivot.start = ranges[end].start;
		pivot.end = ranges[end].end;
		for (; i < end; i++) {
			// 有交集，则认为已经排好序，取交集
			if ((ranges[i].end > pivot.start && ranges[i].end <= pivot.end)
					|| (ranges[i].start >= pivot.start && ranges[i].start < pivot.end)) {
				if (pivot.end > ranges[i].end)
					pivot.end = ranges[i].end;

				if (pivot.start > ranges[i].start)
					pivot.start = ranges[i].start;

				Range tmp = ranges[i];
				ranges[i] = ranges[k + 1];
				ranges[k + 1] = tmp;
				k++;
			} else if (ranges[i].end < pivot.start) {
				Range tmp = ranges[j + 1];
				ranges[j + 1] = ranges[k + 1];
				ranges[k + 1] = tmp;
				k++;
				tmp = ranges[j + 1];
				ranges[j + 1] = ranges[i];
				ranges[i] = tmp;
				j++;
			}
		}

		Range tmp = ranges[end];
		ranges[end] = ranges[k + 1];
		ranges[k + 1] = tmp;
		k++;

		range_index[0] = j;
		range_index[1] = k;
		return range_index;
	}
}
