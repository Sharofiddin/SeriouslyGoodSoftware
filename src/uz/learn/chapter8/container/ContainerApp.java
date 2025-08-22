package uz.learn.chapter8.container;

class ContainerSummary{
  private Double amount;
  private int groupSize;
 public int getGroupSize() {
     return groupSize;
 } 
 public ContainerSummary(Double amount, int groupSize){
  this.amount = amount;
  this.groupSize = groupSize;
 }

 public ContainerSummary(){
   this(0d, 1);
 }
 public void update(double increment){
    this.amount += increment;
 }

 public double getAmount() {
     return amount / groupSize;
 }

 public ContainerSummary merge(ContainerSummary other){
   return new ContainerSummary(amount + other.amount, groupSize + other.groupSize);
 }
}

class Container extends UnionFindNode<Double, ContainerSummary>{
  public Container(){
    super(Attribute.of(ContainerSummary::new,
        ContainerSummary::update, 
        ContainerSummary::merge,
        ContainerSummary::getAmount));
  }
   

}
public class ContainerApp {

  public static void main(String[] args) {
    Container container1 = new Container();
    Container container2 = new Container(); 
    Container container3 = new Container(); 
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
    container1.update(20d);
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
    container1.connectTo(container2);
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
    container3.update(8d);
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
    container1.connectTo(container3);
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
    container1.connectTo(container3);
    System.out.println(container1.get() + " " + container2.get() + " " + container3.get());
  }
}
 	
 	
