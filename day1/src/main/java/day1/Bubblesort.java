package day1;

import java.util.Iterator;
import java.util.Random;

public class Bubblesort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[100];

		for (int i = 0; i < 100; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("BEFORE");
		printArray(arr);
		bubbleSort(arr);
		System.out.println("AFTER");
		printArray(arr);
	}

	private static void bubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = 0; j < arr.length - i-1; j++) {
				if (arr[j] < arr[j+1]) {
					swap(j+1, j, arr);
				}
			}
		}

	}

	private static void swap(int i, int j, int[] arr) {
		// TODO Auto-generated method stub

		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];

	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
