package problems.medium;

/**
 * @author Sherali Obidov.
 */
public class BeautifulArrangement {
        int count=0;
        public int countArrangement(int n) {
            if(n<=2)return n;
            int[] a= new int[n+1];
            for (int i = 0; i < a.length; i++) {
                a[i]=i;
            }
            go(a, 1);
            return count;
        }
        void go(int[] a, int n){
            if(n>a.length) return;
            if(n==a.length){
                boolean f=true;
                for (int i = 1; i < a.length; i++) {
                    if(a[i]%i!=0 && i%a[i]!=0){
                        f=false;
                    }
                    if(!f)break;
                }
                if(f){
                    count++;
                }
            }else{
                for (int i = n; i <a.length ; i++) {
                    if(a[i]%n==0 || n%a[i]==0){
                        swap(a, i, n);
                        go(a, n+1);
                        swap(a, n, i);
                    }

                }
            }

        }
        void swap(int[] a, int i, int n) {
            int temp=a[i];
            a[i]=a[n];
            a[n]=temp;

        }
}
