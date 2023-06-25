package day1;

import java.util.*;
import java.util.LinkedList;

public class LinkedListSwap {
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();

		// Adding elements to Linked List
		ll.add(10);
		ll.add(11);
		ll.add(12);
		ll.add(13);
		ll.add(14);
		ll.add(15);

		// Elements to swap
		int element1 = 11;
		int element2 = 14;

		System.out.println("Linked List Before Swapping :-");

		for (int i : ll) {
			System.out.print(i + " ");
		}

		// Swapping the elements
		swap(ll, element1, element2);
		System.out.println();
		System.out.println();

		System.out.println("Linked List After Swapping :-");

		for (int i : ll) {
			System.out.print(i + " ");
		}
	}

	// Swap Function
	public static void swap(LinkedList<Integer> list, int ele1, int ele2) {

		// Getting the positions of the elements
		int index1 = list.indexOf(ele1);
		int index2 = list.indexOf(ele2);

		// Returning if the element is not present in the
		// LinkedList
		if (index1 == -1 || index2 == -1) {
			return;
		}

		// Swapping the elements
		list.set(index1, ele2);
		list.set(index2, ele1);
	}
}