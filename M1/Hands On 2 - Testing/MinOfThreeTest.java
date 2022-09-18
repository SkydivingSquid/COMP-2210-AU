import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class MinOfThreeTest {

/// TESTS FOR MIN 1 METHOD ///

   /** A test that returns lowest int of a. **/
   @Test public void testMin1a() {
      int expected = -1;
      int actual = MinOfThree.min1(-1, 0, 3);
      Assert.assertEquals(expected, actual);  
   }
   
   /** A test that returns lowest int of b. **/
   @Test public void testMin1b() {
      int expected = 0;
      int actual = MinOfThree.min1(1, 0, 3);
      Assert.assertEquals(expected, actual);
   }
   
   /** A test that returns lowest int of c. **/
   @Test public void testMin1c() {
      int expected = -3;
      int actual = MinOfThree.min1(1, 0, -3);
      Assert.assertEquals(expected, actual);
   }
   
   /** A test that returns lowest int with multiple lowest values. **/
   @Test public void testMin1MultipleLowest() {
      int expected = -3;
      int actual = MinOfThree.min1(-3, -3, 4);
      Assert.assertEquals(expected, actual);
   }
   
/// TESTS FOR MIN 2 METHOD ///

      /** A test that returns lowest int of a. **/
   @Test public void testMin2a() {
      int expected = -1;
      int actual = MinOfThree.min2(-1, 0, 3);
      Assert.assertEquals(expected, actual);  
   }
   
   /** A test that returns lowest int of b. **/
   @Test public void testMin2b() {
      int expected = 0;
      int actual = MinOfThree.min2(1, 0, 3);
      Assert.assertEquals(expected, actual);
   }
   
   /** A test that returns lowest int of c. **/
   @Test public void testMin2c() {
      int expected = -3;
      int actual = MinOfThree.min2(1, 0, -3);
      Assert.assertEquals(expected, actual);
   }
   
   /** A test that returns lowest int with multiple lowest values. **/
   @Test public void testMin2MultipleLowest() {
      int expected = -3;
      int actual = MinOfThree.min2(-3, -3, 4);
      Assert.assertEquals(expected, actual);
   }   
   
    /** A test that returns lowest int from same values. **/ 
   @Test public void testMin2SameValues() {
      int expected = -3;
      int actual = MinOfThree.min2(-3, -3, -3);
      Assert.assertEquals(expected, actual);
   }   
   
}
