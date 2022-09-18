import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

/** jUnit test for CountNegatives class. */

public class CountNegativesTest {

   @Test
   /** Tests count on list containing three negative values. */
   public void testCountNegatives() {
      int[]a = {1, 2, 3, -5, -6, 8, -7};
      int expected = 3;
      assertEquals(expected, CountNegatives.countNegatives(a));
   }
   
   @Test
   /** Tests count on list containing no negative values. */
   public void testCountNegatives1() {
      int[]a = {1, 2, 3, 4, 5, 6, 7};
      int expected = 0;
      assertEquals(expected, CountNegatives.countNegatives(a));
   }
}

