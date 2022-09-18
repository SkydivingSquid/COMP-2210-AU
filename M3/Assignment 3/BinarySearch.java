import java.util.Comparator;

public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) { 
   
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException("firstIndoexOf method contains null parameter");
      }
   
      int first = 0;
      int last = a.length-1;
      int index = -1;
   
      while (first <= last) {
         int mid = (first + last) / 2;
         Key loc = a[mid];
         int comp = comparator.compare(key, loc);
      
         if (comp == 0)
            index = mid;
      
         if (comp <= 0)
            last = mid - 1;
         
         else first = mid + 1;
      }
       
      return index;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) { 
   
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException("lastIndoexOf method contains null parameter");
      }
      
      int first = 0;
      int last = a.length-1;
      int index = -1;
   
      while (first <= last) {
         int mid = (first + last) / 2;
         Key loc = a[mid];
         int comp = comparator.compare(key, loc);
      
         if (comp == 0)
            index = mid;
      
         if (comp < 0)
            last = mid - 1;
         
         else first = mid + 1;
      }
       
      return index;
   }
}