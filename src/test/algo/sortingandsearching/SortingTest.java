package test.algo.sortingandsearching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import algo.sortingandsearching.BubbleSort;
import algo.sortingandsearching.InsertionSort;
import algo.sortingandsearching.LastZero;
import algo.sortingandsearching.MergeSort;
import algo.sortingandsearching.QuickSort;


public class SortingTest {
    final int[] arr = { 4, 3, 0, 11, 7, 5, 15, 12, 99, 1 };
    final int[] sortedArr = { 0, 1, 3, 4, 5, 7, 11, 12, 15, 99 };

    @Test
    void testLastZero(){
        LastZero lastZ =  new LastZero();
        int res = lastZ.lastZero(arr);
        assertEquals(2, res , 0);
    }
    @Test
    void testBubbleSort() {
        BubbleSort.sortSimple(arr);
        assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }

    @Test
    void testInsertionSort() {
        InsertionSort.sortSimple(arr);
        assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }

    @Test
    void testMergeSort() {
        MergeSort.sort(arr);
        assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }

    @Test
    void testQuickSort() {
        QuickSort.sort(arr);
        assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }
}
