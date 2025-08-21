package uz.learn.chapter8.container;

public class UnionFindNode<V,S> implements ContainerLike<V,S>{

	private UnionFindNode<V,S> parent = this;
  
	private int groupSize = 1;

  private final Attribute<V,S> attribute;	
}
