package com.app;

	import java.io.File;
import java.util.ArrayList;
	import java.util.Scanner;
import java.util.TreeSet;

	public class Main {

	    public static void main(String[] args) {
	        /*System.out.println("Hello World!");*/
	        System.out.println("\n**************************************\n");
	        System.out.println("\tWelcome to TheDesk \n");
	        System.out.println("**************************************");
	        optionsSelection();

	    }
	    private static void optionsSelection() {
	        String[] arr = {"1. I wish to review my expenditure",
	                "2. I wish to add my expenditure",
	                "3. I wish to delete my expenditure",
	                "4. I wish to sort the expenditures",
	                "5. I wish to search for a particular expenditure",
	                "6. Close the application"
	        };
	        int[] arr1 = {1,2,3,4,5,6};
	        int  slen = arr1.length;
	        for(int i=0; i<slen;i++){
	            System.out.println(arr[i]);
	            // display the all the Strings mentioned in the String array
	        }
	        ArrayList<Integer> arrlist = new ArrayList<Integer>();
	        ArrayList<Integer> expenses = new ArrayList<Integer>();
	        expenses.add(1000);
	        expenses.add(2300);
	        expenses.add(45000);
	        expenses.add(32000);
	        expenses.add(110);
	        expenses.addAll(arrlist);
	        System.out.println("\nEnter your choice:\t");
	        Scanner sc = new Scanner(System.in);
	        int  options =  sc.nextInt();
	        for(int j=1;j<=slen;j++){
	            if(options==j){
	                switch (options){
	                    case 1:
	                        System.out.println("Your saved expenses are listed below: \n");
	                        System.out.println(expenses+"\n");
	                        optionsSelection();
	                        break;
	                    case 2:
	                        System.out.println("Enter the value to add your Expense: \n");
	                        int value = sc.nextInt();
	                        expenses.add(value);
	                        System.out.println("Your value is updated\n");
	                        expenses.addAll(arrlist);
	                        System.out.println(expenses+"\n");
	                        optionsSelection();

	                        break;
	                    case 3:
	                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
	                        int con_choice = sc.nextInt();
	                        if(con_choice==options){
	                               expenses.clear();
	                            System.out.println(expenses+"\n");
	                            System.out.println("All your expenses are erased!\n");
	                        } else {
	                            System.out.println("Oops... try again!");
	                        }
	                        optionsSelection();
	                        break;
	                    case 4:
	                        sortExpenses(expenses);
	                        optionsSelection();
	                        break;
	                    case 5:
	                        searchExpenses(expenses);
	                        optionsSelection();
	                        break;
	                    case 6:
	                        closeApp();
	                        break;
	                    default:
	                        System.out.println("You have made an invalid choice!");
	                        break;
	                }
	            }
	        }

	    }
	    private static void closeApp() {
	        System.out.println("Closing your application... \nThank you!");
	            }
	    private static void searchExpenses(ArrayList<Integer> arrayList) {
	    	Scanner sc= new Scanner(System.in);
	        int leng = arrayList.size();
	        System.out.println("Enter the expense you need to search:\t");
	        int key= sc.nextInt();
	        int[] arr= new int[leng];
			int t=0;	
			
				for(Integer al: arrayList) {
					arr[t]= al.intValue();	//to access index
				t++;
				}
				int u=binarySearch(arr, key);
				if(u>=0)
					System.out.println("located at position: "+ (u+1));
				else
					System.out.println("Not Found");
	    
	    }
	    
	    private static void sortExpenses(ArrayList<Integer> arrayList) {
	        int arrlength =  arrayList.size();
	        int[] arrs= new int[arrlength];
			int r=0;	
			
				for(Integer al: arrayList) {
					arrs[r]= al.intValue();	//to access index
					r++;
				}
				insertionSort(arrs, arrlength);
	       
	        for (int s=0; s<arrs.length; ++s) 
	        {
	            System.out.print(arrs[s]+" ");
	        } 
	        System.out.println();
	       
	    }
	    
	    
	    private static int binarySearch(int[] arr, int key){
			
			int firstIndex = 0;
		    int lastIndex = arr.length- 1;
		
		while (firstIndex <= lastIndex) {
			int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

			if((arr[middleIndex])==key)	// key present at mid
					return middleIndex;
			else {
			if ((arr[middleIndex])<key)	// If key greater, ignore first half
				firstIndex = middleIndex + 1;
			
			else				// If filename is smaller, ignore second half
				lastIndex = middleIndex - 1;
		}
		
		}
		return -1;
	}
	    
	    
	    
	    static void insertionSort(int arr[], int n) 
	    { 
	        if (n <= 1)                             //passes are done
	        {
	            return; 
	        }

	        insertionSort( arr, n-1 );        //one element sorted, sort the remaining array
	       
	        int last = arr[n-1];                        //last element of the array
	        int j = n-2;                                //correct index of last element of the array
	       
	        while (j >= 0 && arr[j] > last)                 //find the correct index of the last element
	        { 
	            arr[j+1] = arr[j];                          //shift section of sorted elements upwards by one element if correct index isn't found
	            j--; 
	        } 
	        arr[j+1] = last;                            //set the last element at its correct index
	    } 
}


