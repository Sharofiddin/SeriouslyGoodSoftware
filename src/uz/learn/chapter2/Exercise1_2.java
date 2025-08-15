package uz.learn.chapter2;

public class Exercise1_2 {
	public static int[][] identityMatrix(int n) {
		int [][] result = new int[n][n];
		for (int i = 0; i < n; i++)
			result[i][i] = 1;
		return result;
	}
	public static void main(String args[]){
    int [][] result = identityMatrix(5);
		for(int i = 0; i < result.length; i++){
			for( int j = 0; j < result[i].length; j++){
    		System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}


