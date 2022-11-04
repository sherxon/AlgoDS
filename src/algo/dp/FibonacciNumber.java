package algo.dp;

/**
 * Created by sherxon on 3/2/17.
 */
public class FibonacciNumber {

    int fib(int n) { // TIME COMPLEXITY -> O(N), SPACE COMPLEXITY -> O(1)
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        int f1 = 1;
        int f2 = 2;
        while (f1 < n) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f1;
    }

    public int fibUsingArr(int n) { // TIME COMPLEXITY -> O(N), SPACE COMPLEXITY -> O(N)
        if(n==0 || n==1) return n;
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2; i<arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[arr.length-1];
    }

    int fibonacci(int[] a, int n) { // TIME COMPLEXITY -> O(N^2), SPACE COMPLEXITY -> O(N)
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (a[n] != 0) return a[n];
        a[n] = fibonacci(a, n - 1) + fibonacci(a, n - 2);
        return a[n];
    }
}
