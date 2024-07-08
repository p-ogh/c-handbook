package testdome.java;

//binary search

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        //        Start
        //        Take input array and Target
        //        Initialise start = 0 and end = (array size -1)
        //        Intialise mid variable

        int start = 0;
        int end = sortedArray.length - 1;
        int count = 0;

//         mid = (start+end)/2
//        if array[ mid ] < target then start = mid+1
//        if array[ mid ] > target then end = mid-1
//        if start<=end then redo  loop
//        if start > end, return count
        while(start <= end){
            int mid = (start + end)/2 ;

            if(sortedArray[mid] < lessThan){
                count += mid - start + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}