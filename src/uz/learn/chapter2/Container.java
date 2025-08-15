package uz.learn.chapter2;

import java.util.HashSet;
import java.util.Set;

public class Container {
	
	private Set<Container> group;

	private double amount;
  
	public Container() {
		group = new HashSet<>();
		group.add(this);
	}

	public double getAmount() {
		return amount;
	}

	public void connectTo(Container other) {
		if(this.group == other.group) 
			return;
	  int size1 = group.size();
		int size2 = other.group.size();
		double tot1 = size1 * amount,
		       tot2 = size2 * other.amount,
					 newAmount = tot1 + tot2;
    group.addAll(other.group);

		for( Container c: other.group) {
		  c.group = group;
		}

		for( Container c : group ) {
			c.amount = newAmount;
		}

	}

	public void addWater(double amount) {
	  double amountPerContainer = amount / group.size();
		for(Container c : group ) {
      c.amount += amountPerContainer;
		}
	}

	public static void main(String [] args) {
	  Container a = new Container();
	  Container b = new Container();
	  Container c = new Container();
	  Container d = new Container();

		a.connectTo(b);
		b.connectTo(c);
		a.addWater(12);
		d.addWater(8);
	
		System.out.println("a amount = " + a.getAmount());
		System.out.println("b amount = " + b.getAmount());
		System.out.println("c amount = " + c.getAmount());
		System.out.println("d amount = " + d.getAmount());
	}

}
