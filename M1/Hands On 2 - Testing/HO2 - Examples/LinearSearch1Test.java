import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * LinearSearch1Test.java
 * Illustrates JUnit tests for the LinearSearch1 class.
 */
public class LinearSearch1Test {

   /** Test for value randomly in array. */
   @Test
   public void testSearch1() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 6;
      int expected = 2;
      int actual = LinearSearch1.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test for value at beginning of array. */
   @Test
   public void testSearch2() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch1.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test for value at end of array. */
   @Test
   public void testSearch3() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 10;
      int expected = 4;
      int actual = LinearSearch1.search(a, target);
      assertEquals(expected, actual);
   }

/** Test for value not included in array. */
   @Test
   public void testSearch4() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 9;
      int expected = -1;
      int actual = LinearSearch1.search(a, target);
      assertEquals(expected, actual);
   }

/** Test for a value found multiple times in array. */
   @Test
   public void testSearch5() {
      int[] a = {2, 4, 6, 6, 10};
      int target = 6;
      int expected = 2;
      int actual = LinearSearch1.search(a, target);
      assertEquals(expected, actual);
   }

}
