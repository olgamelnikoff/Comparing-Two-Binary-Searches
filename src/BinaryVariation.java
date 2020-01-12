public class BinaryVariation {
	private  static int comparisons =0;

    public static int BinarySearchVariation(int[] array, int first, int last, int key) {

        int searchResult = 0;
        int pivot = first + ((last - first) / 5);

        if (first > last) {
            comparisons++;
            searchResult = -1;

        } else {

            // if key is at pivot then return result
            if (key == array[pivot]) {
                comparisons++;
                searchResult = pivot;

               // if key is in the first 1/5 apply 1/5 -4/5 strategy
            } else if (key < array[pivot]) {
                comparisons++;
                searchResult = BinarySearchVariation(array, first, pivot - 1, key);

              // if key is in the 4/5th of the array
            } else if (key > array[pivot]) {
                
            	comparisons++;
                first = pivot + 1;
                int mid = (first + last)/2; // apply the Regular RegularBinarySearch method once
                
                if(key ==array[mid]) {
                	comparisons++;
                    searchResult = mid;
                }
                else if (key < array[mid]) {
                    comparisons++;
                    searchResult = BinarySearchVariation(array,first,mid-1,key);   // if key not found at mid in regular binarySearch
                                                                                        // go back to 1/5 -4/5 method
                }
                else {
                    if(key > array[mid]){
                        comparisons++;
                        searchResult = BinarySearchVariation(array,mid+1,last,key); // complete the search using
                                                                                        // 1/5 -4/5 strategy
                    }
                }
            }
        }
        return searchResult;
    }

    public static int getComparisons() {
        return comparisons;
    }
}
