package personal.jianyun.algo;

public class ArrayAlgo {
	// 编程之美题目2.14
	public static int getMaxSubArray(int[] values, int length) {
		if (length <= 0) {
			return Integer.MIN_VALUE;
		}
		int allSum = values[0];
		int maxSum = values[0];
		for (int i = 1; i < length; i++) {
			allSum += values[i];
			if (allSum > maxSum) {
				maxSum = allSum;
			}
			if (values[i] > maxSum) {
				maxSum = values[i];
				allSum = values[i];
			}
		}
		return maxSum;
	}

	// 编程之美题目2.15
	public static int getMaxSubArrayOf2D(int[][] v, int rows, int colums) {
		int[] maxSum = new int[colums];
		int[] allSum = new int[colums];
		allSum[0] = v[0][0];
		maxSum[0] = v[0][0];
		Coordinate[] coordinates = new Coordinate[colums];
		coordinates[0].x = 0;
		coordinates[0].y = 0;

		int maxSumLeft = v[0][0];
		int allSumLeft = v[0][0];
		Coordinate coordinateLeft = new Coordinate();
		coordinateLeft.x = 0;
		coordinateLeft.y = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				if (j == 0 && i == 0)
					continue;

				// 每行开始时，初始化left值
				if (j == 0 && i > 0) {
					allSumLeft=0;
					maxSumLeft=0;
					coordinateLeft.x=coordinates[i-1].x;
					coordinateLeft.y=coordinates[i-1].y;
				}

				if (j > 0) {
					int allSumTemp = allSum[j - 1];
					for (int k = coordinates[j-1].y; k <= j; k++)
						allSumTemp += v[i][k];
					allSum[j] = allSumTemp;
				}

				if (i > 0) {
					for (int k = coordinateLeft.x; k <= i; k++)
						allSumLeft += v[k][j];
				}
				int max = maxSum[j - 1];
				if (max < maxSumLeft) {
					max = maxSumLeft;
				}
				if (max < allSum[j])
					max = allSum[j];
				if (max < allSumLeft)
					max = allSumLeft;
				if (max < v[i][j]) {
					max = v[i][j];
				}
				
				if(max == maxSum[j-1] || max==allSum[j]){
					coordinateLeft=coordinates[j]=coordinates[j-1];
				}else if(max==maxSumLeft || max==allSumLeft){
					coordinates[j]=coordinateLeft;
				}else{
					coordinateLeft.x=coordinates[j].x=i;
					coordinateLeft.y=coordinates[j].y=j;
				}
				maxSum[j]=max;
			}
		}

		return 0;
	}
	public static class Coordinate {
		int x, y;
	}
}
