#include <bits/stdc++.h>

using namespace std;
int d=1;
string gameOfThrones(string str){
    // Complete this function
    int s= str.size();
    map<char,int> m;
    int c_even=0,c_odd=0;
    
		for(int i=0;i<s;i++)
		{
			if(m.count(str[i]==0))
			{
			
			int c=count(str.begin(),str.end(),str[i]);
			m[str[i]]=c;
		}
	}
			
		
		map<char,int>::iterator j;
		
		for(j=m.begin();j!=m.end();++j)
		{
			if((j->second)%2==1)
			{
			c_odd++;
			continue;
		}
			if(j->second%2==0)
			c_even++;
		}
		if(c_odd>1)
		return "NO";
		else
		return "YES";
	
	
}

int main() {
    string s;
    cin >> s;
    string result = gameOfThrones(s);
    cout << result << endl;
    return 0;
}
