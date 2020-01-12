public class PureBinary {

	private static int count =0;
	
    public static int BinarySearch(int[] array, int first, int last, int key) {
        int searchResult = 0;
        int mid = (first + last) / 2;

        if (first > last) {
            count ++; // counting the number of comparisons for each step
            searchResult = -1;
        }
        
        else {
            // if key is at middle of array
            if (key == array[mid]) {
                count ++;
                searchResult = mid;
                
              // search if key is in first half
            } else if (key < array[mid]) {
                count++;
                searchResult = BinarySearch(array, first, mid - 1, key);
                
              // search if key is in second half
            } else if (key > array[mid]) {
                count++;
                searchResult = BinarySearch(array, mid + 1, last, key);
            }
        }
        return searchResult;
    }

    public static int getCount() {
        return count;
    }
}
