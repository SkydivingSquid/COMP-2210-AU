import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class SelectorTest {
   /** A test that returns min value in an array. */
   @Test public void testMin() {
      int a[] = {5, -4, -4, 8, -1};
      int expected = -4;
      int actual = Selector.min(a);
      Assert.assertEquals(expected, actual);
   }

   /** A test that returns max value in an array. */
   @Test public void testMax() {
      int a[] = {5, -9, -4, 8, 8};
      int expected = 8;
      int actual = Selector.max(a);
      Assert.assertEquals(expected, actual);
   }
   
  
   @Test public void testKmin() {
      int a[] = {3, 7, 3, 3, 1, 9, 1, 1, 1, 5, 9};
      int k = 2;
      int expected = 3;
      int actual = Selector.kmin(a, k);
      Assert.assertEquals(expected, actual); 
   }
  
  
   @Test public void testKmax() {
      int a[] = {3, 7, 3, 3, 1, 9, 1, 1, 1, 5, 9};
      int k = 2;
      int expected = 7;
      int actual = Selector.kmax(a, k);
      Assert.assertEquals(expected, actual); 
   }
   
   
   @Test public void testRange() {
      int a[] = { 2, 4, 5, 6, 7, 7, 8, 9, 10, 11};
      int low = 5;
      int high = 9;
      int expected[] = {5, 6, 7, 7, 8, 9};
      int actual[] = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
  
   @Test public void testCeiling() { 
      int a[] = {1, 6, 8, 12, 10, 14};
      int key = 9;
      int expected = 10;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   
   @Test public void testFloor() { 
      int a[] = {1, 6, 8, 12, 10, 14};
      int key = 9 ;
      int expected = 8;
      int actual = Selector.floor(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   
   
  
} // final brace