import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		int MAX = question1();

		Random random = new Random();

		int[] arr = new int[100];
		int[] tempArr2 = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = random.nextInt(MAX) * (random.nextBoolean() ? -1 : 1);
		}
		Arrays.sort(arr);
		System.out.println("Initial Array");
		// Logic to print square of array elements
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",  ");
		}
		System.out.println();
		System.out.println("Square Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] * arr[i] + ",  ");
		}
		sort(arr, tempArr2);
		System.out.println();
		System.out.println("Temp Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(tempArr2[i] + ",  ");
		}

		System.out.println("\n\n\n");
		arr = new int[10];
		tempArr2 = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = random.nextInt(MAX) * (random.nextBoolean() ? -1 : 1);
		}
		Arrays.sort(arr);
		System.out.println("Initial Array");
		// Logic to print square of array elements
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",  ");
		}
		System.out.println();
		System.out.println("Square Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] * arr[i] + ",  ");
		}
		sort(arr, tempArr2);
		System.out.println();
		System.out.println("Temp Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(tempArr2[i] + ",  ");
		}

	}

	private static int question1() {
		String str = "abccddaa";
		System.out.println(minifyString(str));
		int MAX = 1000;

		str = "abccdaccc";
		System.out.println(minifyString(str));
		return MAX;
	}

	private static void sort(int[] arr, int[] tempArr2) {
		int leftPtr = 0;
		int rightPtr = arr.length - 1;
		int count = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			int leftMaxSquare = arr[leftPtr] * arr[leftPtr];
			int rightMaxSquare = arr[rightPtr] * arr[rightPtr];
			if (leftMaxSquare > rightMaxSquare) {
				tempArr2[count] = leftMaxSquare;
				leftPtr++;
				count--;
			} else {
				tempArr2[count] = rightMaxSquare;
				rightPtr--;
				count--;
			}
		}
	}

	private static void sort(int[] arr) {
		int leftPtr = 0;
		int rightPtr = arr.length - 1;
		int count = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			int leftMaxSquare = arr[leftPtr] * arr[leftPtr];
			int rightMaxSquare = arr[rightPtr] * arr[rightPtr];
			if (leftMaxSquare > rightMaxSquare) {
				// tempArr2[count] = leftMaxSquare;
				leftPtr++;
				count--;
			} else {
				// tempArr2[count] = rightMaxSquare;
				rightPtr--;
				count--;
			}
		}
	}

	private static String minifyString(String str) {
		int stringLength = str.length();
		for (int i = 0; i < stringLength; i++) {
			if (i + 1 < stringLength && str.charAt(i) == str.charAt(i + 1)) {
				String tempStr = str.substring(i, i + 1); // c
				str = str.replace(tempStr + tempStr, "");
				i = 0;
				stringLength = str.length();
			}

		}
		return str;
	}

	static String ShortenString(String str1) {
		Stack<Character> st = new Stack<Character>();
		int i = 0;

		// Traverse the String str
		while (i < str1.length()) {
			// Checks if stack is empty
			// or top of the stack is not
			// equal to current character
			if (st.isEmpty() || str1.charAt(i) != st.peek()) {
				st.add(str1.charAt(i));
				i++;
			}

			// If top element of the stack is
			// equal to the current character
			else {
				st.pop();
				i++;
			}
		}

		if (st.isEmpty()) {
			return ("Empty String");
		}

		// If stack is not Empty
		else {
			String short_String = "";
			while (!st.isEmpty()) {
				short_String = st.peek() + short_String;
				st.pop();
			}
			return (short_String);
		}
	}
	private static int approach1(int[] nums, int[] frequency) {
		int sum = 0;
		int mid = 0 + (nums.length-0)/2;
		// approach 1

		int left=0;
		int right=nums.length-1;
		for (int i = 1; i < frequency.length; i++) {
			frequency[i] = frequency[i]+frequency[i-1];
		}
		Random random = new Random();
		int seed = random.nextInt(frequency[frequency.length-1]);
        while(left<right){
    	     mid = left + (right-left)/2;
	        if(frequency[mid]<seed){
	            left =mid+1;
	        }
	        else{
	            right = mid;
	        }
        }        
		return nums[mid];
 
	}
}
