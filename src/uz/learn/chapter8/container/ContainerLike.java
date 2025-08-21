package uz.learn.chapter8.container;

public interface ContainerLike<V,T extends ContainerLike<V,T>> {

   V get();
	 void update(V val);
	 void connectTo(T other); 
}
