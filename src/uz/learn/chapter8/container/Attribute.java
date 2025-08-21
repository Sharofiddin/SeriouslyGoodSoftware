package	uz.learn.chapter8.container;

public interface Attribute<V,S> {
  S seed();	
  void update(S summary, V value);
	S merge(S summary1, S summary2);
	V report();
}
