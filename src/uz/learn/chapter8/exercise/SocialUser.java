package uz.learn.chapter8.exercise;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SocialUser {

	private final String name;
	private final Set<SocialUser> friends = new HashSet<>();
  private final int id;
	private static final AtomicInteger counter = new AtomicInteger(1);

	public SocialUser(String name){
    this.name = name;
		this.id = counter.getAndIncrement();
	}
  
	public void befriend(SocialUser other){
   Object first = this.id < other.id ? this.id : other.id;
	 Object second = this.id > other.id ? this.id : other.id;
   
	 synchronized(first){
		 synchronized(second){
       this.friends.add(other);
			 other.friends.add(this);
		 }
	 }
	}

	public synchronized void befriendFaulty(SocialUser other){
   
       friends.add(other);
			 synchronized(other){
   			 other.friends.add(this);
	   }
	}
	private final static int ITERATIONS = 1_000_000;
	public static void main(String[] args) throws InterruptedException{
		SocialUser u1 = new SocialUser("u1");
		SocialUser u2 = new SocialUser("u2");
	  Thread t1 = new Thread(){
      public void run() {
       for (int i = 0; i < ITERATIONS; i++) {
       	u1.befriend(u2);
       }
			}};
	  Thread t2 = new Thread(){
      public void run() {
       for (int i = 0; i < ITERATIONS; i++) {
       	u2.befriend(u1);
       }
			}};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		}	
	}
