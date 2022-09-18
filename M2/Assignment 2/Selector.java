import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
* @author   George Martin (gbm0016@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  13 February 2020
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");
      
   // Creates iterator to run through collection   
      Iterator<T> itr = coll.iterator(); 
      
   // Sets min equal to first element in the collection.   
      T min = itr.next(); 
         
   // finds minimum in collection            
      for (T element : coll) // for every element of type T in collection
         if (comp.compare(element, min) < 0) // compares current element to min
            min = element; // sets new min to current element
       
   // returns minimum    
      return min;
   }
   

   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");
   
   // creates iterator to run through collection
      Iterator<T> itr = coll.iterator();
   
   // sets max equal to first element in collection   
      T max = itr.next();
     
   // finds maximum in colletion  
      for (T element : coll) // for every element of type T in collection
         if (comp.compare(element, max) > 0) // compares element to max
            max = element; // sets max to current element
   
   // returns maximum
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");
   
   // creates a list with elements in collection
      List<T> List1 = new ArrayList(coll);
   
   // sorts elements in list according to comparator
      java.util.Collections.sort(List1, comp);
   
   // thows exception if kth value is invalid
      if (k > coll.size() || k < 1)
         throw new NoSuchElementException("Kth value is outside values in collection");
      
   // declares variables   
      int duplicates = 0;
      int unique = 0;
      
   // Counts and removed duplicate elements in array  
      for (int i = 0; i < List1.size() - 1; i++) {
         while (List1.size() > 1 && i < List1.size() - 1
            && List1.get(i) == List1.get(i + 1)) {
            List1.remove(i);
            duplicates++;
         }
      }
      
   // sets new unique value
      unique = coll.size() - duplicates;
     
   // throws exception if kth value is invalid   
      if (k > unique) {
         throw new NoSuchElementException("Kth value is outside values in collection");
      }
   
   // returns kth smallest value, acounting for first element at 0.
      return List1.get(k - 1);
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");
   
   // creates a list with elements in collection
      List<T> List1 = new ArrayList(coll);
   
   // sorts elements in list according to comparator
      java.util.Collections.sort(List1, comp);
   
   // thows exception if kth value is invalid
      if (k > coll.size() || k < 1)
         throw new NoSuchElementException("Kth value is outside values in collection");
      
   // declares variables   
      int duplicates = 0;
      int unique = 0;
      
   // Counts and removed duplicate elements in array  
      for (int i = 0; i < List1.size() - 1; i++) {
         while (List1.size() > 1 && i < List1.size() - 1
            && List1.get(i) == List1.get(i + 1)) {
            List1.remove(i);
            duplicates++;
         }
      }
   
   // sets new unique value   
      unique = coll.size() - duplicates;
     
   // throws exception if kth value is invalid   
      if (k > unique) {
         throw new NoSuchElementException("Kth value is outside values in collection");
      }
   
   // returns kth largest value, acounting for first element at 0.
   
      return List1.get(List1.size() - k);
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                     Comparator<T> comp) {
                                                     
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");                                                  
   
   // creates new array containing elements from collection.                                                  
      List<T> List1 = new ArrayList(coll);
   
      int i = 0; // index of List1
      int j = 0; // index of range
      
      
   // creates new ArrayList       
      List<T> range = new ArrayList();    
   
   // adds variables in list that are between entered range values.      
      for (T var : List1) { // adds elements to new array
         if (comp.compare(low, var) <= 0 && comp.compare(var, high) <= 0) {
            range.add(List1.get(i)); // accidently putting a j instead of an i here sucked.
            j++;
         }
         i++;
      }
      
   // If no elements are in range, throw exception.   
      if (j == 0) {
         throw new NoSuchElementException("No values can be round within that range.");
      }
   
   // returns range of numbers within collection.   
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");                                                  
     
   // creates a new List containing elements in collection
      List<T> List1 = new ArrayList(coll);
      
   // acts as a gate for method
      boolean valid = false; 
      
   // sets ceiling equal to first element in List1   
      T ceiling = List1.get(0);
         
      for(T var : List1) {
         
      // finds first possible ceiling value and flips boolean gate
         if(!valid && comp.compare(var, key) >= 0) { 
            valid = true;
            ceiling = var;
         }
         
      // finds actual ceiling value once boolean gate flipped 
         if(valid && comp.compare(var, key) >= 0 && comp.compare(ceiling, var) > 0) {
            ceiling = var;
         }
      }
      
      // if no values are possible, boolean throws exception
      if(!valid) {
         throw new NoSuchElementException("Key value too high");
      }
    
   // returns values in collection greater than entered key.   
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
   
   // throws excepton for null collection and comparator
      if (coll == null || comp == null)
         throw new IllegalArgumentException("Collection must contain an element.");
      
   // throws exception is coll is empty
      if (coll.isEmpty()) 
         throw new NoSuchElementException("Collection empty.");                                                  
   
   
   // creates a new List containing elements in collection
      List<T> List1 = new ArrayList(coll);
   
         // acts as a gate for method
      boolean valid = false; 
      
      // sets floor equal to first element in List1
      T floor = List1.get(0);
         
      for(T var : List1) {
      
      // finds first possible floor value and flips boolean gate   
         if(!valid && comp.compare(var, key) <= 0) {
            valid = true;
            floor = var;
         }
        
      // finds actual floor value once boolean gate flipped   
         if(valid && comp.compare(var, key) <= 0 && comp.compare(floor, var) < 0) {
            floor = var;
         }
      }
      
      // if no values are possible, boolean throws exception
      if(!valid) {
         throw new NoSuchElementException("Key value too low");
      }
   
   // returns values in collection less than entered key.    
      return floor;
   }


} // final brace
