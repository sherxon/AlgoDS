#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>

using namespace std;


int main(){
    string S,S1,message;
    int count=0,l=0,f,i;
    cin >> S;
    int length=S.size();
    l=length/3;
    f=length/l;
    for(i=0;i<f;i++)
    message+=S[i];
    for(i=0;i<l;i++)
    S1=S1+message;
    for(i=0;i<length;i++)
    {
		if(S[i]==S1[i])
		continue;
		
		else
		count++;
	}
	cout<<count<<endl;
	return 0;

    
    return 0;
}
