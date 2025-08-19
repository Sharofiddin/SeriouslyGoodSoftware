package uz.learn.chapter7.exercise;

public class Count {
	/**
	 * Returns count of {@code char} into {@code String}
   *
   * @param source - {@link String} which we count chat from it.
   * @param target - counted character 
   *
   * @return count of {@code char} into {@code String}
	 */
  public static int count(String source, char target){
    int i = 0;
    int n = 0;
    boolean hasNext = true; 
    while(hasNext) {
      if(source.charAt(i) == target)
        n++;
      if(i == source.length() - 1)
        hasNext = false;
      else
        i++;
    }
    return n;
    }


  public static void main(String[] args) {
    String source = "an'ana";
    char target = 'a';
    System.out.println("Count of '" + target +"' in " + source + " is: " + count(source, target));
    source = "kastrulka";
    target = 'o';
    System.out.println("Count of '" + target +"' in " + source + " is: " + count(source, target));
  }

}
