// toArray:- It is used to convert given collection into Array.
// get(Index):- it is used to fetch the objects at the given particular index.
package com.collections.List.LinkedList.basics;

import java.util.LinkedList;

public class MiscellaneousMethodsForLinkedList3 {

	public static void main(String[] args) {
		LinkedList l1  = new LinkedList();
		
		l1.add("dog");
		l1.add("lion");
		l1.add("tiger");
		l1.add("cat");
		l1.add("monkey");
		l1.add("panda");
		

		
		Object[] a = l1.toArray(); // converting collection to object array
//		System.out.println(a[10]); // index 10 out of bounds for length 6
		for(Object o:a)
			System.out.println(o);
		
		System.out.println("\n======================\n");
		// using get(index) and traditional for loop
		for(int i = 0; i<l1.size();i++)
			System.out.println(l1.get(i));
		
	}

}
