package problems.medium;

/**
 * Created by sherxon on 2016-12-24.
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        int i=1;
        StringBuilder sb= new StringBuilder();
        while(num!=0){
            int rem=num % 10;
            sb.insert(0, get(i, rem));
            i*=10;
            num/=10;
        }
        return sb.toString();
    }

    public String get(int i, int val){
        String s="";
        if(i==1){
            s+=get2("I", "V", "X",  val);
        }else if (i==10){
            s+=get2("X", "L", "C", val);
        }else if(i==100){
            s+=get2("C", "D", "M", val);
        }else{
            s+=get2("M", "", "", val);
        }
        return s;
    }
    public String get2(String l, String h, String hh, int val){
        switch(val){
            case 1:return l;
            case 2:return l+l;
            case 3:return l+l+l;
            case 4:return l+h;
            case 5:return h;
            case 6:return h+l;
            case 7:return h+l+l;
            case 8:return h+l+l+l;
            case 9:return l+hh;

        }
        return "";
    }
}
