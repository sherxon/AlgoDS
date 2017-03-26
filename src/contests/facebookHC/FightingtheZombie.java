package contests.facebookHC;

/**
 * Created by sherxon on 1/6/17.
 */
public class FightingtheZombie {
    public static void main(String[] args) {
        double p=0;
        double s=100;
        for (int i = 0; i <9; i++) {
            double b= s*0.8;//80 16
            s=s-b;//20 4
            p+=b;//80  16
            System.out.println(p);
        }
        System.out.println(p);
    }
}
