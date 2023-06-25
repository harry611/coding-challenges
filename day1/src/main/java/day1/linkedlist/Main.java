package day1.linkedlist;
/* package whatever; // don't place package name! */

import java.util.Random;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
	public static void main(String[] args) throws java.lang.Exception {
		int[] nums = { 9, 12 };
		int[] frequency = { 2, 3 };
		System.out.println("With Flat Array");
		System.out.println(approach1(nums, frequency));

		int[] nums1 = { 4, 5, 6, 7, 8 };
		int[] frequency1 = { 1, 2, 3, 5, 6 };

		System.out.println(approach1(nums1, frequency1));

		int[] nums2 = { 10, 20, 30, 40, 11, 21, 31, 41 };
		int[] frequency2 = { 2, 3, 4, 3, 6, 7, 8, 2 };

		System.out.println(approach1(nums2, frequency2));
		System.out.println("Random Seed");
		System.out.println(approach2(nums, frequency));
		System.out.println(approach2(nums1, frequency1));
		System.out.println(approach2(nums2, frequency2));
	}

	private static int approach1(int[] nums, int[] frequency) {
		int sum = 0;
		int mid = 0 + (nums.length - 0) / 2;
		// approach 1

		int left = 0;
		int right = nums.length - 1;
		for (int i = 1; i < frequency.length; i++) {
			frequency[i] = frequency[i] + frequency[i - 1];
		}
		Random random = new Random();
		int seed = random.nextInt(frequency[frequency.length - 1]);
		while (left < right) {
			mid = left + (right - left) / 2;
			if (frequency[mid] < seed) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[mid];

	}

	private static int approach2(int[] nums, int[] frequency) {

		Random random = new Random();
		int seed = random.nextInt(frequency.length);
		return nums[seed];

	}
	
	
//	121
}