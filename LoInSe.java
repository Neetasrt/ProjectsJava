package com.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoInSe {
	
	static int lismax = 0; 
    static List<Integer> maxArray = new ArrayList<>();
    //method
    static List<Integer> longInSub(int arr[], int index){
    	if (index == 0) {
            lismax = 1;
            return new ArrayList<>(Arrays.asList(arr[index]));
        }
    	
    	int lislength = 1;
        List<Integer> lisLength = new ArrayList<>();
        
        for (int i=0; i< index; i++)
        {
        	List<Integer> subList = longInSub(arr, i);	//recursive call
            int sublength = subList.size();
            
            if (arr[i] < arr[index] && lislength < (1 + sublength)) {
                lislength = 1 + sublength;
                lisLength = subList;
            }
        }
        lisLength.add(arr[index]);
        
        if (lismax < lislength) {	
            lismax = lislength;
            maxArray = lisLength;
        }

        return lisLength;		//return longest length possible
    }
    
	public static void main(String[] args) {
		int arr[] = {20,35,12,61,6,48,55};
        int n = arr.length;
        List<Integer> ar= new ArrayList<>();
        for(int k=0; k<n;k++) {
        	ar.add(arr[k]);
        }
        List<Integer> r = longInSub( arr, n-1 );
        System.out.println("Array:"+ar);
        System.out.println("SubSequence:"+ r);
        System.out.println("longest length:"+ lismax);
        		
	}

}
