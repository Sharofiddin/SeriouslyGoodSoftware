package uz.learn.chapter7.exercise;

import java.util.Arrays;
import java.util.Stack;

enum Status {
  READY,
	WAITING,
	PROCESSED
}
/**
	 * The BFS implemented in code to use
	 *
	 * @param a Structure to perform the search on a graph, adjacency matrix etc.
	 * @param verticeCount The verticeCount to use
	 * @param sourceVertice The Source
	 */
public class BFS {
  public static void bfsImplement(byte[][] adjacent, int verticeCount, int sourceVertice) { // passing adjacency matrix and number of verticeCount
  	Status [] statuses =  new Status[verticeCount]; //flag container containing status
																		 //of each verticeCount
																		 
		Arrays.fill(statuses,Status.READY); //status initialization
		Stack<Integer> processingStack = new Stack<>(); //operational stack
		processingStack.push(sourceVertice);  //assigning sourceVertice
		while(!processingStack.isEmpty()){
      statuses[processingStack.peek()] = Status.WAITING; 
      System.out.println(processingStack.peek());
		  int currentVertice = processingStack.peek();
		  statuses[currentVertice] = Status.PROCESSED; 
		  processingStack.pop(); //moving to next vertice
		  for(int i = 0; i <verticeCount;i++){
        if(isVerticeReadyAndConnected(adjacent[currentVertice][i], statuses[i])){
          processingStack.push(i);
					statuses[i] = Status.WAITING; 
				}
			}
		}
  }
	private static boolean isVerticeReadyAndConnected(int connectionStatus, Status processingStatus){
     return connectionStatus != 0 && processingStatus == Status.READY;
	}
	public static void main(String[] args) {
	  byte adjacent[][] = {{0,1,1},{1,0,0},{1,0,0}};	
		int verticeCount = 3;
		int sourceVertice = 2;
		bfsImplement(adjacent, verticeCount, sourceVertice);
	}
}
