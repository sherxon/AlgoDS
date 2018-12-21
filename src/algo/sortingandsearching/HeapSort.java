/*
 * Heap sort is a sorting algorithm that works by first organizing the data to be sorted into a special type of binary tree called a heap. 
 * The heap itself has, by definition, the largest value at the top of the tree, so the heap sort algorithm must also reverse the order. 
 * It does this with the following steps:
 * 1. Remove the topmost item (the largest) and replace it with the rightmost leaf. The topmost item is stored in an array.
 * 2. Re-establish the heap.
 * 3. Repeat steps 1 and 2 until there are no more items left in the heap.
 * The sorted elements are now stored in an array.
 * A heap sort is especially efficient for data that is already stored in a binary tree.
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * Time Complexity : O(n log(n))
 * Space Complexity : O(1)
 */

public class HeapSort {
	// Method use to build max heap. Max heap is a heap where value of all root elements in every sub-tree are greater than that of child.
	private static void heapify(int[] arr, int root, int heapSize) {
		int maximum = root;					// Assuming that root is the maximum
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;

		// Checking which element among root, left child and right child has maximum value.
		if (leftChild < heapSize && arr[leftChild] > arr[root])
			maximum = leftChild;
		if (rightChild < heapSize && arr[rightChild] > arr[maximum])
			maximum = rightChild;

		// If root does not have the maximum value, swap with the maximum value and again build a max heap in the sub-tree from the swapped index.
		if (root != maximum) {
			int temp = arr[root];
			arr[root] = arr[maximum];
			arr[maximum] = temp;
			heapify(arr, maximum, heapSize);
		}
	}

	private static void heapSort(int[] arr, int heapSize) {
		for (int i = heapSize / 2 - 1; i >= 0; i--)
			heapify(arr, i, heapSize);	// Iterating through the array to build the max heap.

		// Swapping the root (the largest element) with the last index and then again building max heap of the remaining array.
		for (int i = heapSize - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapSize--;
			heapify(arr, 0, heapSize);
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {65, 87, 12, 3, 94, 53, 44, 36, 27};

		heapSort(arr, arr.length);

		System.out.println("Sorted Array");
		for (int i : arr)
			System.out.print(i + " ");
	}
}
