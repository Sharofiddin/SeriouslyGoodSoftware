package uz.learn.chapter1.novice;
public class Container {
	Container [] g; // group of connected containers
	int n;  // actual gr size
	double x; // amount of water in this container

	public Container() {
     g = new Container[1000];
		 g[0] = this;
		 n = 1;
		 x = 0;
	}

	public void addWater(double x) {
		double y = x/n;
	  for(int i = 0; i < n; i++) {
		  g[i].x += y;
		}
	}

 public void connectTo(Container c) {
   double z = ( x * n + c.n * c.x ) / ( n + c.n );

	 for(int i = 0; i < n; i++) {
	   for(int j = 0; j < c.n; j++) {
			g[i].g[n+j] = c.g[j];
      c.g[j].g[c.n + i] = g[i];
		 }
	 }

	 n = n + c.n;

	 for(int i = 0; i < n; i++ ) {
	  g[i].n = n;
		g[i].x = z;
	 }
 }

 public static void main(String ... args) {
   Container a = new Container();
	 Container b = new Container();
	 a.addWater(10);
	 a.connectTo(b);
	 System.out.println("after connectTo 1");
	 System.out.println(a.x);
	 System.out.println(a.n);
	 a.connectTo(b);
	 System.out.println("after connectTo 2");
	 System.out.println(a.x);
	 System.out.println(a.n);
 }
}
