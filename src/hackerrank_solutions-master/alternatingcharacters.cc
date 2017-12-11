#include <bits/stdc++.h>

using namespace std;

int alternatingCharacters(string s){
    // Complete this function
    char c=s[0];
    int count=0;
    for(int i=1;i<s.size();i++)
    {
		if(s[i]==c)
		{
			
			count++;
		}
		else{
			c=s[i];
		continue;}
		
	}
	return count;
	
}

int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        string s;
        cin >> s;
        int result = alternatingCharacters(s);
        cout << result << endl;
    }
    return 0;
}
