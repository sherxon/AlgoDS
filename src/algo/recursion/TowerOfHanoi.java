package algo.recursion;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. 
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * 1) Only one disk can be moved at a time.
 * 2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * 3) No disk may be placed on top of a smaller disk.
 * ------------------------------------------------------------------------------------------------
 * Take an example for 2 disks :
 * Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
 *
 * 			|			|			|
 			|			|			|
 			|			|			|
 		  =====			|			|
 		=========	____|____	____|____
 			A 			B 			C
 * Step 1 : Shift first disk from 'A' to 'B'.
 *
 * 			|			|			|
 			|			|			|
 			|			|			|
 			|			|			|
 		=========	  =====		____|____
 			A 			B 			C
 * Step 2 : Shift second disk from 'A' to 'C'.
 *
 * 			|			|			|
 			|			|			|
 			|			|			|
 			|			|			|
 		____|____	  =====		=========
 			A 			B 			C
 * Step 3 : Shift first disk from 'B' to 'C'.
 *
 * 			|			|			|
 			|			|			|
 			|			|			|
 			|			|		  =====
 		____|____	____|____	=========
 			A 			B 			C
 *
 * The pattern here is :
 * Shift 'n-1' disks from 'A' to 'B'.
 * Shift last disk from 'A' to 'C'.
 * Shift 'n-1' disks from 'B' to 'C'.
 *
 * For n disks, total 2^n – 1 moves are required.
 */

public class TowerOfHanoi {
    public static void towerOfHanoi(int top, char start, char via, char end) {
        if (top == 1)
            System.out.println(start + " --> " + end);    // If one disk is left, move it to last rod
        else {
            towerOfHanoi(top - 1, start, end, via);        // Shifting n - 1 disks from A to B with the help of C
            System.out.println(start + " --> " + end);    // Shifting last disk from A to C
            towerOfHanoi(top - 1, via, start, end);        // Shifting n - 1 disks from B to C with the help of A
        }
    }

    public static void main(String[] args) {
        int blocks = 5;                            // Number of blocks in the tower
        towerOfHanoi(blocks, 'A', 'B', 'C');    // Moving all blocks from A to C
    }
}
