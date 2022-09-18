import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.io.File;

public class Autocomplete {

   private Term[] termsArray;
 
	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) { 
   
      if (terms == null) {
         throw new NullPointerException("must contain a term");
      }
      
      termsArray = terms.clone();
      
      Arrays.sort(termsArray); 
   }
  
  
	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
    
    
   public Term[] allMatches(String prefix) { 
   
      if (prefix == null) {
         throw new NullPointerException("must contain a prefix");
      }
      
      int bottom = BinarySearch.<Term>firstIndexOf(termsArray, new Term(prefix, 0),
                     Term.byPrefixOrder(prefix.length()));
   
      int top = BinarySearch.<Term>lastIndexOf(termsArray, new Term(prefix, 0),
                     Term.byPrefixOrder(prefix.length()));      
                      
                      
      Term [] matches = Arrays.copyOfRange(termsArray, bottom, (top + 1));                                          
      Arrays.sort(matches, Term.byDescendingWeightOrder());
      
      return matches;
   }                               
      
      
      
 
}