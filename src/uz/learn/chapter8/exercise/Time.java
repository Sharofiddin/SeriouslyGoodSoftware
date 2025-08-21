package uz.learn.chapter8.exercise;

public class Time {
  private final int hour;
	private final int minute;
	private final int second;

	public Time(int hour, int minute, int second){
		if(!isValid(hour, minute, second))
			throw new IllegalArgumentException(format(hour) + ":" +format(minute) + ":" + format(second));
    this.hour = hour;
	  this.minute = minute;
	  this.second = second;
	}
  private boolean isValid(int hour, int minute, int second){
		return hour <= 23 && hour >= 0 && minute <= 59 && minute >= 0 && second <= 59 && second >= 0;
	} 

	private boolean isValid(Time time){
     return isValid(time.hour, time.minute, time.second);
	}
	private String format(int timeUnit){
    if(timeUnit < 10)
			return "0" + timeUnit;
		return ""+timeUnit;
	}

	public Time addNoWrapping(Time delta){
		int secondNew = (delta.second + this.second) % 60;
    int minuteAddition = (this.second + delta.second) / 60;
		int minuteNew = delta.minute + this.minute +  minuteAddition;
		int hourAddition = minuteNew / 60;
		minuteNew %= 60;
    int hourNew = delta.hour + this.hour + hourAddition;
		if(hourNew  <= 23 && minuteNew <= 59 && secondNew <= 59)
			return new Time(hourNew, minuteNew, secondNew);
		else return new Time(23, 59, 59);
		
	}
	
	public Time addAndWrapAround(Time delta){
		int secondNew = (delta.second + this.second) % 60;
    int minuteAddition = (this.second + delta.second) / 60;
		int minuteNew = delta.minute + this.minute +  minuteAddition;
		int hourAddition = minuteNew / 60;
		minuteNew %= 60;
    int hourNew = (delta.hour + this.hour + hourAddition) % 24;
		return new Time(hourNew, minuteNew, secondNew);
	}
  
	public Time subtractAndWrapAround(Time delta){
		int secondNew = delta.second > second ? (this.second + 60 - delta.second) : this.second - delta.second;
    int minuteDebt = delta.second > second ? 1 : 0;
		int hourDebt = delta.minute + minuteDebt > minute ? 1 : 0;
		int minuteNew = 	delta.minute  + minuteDebt> minute  ? minute + 60 - (delta.minute + minuteDebt) : minute - (delta.minute + minuteDebt);
    int hourNew = hour > (hourDebt + delta.hour) ? hour - (hourDebt + delta.hour) : (hour + 24) - (hourDebt + delta.hour);
		return new Time(hourNew, minuteNew, secondNew);
	}
	
	public Time subtractNoWrapping(Time delta){
		if(delta.hour > this.hour || (delta.hour == this.hour && delta.minute > this.minute) 
				|| (delta.hour == this.hour && delta.minute == this.minute && delta.second > this.second)) return new Time(0, 0,0);
		int secondNew = delta.second > second ? (this.second + 60 - delta.second) : this.second - delta.second;
    int minuteDebt = delta.second > second ? 1 : 0;
		int hourDebt = delta.minute + minuteDebt > minute ? 1 : 0;
		int minuteNew = 	delta.minute  + minuteDebt> minute  ? minute + 60 - (delta.minute + minuteDebt) : minute - (delta.minute + minuteDebt);
    int hourNew = hour - hourDebt - delta.hour;
		return new Time(hourNew, minuteNew, secondNew);
	}
	@Override
	public String toString() {
		return format(hour) + ":" +format(minute) + ":" + format(second);
	}
	public static void main(String[] args) {
		System.out.println("Add with no wrapping");
    Time t1 = new Time(5,10, 15);		
		Time t2 = t1.addNoWrapping(new Time(18,10,50));
		Time t3 = t2.addNoWrapping(new Time(18,10,50));
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println("Add with wrapping");
    t1 = new Time(5,10, 15);		
		t2 = t1.addAndWrapAround(new Time(18,10,50));
		t3 = t2.addAndWrapAround(new Time(18,10,50));
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);

		System.out.println("Subtract with no wrapping");
    t1 = new Time(15,10, 15);		
		t2 = t1.subtractNoWrapping(new Time(8,10,50));
		t3 = t2.subtractNoWrapping(new Time(8,10,50));
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		System.out.println("Subtract with wrapping");
    t1 = new Time(15,10, 15);		
		t2 = t1.subtractAndWrapAround(new Time(8,10,50));
		t3 = t2.subtractAndWrapAround(new Time(8,10,50));
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);

		System.out.println(new Time(0,0,5).subtractAndWrapAround(new Time(0,0,10)));
	}
}
