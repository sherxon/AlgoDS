#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    string s;
    cin >> s;
    int k;
    cin >> k;
    for(int i=0;i<n;i++)
    {
		k=k%26;
		int a=(int)s[i];
		if((a>=97&&a<=122)||(a>=65&&a<=90))
		{
			a=a+k;
			if((a>=91 && a<(90+k))||(a>=123 && a<(122+k)))
			a=a-26;
			char c=(char)a;
			cout<<c;
		}
		else
		cout<<s[i];
	}
    
    
    return 0;
}
