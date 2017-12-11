#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    string s;
    int n,temp_count=0,no_of_valleys=0;
    cin>>n>>s;
    for(int i=0;i<n;i++)
        {
        if(s[i]=='D')
			temp_count++;
		else if((s[i]=='U')&&(temp_count>1))
		{
			no_of_valleys=no_of_valleys+1;;
			temp_count=0;
		}
		else
		continue;
		}
		cout<<no_of_valleys<<endl;
    
    return 0;
}
