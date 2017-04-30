According to Wikipedia, Dynamic programming (also known as dynamic optimization) is a method for solving a complex problem by
breaking it down into a collection of simpler subproblems, solving each of those subproblems just once, 
and storing their solutions – ideally, using a memory-based data structure.
For example, in order computer Nth Fibonacci number or to find shortest path, we can use DP and get result in
much easier and optimized way.   
DP techniques help us to solve exponential problems in polynomial time.   
<br>
Notes From MIT(6.006)->   
DP => careful brute force  
DP => guessing + recursion + memoization  
DP => shortest path in some DAG  
Time complexity => # subproblems x time/subproblem (treating recursion calls as O(1))  
  
These are five interdependent steps to DP  
1) define subproblems  
2) guess ( part of subproblems)  
3) relate subproblem solutions  
4) build an algorithm => recurse and memoize or build DP table bottom up  
5) solve original problem    
  

Naive approach to calculate Nth Fibonacci number is:  
   function fib(n)  
       if n <= 1 return n  
       return fib(n − 1) + fib(n − 2)      

Notice that if we call, say, fib(5), we produce a call tree that calls the function on the same value many different times:    

1)fib(5)  
2)fib(4) + fib(3)  
3)(fib(3) + fib(2)) + (fib(2) + fib(1))  
4)((fib(2) + fib(1)) + (fib(1) + fib(0))) + ((fib(1) + fib(0)) + fib(1))  
5)(((fib(1) + fib(0)) + fib(1)) + (fib(1) + fib(0))) + ((fib(1) + fib(0)) + fib(1))  

Now, suppose we have a simple map object, m, which maps each value of fib that has already been calculated to its result, and we modify our function to use it and update it. The resulting function requires only O(n) time instead of exponential time (but requires O(n) space):    
  
var m := map(0 → 0, 1 → 1)  
     function fib(n)  
        if key n is not in map m   
            m[n] := fib(n − 1) + fib(n − 2)  
        return m[n]  
We can also use constant space in bottom-up approach:  
function fib(n)  
       if n = 0  
           return 0  
       else  
           var previousFib := 0, currentFib := 1  
           repeat n − 1 times // loop is skipped if n = 1  
               var newFib := previousFib + currentFib  
               previousFib := currentFib  
               currentFib  := newFib  
       return currentFib  
       
