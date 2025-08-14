package uz.learn.chapter6.exercise;

import java.util.ArrayList;
import java.util.List;

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
	 for(int i = 1; i < Math.sqrt(n) + 1; i++){
      if(n % i == 0){
        divisors.add(i);
			}
	 }
   return divisors;
  } 
}
