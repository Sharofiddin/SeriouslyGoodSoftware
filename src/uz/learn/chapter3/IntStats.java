package uz.learn.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntStats {
  List<Integer> numbers = new ArrayList<>();
  long sum = 0l;
	public void insert(int n){
		numbers.add(n);
		sum += n;

	}

	public double getAverage() {
    return sum / (double) numbers.size();
	}

	public double getMedian() {
		Collections.sort(numbers);
		final int size = numbers.size();
		if( size % 2 == 0){
		  return (numbers.get(size/2-1) + numbers.get(size/2)) / 2.0;
		} 

	  return numbers.get(size/2);
	}

  public static void main(String [] args){
	  IntStats intStats = new IntStats();
		intStats.insert(2);
		intStats.insert(11);
		intStats.insert(10);
		intStats.insert(20);
		intStats.insert(100);
		System.out.println("Average : " + intStats.getAverage());
		System.out.println("Median : " + intStats.getMedian());
	}
}
