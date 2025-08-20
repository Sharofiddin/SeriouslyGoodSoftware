package uz.learn.chapter8.exercise;

public class AtomicPair<S,T> {
  private static final int ITERATIONS = 1_000;
	private final Object lock = new Object();
	private S first;
	private T second;
	public void setBoth(S first, T second){
    synchronized(lock) {
          this.first = first;
				  this.second = second;
		}
	}
  
	public S getFirst(){
   		synchronized(lock){
           return first;
			}
	}

	public T getSecond(){
   		synchronized(lock){
           return second;
			}
	}

	

	public static void main(String[] args) throws InterruptedException {
		AtomicPair<String, Integer> ap = new AtomicPair<>();
	  Thread t1 = new Thread(){
       @Override
       public void run() {
				   for(int i = 0; i < ITERATIONS; i++){
           ap.setBoth("first", 1);

		 }}};
	   Thread t2 = new Thread(){
       @Override
       public void run() {
				   for(int i = 0; i < ITERATIONS; i++){
           ap.setBoth("second", 2);

		 }}};	
		 Thread reader = new Thread(){
       @Override
       public void run() {
         for(int i = 0; i < ITERATIONS; i++) {
					 assert postCheckPair(ap) : "Post cond failed";       }
				 }
		 };
		 System.out.println("Starting threads");

		 t1.start();
		 t2.start();
		 reader.start();
		 t1.join();
		 t2.join();
		 reader.join();
		 System.out.println("Threads finished tasks");
	}

	public static boolean postCheckPair(AtomicPair<String,Integer> pair){
	   return (pair.getFirst().equals("first") && pair.getSecond().equals(1))
	||  (pair.getFirst().equals("second") && pair.getSecond().equals(2));
	
	}
		 }
