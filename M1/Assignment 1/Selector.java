import java.util.Arrays; 

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   George Martin (gbm0016@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  30 January 2020
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }

   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
    
      if (a == null || a.length < 1) { // throws exception if invalid array
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
   
      int min = a[0]; // sets min equal to first value in array
      
      int[] b = Arrays.copyOf(a, a.length); // clones a
      
      for (int val : b) { // for every val of type array b
         if (val <= min) { // compares val to min
            min = val; // sets new min
         }
      }
      return min;
   }

   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
   
      if (a == null || a.length < 1) { // throws exception if invalid array
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
      
      int max = a[0]; // sets max equal to first value in array
      
      int[] b = Arrays.copyOf(a, a.length); // clones a
      
      for (int val : b) { // for every value in array b
         if (val >= max) { // compared value to max
            max = val; // sets new max
         }
      }
         
      return max;
   }

   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
   
   // throws exception if array is not set or empty
      if (a == null || a.length < 1) {
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
      
      int i = 0; // standard index
      int j = 0; // comparative index in array b
      int z = 1; // index of array c
      int count = 0; // count used with algorithm to set array length of c
      int duplicates =0; // number of duplicates in array b
      
      int[] b = Arrays.copyOf(a, a.length); // clones array a
      
      // sorts array in ascending order
      Arrays.sort(b); 
   
      // counts duplicates in sorted array b
      for (int var : b) {
         if (i < (b.length - 1) && b[i] == b[i + 1]) { // maintains bounds
            duplicates++;
         }
         i++;
      }
      
      //sets count by taking array length and subtracting duplicates
      count = b.length - duplicates;
         
      // throws argument if k out of bounds   
      if (k < 1 || k > count) { 
         throw new IllegalArgumentException("Invalid search length");
      }
      
      // creates new blank Array sized for unique variables   
      int[] c = new int[count];
       
       
      i = 1; // resets i to required comparison value
   
      c[0] = b[0]; // sets first value of array c to first value in array b
      
      for (int var : b) {
      
      // moves through array, skipping over duplicates
         if (i < (b.length) && b[i] == b[j]) { // maintains bounds
            i++;
         }
      
      // when unique variable is found, adds to array c and increases i and j
         if (i < b.length && b[i] != b[j]) { // maintains bounds
            j++;
            b[j] = b[i];
            i++;
            c[z] = b[j];
            z++;
         }  
      }
   
      return c[k - 1]; // returns kth smallest value
   }

   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
   
   // throws exception if array is not set or empty
      if (a == null || a.length < 1) {
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
      
      int i = 0; // standard index
      int j = 0; // comparative index in array b
      int z = 1; // index of array c
      int count = 0; // count used with algorithm to set array length of c
      int duplicates = 0; // number of duplicates in array b
      
      int[] b = Arrays.copyOf(a, a.length); // clones array a
      
      // sorts array in ascending order
      Arrays.sort(b); 
   
      // counts duplicates in sorted array b
      for (int var : b) {
         if (i < (b.length - 1) && b[i] == b[i + 1]) { // maintains bounds
            duplicates++;
         }
         i++;
      }
      
      // sets count by taking array length and subtracting duplicates
      count = b.length - duplicates;
         
      // throws exception if k out of bounds
      if (k < 1 || k > count) { 
         throw new IllegalArgumentException("Invalid search length");
      }
                     
      // creates new blank array sized specifically for unique variables   
      int[] c = new int[count];
      
      i = 1; // resets i to required comparison value
      
      c[0] = b[0]; // sets first value of array c to first value in array b
      
      for (int var : b) {
      
      // moves through array, skipping over duplicates
         if (i < (b.length) && b[i] == b[j]) { // maintains bounds
            i++;
         }
      // when unique variable is found, adds to array c and increases i and j
         if (i < b.length && b[i] != b[j]) { // maintains bounds
            j++;
            b[j] = b[i];
            i++;
            c[z] = b[j];
            z++;
         }  
      }
      
      return c[c.length - k]; // returns kth largest value
   }

   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
   
   // throws exception if array is not set or empty
      if(a == null || a.length < 1) { 
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
      
      int count = 0; // used for new Array size
      int i = 0; // index of a
      int k = 0; // index of rangeArray
      
      for (int var : a) { // sets size of new Array
         if(low <= a[i] && a[i] <= high) {
            count++;
         }
         i++;
      }
         
      int[] rangeArray = new int[count]; // creates new Array
         
      i = 0; // resets index
      for (int var: a) { // adds elements to new array
         if (low <= a[i] && a[i] <= high) {
            rangeArray[k] = a[i];
            k++;
         }
         i++;
      }
      
      return rangeArray;
   }

   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
   
   // throws exception if array is not set or empty
      if(a == null || a.length < 1) {
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
         
      boolean valid = false; // acts as a gate for method
      int ceiling = a[0];
         
      for(int var : a) {
         
      // finds first possible ceiling value and flips boolean gate
         if(!valid && var >= key) { 
            valid = true;
            ceiling = var;
         }
         
      // finds actual ceiling value once boolean gate flipped 
         if(valid && var >= key && ceiling > var) { 
            ceiling = var;
         }
      }
      
      // if no values are possible, boolean throws exception
      if(!valid) {
         throw new IllegalArgumentException("Key value too high");
      }
      
      return ceiling;
   }

   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
   
   // throws exception if array is not set or empty
      if(a == null || a.length < 1) {
         throw new IllegalArgumentException("Array must have length of at least 1");
      }
         
      boolean valid = false; // acts as a gate for method
      int floor = a[0];
         
      for(int var : a) {
      
      // finds first possible floor value and flips boolean gate   
         if(!valid && var <= key) {
            valid = true;
            floor = var;
         }
        
      // finds actual floor value once boolean gate flipped   
         if(valid && var <= key && floor < var) {
            floor = var;
         }
      }
      
      // if no values are possible, boolean throws exception
      if(!valid) {
         throw new IllegalArgumentException("Key value too low");
      }
      return floor;
   }


} // final brace
