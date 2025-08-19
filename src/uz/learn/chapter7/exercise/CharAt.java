package uz.learn.chapter7.exercise;

public interface CharAt {
  
	/**
	 * Returns character of string at i-th index
	 * @throws {@link StringIndexOutOfBoundsException} if i is out of string's index range or negative.
	 * @return {@code char} at i-th posion of {@link String}
	 */
	public int charAt(int i);
}
