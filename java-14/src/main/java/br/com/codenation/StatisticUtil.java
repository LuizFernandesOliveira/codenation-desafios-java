package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) Arrays.stream(elements).average().getAsDouble();
	}

	public  static int mode(int[] elements) {

		int moda = 0, quantity = 0, nextQuantity = 0;

		for (int element : elements) {
			nextQuantity = 0;
			for (int nextElement : elements) {
				if (element == nextElement) nextQuantity++;
				if (nextQuantity > quantity) {
					quantity = nextQuantity;
					moda = element;
				}
			}
		}
		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int middleIndex = (elements.length - 1) / 2;
		int firstMedian = elements[middleIndex];
		int secondMedian = elements[middleIndex + 1];
		if (elements.length % 2 == 0) {
			return (firstMedian + secondMedian) / 2;
		}
		return firstMedian;
	}
}