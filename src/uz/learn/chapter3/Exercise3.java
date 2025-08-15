package uz.learn.chapter3;

class Appliance {
  private int power;
	private boolean isOn = false;
	private Grid grid;

	Appliance(int power){
	  this.power = power;
	}
  public void plugInto(Grid grid) {
		if(grid == this.grid) return;
		if(this.grid != null && isOn) {
      grid.reclaim(power);
		}
		this.grid = grid;
	}
	public void on(){
		if(isOn) return;
		try{
			this.grid.use(power);
  	  this.isOn = true;
		} catch(Exception e) {
      e.printStackTrace();
			System.out.println("Appliance can not be turned on");
		}
	}
	public void off(){
		if(!isOn) return;
	  this.isOn = false;
		this.grid.reclaim(power);
	}
}

class Grid {
	private int power;
  private int used;
	Grid(int power){
	  this.power = power;
	}

	public void reclaim(int appliancePower){
     used -= appliancePower;
	}

	public void use(int appliancePower ) throws Exception {
     if (used + appliancePower > this.power ) {
       throw new Exception("Appliances consumption overflow");
		 }
     used += appliancePower;
	}

	public int residualPower(){
   return power - used; 
	}
}

public class Exercise3 {
  
	public static void main(String ... args) {
	   Appliance tv = new Appliance(150);
	   Appliance radio = new Appliance(30);
		 Grid grid = new Grid(3000);

	   Appliance superMuperConsumer = new Appliance(2999);
		 
		 tv.plugInto(grid);
		 radio.plugInto(grid);
		 System.out.println(grid.residualPower());
		 tv.on();
		 System.out.println(grid.residualPower());
		 radio.on();
		 System.out.println(grid.residualPower());
		 tv.off();
		 System.out.println(grid.residualPower());
		 superMuperConsumer.plugInto(grid);
		 superMuperConsumer.on();
		 System.out.println(grid.residualPower());

	}
  
}
