/**
 * Kelleen Angus
 * DUE 04/23/2019
 * Assignment #1
 * Sorts Driver
 */
package assignment1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class sortsDriver {
	
	public static int fillArray() {
		Random random = new Random();
		int rNumber = random.nextInt(20 - -20 + 1) + -20;
		//I was getting values in the thousands, so for test purposes i made my range -20 to 20
		return rNumber;
	}

	public static void main(String []args) {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter sort (i[nsertion], q[uick], m[erge], r[adix], a[ll]):");
		String sortType = scanner.nextLine();
		//ERROR HANDING FOR WRONG INPUT
		while(!(sortType.equalsIgnoreCase("a") || sortType.equalsIgnoreCase("m") || sortType.equalsIgnoreCase("q") || sortType.equalsIgnoreCase("r") || sortType.equalsIgnoreCase("i"))) {
			System.out.println("Not a valid input. Try again.");
			System.out.println("Enter sort (i[nsertion], q[uick], m[erge], r[adix], a[ll]):");
			sortType = scanner.nextLine();
		}
		
		System.out.println("Enter n (size of array to sort): ");
		int n = scanner.nextInt();
		//ERROR HANDLING FOR INVALID ARRAY SIZE
		while (n < 1) {
			System.out.println("Enter a valid Array size.");
			System.out.println("Enter n (size of array to sort): ");
			n = scanner.nextInt();
		}
		
		//*** CREATE THE NEW UNSORTED ARRAY ***//
		int[] unSortedArray = new int[n];
		for (int i=0; i< n; i++) {
			unSortedArray[i] = fillArray();
		}
		
		
		int changes = 0;
		if(n <= 20) {
			//Print out the unsorted + sorted Array
			System.out.print("Unsorted: ");
			System.out.println(Arrays.toString(unSortedArray));			
		}
		
		//Get the sort type from the user
		if (sortType.equalsIgnoreCase("m")) {
			//If the case is an M, do Merge Sort
		        int[] sortedMerge = Sorts.mergeSort(unSortedArray, 0, unSortedArray.length-1, changes); 
		        System.out.print("Comparisons: "+ changes);		        
		        if(n <= 20) {
					//Print out the sorted Array
					System.out.println("Sorted: ");System.out.println(Arrays.toString(sortedMerge));		
				}
			
		}else if(sortType.equalsIgnoreCase("q")) {
			//If the case is an Q, do Quick Sort
			int[] sortedQuick = Sorts.quickSort(unSortedArray, 0, unSortedArray.length - 1, changes);
			System.out.println("Comparisons: "+ changes);
			//Sorts.callQuickSort(unSortedArray, 0, unSortedArray.length - 1 );
			if(n <= 20) {
				//Print out the sorted Array
				System.out.println("Sorted: "+Arrays.toString(sortedQuick));		
			}
				
		}else if(sortType.equalsIgnoreCase("r")) {
			int arraySize = unSortedArray.length; 
	        int[] sortedRadix = Sorts.checkForNeg(unSortedArray, arraySize);
	        System.out.println("Comparisons:"+ changes);
	        
	        if(n <= 20) {
				//Print out the sorted Array
				System.out.println("Sorted: " + Arrays.toString(sortedRadix));
	        }
	        
		}else if(sortType.equalsIgnoreCase("i")) {
			//If the case is an I, do Insertion Sort
			int[] sortedInsert = Sorts.insertionSort(unSortedArray, unSortedArray.length - 1, changes);			
	        //System.out.print("unsorted array test: "+ Arrays.toString(sortedInsert));
			System.out.println("Comparisons: " + changes);	        
			if(n <= 20) {
				//Print out the sorted Array
				System.out.print("Sorted: "+ Arrays.toString(sortedInsert));		
			}
		}
		
		if(sortType.equalsIgnoreCase("a")) {
			final int[] newUnSort = unSortedArray;
			//System.out.println("Unsorted: "+ Arrays.toString(unSortedArray));
	        //System.out.println("unsorted array test: "+ Arrays.toString(newUnSort));
	        //final int[] unSortArray = unSortedArray;
	        //Collection<int[]> items = Collections.unmodifiableCollection(Arrays.asList(unSortedArray));
			
			
			//Radix
	        	int[] sortedRadix = Sorts.checkForNeg(unSortedArray, unSortedArray.length - 1);
	        	//System.out.println("Radix_A: "+ Arrays.toString(sortedRadix));
	        	//System.out.println("unsorted array test: "+ Arrays.toString(newUnSort));
	        	System.out.println("\nRadix:"+ changes);
	        	if(n <= 20) {
					//Print out the sorted Array
					System.out.println("Sorted: "+ Arrays.toString(sortedRadix)+"\n");		
				}
			//Merge
	        	//int[] sortedMerge = Sorts.mergeSortSpecial(items, 0, unSortedArray.length-1, changes); 
	        	int[] sortedMerge = Sorts.mergeSort(newUnSort, 0, newUnSort.length -1, changes);
	        	//System.out.println("unsorted array test: "+ Arrays.toString(newUnSort));
	        	System.out.println("Merge: "+ changes);
	        	if(n <= 20) {
					//Print out the sorted Array
					System.out.println("Sorted: "+ Arrays.toString(sortedMerge)+"\n");		
				}
	        
	        //Insertion
	        	changes = 0;
	        	Sorts.insertionSort(unSortedArray, unSortedArray.length - 1, changes);
	        	System.out.println("Insertion: "+ changes);
	        	int[] sortedInsert = Sorts.insertionSort(unSortedArray, unSortedArray.length - 1, changes);			     
				if(n <= 20) {
					//Print out the sorted Array
					System.out.println("Sorted: "+ Arrays.toString(sortedInsert)+"\n");		
				}
     
	        //Quick
	        	changes = 0;
	        	int[] sortedQuick = Sorts.quickSort(unSortedArray, 0, unSortedArray.length - 1, changes);
				System.out.println("Quick: "+ changes);
				//System.out.print("unsorted array test: "+ Arrays.toString(sortedInsert));  
				if(n <= 20) {
					//Print out the sorted Array
					System.out.println("Sorted: "+ Arrays.toString(sortedQuick)+"\n");		
				}
	        
		}
		
		//Print the sorted array	
	}
}