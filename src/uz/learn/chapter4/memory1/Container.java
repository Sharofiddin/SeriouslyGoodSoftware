package uz.learn.chapter4.memory1;
import java.util.ArrayList;
import java.util.List;

public class Container {
	private List<Container> group;
	private float amount;
	public float getAmount() { return amount; }

	public void connectTo(Container other) {
	  if(this.group == null) {
			this.group = new ArrayList<>();
			this.group.add(this);
		}

		if(other.group == null) {
				other.group = new ArrayList<>();
				other.group.add(other);
		}

		if(this.group == other.group) return;

		int size1 = this.group.size();
		int size2 = other.group.size();
		float tot1 = this.amount;
		float tot2 = other.amount;
		float newAmount = (tot1 + tot2) / (size1 + size2);
    group.addAll(other.group);
		for(Container c : other.group) {
		  c.group = group;
		}
		for(Container c : group){
		 c.amount = newAmount;
		}
	}

	public void addWater(float amount) {
	  if(group == null){
			this.amount = amount;
		} else {
		  float amountPerContainer = amount / group.size();
		  for(Container c : group) {
		  	c.amount += amountPerContainer;
		 }
		}
	}

	public static void main(String [] args) {
	  Container a = new Container();
		Container b = new Container();
		a.addWater(12);
		b.addWater(8);
		a.connectTo(b);
		b.connectTo(a);
		System.out.println("a=" + a.getAmount() + ", b= " + b.getAmount());
	}
}

