import java.util.Comparator;


public class Term implements Comparable<Term> {

   private String userQuery;
   private long queryWeight;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
    
   public Term(String query, long weight) { 
     
      if (query == null) 
         throw new NullPointerException("No query entered");
      
      
      if (weight < 0) 
         throw new IllegalArgumentException("weight must be non-negative");
      
      userQuery = query;
      queryWeight = weight;
      
   }
   
   /** 
    * Getter method for query.
    */
   public String getQuery() {
      return userQuery;
   }

   /** 
    * Getter method for weight.
    */ 
   public long getWeight() {
      return queryWeight;
   }
   
   
   /**
    * Compares the two terms in descending order of weight.
    */
  
   public static Comparator<Term> byDescendingWeightOrder() { 
   
      return new DescendingWeightComparator();
   }
    
   /**
    * Private class that compares term weights and returns an int value.
    */ 
   private static class DescendingWeightComparator implements Comparator<Term> {
      public int compare(Term t1, Term t2) {
      
         if (t1 == null || t2 == null) {
            throw new NullPointerException("DescendingWeightComparator has null values");
         }
      
         if (t1.getWeight() < t2.getWeight()) 
            return 1;
      
         if (t1.getWeight() > t2.getWeight()) 
            return -1;
         
         else 
            return 0;
      }
   }
   
   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) { 
   
      if (length <= 0) {
         throw new IllegalArgumentException("byPrefixOrder length <= 0");
      }
   
      return new PrefixOrderComparator(length); 
   }
   
   private static class PrefixOrderComparator implements Comparator<Term> {
      private final int L;
   
   
      public PrefixOrderComparator(int L) {
         this.L = L;
      }
   
      public int compare (Term a, Term b) {
      
         int aLength = a.getQuery().length();
         int bLength = b.getQuery().length();
         if (aLength < L || bLength < L) {
            if (aLength == bLength) {
               return a.getQuery().compareTo(b.getQuery());
            }
            int min = Math.min(aLength, bLength);
            int result = a.getQuery().substring(0, min).compareTo(b.getQuery().substring(0, min));
            if (result == 0) {
               if (aLength < bLength) { 
                  return -1;
               }
               return 1;
            }
            return result;
         }
         return a.getQuery().substring(0, L).compareTo(b.getQuery().substring(0, L));         
      }
   }
   
   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
   
      return userQuery.compareTo(other.userQuery);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){ 
   
      return "" + userQuery + "\t" + queryWeight + "";
   }

} // final brace