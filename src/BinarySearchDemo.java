/* 
 Nour Yaghmour  
 Olga Melnikova 
 */

import java.util.Scanner;

public class BinarySearchDemo {
	
	// A method to create a random increasing order values in an array
    public static void fillRandomArray(int[] array) {
        array[0] = (int) (Math.random() * 100) + 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + (int) (Math.random() * 100) + 1;
        }
    }
    
    public static void main(String[] args) {
  
    	int size = 0;
    	Scanner keyboard = new Scanner(System.in); 
    	
    	//Ask user to enter the array size that cannot be less than 1000 elements:
		System.out.println("Enter the array size. It should be more than 1000.");
		
		//The user should re-enter the size number if it is less than 1000.
    	do {
    		size = keyboard.nextInt();
    		
    		if (size <= 1000 ) {
    			System.out.println("The number should be more than 1000. Please re-enter the number");
    		}
    		
        } while (size <=1000);
        
        
    	//Creating the array
        int [] array = new int [1100];
        
        fillRandomArray(array);
        
        //Outputting the array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        Scanner scanner = new Scanner(System.in); // Ask user to enter a search key
        System.out.println("Enter the search key: ");
        int key = scanner.nextInt();

        PureBinary binary =  new PureBinary(); // create an object of class RegularBinarySearch to call its method
        BinaryVariation newBinary = new BinaryVariation(); // create an object of class NewBinarySearch to call its method

        //Search using 1/5 - 4/5 strategy
        int posFifth = 0;
        posFifth = newBinary.BinarySearchVariation(array, 0, array.length-1, key); //return the position of the key using 1/5 - 4/5 strategy
        
        if (posFifth != -1) {
            System.out.println("Search key " + key + " was found using 1/5th - 4/5th Strategy\nat position " + posFifth + " with " + newBinary.getComparisons() + " comparisons");
        } 
        else {
            System.out.println(key + " was not found in the array using 1/5th - 4/5th Strategy.\nNumber of comparisons = " + newBinary.getComparisons());
        }
        
        //Search using regular binary search strategy
        int posReg = 0;
        posReg = binary.BinarySearch(array, 0, array.length-1, key); //return the position of the key using regular binary search strategy

        if(posReg != -1){ //if the key is found in the array
            System.out.println("Search key " +key +" was found using RegularBinarySearch\nat position "+ posReg + " with "+ binary.getCount() + " comparisons");
        }
        
        else {  //if the key is not found in the array
            System.out.println(key + " was not found in the array using RegularBinarySearch.\nNumber of comparisons = "+ binary.getCount());
        }
    }
}
