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
    int n,count=0,max_count=0;;
    cin >> n;
    vector<int> a(n);
    for(int a_i = 0;a_i < n;a_i++){
       cin >> a[a_i];
    }
    sort(a.begin(),a.end());
    for(int i=0;i<n;i++)
    {
		for(int j=i;j<n;j++)
		{
			if(abs(a[i]-a[j])<=1)
			count++;
		}
	if(count>max_count)
	max_count=count;
	count=0;
	}
	cout<<max_count<<endl;
			
    return 0;
}
