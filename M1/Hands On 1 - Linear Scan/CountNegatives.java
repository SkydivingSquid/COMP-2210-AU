/**
 * Applies the linear scan strategy to counting the number of negative
 * values in an array.
 */
public class CountNegatives {

   /**
    * Prints result of countNegatives method.
    * @param args Command line arguments - (not used).
    */
    
   public static void main(String[] args) {
      int[] a = {1, 2, 3, -4, -5, 6};
      int result = countNegatives(a);
      System.out.print(result);
   }
    
   /**
    * @return the number of negative values in the given array.
    */
   public static int countNegatives(int[]a) {
      int negativeCount = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] < 0) {
            negativeCount++;
         }
      }
      return negativeCount;
   }
}
