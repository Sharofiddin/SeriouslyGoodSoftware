package uz.learn.chapter5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BoundedSet<T> {
	private final LinkedList<T> data;
	private final int capacity;
  
	public BoundedSet(int capacity){
   this.data = new LinkedList<>();
	 this.capacity = capacity;
	}
  public BoundedSet(BoundedSet<T> other){
    this.data = new LinkedList<>(other.data);
	  this.capacity = other.capacity;
	}
  public void add(T element){
		if(element == null){
  		throw new NullPointerException();
		}
    BoundedSet<T> copy = null;
		assert (copy = new BoundedSet<>(this)) != null;
		data.remove(element);

		if(data.size() == capacity){
     data.removeFirst();
		}

		data.addLast(element);
		assert postAdd(copy, element) : "add failed post condition";
	}


	private boolean postAdd(BoundedSet<T> oldSet, T element) {
		if (!data.getLast().equals(element)) {
			return false;
		}

		List<T> copyOfCurrent = new ArrayList<>(data);
		copyOfCurrent.remove(element);
		oldSet.data.remove(element);

		if(oldSet.data.size() == capacity){
		  oldSet.data.removeFirst();
		}
    
		return oldSet.data.equals(copyOfCurrent);
	}


	public boolean contains(T element){
	  return data.contains(element);
	}
  public static void main(String[] args) {
  		BoundedSet<Integer> ints = new BoundedSet<>(3);
			ints.add(1);
			ints.add(2);
			ints.add(3);
			ints.add(4);
			System.out.println("contains(1): " + ints.contains(1) );
			System.out.println("contains(2): " + ints.contains(2) );
			System.out.println("contains(3): " + ints.contains(3) );
			System.out.println("contains(4): " + ints.contains(4) );
      // Collection
			ints.add(2);
			ints.add(6);
			System.out.println("contains(2): " + ints.contains(2) );
			System.out.println("contains(6): " + ints.contains(6) );
			System.out.println("contains(3): " + ints.contains(3) );

  }
}
