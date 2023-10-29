package algo.sortingandsearching;

public class LastZero {
        public int lastZero(int[] x){
            for (int i = 0; i < x.length; i++){
                if (x[i] == 0) 
                    return i;
            }
            return -1;
        }
}
