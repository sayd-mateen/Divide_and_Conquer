/*Name: Sayd Mateen  */

import java.util.*;

public class DivideConquer{
	
	public static void main(String[] args){
		int A[] = {2, 4, 6, 19, 22, 25 };
		int B[] = {7, 13, 14, 21, 23, 33 };
		System.out.println("Array A = " + Arrays.toString(A));
		System.out.println("Array B = " + Arrays.toString(B));
		/* The two arrays get sent to recursion method with their left and right bounds.
	   	 	We send length-1 because the array starts at [0] so the total number of elements will be one less than size */
		System.out.print("The "+ A.length + "th largest is ");	
		recursion(A, 0, A.length-1, B, 0, B.length-1); 
	
	}
	
	
	public static void recursion(int a[], int aLeft, int aRight, int b[], int bLeft, int bRight){
		/* The round method will take the array left and right bounds and will return the distance to the center element.
			Its important to get distance and not the actual element location because the center element location will be different for 
			each array. */
		int center = round(aLeft, aRight);
		
		//Base Case: 
		/* This base case will occur when there is one element left in each array. We can determine this by seeing if the left and 
			right bounds are the same then doing a last check to see which is greater. */
		if(aLeft == aRight){
			if(a[aLeft] >= b[bLeft]){
				System.out.println(a[aLeft]);
				return;
			}else{
				System.out.println(b[bLeft]);
				return; 
			}
		}
		
		//Recursion:
		/* This is the Divide section, the if statement checks to see which center is greater to determine which recursion call to impliment
			splitting the arrays every recursion call. */
		if(a[aLeft + center] > b[bLeft + center]){
			/* If array a is determined to have a greater center, we know that the right half of array a is not needed so we adjust the right bound
			     by subtractin it from the distance to center. For array b we dont need the left half so we add the center distance to the left half.
				 */
			recursion(a, aLeft, aRight - center, b, bLeft + center, bRight);
		}else{
			/* If array b is determined to have a greater center, we know that the right half of array b is not needed so we adjust the right bound
			     by subtractin it from the distance to center. For array a we dont need the left half so we add the center distance to the left half.
				 */
			recursion(b, bLeft, bRight - center, a, aLeft + center, aRight);
		}
		
	}
	/* this method will return the rounded up center distance. The reason why we round up is because we dont know if the size will 
		be even or odd. */
	public static int round(int left, int right){
		return (int) Math.ceil((right - left) / 2.0);
	}
}
