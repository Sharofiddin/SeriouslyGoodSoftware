package uz.learn.chapter3;

class Appliance {
  private int power;
	private boolean isOn = false;
	Appliance(int power){
	  this.power = power;
	}

	public void on(){
	  this.isOn = true;
	}
	public void off(){
	  this.isOn = false;
	}
}

class Grid {
	private int power;
	Grid(int power){
	  this.power = power;
	}
}
