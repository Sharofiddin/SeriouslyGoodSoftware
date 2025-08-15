package uz.learn.chapter2;

import java.util.Set;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class User {
  private String name;
	User(String name) {
		this.name = name;
	}
  private Set<User> friends = new HashSet<>();  

	public void befriend(User other) {
	  this.friends.add(other);
		other.friends.add(this);
	}
  public boolean isDirectFriendOf(User other){
	  return this.friends.contains(other);
	}
  public boolean isInDirectFriendOf(User other){
		Deque<User> checkingUsers = new LinkedList<>();
		Set<User> visited = new HashSet<>();
		for(User user: this.friends) {
			checkingUsers.addAll(user.friends);
		}
		while(checkingUsers.size() > 0 ){
      User user = checkingUsers.removeFirst();
      if(!visited.contains(user)){
			  if (user.friends.contains(other))
				 	return true;
			  checkingUsers.addAll(user.friends);
				visited.add(user);
			}
		}
	  return false;
	}

	public String toString() {
		return name;
	}
}

public class Exercise3 {
  public static void main(String ... args) {
	  User user1 = new User("user1");
		User user2 = new User("user2");
		User user3 = new User("user3");
		User user4 = new User("user4");
		User user5 = new User("user5");
		user1.befriend(user2);
		user2.befriend(user3);
		user3.befriend(user4);
		System.out.println(user1 +" is direct friend of " + user2 + " = " + user1.isDirectFriendOf(user2));
		System.out.println(user1 +" is direct friend of " + user3 + " = " + user1.isDirectFriendOf(user3));
		System.out.println(user1 +" is in direct friend of " + user3 + " = " + user1.isInDirectFriendOf(user3));
		System.out.println(user1 +" is in direct friend of " + user4 + " = " + user1.isInDirectFriendOf(user4));
		System.out.println(user1 +" is in direct friend of " + user5 + " = " + user1.isInDirectFriendOf(user5));
	}
}
