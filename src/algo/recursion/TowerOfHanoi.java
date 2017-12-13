public class TowerOfHanoi {
	public static void towerOfHanoi(int top, char start, char via, char end) {
		if (top == 1) 
			System.out.println(start + " --> " + end);
		else {
			towerOfHanoi(top - 1, start, end, via);
			System.out.println(start + " --> " + end);
			towerOfHanoi(top - 1, via, start, end);
		}
	}

	public static void main(String[] args) {
		int blocks = 5;							// Number of blocks in the tower 
		towerOfHanoi(blocks, 'A', 'B', 'C');	// Moving all blocks from A to C
	}
}
