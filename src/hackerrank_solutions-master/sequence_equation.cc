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
int main() {
    int n,*arr,search;
    cin>>n;
    arr=(int*)(malloc(n*sizeof(int)));
    for(int i=0;i<n;i++)
        cin>>arr[i];
    for(int x=1;x<=n;x++)
    {
		for(int j=0;j<n;j++)
		{
			if(x==arr[j])
			{
			search=j+1;
			for(int k=0;k<n;k++)
			{
				if(search==arr[k])
				{
				cout<<k+1;
				break;
			}
			}
		}
	}
}
    
    
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}
