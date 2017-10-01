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
    int n;
    int k,e=100,i=0;
    cin >> n >> k;
    vector<int> c(n);
    for(int c_i = 0;c_i < n;c_i++){
       cin >> c[c_i];
    }
    while(true)
    {
		i=(i+k)%n;
		if(c[i]==1)
		e=e-3;
		else
		e=e-1;
		if(i==0)
		break;
	}
	cout<<e;
   
   
    
    
    return 0;
}
