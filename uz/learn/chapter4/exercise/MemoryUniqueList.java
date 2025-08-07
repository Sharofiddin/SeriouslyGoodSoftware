package uz.learn.chapter4.exercise;
import java.util.Arrays;
public class MemoryUniqueList<E> {
  private Object[] underArr;
	private int capacity = 0;
	public MemoryUniqueList(int capacity){
    this.capacity = capacity;
	}

	public boolean set(int index, E element) {
		if(index < 0 || index > capacity -1)
			return false;
		if(underArr == null){
      underArr = new Object[index + 1];
		} else {
	  for(Object c: underArr)
			if(c != null && ((E)c).equals(element))return false;	
		}
		if(index > underArr.length){
      underArr = Arrays.copyOf(underArr, index+1);
		}
		underArr[index] = element;
		return true;
	}

  public  <E> E get(int index) {
   if(index >=0 && index < underArr.length)
		 return (E)underArr[index];
	 return null;
	}
  public static void main(String [] args) {
    MemoryUniqueList<Integer> numbers = new MemoryUniqueList<>(10);
		System.out.println(""+ numbers.set(0,1));
		System.out.println(""+ numbers.set(4,8));
		System.out.println(""+ numbers.set(3,4));
		System.out.println("" + numbers.get(0));
		System.out.println("" + numbers.get(4));
		System.out.println("" + numbers.get(3));
		System.out.println(""+ numbers.set(30,1));
		System.out.println(""+ numbers.set(1,8));
		System.out.println(""+ numbers.set(3,5));
		System.out.println("" + numbers.get(3));
  }

}
