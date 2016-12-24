package Timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class TestTask2002 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        Map<String, Log> logs= new HashMap<>();
        String res=null;
        for (int i = 0; i < n; i++) {
            String[] s=in.nextLine().split(" ");
            if(!logs.containsKey(s[1])){
                if("login".equals(s[0]) || "logout".equals(s[0])) res= "fail: no such user";
                else {
                    logs.put(s[1], new Log(s[2], s[1], 0)); //registered log out
                    res="success: new user added";
                }
            }else{
               if("register".equals(s[0]))res="fail: user already exists";
               else if("login".equals(s[0])){
                   if(!logs.get(s[1]).pass.equals(s[2]))res="fail: incorrect password";
                   else if(logs.get(s[1]).status==1)res="fail: already logged in";
                   else {
                       res="success: user logged in";
                       logs.get(s[1]).status=1;
                   }
               }else {
                   if(logs.get(s[1]).status==0)res="fail: already logged out";
                   else  {
                       res="success: user logged out";
                       logs.get(s[1]).status=0;
                   }
               }
            }
            System.out.println(res);
        }

    }
    private static class Log{
        String pass;
        String name;
        int status;

        public Log(String pass, String name, int status) {
            this.pass = pass;
            this.name = name;
            this.status = status;
        }
    }
}
