/**
 * 
 */
package assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Sorts {
	/*** 	CREATING ARRAY 	***/
	static int fillArray() {
		Random random = new Random();
		int rNumber = random.nextInt(20 - -20 + 1) + -20;
		//I was getting values in the thousands, so for test purposes i made my range -20 to 20
		return rNumber;
	}
	static int[] newArray (int length) {
		int[] newArray = new int[length];
		for(int i=0; i<length; i++) {
			newArray[i] = fillArray();		
		}
		return newArray;
	}
	/***	TRACKING 	***/
	public static int[] trackingChanges (int[] array, String type) {
		int[] unSortedArray = array;
		int[] testerArray = array;
		int arrayLength = unSortedArray.length;
		
		if(20 >= arrayLength && !(type.equalsIgnoreCase("a"))) {
			//If the array is greater than or equal to 20, and it's not an a, print the unSorted array;
			System.out.print("Unsorted: ");
			System.out.println(Arrays.toString(unSortedArray));	
		}
		int changedInt = 0;
		
		return array;
	}
	
	
	/***	INSERTION SORT 	***/
	
	static int[] insertionSort (int[] unSorted, int y, int changes){
		int[] newSort = unSorted;
		if(y <= 1) {
			return newSort;
		}
		//Keep running un til it gets to the front of the array
		insertionSort(newSort, y-1, changes);
		int testerValue = newSort[y - 1];
		int z = y - 2;
		while (z >= 0 && newSort[z] > testerValue) {
			changes++;
			newSort[z + 1] = newSort[z];
			z = z -1;
		}
		newSort[z + 1] = testerValue;
		
		return newSort;
		
		//return x;
	}

	/***	MERGE SORT 	***/
	public static int[] merge(int n[], int l, int middle, int right) 
    { 
		String newArray = Arrays.toString(n);
        //Get the side of the left and right after the middle 'pivot'
        int leftSide = middle - l + 1; 
        int rightSide = right - middle;        
        
        /* Create left and right side arrays */
        int Left[] = new int [leftSide]; 
        int Right[] = new int [rightSide]; 
  
        /* give the arrays there values*/
        for (int i = 0; i < leftSide; i++) {
        	Left[i] = n [l + i]; 
        }   
        for (int j = 0; j < rightSide; j++) {
            Right[j] = n [middle + 1+ j]; 
        }
  
        // Index of the first value in the arrays 
        int x = 0, y = 0; 
        
        // Initial index of merged subarray array 
        int k = l; 
        while (x < leftSide && y < rightSide) { 
            if (Left[x] <= Right[y]) { 
                n[k] = Left[x]; 
                x++; 
               // changes++;
            } else { 
                n[k] = Right[y]; 
                y++;
                //changes++;
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (x < leftSide) { 
            n[k] = Left[x]; 
            x++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (y < rightSide) { 
            n[k] = Right[y]; 
            y++; 
            k++; 
        } 
      //System.out.println("MERGESORT ARRAY: " + Arrays.toString(n));
      //System.out.println("NewArray: " + newArray + ", OLD ARRAY: "+Arrays.toString(n));
        
      String nArray = Arrays.toString(n);
      if(!(newArray.equals(nArray))){
    	  //changes ++;
    	  //System.out.println("NumberOfChages: " + changes);
      }
//      System.out.println("FinalChanges: "+changes);
//      return changes;
      return n;
    } 
  
    static int[] mergeSort(int array[], int leftSide, int rightSide, int changes) { 
    	//Used to Sort the merge function
    	int[] oldArray = array;
    		if (leftSide < rightSide) 
    		{ 
                // Find the middle point 
                int middle = (leftSide + rightSide) / 2; 
      
                 //Sort first and second halves 
                mergeSort(array, leftSide, middle, changes); 
                if(oldArray != array) 
                {	
                	changes++;
                }
                mergeSort(array , middle + 1, rightSide, changes); 
                if(oldArray != array) {
                	changes++;
                }
                
                // Merge the sorted halves 
                merge(array, leftSide, middle, rightSide); 
            }
    		//System.out.println("Merge_A: "+ Arrays.toString(n));
    		return array;
    	}
        
        //System.out.println("Merge_A: "+ Arrays.toString(n));

 
    /***	QUICK SORT	***/
    public static int[] callQuickSort(int[] array, int start, int end, int changes) {
    	int[] sortedQuick = quickSort(array,start, end, changes);
    	
    	if(array.length <= 20) {
        	System.out.println("Sorted: "+ Arrays.toString(sortedQuick));
        }
    	return array;
    }
	public static int[] quickSort(int[] unSortedA, int start, int end, int changes){
		 
        int partition = partition(unSortedA, start, end);
 
        if(partition-1>start) {
            quickSort(unSortedA, start, partition - 1, changes);
            changes++;
        }
        if(partition+1<end) {
            quickSort(unSortedA, partition + 1, end, changes);
            changes++;
        }
		return unSortedA;
    }
 
    public static int partition(int[] unSortA, int start, int end){
        int pivot = unSortA[end];
 
        for(int i=start; i<end; i++){
            if(unSortA[i]<pivot){
                int temp= unSortA[start];
                unSortA[start]=unSortA[i];
                unSortA[i]=temp;
                start++;
            }
        }
 
        int temp = unSortA[start];
        unSortA[start] = pivot;
        unSortA[end] = temp;
 
        return start;
    }


	/*** RADIX SORT ***/
    static int getMax(int array[], int n) 
    { 
        int maximum = array[0]; 
        for (int i = 1; i < n; i++) 
            if (array[i] > maximum) 
                maximum = array[i]; 
        return maximum; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arrayUnSort[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arrayUnSort[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arrayUnSort[i]/exp)%10 ] - 1] = arrayUnSort[i]; 
            count[ (arrayUnSort[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arrayUnSort[i] = output[i]; 
    } 
   static int[] positiveRadixSort(int arrayUnSort[], int n) 
   { 
       // Find the maximum number to know number of digits 
       int m = getMax(arrayUnSort, n); 
 
       // Do counting sort for every digit. Note that instead 
       // of passing digit number, exp is passed. exp is 10^i 
       // where i is current digit number 
       for (int exp = 1; m/exp > 0; exp *= 10) 
           countSort(arrayUnSort, n, exp); 
       
       return arrayUnSort;
   } 
    
    static int[] checkForNeg (int arrayUnSort[], int n) {
    	int compare = 0;
    	int negCount =0;
    	int posCount =0;
    	for(int i = 0;i<arrayUnSort.length; i++) {
    		if(arrayUnSort[i] < 0) {
    			//If neg number, add to counter
    			negCount++;
    		}else {
    			posCount++;
    		}
    	}
    	int[] positiveArr = new int[posCount];
    	int[] negativeArr = new int[negCount];
    	for(int j=0; j<arrayUnSort.length; j++){
    		if(arrayUnSort[j] < 0) {
    			//if the value is negative, add to negative Arr
    			for(int k = 0; k<negativeArr.length; k++) {
    				if(negativeArr[k] == 0) {
    					negativeArr[k] = arrayUnSort[j];
    					break;
    				}
    			}
    		}else {
    			for(int k = 0; k<positiveArr.length; k++) {
    				if(positiveArr[k] == 0) {
    					positiveArr[k] = arrayUnSort[j];
    					break;
    				}
    			}
    		}
    	}
		int[] sortedNegatives = negativeRadixSort(negativeArr, negativeArr.length );
		int[] sortedPositives = positiveRadixSort(positiveArr, positiveArr.length);
    	
    	int[] sortedRadix = new int[sortedNegatives.length + sortedPositives.length];	
    	for(int i = 0; i<sortedRadix.length; i++) {
    		if(i < sortedNegatives.length ) {
    			sortedRadix[i] = sortedNegatives[i];
    		}else {
    			int q = i - sortedNegatives.length;
    			sortedRadix[i] = sortedPositives[q];
    		}
    	}
    	//System.out.println("Comparisons: " + compare);
    	return sortedRadix; 
    }
    	
    	
    	//radixsort(positiveArr, positiveArr.size() - 1);
    	
  
    public static int[] negativeRadixSort(int[] negativeArr, int length) {
    	
    	ArrayList<Integer> intList = new ArrayList<Integer>();
    	
    	for (int index = 0; index < length; index++) { 
    	  intList.add(negativeArr[index]);
    	} 

    	intList.sort((Integer i1, Integer i2) -> Math.abs(i2) - Math.abs(i1));

    	int[] negativeSorted = new int[intList.size()];
    	for(int i=0; i< negativeSorted.length; i++) {
    		negativeSorted[i] = intList.get(i).intValue();
    	}
    	
    	return negativeSorted;
	}
}
