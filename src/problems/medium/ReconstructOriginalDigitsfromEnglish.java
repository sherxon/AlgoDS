package problems.medium;

/**
 * Created by sherxon on 1/7/17.
 */
public class ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String ss) {
        int [] a= new int[26];

        char[] ch=ss.toCharArray();
        for(char c:ch) a[c-'a']++;

        StringBuilder sb= new StringBuilder();
        int z=a['z'-'a'];
        a['z'-'a']=0;
        a['e'-'a']-=z;
        a['r'-'a']-=z;
        a['o'-'a']-=z;


        int u=a['u'-'a'];
        a['u'-'a']=0;
        a['f'-'a']-=u;
        a['o'-'a']-=u;
        a['r'-'a']-=u;


        int w=a['w'-'a'];
        a['w'-'a']=0;
        a['t'-'a']-=w;
        a['o'-'a']-=w;


        int x=a['x'-'a'];
        a['x'-'a']=0;
        a['s'-'a']-=x;
        a['i'-'a']-=x;


        int g=a['g'-'a'];
        a['g'-'a']=0;
        a['e'-'a']-=g;
        a['i'-'a']-=g;
        a['h'-'a']-=g;
        a['t'-'a']-=g;


        int s=a['s'-'a'];
        a['s'-'a']=0;
        a['e'-'a']-=s;
        a['e'-'a']-=s;
        a['v'-'a']-=s;
        a['n'-'a']-=s;


        int o=a['o'-'a'];
        a['o'-'a']=0;
        a['n'-'a']-=o;
        a['e'-'a']-=o;


        int h=a['h'-'a'];
        a['h'-'a']=0;
        a['t'-'a']-=h;
        a['r'-'a']-=h;
        a['e'-'a']-=h;
        a['e'-'a']-=h;


        int v=a['v'-'a'];
        a['v'-'a']=0;
        a['f'-'a']-=v;
        a['i'-'a']-=v;
        a['e'-'a']-=v;


        int ii=a['i'-'a'];
        a['i'-'a']=0;
        a['n'-'a']-=ii;
        a['n'-'a']-=ii;
        a['e'-'a']-=ii;
        for(int i=0; i<z; i++)sb.append("0");
        for(int i=0; i<o; i++)sb.append("1");
        for(int i=0; i<w; i++)sb.append("2");
        for(int i=0; i<h; i++)sb.append("3");
        for(int i=0; i<u; i++)sb.append("4");
        for(int i=0; i<v; i++)sb.append("5");
        for(int i=0; i<x; i++)sb.append("6");
        for(int i=0; i<s; i++)sb.append("7");
        for(int i=0; i<g; i++)sb.append("8");
        for(int i=0; i<ii; i++)sb.append("9");
        return sb.toString();

    }
}
