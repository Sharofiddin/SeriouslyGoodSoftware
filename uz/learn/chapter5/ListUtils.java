package uz.learn.chapter5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListUtils {
public static <T> List<T> interleaveLists(List<T> l1, List<T> l2) {
  	if(l1 == null || l2 == null)
			throw new NullPointerException("Arguments shouldn't be null");
		if(l1.size() != l2.size())
			throw new IllegalArgumentException("Arguments must have the same length");
		List<T> result = new LinkedList<>();
		for (int i = 0; i < l1.size(); i++) {
			result.add(l1.get(i));
			result.add(l2.get(i));
		}	
	assert postInterleaveLists(l1, l2, result) : "Post conditions failed for interleaveLists";
  return result;
	}
	public static void main(String[] args) {
	   List<Integer> l1 = List.of(1,3,5,7);	
	   List<Integer> l2 = List.of(2,4,6,8);	
		 List<Integer> res =  interleaveLists(l1, l2);
    for (Integer val : res) {
      System.out.print(val + " ");
    }
		     
	}

	private static  <T> boolean postInterleaveLists(List<T> l1, List<T> l2, List<T> result) {
		if(l1.size() + l2.size() != result.size() || l2.size() != l1.size())
			return false;
		Iterator<T> resIt = result.iterator();
		Iterator<T> l1It = l1.iterator();
		Iterator<T> l2It = l2.iterator();
		boolean odd = true;
		while(resIt.hasNext()){
      if(odd && resIt.next() != l1It.next()) return false;
			if(!odd && resIt.next() != l2It.next()) return false;
			odd = !odd;
		}
		return true;	
	}
}
