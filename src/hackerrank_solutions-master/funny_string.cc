#include <bits/stdc++.h>

using namespace std;

void funnyString(string s){
    string r=s;
    reverse(r.begin(),r.end());
    int n=r.size(),flag=1;
    for(int i=1;i<n;i++)
    {
		if((abs(((int)s[i])-((int)s[i-1])))==(abs(((int)r[i])-((int)r[i-1]))))
		continue;
		else
		{
			flag=0;
			break;
			
		}
	}
	if(flag==0)
	cout<<"Not Funny";
	else
	cout<<"Funny";
		
    
}

int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        string s;
        cin >> s;
        funnyString(s);
      
    }
    return 0;
}
