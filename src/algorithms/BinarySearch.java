import java.util.Scanner;

public class BinarySearch {

  public static int binarySearch(int[] arr, int value) {
     int index = -1;
     int high = arr.length-1;
     int low = 0;
     int mid = (high+low)/2;

     while(high >= low) {
       if(arr[high] == value) {
         index = high;
         break;
       } else if(arr[low] == value) {
         index = low;
         break;
       } else if(arr[mid] == value) {
          index = mid;
          break;
       } else if(arr[high] < value || arr[low] > value) {
          return -1;
       } else if(arr[mid] > value) {
          high = mid;
       } else if(arr[mid] < value) {
         low = mid;
       }
       mid = (high+low)/2;
     }
     return index;
  }

  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 5};
    Scanner in = new Scanner(System.in);
    int test = in.nextInt();
    System.out.println(binarySearch(array, test));
  }
}
