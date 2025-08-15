package uz.learn.chapter6.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DivisorsTest {
	/**
	 * @return List of divisors of n, empty list for n==0, if n <&lt> 0 works same list as its opposite
	 */
  public static List<Integer> getDivisors(int n) {
   List<Integer> divisors = new ArrayList<>();
	 if(n == 0){
     return divisors;
	 }
	 if(n < 0) n = -n;
	 for(int i = 1; i <= Math.sqrt(n); i++){
      if(n % i == 0){
        divisors.add(i);
        if(n / i != i)
          divisors.add(n/i);
			}
	 }
   Collections.sort(divisors);  
   return divisors;
  } 

  @Test
  public void testPositiveOne(){
   List<Integer> divisors =  getDivisors(1);
   assertEquals(divisors, List.of(1)); 
  }

  @Test
  public void testPositivePrime(){
   List<Integer> divisors =  getDivisors(5);
   assertEquals(divisors, List.of(1,5)); 
  }
  
  @Test
  public void testPositiveComposite(){
   List<Integer> divisors =  getDivisors(10);
   assertEquals(divisors, List.of(1,2,5,10)); 
  }
  
  @Test
  public void testNegativeComposite(){
   List<Integer> divisors =  getDivisors(-10);
   assertEquals(divisors, List.of(1,2,5,10)); 
  }
  @Test
  public void testZero(){
   List<Integer> divisors =  getDivisors(0);
   assertTrue("Divisors of zero should be the empty list",divisors.isEmpty()); 
  }
}
