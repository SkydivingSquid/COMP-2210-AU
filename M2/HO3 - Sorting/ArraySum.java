/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author George Martin (gbm0016@auburn.edu)
 * @version 2020-02-09
 */
public class ArraySum {

	/** Returns the sum of values in the given array. */
   public static int sum(int[] a, int left, int right) {
   
      if (a == null) {
         return -1;
      }  
      
      if (left >= right) {
         return a[left];
      }
      
      else {
      
         return a[right] + sum(a, left, right - 1);
      }
   }
         
   
   // public static void main(String[] args) {
      // int[] a = {1, 2, 3, 4, 5};
   // 
      // System.out.println(sum(a, 0, a.length - 1));
   // }
   
   
}
