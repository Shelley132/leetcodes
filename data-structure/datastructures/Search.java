package datastructures;

/**
 * @author LLJ
 * @version 2017年4月15日下午7:50:13
 */
public class Search {


    public static int binarySearch(int[] srcArray, int des) {

        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (des == srcArray[middle]) {
                return middle;
            } else if (des < srcArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
