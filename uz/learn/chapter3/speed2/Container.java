package uz.learn.chapter3.speed2;

import java.util.*;

/** A water container, optimized for speed of addWater and connectTo
 */

public class Container {
 
	private double amount;
	private Container next;
  private int groupSize;	
	public double getAmount() {
		updateGroup();
		return amount;
	}

	public void addWater(double amount) {
		this.amount += amount;
	}

  public void connectTo(Container other) {
		Container oldNext = this.next;
		this.next = other.next;
		other.next = oldNext;
	}

	private void updateGroup() {
	  Container current = this;
		double totalAmount = 0.0;
		int groupSize = 0;
		do {
      totalAmount += current.amount;
			groupSize++;
			current = current.next;
  	} while(current != this);
   	double newAmount = totalAmount / groupSize;
   	current = this;
   	do {
			current.groupSize = groupSize;
   	  current.amount = newAmount;
   		current = current.next;
   	} while (current != this);
	}

	public int groupSize() {
    return groupSize;
	}
	// O(n)
  public void flush() {
	  Container current = this;
		do {
			current.amount = 0;
			current = current.next;
		}while (current != this);
	}
}
