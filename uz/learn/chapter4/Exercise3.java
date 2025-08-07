
package uz.learn.chapter4;

import java.util.*;

public class Exercise3 {
	 public static void main(String [] args){
	  Container c1 = new Container();
		c1.addWater(10);
		Container c2 = new Container();
		c2.addWater(4);
		Container c3 = new Container();
		c3.addWater(4);
		Container c4 = new Container();
		c4.addWater(4);
		System.out.println("Initial");
		System.out.println("c1=" + c1.getAmount() + " c2="+ c2.getAmount());
		System.out.println("c3=" + c3.getAmount() + " c4="+ c4.getAmount());
		c1.connectTo(c2);
		c3.connectTo(c4);
		System.out.println("after c1->c2, c3->c4");
		System.out.println("c1=" + c1.getAmount() + " c2="+ c2.getAmount());
		System.out.println("c3=" + c3.getAmount() + " c4="+ c4.getAmount());
		c3.connectTo(c1);
		System.out.println("after c1->c3");
		System.out.println("c1=" + c1.getAmount() + " c2="+ c2.getAmount());
		System.out.println("c3=" + c3.getAmount() + " c4="+ c4.getAmount());
	 }
}

class Container {
  protected Container parent = this;
	public Container(){
     parent = new SpecialContainer();
	}
	public Container(boolean dummy){
	}
	protected Container findRootAndCompress() {
		  if(this.isRoot())
				return this;
      if(parent.isRoot())
				return parent;
			parent = parent.findRootAndCompress();
      return parent;
		}
	protected boolean isRoot(){
		return parent.parent == parent;
	}
  private static class SpecialContainer extends Container{
  	public SpecialContainer(){
       super(true);
   	}
    double amount;
  	int size = 1;
  }
	public double getAmount() {
		System.out.println("isRoot = " + isRoot() + ", is parent instanceof SpecialContainer " + (parent instanceof SpecialContainer));
	  Container root = findRootAndCompress();
		SpecialContainer parent = (SpecialContainer)root.parent;
		return parent.amount;
	}

	public void addWater(double amount) {
		Container root = findRootAndCompress();
		SpecialContainer parent = (SpecialContainer)root.parent;
		parent.amount += amount / parent.size;
	}
  
  public void connectTo(Container other) {
		Container root1 = this.findRootAndCompress();
		Container root2 = other.findRootAndCompress();
    
		if(root1 == root2) return;
		SpecialContainer parent1 = (SpecialContainer)root1.parent;
		SpecialContainer parent2 = (SpecialContainer)root2.parent;
		int size1 = parent1.size;
		int size2 = parent2.size;

    
		double newAmount = (parent1.amount * size1 + parent2.amount * size2) / (size1 + size2);
		if(parent2.size >= parent1.size) {
        root1.parent = root2;
				parent2.amount = newAmount;
				parent2.size += size1;
		} else {
        root2.parent = root1;
				parent1.amount = newAmount;
				parent1.size += size2;
		}
	}
  
  public int groupSize() {
	  Container root = findRootAndCompress();
		SpecialContainer parent = (SpecialContainer) root.parent;
		return parent.size;
	}
  // O(logN)
	public void flush() {
	    Container root = findRootAndCompress();
			SpecialContainer parent = (SpecialContainer) root.parent;
		  parent.amount = 0d;
	}

}
