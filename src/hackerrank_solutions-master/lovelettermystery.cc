#include <bits/stdc++.h>

using namespace std;

void theLoveLetterMystery(string s){
	string s1=s;
	int count=0;
	reverse(s1.begin(),s1.end());
	int len=s.size();
	int mid=ceil(len/2);
	for(int i=0;i<mid;i++)
	{
		int c=abs(((int)s[i])-((int)s1[i]));
		count+=c;
	}
	cout<<count<<endl;;
    // Complete this function
}

int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        string s;
        cin >> s;
        theLoveLetterMystery(s);
      
    }
    return 0;
}
