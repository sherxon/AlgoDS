package problems.medium;

import java.util.*;

/**
 * Created by sherxon on 4/28/17.
 */
public class PalindromPermuatation2 {
    public static void main(String[] args) {
        System.out.println(new PalindromPermuatation2().generatePalindromes("abc"));
    }
    public List<String> generatePalindromes(String s) {
        List<String> list= new ArrayList<>();
        if(s.length() == 0) return list;
        char[] a=s.toCharArray();
        String res=isPalin(a);
        if(res.length()==0)return list;

        Set<String> set= new HashSet<>();
        char[] b=res.substring(0, res.length()-1).toCharArray();
        perm(b, 0, set);
        for (String s1 : set) {
            StringBuilder sb= new StringBuilder(s1);
            if(s.length()%2==0)
                list.add(s1+sb.reverse().toString());
            else
                list.add(s1+res.charAt(res.length()-1) + sb.reverse().toString());
        }
        return list;
    }

    void perm(char[] a, int k, Set<String> set){
        if(k==a.length){
            set.add(new String(a));
            return;
        }

        for(int i=k; i<a.length; i++){
            if(i!=k && a[i]==a[k])continue;
            swap(a, i, k);
            perm(a, k + 1, set);
            swap(a, i, k);
        }
    }
    void swap(char[] a, int i, int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    String isPalin(char[] a){
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(!map.containsKey(a[i]))
                map.put(a[i], 1);
            else
                map.put(a[i], map.get(a[i]) + 1);
        }
        StringBuilder sb= new StringBuilder();
        int odds=0;
        char odd='0';
        for (Character character : map.keySet()) {
            if(map.get(character)%2!=0){
                odds++;
                odd=character;
            }
            for (int i = 0; i < map.get(character)/2; i++) {
                sb.append(character);
            }
        }

        return odds>1  ? "" : sb.append(odd).toString();
    }
}
