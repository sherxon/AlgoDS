/*

Added by Abhimanyu Saraswat
on 22.10.2019
*/

/* 
Input
1  2  3
4  5  6 
7  8  9
10 11 12

Output

1  5 9 
10 6 2 
3  7 11 
12 8 4

*/
public class MatrixWavePrint{

	
	// input - input 2D array
	public static void wavePrint(int input[][]){
		
	

for(int j=0;j<input[0].length;j++) {
			if(j%2==0) {
			for(int i=0;i<input.length;i++) {
			System.out.print(input[i][j]+" ");	
			}
			}
			else {
				for(int i=input.length-1;i>=0;i--) {
					System.out.print(input[i][j]+" ");	
					}
			}
		}
		
    }

	
}
